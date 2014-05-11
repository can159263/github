package cn.szboc.platform.component.csp.trade.trade_A00400.response;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;

@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 1281)
public class StandardResponseBean_A00400_OPT_1 extends ResponseAdapter_A00400_OPT_1 {

	@MessageField(startPos = 300, length = 20, type = PadType.LEFT, material = 48)
	public void setDownAccountNo(String downAccountNo) {
		super.setDownAccountNo(downAccountNo);
	}

	@MessageField(startPos = 320, length = 3)
	public void setDownCurrencyNo(String downCurrencyNo) {
		super.setDownCurrencyNo(downCurrencyNo);
	}

	@MessageField(startPos = 323, length = 7)
	public void setDownAccountStatus(String downAccountStatus) {
		super.setDownAccountStatus(downAccountStatus);
	}

	@MessageField(startPos = 330, length = 5)
	public void setDownBranchNo(String downBranchNo) {
		super.setDownBranchNo(downBranchNo);
	}

	@MessageField(startPos = 335, length = 30)
	public void setDownAccountType(String downAccountType) {
		super.setDownAccountType(downAccountType);
	}

	@MessageField(startPos = 365, length = 4)
	public void setDownProcuctType(String downProcuctType) {
		super.setDownProcuctType(downProcuctType);
	}

	@MessageField(startPos = 369, length = 4)
	public void setDownPcSubType(String downPcSubType) {
		super.setDownPcSubType(downPcSubType);
	}

	@MessageField(startPos = 373, length = 4)
	public void setDownInterestMode(String downInterestMode) {
		super.setDownInterestMode(downInterestMode);
	}

	@MessageField(startPos = 377, length = 7)
	public void setDownFiller1(String downFiller1) {
		super.setDownFiller1(downFiller1);
	}

	@MessageField(startPos = 384, length = 60)
	public void setDownAccountName(String downAccountName) {
		super.setDownAccountName(downAccountName);
	}

	@MessageField(startPos = 444, length = 60)
	public void setDownCustomerName(String downCustomerName) {
		super.setDownCustomerName(downCustomerName);
	}

	@MessageField(startPos = 504, length = 12)
	public void setDownPhoneOfHouse(String downPhoneOfHouse) {
		super.setDownPhoneOfHouse(downPhoneOfHouse);
	}

	@MessageField(startPos = 516, length = 12)
	public void setDownPhoneOfCompany(String downPhoneOfCompany) {
		super.setDownPhoneOfCompany(downPhoneOfCompany);
	}

	@MessageField(startPos = 528, length = 10)
	public void setDownAccountOpenDate(String downAccountOpenDate) {
		super.setDownAccountOpenDate(downAccountOpenDate);
	}

	@MessageField(startPos = 538, length = 10)
	public void setDownLastMaintainDate(String downLastMaintainDate) {
		super.setDownLastMaintainDate(downLastMaintainDate);
	}

	@MessageField(startPos = 548, length = 10)
	public void setDownLastTradeDate(String downLastTradeDate) {
		super.setDownLastTradeDate(downLastTradeDate);
	}

	@MessageField(startPos = 558, length = 10)
	public void setDownInterestFromDate(String downInterestFromDate) {
		super.setDownInterestFromDate(downInterestFromDate);
	}

	@MessageField(startPos = 568, length = 10)
	public void setDownInterestEndDate(String downInterestEndDate) {
		super.setDownInterestEndDate(downInterestEndDate);
	}

	@MessageField(startPos = 578, length = 9)
	public void setDownRate(String downRate) {
		super.setDownRate(downRate);
	}

	@MessageField(startPos = 587, length = 1)
	public void setDownFiller2(String downFiller2) {
		super.setDownFiller2(downFiller2);
	}

	@MessageField(startPos = 588, length = 19)
	public void setDownCurrentBalance(String downCurrentBalance) {
		super.setDownCurrentBalance(downCurrentBalance);
	}

	@MessageField(startPos = 607, length = 19)
	public void setDownUnclearedAmount(String downUnclearedAmount) {
		super.setDownUnclearedAmount(downUnclearedAmount);
	}

	@MessageField(startPos = 626, length = 19)
	public void setDownNpbValue(String downNpbValue) {
		super.setDownNpbValue(downNpbValue);
	}

	@MessageField(startPos = 645, length = 19)
	public void setDownInterestAvailable(String downInterestAvailable) {
		super.setDownInterestAvailable(downInterestAvailable);
	}

