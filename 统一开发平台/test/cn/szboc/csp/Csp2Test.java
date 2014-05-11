package cn.szboc.csp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.component.csp.requestbuilder.CspTransactionRequestBuilderFactory;
import cn.szboc.platform.component.csp.trade.trade_000400.request.RequestAdapter_000400;
import cn.szboc.platform.component.csp.trade.trade_000400.response.ResponseAdapter_000400_OPT_1;
import cn.szboc.platform.component.msgbean.annotation.MessageField;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class Csp2Test extends AbstractJUnit4SpringContextTests {

	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;

	@Test
	public void test() {

		X x = new X(){
			public void x() {System.out.println(22);};
		};
		x.x();
		System.out.println(x.getClass());
		System.out.println(x.getClass().getSuperclass());
				
	}

	public static void main(String[] args) {
		X x = new X(){
			public void x() {System.out.println(22);};
		};
		x.x();
		System.out.println(x.getClass().getSuperclass());
	}
	
}

