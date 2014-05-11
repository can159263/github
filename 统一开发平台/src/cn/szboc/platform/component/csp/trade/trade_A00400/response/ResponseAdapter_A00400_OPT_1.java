package cn.szboc.platform.component.csp.trade.trade_A00400.response;

import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

@MessageBean(
	Target = To.TO_BEAN,
	ExpectedWriteSize = 1281
)
public class ResponseAdapter_A00400_OPT_1 extends ResponseAdapter_A00400 {

	// ===========================下载数据域=====================================
	/** 帐号			*/		private String downAccountNo;
	/** 币别			*/		private String downCurrencyNo;
	/** 账户状态		*/		private String downAccountStatus;
	/** 机构号			*/		private String downBranchNo;
	/** 账户类型		*/		private String downAccountType;
	/** 产品类型		*/		private String downProcuctType;
	/** 产品子类		*/		private String downPcSubType;
	/** 计息方式		*/		private String downInterestMode;
	/** FILTER_1	*/		private String downFiller1;
	/** 账户名称		*/		private String downAccountName;
	/** 客户名称		*/		private String downCustomerName;
	/** 住宅电话		*/		private String downPhoneOfHouse;
	/** 公司电话		*/		private String downPhoneOfCompany;
	/** 开户日期		*/		private String downAccountOpenDate;
	/** 上次维护日期		*/		private String downLastMaintainDate;
	/** 上次交易日期		*/		private String downLastTradeDate;
	/** 计息起日		*/		private String downInterestFromDate;
	/** 计息止日		*/		private String downInterestEndDate;
	/** 利率			*/		private String downRate;
	/** FILTER_2	*/		private String downFiller2;
	/** 当前余额		*/		private String downCurrentBalance;
	/** 未清算金额		*/		private String downUnclearedAmount;
	/** 无折存款额		*/		private String downNpbValue;
	/** 应付利息		*/		private String downInterestAvailable;
	/** 存折余额		*/		private String downPbookBalance;
	/** 不计息金额		*/		private String downNoInterestAmount;
	/** 通胀后余额		*/		private String downInflatedBalance;
	/** 前期利息调整		*/		private String downPreInterestAdjustment;
	/** 支票申请本数		*/		private String downChequeBooksOnOrder;
	/** 定期息支票		*/		private String downTermCheque;
	/** 年度利息总额		*/		private String downInterestSumOfYear;
	/** 上次超限日		*/		private String downLastOverLimitDate;
	/** 本国人代扣所得税	*/		private String downResWithTax;
	/** 外国人代扣所得税	*/		private String downNonResWithTax;
	/** 信用限额		*/		private String downCreditLimit;
	/** 当前VISA借记利息	*/		private String downCurrVisaInterest;
	/**	有效信用额		*/		private String downAvailableCredit;
	/**	当前购买		*/		private String downCurrPurchases;
	/**	上次最低付款		*/		private String downLastMinPayment;
	/**	当前现金预支		*/		private String downCurrCashAdvances;
	/**	现金预支利息		*/		private String downCashIntApplied;
	/**	购买利息		*/		private String downPurchIntApplied;
	/**	安全代码		*/		private String downSecuirityCode;
	/**	Filler3		*/		private String downFiller3;
	/**	新分行号		*/		private String downNewBranchNo;
	/**	对帐单周期		*/		private String downStatementFreq;
	/**	循环			*/		private String downCycle;
	/**	天			*/		private String downDay;
	/**	存折编号		*/		private String downPassbookNo;
	/**	存折行数		*/		private String downPbLineNo;
	/**	NCD Ref Code*/		private String downNcdRefCode;
	/**	NCD Neg.Int. Code*/	private String downNcdNegIntCode;
	/**	Filler4		*/		private String downFiller4;
	/**	交易日期		*/		private String downOpenPostDate;
	/**	总帐分类代码		*/		private String downGlClassificationCode;
	/**	Last Acct Type Chg*/private String downLastAcctTypeChg;
	/**	透支息			*/		private String downOdIntetrestAvalable;
	/**	Filler5		*/		private String downFiller5;
	/**	退票计数		*/		private String downChqDishonorCount;
	/**	取消退票计数		*/		private String downCancelChqDishonorCount;
	/**	Branch No/Ind	*/	private String downBranchNoInd;
	/**	PB Version	*/		private String downPbVersion;
	/**	Passbook Status	*/	private String downPassbookStatus;
	/**	印章状态		*/		private String downChopStatus;
	/**	存单号			*/		private String downCertificateNo;
	/**	存单状态		*/		private String downCertificateStatus;
	/**	Filler6		*/		private String downFiller6;
	/**	Agreement Signoff*/	private String downAgreementSignoff;
	/**	Complex TD	*/		private String downComplexTd;
	/**	Black List Date	*/	private String downBlackListDate;
	/**	IType Int Accr	*/	private String downITypeIntAccr;
	/**	Transmit Int Accr*/	private String downTransmitIntAccr;
	/**	Abandon Offset	*/	private String downAbandonOffset;
	// ========================= set & get =====================================

