package com.test.process;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.uniformproxy.frontend.server.process.processor.service.MessgeService;

@ContextConfiguration(locations = "classpath*:MessageRecvApplicatonContext.xml")
public class TestMsgControl extends AbstractJUnit4SpringContextTests {
	@Autowired
	@Qualifier("messgeService")
	private MessgeService messgeService;

	@Test
	public void test1() {

		Boolean result = null;
		try {
			result = this.messgeService.checkMsgControl("S001", "A001");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
		Assert.assertEquals(Boolean.FALSE, result);
	}
	
	@Test
	public void test2() {
		
		Boolean result = null;
		try {
			result = this.messgeService.checkMsgControl("S001", "xxxx");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
		Assert.assertEquals(null, result);
	}
}