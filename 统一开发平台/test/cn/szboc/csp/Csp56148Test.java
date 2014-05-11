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
import cn.szboc.platform.component.csp.trade.commons.response.CspTradeResult;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_000440.response.StandardResponseBean_000440;
import cn.szboc.platform.component.csp.trade.trade_056048.response.StandardResponseBean_056048;
import cn.szboc.platform.component.csp.trade.trade_056148.response.StandardResponseBean_056148;
import cn.szboc.platform.component.csp.trade.trade_097511.response.StandardResponseBean_097511;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class Csp56148Test extends AbstractJUnit4SpringContextTests
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
//			String accountOut = "752357970734";
//			String accountIn = "777057970682";
			String accountOut = "743257970869";
			String accountIn = "756257970727";
			BigDecimal tradeAmt = new BigDecimal("5.55");
			ExecuteResponse<StandardResponseBean_000440> responseOut = null;
			responseOut = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountOut).setUpAccountSubType("CNY0").build().send();
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
			responseIn = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountIn).setUpAccountSubType("CNY0").build().send();
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
			
			String transNo = DateUtils.getDateTimeStrNo();
			
			System.out.println("\n###########################发送56048转账交易###########################");
			ExecuteResponse<StandardResponseBean_056048> respseon_56048 = null;
			respseon_56048 = factory.newRequestBuilder_056048()
									.newRequest("17836", "9880800")
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
									.setUpSubAccountType("CNY0")
									.setUpProdType("5502")
                					.setUpPcSubType("1001")
								  	.setCommonFiled(CspTradeCommonField.TRANS_NO, transNo)
								  	.build().send();
			
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
			responseOut = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountOut).setUpAccountSubType("CNY0").build().send();
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
			responseIn = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountIn).setUpAccountSubType("CNY0").build().send();
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
			
			System.out.println("\n###########################发送56148冲正交易###########################");
			ExecuteResponse<StandardResponseBean_056148> respseon_56148 = null;
			respseon_56148 = factory.newRequestBuilder_056148()
									.newRequest("17836", "9880800")
									.setUpAccountOut(accountOut)
									.setUpChqNo(chqNo)
									.setUpCusAmtStr(tradeAmt)
									.setUpPcCurrency("001")
									.setUpStrAmt(tradeAmt)
									.setUpCurrencyNo("001")
									.setUpResultAmt(tradeAmt)
									.setUpRevsTraceNo(cspNo)
								  	.build().send();
			if (respseon_56148.getResult().isTradeNormal())
			{
				if (respseon_56148.getResult().isTradeSuccess())
				{
					System.out.println("56148交易成功:");
				}
				else
				{
					System.out.println("56148交易失败:");
					System.out.println("返回码为:" + respseon_56148.getTradeResultBean().getCommonReturnCode());
				}
			}
			else
			{
				System.out.println("56148交易异常");
				respseon_56148.getThrowable().printStackTrace();
			}
			
			
			System.out.println("发送97511查询交易");
			
			ExecuteResponse<StandardResponseBean_097511> resp_97511 = factory.newRequestBuilder_097511()
					.newRequest("17836", "9880800")
					.setUpSystemTransNo(transNo)
					.setUpTransDate(DateUtils.getDateStrNO())
					.build()
					.send();
			
			if(resp_97511.getResult() == CspTradeResult.TRADE_SUCCESS){
				System.out.println("97511查询成功");
				System.out.println("原交易状态为:" + resp_97511.getTradeResultBean().getDownTransStatus());
			} else {
				System.out.println("97511查询失败");
			}
			
			
			System.out.println("\n###########################发送借方账户信息查询交易###########################");
			responseOut = null;
			responseOut = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountOut).setUpAccountSubType("CNY0").build().send();
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
			responseIn = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountIn).setUpAccountSubType("CNY0").build().send();
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