	public String getDownAccountNo() {
		return downAccountNo;
	}

	public String getDownCurrencyNo() {
		return downCurrencyNo;
	}

	public String getDownAccountStatus() {
		return downAccountStatus;
	}

	public String getDownBranchNo() {
		return downBranchNo;
	}

	public String getDownAccountType() {
		return downAccountType;
	}

	public String getDownProcuctType() {
		return downProcuctType;
	}

	public String getDownPcSubType() {
		return downPcSubType;
	}

	public String getDownInterestMode() {
		return downInterestMode;
	}

	public String getDownFiller1() {
		return downFiller1;
	}

	public String getDownAccountName() {
		return downAccountName;
	}

	public String getDownCustomerName() {
		return downCustomerName;
	}

	public String getDownPhoneOfHouse() {
		return downPhoneOfHouse;
	}

	public String getDownPhoneOfCompany() {
		return downPhoneOfCompany;
	}

	public String getDownAccountOpenDate() {
		return downAccountOpenDate;
	}

	public String getDownLastMaintainDate() {
		return downLastMaintainDate;
	}

	public String getDownLastTradeDate() {
		return downLastTradeDate;
	}

	public String getDownInterestFromDate() {
		return downInterestFromDate;
	}

	public String getDownInterestEndDate() {
		return downInterestEndDate;
	}

	public String getDownRate() {
		return downRate;
	}

	public String getDownFiller2() {
		return downFiller2;
	}

	public String getDownCurrentBalance() {
		return downCurrentBalance;
	}

	public String getDownUnclearedAmount() {
		return downUnclearedAmount;
	}

	public String getDownNpbValue() {
		return downNpbValue;
	}

	public String getDownInterestAvailable() {
		return downInterestAvailable;
	}

	public String getDownPbookBalance() {
		return downPbookBalance;
	}

	public String getDownNoInterestAmount() {
		return downNoInterestAmount;
	}

	public String getDownInflatedBalance() {
		return downInflatedBalance;
	}

	public String getDownPreInterestAdjustment() {
		return downPreInterestAdjustment;
	}

	public String getDownChequeBooksOnOrder() {
		return downChequeBooksOnOrder;
	}

	public String getDownTermCheque() {
		return downTermCheque;
	}

	public String getDownInterestSumOfYear() {
		return downInterestSumOfYear;
	}

	public String getDownLastOverLimitDate() {
		return downLastOverLimitDate;
	}

	public String getDownResWithTax() {
		return downResWithTax;
	}

	public String getDownNonResWithTax() {
		return downNonResWithTax;
	}

	public String getDownCreditLimit() {
		return downCreditLimit;
	}

	public String getDownCurrVisaInterest() {
		return downCurrVisaInterest;
	}

	public String getDownAvailableCredit() {
		return downAvailableCredit;
	}

