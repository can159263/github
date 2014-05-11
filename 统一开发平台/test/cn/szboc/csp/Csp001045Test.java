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
import cn.szboc.platform.component.csp.trade.trade_001045.response.StandardResponseBean_001045;
import cn.szboc.platform.component.csp.trade.trade_097511.response.StandardResponseBean_097511;

@ContextConfiguration(locations = "classpath*:test-config/PlatformApplicatonContext-ext.xml")
public class Csp001045Test extends AbstractJUnit4SpringContextTests {

	
	@Autowired
	private CspTransactionRequestBuilderFactory factory;

	@Test
	public void test() {

		try {
			
			System.out.println("\n###########################发送借方账户信息查询交易###########################");
			
			String accountOut = "767957970673";
			String accountIn = "749757970685";
			
			ExecuteResponse<StandardResponseBean_000440> responseOut = null;
			responseOut = factory.newRequestBuilder_000440()
									.newRequest("17836", "9880800")
									.setUpAccountNo(accountOut)
									//.setUpAccountSubType("CNY0")
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
			responseIn = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountIn)
					//.setUpAccountSubType("CNY0")
					.build().send();
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
			
			
			System.out.println("\n###########################发送1045转账交易###########################");
			
			ExecuteResponse<StandardResponseBean_001045> respseon_001045 = null;
			
			BigDecimal tradeAmt = new BigDecimal("100");
			
			String transNo = "S001" +  DateUtils.getDateTimeStrNo();
			
			respseon_001045 = factory.newRequestBuilder_001045()
                					.newRequest("17836", "9880800")
                					.setUpAccountNoOut(accountOut)
                					.setUpAccountNoIn(accountIn)
                					.setUpPromptCode("NF")
                					.setUpAmt(tradeAmt)
                					.setUpCurrcyNo("001")
                					.setUpBrief("扣款测试")
//                					.setUpLinkCurFlag("0")
//                					.setUpPcBancsCode("55021001")
                					.setCommonFiled(CspTradeCommonField.TRANS_NO, transNo)
                					.build().send();
			
			if (respseon_001045.getResult().isTradeNormal()) {
				if (respseon_001045.getResult().isTradeSuccess()) {
					System.out.println("001045交易成功:");
					System.out.println("001045交易CSP流水号为:" + respseon_001045.getTradeResultBean().getCommonCspNo());
				} else {
					System.out.println("001045交易失败:");
					System.out.println("返回码为:" + respseon_001045.getTradeResultBean().getCommonReturnCode());
				}
			} else {
				System.out.println("001045交易异常");
				respseon_001045.getThrowable().printStackTrace();
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
				System.out.println("原交易CSP接口流水号为:" + resp_97511.getTradeResultBean().getDownQueryCspTransNo());
			} else {
				System.out.println("97511查询失败");
			}
			
			
			System.out.println("\n###########################发送借方账户信息查询交易###########################");
			
			
			responseOut = null;
			responseOut = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountOut)
					//.setUpAccountSubType("CNY0")
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
			
			responseIn = null;
			responseIn = factory.newRequestBuilder_000440().newRequest("17836", "9880800").setUpAccountNo(accountIn)
					//.setUpAccountSubType("CNY0")
					.build().send();
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
