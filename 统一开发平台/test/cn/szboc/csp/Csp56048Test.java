package cn.szboc.csp;

import java.math.BigDecimal;

import org.apache.commons.lang3.RandomStringUtils;
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
import cn.szboc.platform.component.csp.trade.trade_097511.response.StandardResponseBean_097511;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class Csp56048Test extends AbstractJUnit4SpringContextTests {

	
	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;

	@Test
	public void test() {

		try {
			
			System.out.println("\n###########################发送借方账户信息查询交易###########################");
			
//			String accountOut = "744557189184";
//			String accountIn = "743258562747";
//			String accountOut = "753657928730";
//			String accountIn = "745854135122";
			String accountOut = "767957970673";
			String accountIn = "749757970685";
			
//			String accountOut = "745854135122";
//			String accountIn = "800136489228406001";
			//String accountOut = "764057970564";
//			String accountOut = "524853391704";
//			String accountIn = "752358888828"; // 快付通生产账号
//			String accountOut = "756257970727"; // 财政局账号
			
			BigDecimal tradeAmt = new BigDecimal("0.01");
			
			ExecuteResponse<StandardResponseBean_000440> responseOut = null;
			responseOut = factory.newRequestBuilder_000440()
									.newRequest("17836", "9880800")
									.setUpAccountNo(accountOut)
									.setUpAccountSubType("CNY0")
									.build().send();
			if (responseOut.getResult().isTradeNormal()) {
				if (responseOut.getResult().isTradeSuccess()) {
					System.out.println("440交易成功:");
					System.out.println("账号:[" + accountOut + "]的余额为:" + responseOut.getTradeResultBean().getDownAmt());
				} else {
					System.out.println("440交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("交易异常");
				responseOut.getThrowable().printStackTrace();
			}
			
			System.out.println("###########################发送贷方账户信息查询交易###########################");
			
			ExecuteResponse<StandardResponseBean_000440> responseIn = null;
			responseIn = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountIn).setUpAccountSubType("CNY0").build().send();
			if (responseIn.getResult().isTradeNormal()) {
				if (responseIn.getResult().isTradeSuccess()) {
					System.out.println("440交易成功:");
					System.out.println("账号:[" + accountIn + "]的余额为:" + responseIn.getTradeResultBean().getDownAmt());
				} else {
					System.out.println("440交易失败:");
					System.out.println("返回码为:" + responseIn.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("交易异常");
				responseIn.getThrowable().printStackTrace();
			}
			
			
			System.out.println("\n###########################发送56048转账交易###########################");
			
			ExecuteResponse<StandardResponseBean_056048> respseon_56048 = null;
			
			String transNo = "S001" +  DateUtils.getDateTimeStrNo();
			
			System.out.println("CSP传票号是" + transNo);
			
			//.setUpDeductAccountSystemType("DEP")
			//.setUpApplyAccountNo(accountOut)
			//.setUpPayerSystemType("DEP")
			//.setUpPassbkFlag("N")
			//.setUpRecCurNo("001")
			//.setUpBenefitAcct(accountIn)
			//.setUpRecnoSys("DEP")
			respseon_56048 = factory.newRequestBuilder_056048()
                					.newRequest("17836", "9880800")
                					.setUpAccountOut(accountOut)
                					.setUpCusAmtStr(tradeAmt)
                					.setUpPromptCode("G8")
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
									//.setUpSubAccountType("CNY0")
									.setUpStatNar("手续费")
//                					.setUpProdType("5506")
//                					.setUpPcSubType("0610")
                					.setUpProdType("5502")
                					.setUpPcSubType("1001")
                					.setCommonFiled(CspTradeCommonField.TRANS_NO, transNo)
                					.build().send();
			
			if (respseon_56048.getResult().isTradeNormal()) {
				if (respseon_56048.getResult().isTradeSuccess()) {
					System.out.println("56048交易成功:");
				} else {
					System.out.println("56048交易失败:");
					System.out.println("返回码为:" + respseon_56048.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("56048交易异常");
				respseon_56048.getThrowable().printStackTrace();
			}
			
			System.out.println("交易完成,再次发送查询交易");
			
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
			if (responseOut.getResult().isTradeNormal()) {
				if (responseOut.getResult().isTradeSuccess()) {
					System.out.println("440交易成功:");
					System.out.println("账号:[" + accountOut + "]的余额为:" + responseOut.getTradeResultBean().getDownAmt());
				} else {
					System.out.println("440交易失败:");
					System.out.println("返回码为:" + responseOut.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("交易异常");
				responseOut.getThrowable().printStackTrace();
			}
			
			System.out.println("###########################发送贷方账户信息查询交易###########################");
			
			responseIn = null;
			responseIn = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountIn).setUpAccountSubType("CNY0").build().send();
			if (responseIn.getResult().isTradeNormal()) {
				if (responseIn.getResult().isTradeSuccess()) {
					System.out.println("440交易成功:");
					System.out.println("账号:[" + accountIn + "]的余额为:" + responseIn.getTradeResultBean().getDownAmt());
				} else {
					System.out.println("440交易失败:");
					System.out.println("返回码为:" + responseIn.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("交易异常");
				responseIn.getThrowable().printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
