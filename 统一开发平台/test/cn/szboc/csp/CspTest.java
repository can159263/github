package cn.szboc.csp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.component.csp.requestbuilder.CspTransactionRequestBuilderFactory;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_000440.request.RequestAdapter_000440;
import cn.szboc.platform.component.csp.trade.trade_000440.response.StandardResponseBean2_000440;
import cn.szboc.platform.component.csp.trade.trade_000440.response.StandardResponseBean_000440;
import cn.szboc.platform.component.msgbean.annotation.MessageField;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class CspTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;

	@Test
	public void test() {

		try {
//			ExecuteResponse<ResponseBean_A00400_OPT_Wrapper> response = 
//			factory.newRequestBuilder_A00400()
//					.newRequest("00033", "9880800")
//					.setAccountNo("630157719665")
//					.setQueryOption("1")
//					.build()
//					.send();
			
//			factory.newRequestBuilder_000440()
//					.newRequest("17836", "9880800")
//					.setUpAccountNo("810108921508091001")
//					.setCommonFiled(CspTradeCommonField.SYSTEM_DATE, "")
//					.build()
//					.send();
			
			
			
			factory.newRequestBuilder_000400_OPT_1()
        			.newRequest("17836", "9880800")
        			.setUpAccountNo("800136489228406001");
        			//.send();
			
			ExecuteResponse<StandardResponseBean2_000440> res = 
			factory.newRequestBuilder_000440()
					.newRequest("17836", "9880800",new RequestAdapter_000440() {
						
						@MessageField(startPos = 300, length = 31)
						public String getUpAccountNo() {
							return "800136489228406001";
						}
						
					}).send(StandardResponseBean2_000440.class);
					
			ExecuteResponse<StandardResponseBean_000440> res2 = 
					factory.newRequestBuilder_000440()
							.newRequest("17836", "9880800")
							.send();
							
			
			
			System.out.println(res.getTradeResultBean().getCommonReturnCode());
			
			
			System.out.println();
		} catch(Exception e) {
			e.printStackTrace();
		}
				
	}
	
}
