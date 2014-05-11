package cn.szboc.csp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.component.csp.requestbuilder.CspTransactionRequestBuilderFactory;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_097511.response.StandardResponseBean_097511;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class Csp097511Test extends AbstractJUnit4SpringContextTests {

	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;

	@Test
	public void test() {

		try {

			System.out.println("\n###########################发送A00400信息查询交易###########################");

			String accountOut = "743257970869";

			ExecuteResponse<StandardResponseBean_097511> responseOut = null;

			responseOut = factory.newRequestBuilder_097511()
								.newRequest("17836", "9880800")
								.setUpTransDate("20121109")
								.setUpSystemTransNo("CDS00001")
								.build().send();

			if (responseOut.getResult().isTradeNormal()) {
				if (responseOut.getResult().isTradeSuccess()) {
					StandardResponseBean_097511 rtnBean = responseOut.getTradeResultBean();
					System.out.println("097511交易成功:");
					System.out.println("查询返回的状态码是            :" + rtnBean.getDownTransStatus());
					System.out.println("查询返回的后台交易流水号:" + rtnBean.getDownQqueryBackgroundTransNo());
					System.out.println("查询返回的原返回码是        :" + rtnBean.getDownRetCode());
					System.out.println("查询返回的CSP流水号是  :" + rtnBean.getDownQueryCspTransNo());
				} else {
					System.out.println("097511交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("097511交易异常");
				responseOut.getThrowable().printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
