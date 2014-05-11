package cn.szboc.platform.component.xmlbean.nospring;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 对JAXB的轻微封装,摒弃了不常用的功能,只对外暴漏了简单的转换 如果要实现JAXB提供的高级功能,请直接使用JAXBContext等
 */
@SuppressWarnings("all")
public class XmlBeanMapping {

	private JAXBContext jaxbContext;

	private static final String ENCODING = "jaxb.encoding";
	private static final String FORMAT_OUTPUT = "jaxb.formatted.output";
	private static final String SCHEMA_LOCATION = "jaxb.schemaLocation";
	private static final String NO_NAMESPACE_SCHEMA_LOCATION = "jaxb.noNamespaceSchemaLocation";

	private String encoding;
	private Boolean formatOutput;
	private String schemaLocation;
	private String noNamespaceSchemaLocation;

	private String schemaFilepath;
	private String schemaClasspath;
	private Schema _schema;

	public XmlBeanMapping(Class... classesToBeBound) throws JAXBException {
		jaxbContext = JAXBContext.newInstance(classesToBeBound);
	}

	public XmlBeanMapping(String contextPath) throws JAXBException {
		jaxbContext = JAXBContext.newInstance(contextPath);
	}

	public XmlBeanMapping(Class[] classesToBeBound, Map<String, ?> properties) throws JAXBException {
		jaxbContext = JAXBContext.newInstance(classesToBeBound, properties);
	}

	public String getEncoding() {
		return encoding;
	}

	public boolean isFormatOutput() {
		return formatOutput;
	}

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public String getNoNamespaceSchemaLocation() {
		return noNamespaceSchemaLocation;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setFormatOutput(boolean formatOutput) {
		this.formatOutput = formatOutput;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public void setNoNamespaceSchemaLocation(String noNamespaceSchemaLocation) {
		this.noNamespaceSchemaLocation = noNamespaceSchemaLocation;
	}

	public void setSchemaClasspath(String schemaClasspath) {
		this.schemaClasspath = schemaClasspath;
		try {
			SchemaFactory facotry = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			_schema = facotry.newSchema(new StreamSource(this.getClass().getResourceAsStream(schemaClasspath)));
		} catch (SAXException e) {
			throw new IllegalArgumentException("schema parse 异常, 参数为" + schemaClasspath, e);
		}
	}

	public void setSchemaFilepath(String schemaFilepath) {
		this.schemaFilepath = schemaFilepath;
		try {
			SchemaFactory facotry = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			_schema = facotry.newSchema(new StreamSource(new File(schemaFilepath)));
		} catch (SAXException e) {
			throw new IllegalArgumentException("schema parse 异常, 参数为" + schemaFilepath, e);
		}
	}

	private Marshaller createMarshaller(ValidationEventHandler handler) throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		if (this.encoding != null) {
			marshaller.setProperty(ENCODING, this.encoding);
		}
		if (this.formatOutput != null) {
			marshaller.setProperty(FORMAT_OUTPUT, this.formatOutput);
		}
		if (this.schemaLocation != null) {
			marshaller.setProperty(SCHEMA_LOCATION, this.schemaLocation);
		}
		if (this.noNamespaceSchemaLocation != null) {
			marshaller.setProperty(NO_NAMESPACE_SCHEMA_LOCATION, this.noNamespaceSchemaLocation);
		}
		marshaller.setEventHandler(handler);
		if (_schema != null) {
			marshaller.setSchema(_schema);
		}
		
		return marshaller;
	}

	private Unmarshaller createUnmarshaller(ValidationEventHandler handler) throws JAXBException {
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		unmarshaller.setEventHandler(handler);
		if (_schema != null) {
			unmarshaller.setSchema(_schema);
		}
		return unmarshaller;
	}

	public Document beanToDom(Object jaxbElement) throws Exception {

		ValidationEventCollector handler = new ValidationEventCollector();

		Marshaller marshaller = createMarshaller(handler);

		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		marshaller.marshal(jaxbElement, doc);

		checkValidEvent(handler);

		return doc;
	}
	
	
	public byte[] beanToBytes(Object jaxbElement) throws Exception {

		ValidationEventCollector handler = new ValidationEventCollector();

		Marshaller marshaller = createMarshaller(handler);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(jaxbElement, baos);

		checkValidEvent(handler);

		return baos.toByteArray();
	}

	public void beanToStream(Object jaxbElement, OutputStream os) throws Exception {

		ValidationEventCollector handler = new ValidationEventCollector();

		Marshaller marshaller = createMarshaller(handler);

		marshaller.marshal(jaxbElement, os);

		checkValidEvent(handler);

	}

	public Object fileToBean(File file) throws Exception {

		Source source = new StreamSource(file);
		return unmarshal(source);
	}

	public Object bytesToBean(byte[] data) throws Exception {

		Source source = new StreamSource(new ByteArrayInputStream(data));
		return unmarshal(source);
	}

	public Object streamToBean(InputStream is) throws Exception {

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

		ValidationEventCollector handler = new ValidationEventCollector();

		Unmarshaller unmarshaller = createUnmarshaller(handler);

		Object jaxbElement = unmarshaller.unmarshal(source);

		checkValidEvent(handler);

		return jaxbElement;
	}

	/**
	 * 对于schema校验结果的简单封装
	 * 
	 * @param handler
	 * @throws Exception
	 */
	private void checkValidEvent(ValidationEventCollector handler) throws Exception {
		// 检测有误
		ValidationEvent[] events = handler.getEvents();
		if (events != null && events.length != 0) {
			ValidationEvent ve = events[0];
			String msg = ve.getMessage();
			ValidationEventLocator vel = ve.getLocator();
			int line = vel.getLineNumber();
			int column = vel.getColumnNumber();
			String level = null;
			switch (ve.getSeverity()) {
				case ValidationEvent.WARNING:
					level = "警告";
					break;
				default:
					level = "错误";
			}
			throw new Exception("XML " + level + ", 错误位于第" + line + "行, 第" + column + "列, " + msg);
		}
	}
}
