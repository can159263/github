package cn.szboc.csp;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.commons.DateUtils;
import cn.szboc.platform.component.csp.requestbuilder.CspTransactionRequestBuilderFactory;
import cn.szboc.platform.component.csp.trade.commons.CspTradeCommonField;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_000440.response.StandardResponseBean_000440;
import cn.szboc.platform.component.csp.trade.trade_056048.request.StandardRequestBean_056048;
import cn.szboc.platform.component.csp.trade.trade_056048.response.StandardResponseBean_056048;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class CspRollbackTest extends AbstractJUnit4SpringContextTests
{
	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;
	
	@Test
	public void test()
	{
		try
		{
			System.out.println("\n###########################发送借方账户信息查询交易###########################");
			String accountOut = "773157928376";
			String accountIn = "402658384704";
			ExecuteResponse<StandardResponseBean_000440> responseOut = null;
			responseOut = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountOut).build().send();
			if (responseOut.getResult().isTradeNormal())
			{
				if (responseOut.getResult().isTradeSuccess())
				{
					System.out.println("440交易成功:");
					System.out.println("账号:[" + accountOut + "]的余额为:" + responseOut.getTradeResultBean().getDownAmt());
				}
				else
				{
					System.out.println("440交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			}
			else
			{
				System.out.println("交易异常");
				responseOut.getThrowable().printStackTrace();
			}
			
			System.out.println("###########################发送贷方账户信息查询交易###########################");
			ExecuteResponse<StandardResponseBean_000440> responseIn = null;
			responseIn = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountIn).build().send();
			if (responseIn.getResult().isTradeNormal())
			{
				if (responseIn.getResult().isTradeSuccess())
				{
					System.out.println("440交易成功:");
					System.out.println("账号:[" + accountIn + "]的余额为:" + responseIn.getTradeResultBean().getDownAmt());
				}
				else
				{
					System.out.println("440交易失败:");
					System.out.println("返回码为:" + responseIn.getTradeResultBean().getCommonReturnCode());
				}
			}
			else
			{
				System.out.println("交易异常");
				responseIn.getThrowable().printStackTrace();
			}
			
			System.out.println("\n###########################发送56048转账交易###########################");
			ExecuteResponse<StandardResponseBean_056048> respseon_56048 = null;
			BigDecimal tradeAmt = new BigDecimal("0.01");
			StandardRequestBean_056048 request56048 = null;
			request56048 = factory.newRequestBuilder_056048()
					.newRequest("17836", "9880800");
			respseon_56048 = request56048
									.setUpAccountOut(accountOut)
									.setUpCusAmtStr(tradeAmt)
									.setUpPromptCode("NF")
									.setUpAccountIn(accountIn)
									.setUpAccountInSystemType("DEP")
								  	.setUpExchangeCurrencyNo("001")
								  	.setUpStrAmt(tradeAmt)
								  	.setUpDeductAccountSystemType("DEP")
								  	.setUpCurrencyNo("001")
								  	.setUpLocalCurrencyAmt(tradeAmt)
								  	.setUpExchangeRate(new BigDecimal("0.00000"))
								  	.setUpBusProperty("0")
								  	.setUpTransferMode("R")
								  	.setUpSource("T")
								  	.setUpTransferDestination("1")
								  	.setUpRate(new BigDecimal("0.00000"))
								  	.setUpLinkCurrencyNo("001")
								  	.setUpSifOrgIdt(responseIn.getTradeResultBean().getDownBranchNo())
								  	.setUpDeclareCancelFlag("N")
								  	.setCommonFiled(CspTradeCommonField.TRANS_NO, DateUtils.getDateTimeStrNo())
								  	.build()
								  	.send();
			
			//记录下汇款编号，冲正时会使用到
			String chqNo = respseon_56048.getTradeResultBean().getDownIpcsCode();
			//记录下CSP流水号，冲正时会使用到
			String cspNo = respseon_56048.getTradeResultBean().getCommonCspNo();
			
			if (respseon_56048.getResult().isTradeNormal())
			{
				if (respseon_56048.getResult().isTradeSuccess())
				{
					System.out.println("56048交易成功:");
				}
				else
				{
					System.out.println("56048交易失败:");
					System.out.println("返回码为:" + respseon_56048.getTradeResultBean().getCommonReturnCode());
				}
			}
			else
			{
				System.out.println("56048交易异常");
				respseon_56048.getThrowable().printStackTrace();
			}
			System.out.println("交易完成,再次发送查询交易");
			
			System.out.println("\n###########################发送借方账户信息查询交易###########################");
			responseOut = null;
			responseOut = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountOut).build().send();
			if (responseOut.getResult().isTradeNormal())
			{
				if (responseOut.getResult().isTradeSuccess())
				{
					System.out.println("440交易成功:");
					System.out.println("账号:[" + accountOut + "]的余额为:" + responseOut.getTradeResultBean().getDownAmt());
				}
				else
				{
					System.out.println("440交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			}
			else
			{
				System.out.println("交易异常");
				responseOut.getThrowable().printStackTrace();
			}
			
			System.out.println("###########################发送贷方账户信息查询交易###########################");
			responseIn = null;
			responseIn = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountIn).build().send();
			if (responseIn.getResult().isTradeNormal())
			{
				if (responseIn.getResult().isTradeSuccess())
				{
					System.out.println("440交易成功:");
					System.out.println("账号:[" + accountIn + "]的余额为:" + responseIn.getTradeResultBean().getDownAmt());
				}
				else
				{
					System.out.println("440交易失败:");
					System.out.println("返回码为:" + responseIn.getTradeResultBean().getCommonReturnCode());
				}
			}
			else
			{
				System.out.println("交易异常");
				responseIn.getThrowable().printStackTrace();
			}
			
			System.out.println("\n###########################发送56048的冲正交易###########################");
			request56048.rollback();
			
			
			
			System.out.println("\n###########################发送借方账户信息查询交易###########################");
			responseOut = null;
			responseOut = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountOut).build().send();
			if (responseOut.getResult().isTradeNormal())
			{
				if (responseOut.getResult().isTradeSuccess())
				{
					System.out.println("440交易成功:");
					System.out.println("账号:[" + accountOut + "]的余额为:" + responseOut.getTradeResultBean().getDownAmt());
				}
				else
				{
					System.out.println("440交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			}
			else
			{
				System.out.println("交易异常");
				responseOut.getThrowable().printStackTrace();
			}
			
			System.out.println("###########################发送贷方账户信息查询交易###########################");
			responseIn = null;
			responseIn = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountIn).build().send();
			if (responseIn.getResult().isTradeNormal())
			{
				if (responseIn.getResult().isTradeSuccess())
				{
					System.out.println("440交易成功:");
					System.out.println("账号:[" + accountIn + "]的余额为:" + responseIn.getTradeResultBean().getDownAmt());
				}
				else
				{
					System.out.println("440交易失败:");
					System.out.println("返回码为:" + responseIn.getTradeResultBean().getCommonReturnCode());
				}
			}
			else
			{
				System.out.println("交易异常");
				responseIn.getThrowable().printStackTrace();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}