	@MessageField(startPos = 664, length = 19)
	public void setDownPbookBalance(String downPbookBalance) {
		super.setDownPbookBalance(downPbookBalance);
	}

	@MessageField(startPos = 683, length = 19)
	public void setDownNoInterestAmount(String downNoInterestAmount) {
		super.setDownNoInterestAmount(downNoInterestAmount);
	}

	@MessageField(startPos = 702, length = 19)
	public void setDownInflatedBalance(String downInflatedBalance) {
		super.setDownInflatedBalance(downInflatedBalance);
	}

	@MessageField(startPos = 721, length = 19)
	public void setDownPreInterestAdjustment(String downPreInterestAdjustment) {
		super.setDownPreInterestAdjustment(downPreInterestAdjustment);
	}

	@MessageField(startPos = 740, length = 2)
	public void setDownChequeBooksOnOrder(String downChequeBooksOnOrder) {
		super.setDownChequeBooksOnOrder(downChequeBooksOnOrder);
	}

	@MessageField(startPos = 742, length = 8)
	public void setDownTermCheque(String downTermCheque) {
		super.setDownTermCheque(downTermCheque);
	}

	@MessageField(startPos = 750, length = 19)
	public void setDownInterestSumOfYear(String downInterestSumOfYear) {
		super.setDownInterestSumOfYear(downInterestSumOfYear);
	}

	@MessageField(startPos = 769, length = 10)
	public void setDownLastOverLimitDate(String downLastOverLimitDate) {
		super.setDownLastOverLimitDate(downLastOverLimitDate);
	}

	@MessageField(startPos = 779, length = 19)
	public void setDownResWithTax(String downResWithTax) {
		super.setDownResWithTax(downResWithTax);
	}

	@MessageField(startPos = 798, length = 19)
	public void setDownNonResWithTax(String downNonResWithTax) {
		super.setDownNonResWithTax(downNonResWithTax);
	}

	@MessageField(startPos = 817, length = 17)
	public void setDownCreditLimit(String downCreditLimit) {
		super.setDownCreditLimit(downCreditLimit);
	}

	@MessageField(startPos = 834, length = 19)
	public void setDownCurrVisaInterest(String downCurrVisaInterest) {
		super.setDownCurrVisaInterest(downCurrVisaInterest);
	}

	@MessageField(startPos = 853, length = 17)
	public void setDownAvailableCredit(String downAvailableCredit) {
		super.setDownAvailableCredit(downAvailableCredit);
	}

	@MessageField(startPos = 870, length = 19)
	public void setDownCurrPurchases(String downCurrPurchases) {
		super.setDownCurrPurchases(downCurrPurchases);
	}

	@MessageField(startPos = 889, length = 19)
	public void setDownLastMinPayment(String downLastMinPayment) {
		super.setDownLastMinPayment(downLastMinPayment);
	}

	@MessageField(startPos = 908, length = 19)
	public void setDownCurrCashAdvances(String downCurrCashAdvances) {
		super.setDownCurrCashAdvances(downCurrCashAdvances);
	}

	@MessageField(startPos = 927, length = 19)
	public void setDownCashIntApplied(String downCashIntApplied) {
		super.setDownCashIntApplied(downCashIntApplied);
	}

	@MessageField(startPos = 946, length = 19)
	public void setDownPurchIntApplied(String downPurchIntApplied) {
		super.setDownPurchIntApplied(downPurchIntApplied);
	}

	@MessageField(startPos = 965, length = 5)
	public void setDownSecuirityCode(String downSecuirityCode) {
		super.setDownSecuirityCode(downSecuirityCode);
	}

	@MessageField(startPos = 970, length = 7)
	public void setDownFiller3(String downFiller3) {
		super.setDownFiller3(downFiller3);
	}

	@MessageField(startPos = 977, length = 5)
	public void setDownNewBranchNo(String downNewBranchNo) {
		super.setDownNewBranchNo(downNewBranchNo);
	}

	@MessageField(startPos = 982, length = 1)
	public void setDownStatementFreq(String downStatementFreq) {
		super.setDownStatementFreq(downStatementFreq);
	}

	@MessageField(startPos = 983, length = 2)
	public void setDownCycle(String downCycle) {
		super.setDownCycle(downCycle);
	}

	@MessageField(startPos = 985, length = 2)
	public void setDownDay(String downDay) {
		super.setDownDay(downDay);
	}

	@MessageField(startPos = 987, length = 20)
	public void setDownPassbookNo(String downPassbookNo) {
		super.setDownPassbookNo(downPassbookNo);
	}

