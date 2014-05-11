package cn.szboc.platform.component.csp.trade.trade_A00400.response;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.To;

@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 638)
public class StandardResponseBean_A00400_OPT_6 extends ResponseAdapter_A00400_OPT_6 {

	@MessageField(startPos = 300, length = 17)
	public void setDownAccountNo(String downAccountNo) {
		super.setDownAccountNo(downAccountNo);
	}

	@MessageField(startPos = 317, length = 17)
	public void setDownCusId(String downCusId) {
		super.setDownCusId(downCusId);
	}

	@MessageField(startPos = 334, length = 34)
	public void setDownIdNumber(String downIdNumber) {
		super.setDownIdNumber(downIdNumber);
	}

	@MessageField(startPos = 368, length = 4)
	public void setDownSubAccountType(String downSubAccountType) {
		super.setDownSubAccountType(downSubAccountType);
	}

	@MessageField(startPos = 372, length = 3)
	public void setDownBookNo(String downBookNo) {
		super.setDownBookNo(downBookNo);
	}

	@MessageField(startPos = 375, length = 2)
	public void setDownSheetNo(String downSheetNo) {
		super.setDownSheetNo(downSheetNo);
	}

	@MessageField(startPos = 377, length = 60)
	public void setDownCustomerName(String downCustomerName) {
		super.setDownCustomerName(downCustomerName);
	}

	@MessageField(startPos = 437, length = 2)
	public void setDownNation(String downNation) {
		super.setDownNation(downNation);
	}

	@MessageField(startPos = 439, length = 1)
	public void setDownCnySettleAcctType(String downCnySettleAcctType) {
		super.setDownCnySettleAcctType(downCnySettleAcctType);
	}

	@MessageField(startPos = 440, length = 5)
	public void setDownBranchNo(String downBranchNo) {
		super.setDownBranchNo(downBranchNo);
	}

	@MessageField(startPos = 445, length = 5)
	public void setDownCustomerAttribute(String downCustomerAttribute) {
		super.setDownCustomerAttribute(downCustomerAttribute);
	}

	@MessageField(startPos = 450, length = 4)
	public void setDownAccountType(String downAccountType) {
		super.setDownAccountType(downAccountType);
	}

	@MessageField(startPos = 454, length = 4)
	public void setDownAccountSubType(String downAccountSubType) {
		super.setDownAccountSubType(downAccountSubType);
	}

	@MessageField(startPos = 458, length = 1)
	public void setDownWithdrawType(String downWithdrawType) {
		super.setDownWithdrawType(downWithdrawType);
	}

	@MessageField(startPos = 459, length = 8)
	public void setDownOpenDate(String downOpenDate) {
		super.setDownOpenDate(downOpenDate);
	}

	@MessageField(startPos = 467, length = 8)
	public void setDownValidDate(String downValidDate) {
		super.setDownValidDate(downValidDate);
	}

	@MessageField(startPos = 475, length = 8)
	public void setDownFreezeMatDate(String downFreezeMatDate) {
		super.setDownFreezeMatDate(downFreezeMatDate);
	}

	@MessageField(startPos = 483, length = 17)
	public void setDownSourceAcct(String downSourceAcct) {
		super.setDownSourceAcct(downSourceAcct);
	}

	@MessageField(startPos = 500, length = 4)
	public void setDownTermPeriod(String downTermPeriod) {
		super.setDownTermPeriod(downTermPeriod);
	}

	@MessageField(startPos = 504, length = 1)
	public void setDownBasisPeriod(String downBasisPeriod) {
		super.setDownBasisPeriod(downBasisPeriod);
	}

	@MessageField(startPos = 505, length = 2)
	public void setDownWithdrawIntFreq(String downWithdrawIntFreq) {
		super.setDownWithdrawIntFreq(downWithdrawIntFreq);
	}

	@MessageField(startPos = 507, length = 1)
	public void setDownContinueDep(String downContinueDep) {
		super.setDownContinueDep(downContinueDep);
	}

	@MessageField(startPos = 508, length = 1)
	public void setDownMatNotice(String downMatNotice) {
		super.setDownMatNotice(downMatNotice);
	}

	@MessageField(startPos = 509, length = 8)
	public void setDownMatDate(String downMatDate) {
		super.setDownMatDate(downMatDate);
	}

	@MessageField(startPos = 517, length = 1)
	public void setDownRateChgInd(String downRateChgInd) {
		super.setDownRateChgInd(downRateChgInd);
	}

	@MessageField(startPos = 518, length = 1)
	public void setDownRateType(String downRateType) {
		super.setDownRateType(downRateType);
	}

