package cn.szboc.platform.component.csp.trade.commons.interceptor;

import java.math.BigDecimal;

import cn.szboc.platform.component.msgbean.FieldTranslateProperty;
import cn.szboc.platform.component.msgbean.exception.MsgBeanConvertException;
import cn.szboc.platform.component.msgbean.interseptor.AfterSetInterceptor;

/**
 * 在设置BigDecimal值后设置该值的标度为2,即保留2位有效小数
 */
public class BigDecimalScaleInterceptor implements AfterSetInterceptor {

	/**
	 * BigDecimal支持的标度
	 */
	private static final int scaleSize = 2;

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
			throw new MsgBeanConvertException("本拦截器支持的金额字段必须是BigDecimal类型");
		}

		if(((BigDecimal) value).scale() > 2){
			throw new MsgBeanConvertException("金额字段标度过高,最多支持2位标度!");
		}
		
		value = ((BigDecimal) value).setScale(scaleSize);

		return value;
	}
}
