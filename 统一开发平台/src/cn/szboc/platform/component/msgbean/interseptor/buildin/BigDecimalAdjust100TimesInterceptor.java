package cn.szboc.platform.component.msgbean.interseptor.buildin;

import java.math.BigDecimal;

import cn.szboc.platform.component.msgbean.FieldTranslateProperty;
import cn.szboc.platform.component.msgbean.exception.MsgBeanConvertException;
import cn.szboc.platform.component.msgbean.interseptor.AfterSetInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.BeforeGetInterceptor;

/**
 * 扩大金额100倍的BigDecimal拦截器
 * 针对BigDecimal字段格式修正 小数点去除,金额的浮点数扩大/缩小100倍,具体为
 * 把从BigDecimal属性中取到的数值扩大100倍,方便传到CSP进行账务交易
 * 在BigDecimal属性被设置后,金额缩小100倍,方便从CSP返回的(默认2位小数)金额格式解析
 */
public class BigDecimalAdjust100TimesInterceptor implements BeforeGetInterceptor, AfterSetInterceptor {

	/**
	 * 默认浮点数的标度是2
	 */
	private static final int scaleSize = 2;

	/**
	 * 修正BigDecimal格式的金额属性 对其进行调整,缩小100倍
	 */
	@Override
	public Object afterSetToProperty(Object value, FieldTranslateProperty fieldTranslateProperty) throws MsgBeanConvertException {

		if (fieldTranslateProperty == null) {
			throw new MsgBeanConvertException("传入字段属性不能为null");
		}

		if (value == null) {
			return null;
		}

		// 必须是BigDecimal
		if (!(value instanceof BigDecimal)) {
			throw new MsgBeanConvertException("本拦截器支持的金额字段必须是BigDecimal类型," + fieldTranslateProperty);
		}

		// 转成BigDecimal类型
		BigDecimal bdValue = (BigDecimal) value;

		// 确保此时BigDecimal没有标度,即没有小数部分
		if (bdValue.scale() != 0) {
			throw new MsgBeanConvertException("本拦截器支持的BigDecimal的标度必须是0,但是传入的值为" + bdValue.toPlainString() + ",其标度为" + bdValue.scale() + ","
					+ fieldTranslateProperty);
		}

		// 小数点向左移动scaleSize位,10的scaleSize次幂倍
		bdValue = bdValue.movePointLeft(scaleSize);

		// 返回转换后的数值
		return bdValue;
	}

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
			throw new MsgBeanConvertException("本拦截器支持的金额字段必须是BigDecimal类型," + fieldTranslateProperty);
		}

		// 转成BigDecimal类型
		BigDecimal bdValue = (BigDecimal) value;

		if (bdValue.scale() > scaleSize) {
			throw new MsgBeanConvertException("本拦截器支持的字段所代表的BigDecimal值的最大标度为" + scaleSize + ",但传入的值[" + bdValue.toPlainString() + "]的标度为"
					+ bdValue.scale() + ",即传入参数的小数位数超过了" + scaleSize + ", " + fieldTranslateProperty);
		}

		// 小数点向右移动scaleSize位,扩大10的scaleSize次幂倍
		bdValue = bdValue.movePointRight(scaleSize);

		// 返回转换后的数值
		return bdValue;
	}

}
