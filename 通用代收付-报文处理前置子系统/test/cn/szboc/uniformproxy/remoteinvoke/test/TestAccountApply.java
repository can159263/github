package cn.szboc.uniformproxy.remoteinvoke.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:MessageRecvApplicatonContext.xml")
public class TestAccountApply {

	@Autowired
	@Qualifier("remoteInvokeService")
	private RemoteInvokeService service;

	@Test
	public void test() {

	}

}