	public String getDownCurrPurchases() {
		return downCurrPurchases;
	}

	public String getDownLastMinPayment() {
		return downLastMinPayment;
	}

	public String getDownCurrCashAdvances() {
		return downCurrCashAdvances;
	}

	public String getDownCashIntApplied() {
		return downCashIntApplied;
	}

	public String getDownPurchIntApplied() {
		return downPurchIntApplied;
	}

	public String getDownSecuirityCode() {
		return downSecuirityCode;
	}

	public String getDownFiller3() {
		return downFiller3;
	}

	public String getDownNewBranchNo() {
		return downNewBranchNo;
	}

	public String getDownStatementFreq() {
		return downStatementFreq;
	}

	public String getDownCycle() {
		return downCycle;
	}

	public String getDownDay() {
		return downDay;
	}

	public String getDownPassbookNo() {
		return downPassbookNo;
	}

	public String getDownPbLineNo() {
		return downPbLineNo;
	}

	public String getDownNcdRefCode() {
		return downNcdRefCode;
	}

	public String getDownNcdNegIntCode() {
		return downNcdNegIntCode;
	}

	public String getDownFiller4() {
		return downFiller4;
	}

	public String getDownOpenPostDate() {
		return downOpenPostDate;
	}

	public String getDownGlClassificationCode() {
		return downGlClassificationCode;
	}

	public String getDownLastAcctTypeChg() {
		return downLastAcctTypeChg;
	}

	public String getDownOdIntetrestAvalable() {
		return downOdIntetrestAvalable;
	}

	public String getDownFiller5() {
		return downFiller5;
	}

	public String getDownChqDishonorCount() {
		return downChqDishonorCount;
	}

	public String getDownCancelChqDishonorCount() {
		return downCancelChqDishonorCount;
	}

	public String getDownBranchNoInd() {
		return downBranchNoInd;
	}

	public String getDownPbVersion() {
		return downPbVersion;
	}

	public String getDownPassbookStatus() {
		return downPassbookStatus;
	}

	public String getDownChopStatus() {
		return downChopStatus;
	}

	public String getDownCertificateNo() {
		return downCertificateNo;
	}

	public String getDownCertificateStatus() {
		return downCertificateStatus;
	}

	public String getDownFiller6() {
		return downFiller6;
	}

	public String getDownAgreementSignoff() {
		return downAgreementSignoff;
	}

	public String getDownComplexTd() {
		return downComplexTd;
	}

	public String getDownBlackListDate() {
		return downBlackListDate;
	}

	public String getDownITypeIntAccr() {
		return downITypeIntAccr;
	}

	public String getDownTransmitIntAccr() {
		return downTransmitIntAccr;
	}

	public String getDownAbandonOffset() {
		return downAbandonOffset;
	}

	public void setDownAccountNo(String downAccountNo) {
		this.downAccountNo = downAccountNo;
	}

	public void setDownCurrencyNo(String downCurrencyNo) {
		this.downCurrencyNo = downCurrencyNo;
	}

	public void setDownAccountStatus(String downAccountStatus) {
		this.downAccountStatus = downAccountStatus;
	}

	public void setDownBranchNo(String downBranchNo) {
		this.downBranchNo = downBranchNo;
	}

	public void setDownAccountType(String downAccountType) {
		this.downAccountType = downAccountType;
	}

	public void setDownProcuctType(String downProcuctType) {
		this.downProcuctType = downProcuctType;
	}

	public void setDownPcSubType(String downPcSubType) {
		this.downPcSubType = downPcSubType;
	}

	public void setDownInterestMode(String downInterestMode) {
		this.downInterestMode = downInterestMode;
	}

	public void setDownFiller1(String downFiller1) {
		this.downFiller1 = downFiller1;
	}

	public void setDownAccountName(String downAccountName) {
		this.downAccountName = downAccountName;
	}

	public void setDownCustomerName(String downCustomerName) {
		this.downCustomerName = downCustomerName;
	}

