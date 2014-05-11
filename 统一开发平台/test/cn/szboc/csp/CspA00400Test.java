package cn.szboc.csp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.component.csp.requestbuilder.CspTransactionRequestBuilderFactory;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_A00400.response.StandardResponseBean_A00400_OPT_1;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class CspA00400Test extends AbstractJUnit4SpringContextTests {

	
	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;

	@Test
	public void test() {

		try {
			
			System.out.println("\n###########################发送A00400信息查询交易###########################");
			
			//745854135122
			//753657928730
			//741957928501
			// 浙江 800134298708093001 371458346136
			
			/**
			 *	810111184208091001
             *  810111203508091001
             *  810111203508091001
             *  810106559508091001
             *  810111185008091001
             *  810111174608091001
             *  
             *  753657928730
			 */
			
			String accountOut = "756257970727";
			
			ExecuteResponse<StandardResponseBean_A00400_OPT_1>   responseOut = null;
			
			responseOut = 
			factory.newRequestBuilder_A00400_OPT_1()
				.newRequest("17836", "9880800")
				.setUpAccountNo(accountOut)
				.setUpProvinceCode("99")
				.build().send();
			
			if (responseOut.getResult().isTradeNormal()) {
				if (responseOut.getResult().isTradeSuccess()) {
					System.out.println("A00400交易成功:");
					System.out.println("账号:[" + accountOut + "]的机构号为:" + responseOut.getTradeResultBean().getDownBranchNo());
					System.out.println("账号:[" + accountOut + "]的户名为:" + responseOut.getTradeResultBean().getDownAccountName());
					System.out.println("账号:[" + accountOut + "]的客户名为:" + responseOut.getTradeResultBean().getDownCustomerName());
					System.out.println("账号:[" + accountOut + "]的币别为:" + responseOut.getTradeResultBean().getDownCurrencyNo());
				} else {
					System.out.println("A00400交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("A00400交易异常");
				responseOut.getThrowable().printStackTrace();
			}
			
			
			
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
