package cn.szboc.platform.component.xmlbean.spring;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


public class XmlBeanMapping {

	private Jaxb2Marshaller jaxb2Marshaller;

	@Required
	public void setJaxb2Marshaller(Jaxb2Marshaller jaxb2Marshaller) {
		this.jaxb2Marshaller = jaxb2Marshaller;
	}

	/**
	 * 将一个JAXB对象转为序列化为byte数组
	 * 
	 * @param jaxbElement
	 * @return
	 * @throws Exception
	 */
	public byte[] marshal(Object jaxbElement) throws Exception {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		StreamResult sr = new StreamResult(baos);

		try {
			jaxb2Marshaller.marshal(jaxbElement, sr);
		} catch (Exception e) {
			throw new Exception("序列化Jaxb对象时异常," + e.getMessage(), e);
		}

		checkValidEvent();

		return baos.toByteArray();
	}

	public Object unmarshal(File file) throws Exception {

		Source source = new StreamSource(file);
		return unmarshal(source);
	}

	public Object unmarshal(byte[] data) throws Exception {

		Source source = new StreamSource(new ByteArrayInputStream(data));
		return unmarshal(source);
	}

	public Object unmarshal(InputStream is) throws Exception {

		Source source = new StreamSource(is);
		return unmarshal(source);
	}

	/**
	 * 实现了内部转换事件探测与异常的合并
	 * 
	 * @param source
	 * @return
	 * @throws Exception
	 */
	private Object unmarshal(Source source) throws Exception {

		Object jaxbElement = null;
		try {
			jaxbElement = jaxb2Marshaller.unmarshal(source);
		} catch (Exception e) {
			throw new Exception("生成Jaxb对象时异常," + e.getMessage() + "******", e);
		}

		checkValidEvent();

		return jaxbElement;
	}

	private void checkValidEvent() throws Exception {
		// 检测有误
		ValidationEvent[] events = ThreadSafeValidationEventHandler.getEvents();
		if (events != null && events.length != 0) {
			for (ValidationEvent ve : events) {
				String msg = ve.getMessage();
				ValidationEventLocator vel = ve.getLocator();
				int line = vel.getLineNumber();
				int column = vel.getColumnNumber();
				String level = null;
				switch (ve.getSeverity()) {
					case ValidationEvent.WARNING:
						level = "警告";
						break;
					case ValidationEvent.ERROR:
						level = "错误";
						break;
					case ValidationEvent.FATAL_ERROR:
						level = "严重错误";
						break;
					default:
						level = "未知情况";
				}
				throw new Exception("XML校验异常!级别为" + level + ", 错误位于第" + line + "行, 第" + column + "列, 具体信息是:" + msg);
			}
		}
	}
}