	public void setDownPhoneOfHouse(String downPhoneOfHouse) {
		this.downPhoneOfHouse = downPhoneOfHouse;
	}

	public void setDownPhoneOfCompany(String downPhoneOfCompany) {
		this.downPhoneOfCompany = downPhoneOfCompany;
	}

	public void setDownAccountOpenDate(String downAccountOpenDate) {
		this.downAccountOpenDate = downAccountOpenDate;
	}

	public void setDownLastMaintainDate(String downLastMaintainDate) {
		this.downLastMaintainDate = downLastMaintainDate;
	}

	public void setDownLastTradeDate(String downLastTradeDate) {
		this.downLastTradeDate = downLastTradeDate;
	}

	public void setDownInterestFromDate(String downInterestFromDate) {
		this.downInterestFromDate = downInterestFromDate;
	}

	public void setDownInterestEndDate(String downInterestEndDate) {
		this.downInterestEndDate = downInterestEndDate;
	}

	public void setDownRate(String downRate) {
		this.downRate = downRate;
	}

	public void setDownFiller2(String downFiller2) {
		this.downFiller2 = downFiller2;
	}

	public void setDownCurrentBalance(String downCurrentBalance) {
		this.downCurrentBalance = downCurrentBalance;
	}

	public void setDownUnclearedAmount(String downUnclearedAmount) {
		this.downUnclearedAmount = downUnclearedAmount;
	}

	public void setDownNpbValue(String downNpbValue) {
		this.downNpbValue = downNpbValue;
	}

	public void setDownInterestAvailable(String downInterestAvailable) {
		this.downInterestAvailable = downInterestAvailable;
	}

	public void setDownPbookBalance(String downPbookBalance) {
		this.downPbookBalance = downPbookBalance;
	}

	public void setDownNoInterestAmount(String downNoInterestAmount) {
		this.downNoInterestAmount = downNoInterestAmount;
	}

	public void setDownInflatedBalance(String downInflatedBalance) {
		this.downInflatedBalance = downInflatedBalance;
	}

	public void setDownPreInterestAdjustment(String downPreInterestAdjustment) {
		this.downPreInterestAdjustment = downPreInterestAdjustment;
	}

	public void setDownChequeBooksOnOrder(String downChequeBooksOnOrder) {
		this.downChequeBooksOnOrder = downChequeBooksOnOrder;
	}

	public void setDownTermCheque(String downTermCheque) {
		this.downTermCheque = downTermCheque;
	}

	public void setDownInterestSumOfYear(String downInterestSumOfYear) {
		this.downInterestSumOfYear = downInterestSumOfYear;
	}

	public void setDownLastOverLimitDate(String downLastOverLimitDate) {
		this.downLastOverLimitDate = downLastOverLimitDate;
	}

	public void setDownResWithTax(String downResWithTax) {
		this.downResWithTax = downResWithTax;
	}

	public void setDownNonResWithTax(String downNonResWithTax) {
		this.downNonResWithTax = downNonResWithTax;
	}

	public void setDownCreditLimit(String downCreditLimit) {
		this.downCreditLimit = downCreditLimit;
	}

	public void setDownCurrVisaInterest(String downCurrVisaInterest) {
		this.downCurrVisaInterest = downCurrVisaInterest;
	}

	public void setDownAvailableCredit(String downAvailableCredit) {
		this.downAvailableCredit = downAvailableCredit;
	}

	public void setDownCurrPurchases(String downCurrPurchases) {
		this.downCurrPurchases = downCurrPurchases;
	}

	public void setDownLastMinPayment(String downLastMinPayment) {
		this.downLastMinPayment = downLastMinPayment;
	}

	public void setDownCurrCashAdvances(String downCurrCashAdvances) {
		this.downCurrCashAdvances = downCurrCashAdvances;
	}

	public void setDownCashIntApplied(String downCashIntApplied) {
		this.downCashIntApplied = downCashIntApplied;
	}

