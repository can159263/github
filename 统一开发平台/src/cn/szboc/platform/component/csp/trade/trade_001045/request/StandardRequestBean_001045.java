package cn.szboc.platform.component.csp.trade.trade_001045.request;

import java.math.BigDecimal;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.MessageGetEnhance;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;
import cn.szboc.platform.component.msgbean.interseptor.buildin.BigDecimalAdjust100TimesInterceptor;

/**
 * 全量的CSP.001045交易请求Bean
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 512)
public class StandardRequestBean_001045 extends RequestAdapter_001045 {

	@Override
	@MessageField(startPos = 300, length = 22)
	public String getUpAccountNoOut() {
		return super.getUpAccountNoOut();
	}

	@Override
	@MessageField(startPos = 322, length = 16, type = PadType.LEFT, material = 48)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public BigDecimal getUpAmt() {
		return super.getUpAmt();
	}

	@Override
	@MessageField(startPos = 338, length = 2)
	public String getUpPromptCode() {
		return super.getUpPromptCode();
	}
	
	@Override
	@MessageField(startPos = 340, length = 22)
	public String getUpAccountNoIn() {
		return super.getUpAccountNoIn();
	}

	@Override
	@MessageField(startPos = 362, length = 3)
	public String getUpCurrcyNo() {
		return super.getUpCurrcyNo();
	}

	@Override
	@MessageField(startPos = 365, length = 50)
	public String getUpBrief() {
		return super.getUpBrief();
	}

	@Override
	@MessageField(startPos = 415, length = 3)
	public String getUpBookNo() {
		return super.getUpBookNo();
	}

	@Override
	@MessageField(startPos = 418, length = 2)
	public String getUpSheetNo() {
		return super.getUpSheetNo();
	}

	@Override
	@MessageField(startPos = 420, length = 1)
	public String getUpLinkCurFlag() {
		return super.getUpLinkCurFlag();
	}

	@Override
	@MessageField(startPos = 421, length = 8)
	public String getUpPcBancsCode() {
		return super.getUpPcBancsCode();
	}

	@Override
	@MessageField(startPos = 429, length = 4)
	public String getUpPcTerm() {
		return super.getUpPcTerm();
	}

	@Override
	@MessageField(startPos = 433, length = 1)
	public String getUpPcBasis() {
		return super.getUpPcBasis();
	}

	@Override
	@MessageField(startPos = 434, length = 4)
	public String getUpVoteType() {
		return super.getUpVoteType();
	}

	@Override
	@MessageField(startPos = 438, length = 20)
	public String getUpVoteNo() {
		return super.getUpVoteNo();
	}

	@Override
	@MessageField(startPos = 458, length = 1)
	public String getUpWithType() {
		return super.getUpWithType();
	}

	@Override
	@MessageField(startPos = 459, length = 8)
	public String getUpOpenDate() {
		return super.getUpOpenDate();
	}

	@Override
	@MessageField(startPos = 467, length = 6)
	public String getUpCusPwd() {
		return super.getUpCusPwd();
	}

	@Override
	@MessageField(startPos = 473, length = 19)
	public String getUpCardNoOut() {
		return super.getUpCardNoOut();
	}

	@Override
	@MessageField(startPos = 492, length = 19)
	public String getUpCardNoIn() {
		return super.getUpCardNoIn();
	}

	@Override
	@MessageField(startPos = 511, length = 1)
	public String getUpPwdCheckFlag() {
		return super.getUpPwdCheckFlag();
	}
}
