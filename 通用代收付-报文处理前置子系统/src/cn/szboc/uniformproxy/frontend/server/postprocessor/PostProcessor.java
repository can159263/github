package cn.szboc.uniformproxy.frontend.server.postprocessor;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import cn.szboc.platform.component.xmlbean.nospring.XmlBeanMapping;
import cn.szboc.uniformproxy.frontend.server.IMsgDataConvertor;
import cn.szboc.uniformproxy.frontend.server.preprocess.exception.XmlParseException;

/**
 * 后置处理器
 */
public class PostProcessor {

	private List<IMsgDataConvertor> convertors;

	private XmlBeanMapping xmlBeanMapping;

	@Required
	public void setXmlBeanMapping(XmlBeanMapping xmlBeanMapping) {
		this.xmlBeanMapping = xmlBeanMapping;
	}

	@Required
	public void setConvertors(List<IMsgDataConvertor> convertors) {
		this.convertors = convertors;
	}

	/**
	 * 从Bean转为xml字节数据
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public byte[] process(Object bean) throws Exception {

		try {
			return xmlBeanMapping.beanToBytes(bean);
		} catch (Exception e) {
			throw new XmlParseException("将bean转换为字节数组时出现异常", e);
		}

	}
	
	/**
	 * 转码
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public byte[] decode(byte[] data) throws Exception {

		byte[] tmp = data;
		
		if (convertors != null && !convertors.isEmpty()) {
			for (IMsgDataConvertor convertor : convertors) {
				tmp = convertor.convert(tmp);
			}
		}

		return tmp;
	}
	
}
