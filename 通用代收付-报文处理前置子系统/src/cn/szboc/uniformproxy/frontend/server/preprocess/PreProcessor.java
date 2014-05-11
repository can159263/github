package cn.szboc.uniformproxy.frontend.server.preprocess;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import cn.szboc.platform.commons.thread.annotation.ThreadSafe;
import cn.szboc.platform.component.xmlbean.nospring.XmlBeanMapping;
import cn.szboc.uniformproxy.frontend.server.IMsgDataConvertor;
import cn.szboc.uniformproxy.frontend.server.preprocess.exception.XmlParseException;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;

/**
 * 前置处理器,负责报文的MD5校验,解压,解密等工作
 */
@ThreadSafe
public class PreProcessor {

	/**
	 * byte[]转换器
	 */
	private List<IMsgDataConvertor> convertors;

	/**
	 * bean <--> byte[]转换器
	 */
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
	 * 对二进制原始数据进行处理
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public byte[] decode(byte[] data) throws Exception {

		byte[] tmp = data;

		// byte->byte 转换
		if (convertors != null && !convertors.isEmpty()) {
			for (IMsgDataConvertor convertor : convertors) {
				// 当前都是二进制字节块操作的
				tmp = convertor.convert(tmp);
			}
		}

		return tmp;
	}

	/**
	 * 对处理完毕后的xml报文数据进行转bean处理
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public CommonRequestMessage process(byte[] data) throws Exception {
		return (CommonRequestMessage) xmlBeanMapping.bytesToBean(data);
	}
}
