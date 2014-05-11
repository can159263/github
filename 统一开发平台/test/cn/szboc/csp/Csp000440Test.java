package cn.szboc.csp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.component.csp.requestbuilder.CspTransactionRequestBuilderFactory;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_000440.response.StandardResponseBean_000440;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class Csp000440Test extends AbstractJUnit4SpringContextTests {

	
	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;

	@Test
	public void test() {

		try {
			
			System.out.println("\n###########################发送A00440信息查询交易###########################");
			
			String accountOut = "748457970832";
			
			ExecuteResponse<StandardResponseBean_000440>   responseOut = null;
			
			responseOut = 
			factory.newRequestBuilder_000440()
				.newRequest("17836", "9880800")
				.setUpAccountNo(accountOut)
				//.setUpAccountSubType("CNY0")
				.build().send();
			
			if (responseOut.getResult().isTradeNormal()) {
				if (responseOut.getResult().isTradeSuccess()) {
					System.out.println("000440交易成功:");
					System.out.println("账号:[" + accountOut + "]的机构号为:" + responseOut.getTradeResultBean().getDownBranchNo());
					System.out.println("账号:[" + accountOut + "]的金额为:" + responseOut.getTradeResultBean().getDownAmt());
					System.out.println("账号:[" + accountOut + "]的有效金额为:" + responseOut.getTradeResultBean().getDownEffectAmt());
					System.out.println("账号:[" + accountOut + "]的冻结金额为:" + responseOut.getTradeResultBean().getDownFrozenAmt());
				} else {
					System.out.println("000440交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("000440交易异常");
				responseOut.getThrowable().printStackTrace();
			}
			
			
			
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
