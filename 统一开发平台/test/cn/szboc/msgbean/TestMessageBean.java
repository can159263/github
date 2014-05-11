package cn.szboc.msgbean;

import org.junit.Test;

import cn.szboc.platform.component.csp.trade.trade_000440.request.RequestAdapter_000440;
import cn.szboc.platform.component.msgbean.MessageBeanCotext;
import cn.szboc.platform.component.msgbean.exception.MsgBeanContextInitException;

public class TestMessageBean {

	@Test
	public void test() {
		try {
			MessageBeanCotext ctx = new MessageBeanCotext(RequestAdapter_000440.class);
			
		} catch (MsgBeanContextInitException e) {
			e.printStackTrace();
		}
	}

}
