package com.test.jaxb.A001;

import java.io.File;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.szboc.platform.component.xmlbean.nospring.XmlBeanMapping;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B001REQUEST;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:MessageRecvApplicatonContext.xml")
public class TestA001Request2 {

	@Autowired
	@Qualifier("KEY_XML_BEAN_MAPPING")
	private XmlBeanMapping xmlBeanMapping;

	@Test
	public void testIn() {

		final File file = new File("F:/Projects/快付通代收代付系统/设计文档/通信报文规则/统一/xml与xsd/B001_request.xml");
		
		System.out.println(new Date());
		
		for (int i = 0; i < 10000; i++) {
			
			final int x = i;
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					try {
						B001REQUEST o = (B001REQUEST) xmlBeanMapping.fileToBean(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println(x);
					
				}
			}).start();
		}
		
		
		
	}

}
