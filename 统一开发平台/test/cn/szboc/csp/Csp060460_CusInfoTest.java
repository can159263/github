package cn.szboc.csp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.component.csp.requestbuilder.CspTransactionRequestBuilderFactory;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_060460.response.StandardResponseBean_060460_OPT_B;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class Csp060460_CusInfoTest extends AbstractJUnit4SpringContextTests
{
	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;
	
	@Test
	public void test()
	{
		try
		{
			System.out.println("\n###########################发送060460信息查询交易###########################");
			
			String accountOut = "200782825";
			ExecuteResponse<StandardResponseBean_060460_OPT_B> responseOut = null;
			responseOut = factory.newRequestBuilder_060460_OPT_B()
								 .newRequest("17836", "9880800")
								 .setUpALinkAccount(accountOut)
								 .setUpCusType("02")
								 .setUpStdDcFlag("C")
								 .setUpStdQueryOption("B")
								 .build()
								 .send();
			if (responseOut.getResult().isTradeNormal())
			{
				if (responseOut.getResult().isTradeSuccess())
				{
					System.out.println("060460交易成功:");
					System.out.println("账号:[" + accountOut + "]的开户行为:" + responseOut.getTradeResultBean().getDownCreatingBranch());
					System.out.println("账号:[" + accountOut + "]的所属行为:" + responseOut.getTradeResultBean().getDownBelongingBranch());
					System.out.println("账号:[" + accountOut + "]的客户号为:" + responseOut.getTradeResultBean().getDownCusNo());
					System.out.println("账号:[" + accountOut + "]的客户名为:" + responseOut.getTradeResultBean().getDownCusName());
					System.out.println("证件类型:" + responseOut.getTradeResultBean().getDownPassType());
					System.out.println("证件号码:" + responseOut.getTradeResultBean().getDownPassNo());
				}
				else
				{
					System.out.println("060460交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			}
			else
			{
				System.out.println("060460交易异常");
				responseOut.getThrowable().printStackTrace();
			}
			System.out.println();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}