package cn.szboc.platform.component.csp.trade.trade_001045.response;

import java.math.BigDecimal;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.MessageGetEnhance;
import cn.szboc.platform.component.msgbean.annotation.To;
import cn.szboc.platform.component.msgbean.interseptor.buildin.BigDecimalAdjust100TimesInterceptor;

/**
 * 全量的CSP.001045交易响应Bean
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 507)
public class StandardResponseBean_001045 extends ResponseAdapter_001045 {

	@Override
	@MessageField(startPos = 300, length = 8)
	public void setDownDate(String downDate) {
		super.setDownCusId(downDate);
	}

	@Override
	@MessageField(startPos = 308, length = 8)
	public void setDownTime(String downTime) {
		super.setDownTime(downTime);
	}

	@Override
	@MessageField(startPos = 316, length = 17)
	public void setDownCusId(String downCusId) {
		super.setDownCusId(downCusId);
	}

	@Override
	@MessageField(startPos = 333, length = 16)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public void setDownOutCurrentAmt(BigDecimal downOutCurrentAmt) {
		super.setDownOutCurrentAmt(downOutCurrentAmt);
	}

	@Override
	@MessageField(startPos = 349, length = 16)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public void setDownOutAvailableAmt(BigDecimal downOutAvailableAmt) {
		super.setDownOutAvailableAmt(downOutAvailableAmt);
	}

	@Override
	@MessageField(startPos = 365, length = 5)
	public void setDownOutBranch(String downOutBranch) {
		super.setDownOutBranch(downOutBranch);
	}

	@Override
	@MessageField(startPos = 370, length = 5)
	public void setDownInBranch(String downInBranch) {
		super.setDownInBranch(downInBranch);
	}

	@Override
	@MessageField(startPos = 375, length = 16)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public void setDownInCurrentAmt(BigDecimal downInCurrentAmt) {
		super.setDownInCurrentAmt(downInCurrentAmt);
	}

	@Override
	@MessageField(startPos = 391, length = 16)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public void setDownInAvailableAmt(BigDecimal downInAvailableAmt) {
		super.setDownInAvailableAmt(downInAvailableAmt);
	}

	@Override
	@MessageField(startPos = 407, length = 16)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public void setDownFeeAmt1(BigDecimal downFeeAmt1) {
		super.setDownFeeAmt1(downFeeAmt1);
	}

	@Override
	@MessageField(startPos = 423, length = 16)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public void setDownFeeAmt2(BigDecimal downFeeAmt2) {
		super.setDownFeeAmt2(downFeeAmt2);
	}

	@Override
	@MessageField(startPos = 439, length = 16)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public void setDownFeeAmt3(BigDecimal downFeeAmt3) {
		super.setDownFeeAmt3(downFeeAmt3);
	}

	@Override
	@MessageField(startPos = 455, length = 16)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public void setDownFeeAmt4(BigDecimal downFeeAmt4) {
		super.setDownFeeAmt4(downFeeAmt4);
	}

	@Override
	@MessageField(startPos = 471, length = 16)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public void setDownFeeAmt5(BigDecimal downFeeAmt5) {
		super.setDownFeeAmt5(downFeeAmt5);
	}

	@Override
	@MessageField(startPos = 487, length = 3)
	public void setDownOutBookNo(String downOutBookNo) {
		super.setDownOutBookNo(downOutBookNo);
	}

	@Override
	@MessageField(startPos = 490, length = 2)
	public void setDownOutSeqNo(String downOutSeqNo) {
		super.setDownOutSeqNo(downOutSeqNo);
	}

	@Override
	@MessageField(startPos = 492, length = 3)
	public void setDownInBookNo(String downInBookNo) {
		super.setDownInBookNo(downInBookNo);
	}

	@Override
	@MessageField(startPos = 495, length = 2)
	public void setDownInSeqNo(String downInSeqNo) {
		super.setDownInSeqNo(downInSeqNo);
	}

	@Override
	@MessageField(startPos = 497, length = 10)
	public void setDownTradeRate(BigDecimal downTradeRate) {
		super.setDownTradeRate(downTradeRate);
	}

}