	public void setDownPurchIntApplied(String downPurchIntApplied) {
		this.downPurchIntApplied = downPurchIntApplied;
	}

	public void setDownSecuirityCode(String downSecuirityCode) {
		this.downSecuirityCode = downSecuirityCode;
	}

	public void setDownFiller3(String downFiller3) {
		this.downFiller3 = downFiller3;
	}

	public void setDownNewBranchNo(String downNewBranchNo) {
		this.downNewBranchNo = downNewBranchNo;
	}

	public void setDownStatementFreq(String downStatementFreq) {
		this.downStatementFreq = downStatementFreq;
	}

	public void setDownCycle(String downCycle) {
		this.downCycle = downCycle;
	}

	public void setDownDay(String downDay) {
		this.downDay = downDay;
	}

	public void setDownPassbookNo(String downPassbookNo) {
		this.downPassbookNo = downPassbookNo;
	}

	public void setDownPbLineNo(String downPbLineNo) {
		this.downPbLineNo = downPbLineNo;
	}

	public void setDownNcdRefCode(String downNcdRefCode) {
		this.downNcdRefCode = downNcdRefCode;
	}

	public void setDownNcdNegIntCode(String downNcdNegIntCode) {
		this.downNcdNegIntCode = downNcdNegIntCode;
	}

	public void setDownFiller4(String downFiller4) {
		this.downFiller4 = downFiller4;
	}

	public void setDownOpenPostDate(String downOpenPostDate) {
		this.downOpenPostDate = downOpenPostDate;
	}

	public void setDownGlClassificationCode(String downGlClassificationCode) {
		this.downGlClassificationCode = downGlClassificationCode;
	}

	public void setDownLastAcctTypeChg(String downLastAcctTypeChg) {
		this.downLastAcctTypeChg = downLastAcctTypeChg;
	}

	public void setDownOdIntetrestAvalable(String downOdIntetrestAvalable) {
		this.downOdIntetrestAvalable = downOdIntetrestAvalable;
	}

	public void setDownFiller5(String downFiller5) {
		this.downFiller5 = downFiller5;
	}

	public void setDownChqDishonorCount(String downChqDishonorCount) {
		this.downChqDishonorCount = downChqDishonorCount;
	}

	public void setDownCancelChqDishonorCount(String downCancelChqDishonorCount) {
		this.downCancelChqDishonorCount = downCancelChqDishonorCount;
	}

	public void setDownBranchNoInd(String downBranchNoInd) {
		this.downBranchNoInd = downBranchNoInd;
	}

	public void setDownPbVersion(String downPbVersion) {
		this.downPbVersion = downPbVersion;
	}

	public void setDownPassbookStatus(String downPassbookStatus) {
		this.downPassbookStatus = downPassbookStatus;
	}

	public void setDownChopStatus(String downChopStatus) {
		this.downChopStatus = downChopStatus;
	}

	public void setDownCertificateNo(String downCertificateNo) {
		this.downCertificateNo = downCertificateNo;
	}

	public void setDownCertificateStatus(String downCertificateStatus) {
		this.downCertificateStatus = downCertificateStatus;
	}

	public void setDownFiller6(String downFiller6) {
		this.downFiller6 = downFiller6;
	}

	public void setDownAgreementSignoff(String downAgreementSignoff) {
		this.downAgreementSignoff = downAgreementSignoff;
	}

	public void setDownComplexTd(String downComplexTd) {
		this.downComplexTd = downComplexTd;
	}

	public void setDownBlackListDate(String downBlackListDate) {
		this.downBlackListDate = downBlackListDate;
	}

	public void setDownITypeIntAccr(String downITypeIntAccr) {
		this.downITypeIntAccr = downITypeIntAccr;
	}

	public void setDownTransmitIntAccr(String downTransmitIntAccr) {
		this.downTransmitIntAccr = downTransmitIntAccr;
	}

	public void setDownAbandonOffset(String downAbandonOffset) {
		this.downAbandonOffset = downAbandonOffset;
	}

}