	@MessageField(startPos = 1007, length = 2)
	public void setDownPbLineNo(String downPbLineNo) {
		super.setDownPbLineNo(downPbLineNo);
	}

	@MessageField(startPos = 1009, length = 4)
	public void setDownNcdRefCode(String downNcdRefCode) {
		super.setDownNcdRefCode(downNcdRefCode);
	}

	@MessageField(startPos = 1013, length = 12)
	public void setDownNcdNegIntCode(String downNcdNegIntCode) {
		super.setDownNcdNegIntCode(downNcdNegIntCode);
	}

	@MessageField(startPos = 1025, length = 65)
	public void setDownFiller4(String downFiller4) {
		super.setDownFiller4(downFiller4);
	}

	@MessageField(startPos = 1090, length = 10)
	public void setDownOpenPostDate(String downOpenPostDate) {
		super.setDownOpenPostDate(downOpenPostDate);
	}

	@MessageField(startPos = 1100, length = 25)
	public void setDownGlClassificationCode(String downGlClassificationCode) {
		super.setDownGlClassificationCode(downGlClassificationCode);
	}

	@MessageField(startPos = 1125, length = 10)
	public void setDownLastAcctTypeChg(String downLastAcctTypeChg) {
		super.setDownLastAcctTypeChg(downLastAcctTypeChg);
	}

	@MessageField(startPos = 1135, length = 19)
	public void setDownOdIntetrestAvalable(String downOdIntetrestAvalable) {
		super.setDownOdIntetrestAvalable(downOdIntetrestAvalable);
	}

	@MessageField(startPos = 1154, length = 35)
	public void setDownFiller5(String downFiller5) {
		super.setDownFiller5(downFiller5);
	}

	@MessageField(startPos = 1189, length = 10)
	public void setDownChqDishonorCount(String downChqDishonorCount) {
		super.setDownChqDishonorCount(downChqDishonorCount);
	}

	@MessageField(startPos = 1199, length = 10)
	public void setDownCancelChqDishonorCount(String downCancelChqDishonorCount) {
		super.setDownCancelChqDishonorCount(downCancelChqDishonorCount);
	}

	@MessageField(startPos = 1209, length = 1)
	public void setDownBranchNoInd(String downBranchNoInd) {
		super.setDownBranchNoInd(downBranchNoInd);
	}

	@MessageField(startPos = 1210, length = 2)
	public void setDownPbVersion(String downPbVersion) {
		super.setDownPbVersion(downPbVersion);
	}

	@MessageField(startPos = 1212, length = 1)
	public void setDownPassbookStatus(String downPassbookStatus) {
		super.setDownPassbookStatus(downPassbookStatus);
	}

	@MessageField(startPos = 1213, length = 1)
	public void setDownChopStatus(String downChopStatus) {
		super.setDownChopStatus(downChopStatus);
	}

	@MessageField(startPos = 1214, length = 7)
	public void setDownCertificateNo(String downCertificateNo) {
		super.setDownCertificateNo(downCertificateNo);
	}

	@MessageField(startPos = 1221, length = 1)
	public void setDownCertificateStatus(String downCertificateStatus) {
		super.setDownCertificateStatus(downCertificateStatus);
	}

	@MessageField(startPos = 1222, length = 2)
	public void setDownFiller6(String downFiller6) {
		super.setDownFiller6(downFiller6);
	}

	@MessageField(startPos = 1224, length = 10)
	public void setDownAgreementSignoff(String downAgreementSignoff) {
		super.setDownAgreementSignoff(downAgreementSignoff);
	}

	@MessageField(startPos = 1234, length = 4)
	public void setDownComplexTd(String downComplexTd) {
		super.setDownComplexTd(downComplexTd);
	}

	@MessageField(startPos = 1238, length = 10)
	public void setDownBlackListDate(String downBlackListDate) {
		super.setDownBlackListDate(downBlackListDate);
	}

	@MessageField(startPos = 1248, length = 17)
	public void setDownITypeIntAccr(String downITypeIntAccr) {
		super.setDownITypeIntAccr(downITypeIntAccr);
	}

	@MessageField(startPos = 1265, length = 15)
	public void setDownTransmitIntAccr(String downTransmitIntAccr) {
		super.setDownTransmitIntAccr(downTransmitIntAccr);
	}

	@MessageField(startPos = 1280, length = 1)
	public void setDownAbandonOffset(String downAbandonOffset) {
		super.setDownAbandonOffset(downAbandonOffset);
	}

}
