package com.test.jaxb.A001;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.io.FileUtils;
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
public class TestA001Request {

	@Autowired
	@Qualifier("KEY_XML_BEAN_MAPPING")
	private XmlBeanMapping xmlBeanMapping;

	private byte[] b;
	
	@Test
	public void testIn() {

		final File file = new File("F:/Projects/快付通代收代付系统/设计文档/通信报文规则/统一/xml与xsd/B005_request.xml");
		
		try {
			b = FileUtils.readFileToByteArray(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		final ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		
		System.out.println(new Date());
		
		for(int i = 0; i < 100; i ++){
			
			final int x = i;
			service.execute(new Runnable() {
				
				@Override
				public void run() {
					try {
						Object o = xmlBeanMapping.bytesToBean(b);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			});
		}
		
		System.out.println(new Date());
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while(true){
					try {
						Thread.sleep(1000);
						System.out.println(service.getCompletedTaskCount());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		
		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
