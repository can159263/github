package cn.szboc.csp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.component.csp.requestbuilder.CspTransactionRequestBuilderFactory;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_009751.response.StandardResponseBean_009751;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class Csp009751Test extends AbstractJUnit4SpringContextTests {

	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;

	@Test
	public void test() {

		try {

			System.out.println("\n###########################发送A00400信息查询交易###########################");

			ExecuteResponse<StandardResponseBean_009751> responseOut = null;

			responseOut = factory.newRequestBuilder_009751()
								.newRequest("17836", "9880800")
								.setUpCspTransNo("03404606")
								.setUpCompareFlag("X")
								.build().send();

			if (responseOut.getResult().isTradeNormal()) {
				if (responseOut.getResult().isTradeSuccess()) {
					StandardResponseBean_009751 rtnBean = responseOut.getTradeResultBean();
					System.out.println("009751交易成功:");
					System.out.println("查询返回的状态码是            :" + rtnBean.getDownTransStatus());
					System.out.println("查询返回的后台bancs流水号:" + rtnBean.getDownBancsNo());
					System.out.println("查询返回的后台bancs日期为  :" + rtnBean.getDownBancsDate());
				} else {
					System.out.println("009751交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("009751交易异常");
				responseOut.getThrowable().printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
