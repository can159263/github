package cn.szboc.csp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.component.csp.requestbuilder.CspTransactionRequestBuilderFactory;
import cn.szboc.platform.component.csp.requestbuilder.RequestBuilder_000440;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_000440.request.StandardRequestBean_000440;
import cn.szboc.platform.component.csp.trade.trade_020400.response.StandardResponseBean_020400;

/**
 * Copy Right Information : Forms Syntron <br>
 * Project : 统一开发平台(基于Spring) <br>
 * JDK version used : jdk1.6.0_29 <br>
 * Description : CSP020400测试用例<br>
 * Comments Name : Csp020400Test.java <br>
 * author : likw <br>
 * date : 2013-5-13 <br>
 * Version : 1.00 <br>
 * editor : <br>
 * editorDate : <br>
 */

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class Csp020400Test extends AbstractJUnit4SpringContextTests
{
	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;
	
	@Test
	public void test() {

		try {
			
			System.out.println("\n###########################发送020400信息查询交易###########################");
			
			String accountOut = "9178470019991001";
			
			ExecuteResponse<StandardResponseBean_020400>   responseOut = null;
			
			responseOut = 
			factory.newRequestBuilder_020400()
				.newRequest("17836", "9880800")
				.setUpBglAct(accountOut)
				.build()
				.send();

			if (responseOut.getResult().isTradeNormal()) {
				if (responseOut.getResult().isTradeSuccess()) {
					System.out.println("020400交易成功:");
					System.out.println("账号:[" + accountOut + "]的分类帐户名为:" + responseOut.getTradeResultBean().getDownAcctName());
					System.out.println("账号:[" + accountOut + "]的分行号为:" + responseOut.getTradeResultBean().getDownBranchNo());
					System.out.println("账号:[" + accountOut + "]的币别为:" + responseOut.getTradeResultBean().getDownCurrcyNo());
					System.out.println("账号:[" + accountOut + "]的帐户余额为:" + responseOut.getTradeResultBean().getDownAmt());
				} else {
					System.out.println("020400交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("020400交易异常");
				responseOut.getThrowable().printStackTrace();
			}
			
			
			
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
