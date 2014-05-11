package cn.szboc.platform.component.msgbean;

import java.nio.charset.Charset;
import java.util.ArrayList;

import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 定义了一个Class的转换信息
 */
public class MessageBeanDefinition {

	private Class<?> clazz;

	private Charset cs;

	private To to;

	private int expectedSize;

	private ArrayList<FieldTranslateProperty> fieldProperties = new ArrayList<FieldTranslateProperty>();

	public Class<?> getClazz() {
		return clazz;
	}

	public Charset getCs() {
		return cs;
	}

	public To getTo() {
		return to;
	}

	public int getExpectedSize() {
		return expectedSize;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public void setCs(Charset cs) {
		this.cs = cs;
	}

	public void setTo(To to) {
		this.to = to;
	}

	public void setExpectedSize(int expectedSize) {
		this.expectedSize = expectedSize;
	}

	public ArrayList<FieldTranslateProperty> getFieldProperties() {
		return fieldProperties;
	}

	public void setFieldProperties(ArrayList<FieldTranslateProperty> fieldProperties) {
		this.fieldProperties = fieldProperties;
	}

}