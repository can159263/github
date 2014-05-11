package cn.szboc.csp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.component.csp.requestbuilder.CspTransactionRequestBuilderFactory;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_000400.response.StandardResponseBean_000400_OPT_1;
import cn.szboc.platform.component.csp.trade.trade_000400.response.StandardResponseBean_000400_OPT_6;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class Csp000400_6Test extends AbstractJUnit4SpringContextTests {

	
	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;

	@Test
	public void test() {

		try {
			
			System.out.println("\n###########################发送A00400信息查询交易###########################");
			
			String accountOut = "754957970567";
			
			ExecuteResponse<StandardResponseBean_000400_OPT_1>   responseOut_1 = null;
			
			responseOut_1 = 
			factory.newRequestBuilder_000400_OPT_1()
				.newRequest("17836", "9880800")
				.setUpAccountNo(accountOut)
				.setUpCurrencyNo("001")
				.setUpCashFlag("0")
				.build().send();
			
			if (responseOut_1.getResult().isTradeNormal()) {
				if (responseOut_1.getResult().isTradeSuccess()) {
					System.out.println("000400交易成功:");
					System.out.println("账号:[" + accountOut + "]的机构号为:" + responseOut_1.getTradeResultBean().getDownBranchNo());
					System.out.println("账号:[" + accountOut + "]的金额为:" + responseOut_1.getTradeResultBean().getDownAmt());
					System.out.println("账号:[" + accountOut + "]的币种为:" + responseOut_1.getTradeResultBean().getDownCurrencyNo());
					System.out.println("账号:[" + accountOut + "]的余额为:" + responseOut_1.getTradeResultBean().getDownAmt());
				} else {
					System.out.println("000400交易失败:");
					System.out.println("返回码为:" + responseOut_1.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("000400交易异常");
				responseOut_1.getThrowable().printStackTrace();
			}
			
			ExecuteResponse<StandardResponseBean_000400_OPT_6> responseOut_6 = null;
			
			responseOut_6 = 
					factory.newRequestBuilder_000400_OPT_6()
					.newRequest("17836", "9880800")
					.setUpAccountNo(accountOut)
					.build().send();
			
			if (responseOut_6.getResult().isTradeNormal()) {
				if (responseOut_6.getResult().isTradeSuccess()) {
					System.out.println("000400交易成功:");
					System.out.println("账号:[" + accountOut + "]的机构号为:" + responseOut_6.getTradeResultBean().getDownBranchNo());
					System.out.println("账号:[" + accountOut + "]的子账户类别为:" + responseOut_6.getTradeResultBean().getDownAccountSubType());
					System.out.println("账号:[" + accountOut + "]的客户号为:" + responseOut_6.getTradeResultBean().getDownCustomerNo());
					System.out.println("账号:[" + accountOut + "]的户名为:" + responseOut_6.getTradeResultBean().getDownCustomerName());
				} else {
					System.out.println("000400交易失败:");
					System.out.println("返回码为:" + responseOut_6.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("000400交易异常");
				responseOut_6.getThrowable().printStackTrace();
			}
			
			
			
			
			
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
