package cn.szboc.platform.component.csp.trade.commons.interceptor;

import java.math.BigDecimal;
import java.util.Arrays;

import cn.szboc.platform.commons.ByteUtils;
import cn.szboc.platform.component.msgbean.FieldTranslateProperty;
import cn.szboc.platform.component.msgbean.exception.MsgBeanConvertException;
import cn.szboc.platform.component.msgbean.interseptor.BeforeGetInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.BeforeSetInterceptor;

/**
 * 查询交易的金额字段格式拦截器 查询交易的金额格式如下: 前面补空格, 后面留有一个字节的符号位,' '与'+'代表正数金额,'-'代表负数金额
 * 但总的设计逻辑是,不改变原字节数组的长度.
 */
public class QueryTradeAmtFormatInterseptor implements BeforeGetInterceptor, BeforeSetInterceptor {

	/**
	 * 半角正数符号"+"
	 */
	private static byte positiveSymbol = (byte) '+';

	/**
	 * 半角符号"-"
	 */
	private static byte negativeSymbol = (byte) '-';

	/**
	 * 半角空格符号" "
	 */
	private static byte blankSymbol = (byte) ' ';

	/**
	 * BigDecimal支持的标度
	 */
	private static final int scaleSize = 2;

	/**
	 * 从byte[]解析时,对最后一个栏位的符号进行处理,如果有'-'则移到数字前面
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

		// 不可能有长度为0的情况,金额字段必须有字节数,不做处理,直接返回
		if (data.length == 0) {
			return data;
		}

		// 如果最后一位是' '或'+',则去除后前面补全长度后返回
		if ((data[data.length - 1] == blankSymbol) || (data[data.length - 1] == positiveSymbol)) {
			// 截取前面[length-1]位长度
			byte[] tmp = Arrays.copyOfRange(data, 0, data.length - 1);
			// 前补空白后返回
			return ByteUtils.byteJoin(blankSymbol, tmp);
		}

		// 如果最后一位是'-',则要做移位处理
		if (data[data.length - 1] == negativeSymbol) {
			// 截取前面[length-1]位长度
			byte[] tmp = Arrays.copyOfRange(data, 0, data.length - 1);
			// 去除左侧空白
			tmp = ByteUtils.leftTrim(tmp, blankSymbol);
			// 左边补'-'
			tmp = ByteUtils.byteJoin(negativeSymbol, tmp);
			// 补满原长度后返回
			return ByteUtils.leftPad(tmp, data.length, blankSymbol);
		}

		return data;
	}

	/**
	 * 从属性到byte[]时,必须是Bigdecimal,而且数值的标度必须为2,否则不予通过
	 */
	@Override
	public Object beforeGetToBytes(Object value, FieldTranslateProperty fieldTranslateProperty) throws MsgBeanConvertException {

		if (fieldTranslateProperty == null) {
			throw new MsgBeanConvertException("传入字段属性不能为null");
		}

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
		if (bd.scale() != scaleSize) {
			throw new MsgBeanConvertException("本拦截器支持的金额字段必须是BigDecimal类型,并且标度scale必须是2");
		}

		return bd;
	}
}
