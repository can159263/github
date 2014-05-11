package cn.szboc.platform.component.msgbean.interseptor.buildin;

import java.util.Arrays;

import cn.szboc.platform.commons.ByteUtils;
import cn.szboc.platform.component.msgbean.FieldTranslateProperty;
import cn.szboc.platform.component.msgbean.exception.MsgBeanConvertException;
import cn.szboc.platform.component.msgbean.interseptor.AfterGetInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.BeforeSetInterceptor;

/**
 * ddMMyyyy与yyyyMMdd的互转
 */
public class DateFormatDDMMYYYYInterceptor implements BeforeSetInterceptor, AfterGetInterceptor {

	/**
	 * 将ddMMyyyy格式的8字节调整为yyyyMMdd格式
	 */
	@Override
	public byte[] beforeSetToProperty(byte[] data, FieldTranslateProperty fieldTranslateProperty) throws MsgBeanConvertException {

		if (data == null) {
			throw new MsgBeanConvertException("传入字节数组不能为null");
		}

		if (fieldTranslateProperty == null) {
			throw new MsgBeanConvertException("传入字段属性不能为null");
		}

		if (fieldTranslateProperty.getLength() != data.length) {
			throw new MsgBeanConvertException("传入字节数组长度" + data.length + "与字段属性配置的长度" + fieldTranslateProperty.getLength() + "不符");
		}

		if (data.length != 8) {
			throw new MsgBeanConvertException("本日期格式拦截器只支持8位字节,但实际上有" + data.length);
		}

		// 截取日
		byte[] dd = Arrays.copyOfRange(data, 0, 2);
		// 截取月
		byte[] mm = Arrays.copyOfRange(data, 2, 4);
		// 截取年
		byte[] yyyy = Arrays.copyOfRange(data, 4, 8);

		return ByteUtils.byteJoin(yyyy, mm, dd);
	}

	/**
	 * 将yyyyMMdd格式的8字节调整为ddMMyyyy格式
	 */
	@Override
	public byte[] afterGetToBytes(byte[] data, FieldTranslateProperty fieldTranslateProperty) throws MsgBeanConvertException {
		if (data == null) {
			throw new MsgBeanConvertException("传入字节数组不能为null");
		}

		if (fieldTranslateProperty == null) {
			throw new MsgBeanConvertException("传入字段属性不能为null");
		}

		if (fieldTranslateProperty.getLength() != data.length) {
			throw new MsgBeanConvertException("传入字节数组长度" + data.length + "与字段属性配置的长度" + fieldTranslateProperty.getLength() + "不符");
		}

		if (data.length != 8) {
			throw new MsgBeanConvertException("本日期格式拦截器只支持8位字节,但实际上有" + data.length);
		}

		// 截取年
		byte[] yyyy = Arrays.copyOfRange(data, 0, 4);
		// 截取月
		byte[] mm = Arrays.copyOfRange(data, 4, 6);
		// 截取日
		byte[] dd = Arrays.copyOfRange(data, 6, 8);

		return ByteUtils.byteJoin(dd, mm, yyyy);
	}

}
