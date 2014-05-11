package cn.szboc.csp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.component.csp.requestbuilder.CspTransactionRequestBuilderFactory;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_000400.response.StandardResponseBean_000400_OPT_1;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class Csp000400Test extends AbstractJUnit4SpringContextTests {

	
	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;

	@Test
	public void test() {

		try {
			
			System.out.println("\n###########################发送A00400信息查询交易###########################");
			
			String accountOut = "769257928666";
			
			ExecuteResponse<StandardResponseBean_000400_OPT_1>   responseOut = null;
			
			responseOut = factory.newRequestBuilder_000400_OPT_1()
                				.newRequest("17836", "9880800")
                				.setUpAccountNo(accountOut)
                				.setUpCurrencyNo("001")
                				.setUpCashFlag("0")
                				.build().send();
			
			if (responseOut.getResult().isTradeNormal()) {
				if (responseOut.getResult().isTradeSuccess()) {
					System.out.println("000400交易成功:");
					System.out.println("账号:[" + accountOut + "]的账户名为:" + responseOut.getTradeResultBean().getDownAccountName());
					System.out.println("账号:[" + accountOut + "]的客户名为:" + responseOut.getTradeResultBean().getDownCustomerName());
					System.out.println("账号:[" + accountOut + "]的机构号为:" + responseOut.getTradeResultBean().getDownBranchNo());
					System.out.println("账号:[" + accountOut + "]的金额为:" + responseOut.getTradeResultBean().getDownAmt());
					System.out.println("账号:[" + accountOut + "]的币种为:" + responseOut.getTradeResultBean().getDownCurrencyNo());
				} else {
					System.out.println("000400交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("000400交易异常");
				responseOut.getThrowable().printStackTrace();
			}
			
			
			accountOut = "752357970734";
			
			responseOut = null;
			
			responseOut = 
			factory.newRequestBuilder_000400_OPT_1()
				.newRequest("17836", "9880800")
				.setUpAccountNo(accountOut)
				.build().send();
			
			if (responseOut.getResult().isTradeNormal()) {
				if (responseOut.getResult().isTradeSuccess()) {
					System.out.println("000400交易成功:");
					System.out.println("账号:[" + accountOut + "]的机构号为:" + responseOut.getTradeResultBean().getDownBranchNo());
					System.out.println("账号:[" + accountOut + "]的金额为:" + responseOut.getTradeResultBean().getDownAmt());
				} else {
					System.out.println("000400交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("000400交易异常");
				responseOut.getThrowable().printStackTrace();
			}
			
			
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
