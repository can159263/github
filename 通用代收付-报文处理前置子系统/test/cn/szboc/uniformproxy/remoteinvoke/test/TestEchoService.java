package cn.szboc.uniformproxy.remoteinvoke.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.A001REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.ObjectFactory;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TREQUESTHEAD;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:MessageRecvApplicatonContext.xml")
public class TestEchoService {

	private static ObjectFactory of = new ObjectFactory();
	
	@Autowired
	@Qualifier("remoteInvokeService")
	private RemoteInvokeService service;
	
	@Test
	public void test() {

		
		
		
	}

}
