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
public class CspTransactionTest2 extends AbstractJUnit4SpringContextTests {

	private static String bankNo = "17836";
	private static String operator = "9880800";

	String accountIn = "773157928376";
	String accountOut = "753657928730";

	@Autowired
	@Qualifier("cspTransactionRequestBuilderFactory")
	private CspTransactionRequestBuilderFactory factory;

	private BigDecimal queryBalance(String accountNo) throws Exception {
		ExecuteResponse<StandardResponseBean_000440> responseOut = null;
		responseOut = factory.newRequestBuilder_000440().newRequest(bankNo, operator).setUpAccountNo(accountNo).build().send();
		if (responseOut.getResult().isTradeSuccess()) {
			return responseOut.getTradeResultBean().getDownAmt();
		}
		throw new Exception("查询余额失败");
	}

	private void deduct(String accountNoOut, String accountNoIn, BigDecimal amt) throws Exception {
		ExecuteResponse<StandardResponseBean_056048> respseon_56048 = null;
		StandardRequestBean_056048 request56048 = factory.newRequestBuilder_056048().newRequest(bankNo, operator);
		respseon_56048 = request56048.setUpAccountOut(accountNoOut).setUpCusAmtStr(amt).setUpPromptCode("NF").setUpAccountIn(accountNoIn)
				.setUpAccountInSystemType("DEP").setUpExchangeCurrencyNo("001").setUpStrAmt(amt).setUpDeductAccountSystemType("DEP")
				.setUpCurrencyNo("001").setUpLocalCurrencyAmt(amt).setUpExchangeRate(new BigDecimal("0.00000")).setUpBusProperty("0")
				.setUpTransferMode("R").setUpSource("T").setUpTransferDestination("1").setUpRate(new BigDecimal("0.00000"))
				.setUpLinkCurrencyNo("001").setUpSifOrgIdt("17836").setUpDeclareCancelFlag("N")
				.setCommonFiled(CspTradeCommonField.TRANS_NO, DateUtils.getDateTimeStrNo()).build().send();

		if (respseon_56048.getResult().isTradeSuccess()) {
			return;
		}
		throw new Exception("扣款失败");
	}

	@Test
	public void test() {
		try {
			factory.beginTransaction();
			
			System.out.println("查询余额:" + queryBalance(accountIn));
			
			System.out.println("扣一块钱:");
			deduct(accountOut, accountIn, new BigDecimal("1.00"));
			
			System.out.println("扣五块钱:");
			deduct(accountOut, accountIn, new BigDecimal("1.00"));

			if(true){
				throw new Exception();
			}
			
			factory.commit();
		} catch (Exception e) {
			try {
				factory.rollback();
			} catch (Exception e1) {
				System.out.println("冲正失败");
				e1.printStackTrace();
			}
		} finally {
			try {
				System.out.println("查询余额:" + queryBalance(accountIn));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}