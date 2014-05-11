package com.test.jaxb.A001;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.component.xmlbean.nospring.XmlBeanMapping;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.A001RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.A001RESPONSE.BODY;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.ObjectFactory;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESULTCODE;

@ContextConfiguration(locations = "classpath*:MessageRecvApplicatonContext.xml")
public class TestA001Response extends AbstractJUnit4SpringContextTests {

	@Autowired
	@Qualifier("KEY_XML_BEAN_MAPPING")
	private XmlBeanMapping xmlBeanMapping;

	@Test
	public void testOut() {

		ObjectFactory of = new ObjectFactory();

		A001RESPONSE response = of.createA001RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		head.setRESULTCODE(TRESULTCODE.SUCCESS);
		head.setRESULTDESC("交易成功");
		head.setSENDTIMESTAMP(new Date());
		head.setSYSCODE("S001");

		BODY body = of.createA001RESPONSEBODY();
		body.setEHLO(null);

		response.setHEAD(head);
		response.setBODY(body);

		try {
			xmlBeanMapping.beanToStream(response, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