	@MessageField(startPos = 519, length = 4)
	public void setDownGroupID(String downGroupID) {
		super.setDownGroupID(downGroupID);
	}

	@MessageField(startPos = 523, length = 6)
	public void setDownFiller1(String downFiller1) {
		super.setDownFiller1(downFiller1);
	}

	@MessageField(startPos = 529, length = 4)
	public void setDownRatePeriod(String downRatePeriod) {
		super.setDownRatePeriod(downRatePeriod);
	}

	@MessageField(startPos = 533, length = 1)
	public void setDownTransferIntMth(String downTransferIntMth) {
		super.setDownTransferIntMth(downTransferIntMth);
	}

	@MessageField(startPos = 534, length = 17)
	public void setDownTransferAcct(String downTransferAcct) {
		super.setDownTransferAcct(downTransferAcct);
	}

	@MessageField(startPos = 551, length = 15)
	public void setDownCustLimitCode(String downCustLimitCode) {
		super.setDownCustLimitCode(downCustLimitCode);
	}

	@MessageField(startPos = 566, length = 6)
	public void setDownFiller2(String downFiller2) {
		super.setDownFiller2(downFiller2);
	}

	@MessageField(startPos = 572, length = 1)
	public void setDownRateIntMth(String downRateIntMth) {
		super.setDownRateIntMth(downRateIntMth);
	}

	@MessageField(startPos = 573, length = 1)
	public void setDownRateLnkInd(String downRateLnkInd) {
		super.setDownRateLnkInd(downRateLnkInd);
	}

	@MessageField(startPos = 574, length = 1)
	public void setDownSumOverdraw(String downSumOverdraw) {
		super.setDownSumOverdraw(downSumOverdraw);
	}

	@MessageField(startPos = 575, length = 2)
	public void setDownAppID(String downAppID) {
		super.setDownAppID(downAppID);
	}

	@MessageField(startPos = 577, length = 4)
	public void setDownFeeBonusCode(String downFeeBonusCode) {
		super.setDownFeeBonusCode(downFeeBonusCode);
	}

	@MessageField(startPos = 581, length = 1)
	public void setDownNoticeDealInd(String downNoticeDealInd) {
		super.setDownNoticeDealInd(downNoticeDealInd);
	}

	@MessageField(startPos = 582, length = 1)
	public void setDownNoticeInd(String downNoticeInd) {
		super.setDownNoticeInd(downNoticeInd);
	}

	@MessageField(startPos = 583, length = 17)
	public void setDownNoticeCust(String downNoticeCust) {
		super.setDownNoticeCust(downNoticeCust);
	}

	@MessageField(startPos = 600, length = 1)
	public void setDownStatePeriod(String downStatePeriod) {
		super.setDownStatePeriod(downStatePeriod);
	}

	@MessageField(startPos = 601, length = 2)
	public void setDownCycle(String downCycle) {
		super.setDownCycle(downCycle);
	}

	@MessageField(startPos = 603, length = 2)
	public void setDownDay(String downDay) {
		super.setDownDay(downDay);
	}

	@MessageField(startPos = 605, length = 2)
	public void setDownCopies(String downCopies) {
		super.setDownCopies(downCopies);
	}

	@MessageField(startPos = 607, length = 2)
	public void setDownLanguageCode(String downLanguageCode) {
		super.setDownLanguageCode(downLanguageCode);
	}

	@MessageField(startPos = 609, length = 1)
	public void setDownPostalInd(String downPostalInd) {
		super.setDownPostalInd(downPostalInd);
	}

	@MessageField(startPos = 610, length = 4)
	public void setDownAgentCode(String downAgentCode) {
		super.setDownAgentCode(downAgentCode);
	}

	@MessageField(startPos = 614, length = 4)
	public void setDownRegion(String downRegion) {
		super.setDownRegion(downRegion);
	}

	@MessageField(startPos = 618, length = 1)
	public void setDownTeamInd(String downTeamInd) {
		super.setDownTeamInd(downTeamInd);
	}

	@MessageField(startPos = 619, length = 1)
	public void setDownImpawnInd(String downImpawnInd) {
		super.setDownImpawnInd(downImpawnInd);
	}

	@MessageField(startPos = 620, length = 1)
	public void setDownForeignAccountAttr(String downForeignAccountAttr) {
		super.setDownForeignAccountAttr(downForeignAccountAttr);
	}

	@MessageField(startPos = 621, length = 8)
	public void setDownNegRate(String downNegRate) {
		super.setDownNegRate(downNegRate);
	}

	@MessageField(startPos = 629, length = 9)
	public void setDownRateAddCode(String downRateAddCode) {
		super.setDownRateAddCode(downRateAddCode);
	}

}
