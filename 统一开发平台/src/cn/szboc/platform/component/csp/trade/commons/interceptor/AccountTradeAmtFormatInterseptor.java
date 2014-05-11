package cn.szboc.platform.component.csp.trade.commons.interceptor;

import java.math.BigDecimal;
import java.util.Arrays;

import cn.szboc.platform.commons.ByteUtils;
import cn.szboc.platform.component.msgbean.FieldTranslateProperty;
import cn.szboc.platform.component.msgbean.exception.MsgBeanConvertException;
import cn.szboc.platform.component.msgbean.interseptor.BeforeGetInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.BeforeSetInterceptor;

/**
 * 账务交易的金额字段格式拦截器 查询交易的金额格式如下: 前面0, 无符号位, 无小数点, 即数值扩大100倍
 * 转换的要求:不改变原字节数组的长度.
 */
public class AccountTradeAmtFormatInterseptor implements BeforeGetInterceptor, BeforeSetInterceptor{

	/**
	 * 半角数字符号"0"
	 */
	private static byte zeroSymbol = (byte) '0';
	
	/**
	 * 半角数字符号"0"的字节数组
	 */
	private static byte[] dotPart = ".".getBytes();
	
	/**
	 * BigDecimal支持的标度
	 */
	private static final int scaleSize = 2;

	/**
	 * 从byte[]解析时,给返回的金额字段前面
	 */
	@Override
	public byte[] beforeSetToProperty(byte[] data, FieldTranslateProperty fieldTranslateProperty) throws MsgBeanConvertException {

		if (data == null) {
			throw new MsgBeanConvertException("传入字节数组不能为null");
		}

		if (fieldTranslateProperty == null) {
			throw new MsgBeanConvertException("传入字段属性不能为null");
		}

		// 校验长度
		if (data.length != fieldTranslateProperty.getLength()) {
			throw new MsgBeanConvertException("传入字节数组长度" + data.length + "与字段属性配置的长度" + fieldTranslateProperty.getLength() + "不符");
		}

		if (data.length <= 2) {
			throw new MsgBeanConvertException("传入字节数组长度" + data.length + "过短,(因默认2位有效小数的缘故)至少为2位");
		}

		// 去除左侧的0
		byte[] tmp = ByteUtils.leftTrim(data, zeroSymbol);
		
		// 拿到整数位字节
		byte[] intValue = Arrays.copyOfRange(tmp, 0, tmp.length - 2);
				
		// 拿到小数位字节
		byte[] folatValue = Arrays.copyOfRange(tmp, tmp.length - 2, tmp.length);
		
		// 拼接
		tmp = ByteUtils.byteJoin(intValue, dotPart, folatValue);
		
		// 左侧补0,保证长度
		tmp = ByteUtils.leftPad(tmp, fieldTranslateProperty.getLength(), zeroSymbol);
		
		// 返回
		return tmp;
	}

	/**
	 * 从属性到byte[]时,必须是Bigdecimal,而且数值的标度必须为2,否则不予通过
	 * 最终的效果是把BigDecimal字段扩大100倍
	 */
	@Override
	public Object beforeGetToBytes(Object value, FieldTranslateProperty fieldTranslateProperty) throws MsgBeanConvertException {

		if (fieldTranslateProperty == null) {
			throw new MsgBeanConvertException("传入字段属性不能为null");
		}

		// 对于null值不做处理
		if (value == null) {
			return null;
		}

		// 必须是BigDecimal
		if (!(value instanceof BigDecimal)) {
			throw new MsgBeanConvertException("本拦截器支持的金额字段必须是BigDecimal类型");
		}

		// 转成BigDecimal类型
		BigDecimal bd = (BigDecimal) value;

		// 校验标度
		if (bd.scale() > scaleSize) {
			throw new MsgBeanConvertException("本拦截器支持的金额字段必须是BigDecimal类型,并且标度scale最大是" + scaleSize);
		}
		
		// 强制设置标度是2
		bd.setScale(2);
		
		// 扩大100倍
		bd = bd.movePointRight(2);

		return bd;
	}

}
