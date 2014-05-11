package cn.szboc.platform.component.csp.trade.trade_A00400.response;

import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

@MessageBean(
	Target = To.TO_BEAN,
	ExpectedWriteSize = 638
)
public class ResponseAdapter_A00400_OPT_6 extends ResponseAdapter_A00400 {

	
	// ===========================下载数据域=====================================
    	/** 帐号			*/		private String downAccountNo;
    	/** 客户号			*/		private String downCusId;
    	/** ID号			*/		private String downIdNumber;
    	/** 子账户类型		*/		private String downSubAccountType;
    	/** 册号			*/		private String downBookNo;
    	/** 序号			*/		private String downSheetNo;
    	/** 客户名称		*/		private String downCustomerName;
    	/** 国籍			*/		private String downNation;
    	/** 人民币结算帐户属性	*/		private String downCnySettleAcctType;
    	/** 机构号			*/		private String downBranchNo;
    	/** 客户性质别		*/		private String downCustomerAttribute;
    	/** 帐户类别		*/		private String downAccountType;
    	/** 帐户子类		*/		private String downAccountSubType;
    	/** 支取方式		*/		private String downWithdrawType;
    	/** 开户日期		*/		private String downOpenDate;
    	/** 有效日期		*/		private String downValidDate;
    	/** 冻结到期日		*/		private String downFreezeMatDate;
    	/** 定期存款资金来源账号*/		private String downSourceAcct;
    	/** 存期			*/		private String downTermPeriod;
    	/** 基期			*/		private String downBasisPeriod;
    	/** 取息频率		*/		private String downWithdrawIntFreq;
    	/** 定存续存		*/		private String downContinueDep;
    	/** 定存到期通知		*/		private String downMatNotice;
    	/** 到期日期		*/		private String downMatDate;
    	/** 利率变更通知标识	*/		private String downRateChgInd;
    	/** 利率别			*/		private String downRateType;
    	/** 分层集群		*/		private String downGroupID;
    	/** FILLER		*/		private String downFiller1;
    	/** 利息周期		*/		private String downRatePeriod;
    	/** 转息方式		*/		private String downTransferIntMth;
    	/** 转帐账号		*/		private String downTransferAcct;
    	/** 客户限额编码		*/		private String downCustLimitCode;
    	/** FILLER		*/		private String downFiller2;
    	/** 透支记息方式		*/		private String downRateIntMth;
    	/** 透支连接标识		*/		private String downRateLnkInd;
    	/** 综存透支		*/		private String downSumOverdraw;
    	/** 应用ID		*/		private String downAppID;
    	/** 收费减免编号		*/		private String downFeeBonusCode;
    	/** 通知处理标识		*/		private String downNoticeDealInd;
    	/** 通知标识		*/		private String downNoticeInd;
    	/** 通知客户		*/		private String downNoticeCust;
    	/** 对帐单周期		*/		private String downStatePeriod;
    	/** 循环			*/		private String downCycle;
    	/** 天			*/		private String downDay;
    	/** 份数			*/		private String downCopies;
    	/** 语言代码		*/		private String downLanguageCode;
    	/** 邮政标识		*/		private String downPostalInd;
    	/** 代理人代码		*/		private String downAgentCode;
    	/** 地区			*/		private String downRegion;
    	/** 分组标识		*/		private String downTeamInd;
    	/** 抵押标识		*/		private String downImpawnInd;
    	/** 外币账户属性		*/		private String downForeignAccountAttr;
    	/** 议价利率		*/		private String downNegRate;
    	/** 利率加减码		*/		private String downRateAddCode;
	// ========================= set & get =====================================
	
	public String getDownAccountNo() {
		return downAccountNo;
	}

	public String getDownCusId() {
		return downCusId;
	}

	public String getDownIdNumber() {
		return downIdNumber;
	}

	public String getDownSubAccountType() {
		return downSubAccountType;
	}

	public String getDownBookNo() {
		return downBookNo;
	}

	public String getDownSheetNo() {
		return downSheetNo;
	}

	public String getDownCustomerName() {
		return downCustomerName;
	}

	public String getDownNation() {
		return downNation;
	}

	public String getDownCnySettleAcctType() {
		return downCnySettleAcctType;
	}

	public String getDownBranchNo() {
		return downBranchNo;
	}

	public String getDownCustomerAttribute() {
		return downCustomerAttribute;
	}

	public String getDownAccountType() {
		return downAccountType;
	}

	public String getDownAccountSubType() {
		return downAccountSubType;
	}

	public String getDownWithdrawType() {
		return downWithdrawType;
	}

	public String getDownOpenDate() {
		return downOpenDate;
	}

	public String getDownValidDate() {
		return downValidDate;
	}

	public String getDownFreezeMatDate() {
		return downFreezeMatDate;
	}

	public String getDownSourceAcct() {
		return downSourceAcct;
	}

	public String getDownTermPeriod() {
		return downTermPeriod;
	}

	public String getDownBasisPeriod() {
		return downBasisPeriod;
	}

	public String getDownWithdrawIntFreq() {
		return downWithdrawIntFreq;
	}

	public String getDownContinueDep() {
		return downContinueDep;
	}

	public String getDownMatNotice() {
		return downMatNotice;
	}

	public String getDownMatDate() {
		return downMatDate;
	}

	public String getDownRateChgInd() {
		return downRateChgInd;
	}

	public String getDownRateType() {
		return downRateType;
	}

	public String getDownGroupID() {
		return downGroupID;
	}

	public String getDownFiller1() {
		return downFiller1;
	}

	public String getDownRatePeriod() {
		return downRatePeriod;
	}

	public String getDownTransferIntMth() {
		return downTransferIntMth;
	}

	public String getDownTransferAcct() {
		return downTransferAcct;
	}

	public String getDownCustLimitCode() {
		return downCustLimitCode;
	}

	public String getDownFiller2() {
		return downFiller2;
	}

	public String getDownRateIntMth() {
		return downRateIntMth;
	}

	public String getDownRateLnkInd() {
		return downRateLnkInd;
	}

	public String getDownSumOverdraw() {
		return downSumOverdraw;
	}

	public String getDownAppID() {
		return downAppID;
	}

	public String getDownFeeBonusCode() {
		return downFeeBonusCode;
	}

	public String getDownNoticeDealInd() {
		return downNoticeDealInd;
	}

	public String getDownNoticeInd() {
		return downNoticeInd;
	}

	public String getDownNoticeCust() {
		return downNoticeCust;
	}

	public String getDownStatePeriod() {
		return downStatePeriod;
	}

	public String getDownCycle() {
		return downCycle;
	}

	public String getDownDay() {
		return downDay;
	}

	public String getDownCopies() {
		return downCopies;
	}

	public String getDownLanguageCode() {
		return downLanguageCode;
	}

	public String getDownPostalInd() {
		return downPostalInd;
	}

	public String getDownAgentCode() {
		return downAgentCode;
	}

	public String getDownRegion() {
		return downRegion;
	}

	public String getDownTeamInd() {
		return downTeamInd;
	}

	public String getDownImpawnInd() {
		return downImpawnInd;
	}

	public String getDownForeignAccountAttr() {
		return downForeignAccountAttr;
	}

	public String getDownNegRate() {
		return downNegRate;
	}

	public String getDownRateAddCode() {
		return downRateAddCode;
	}

	public void setDownAccountNo(String downAccountNo) {
		this.downAccountNo = downAccountNo;
	}

	public void setDownCusId(String downCusId) {
		this.downCusId = downCusId;
	}

	public void setDownIdNumber(String downIdNumber) {
		this.downIdNumber = downIdNumber;
	}

	public void setDownSubAccountType(String downSubAccountType) {
		this.downSubAccountType = downSubAccountType;
	}

	public void setDownBookNo(String downBookNo) {
		this.downBookNo = downBookNo;
	}

	public void setDownSheetNo(String downSheetNo) {
		this.downSheetNo = downSheetNo;
	}

	public void setDownCustomerName(String downCustomerName) {
		this.downCustomerName = downCustomerName;
	}

	public void setDownNation(String downNation) {
		this.downNation = downNation;
	}

	public void setDownCnySettleAcctType(String downCnySettleAcctType) {
		this.downCnySettleAcctType = downCnySettleAcctType;
	}

	public void setDownBranchNo(String downBranchNo) {
		this.downBranchNo = downBranchNo;
	}

	public void setDownCustomerAttribute(String downCustomerAttribute) {
		this.downCustomerAttribute = downCustomerAttribute;
	}

	public void setDownAccountType(String downAccountType) {
		this.downAccountType = downAccountType;
	}

	public void setDownAccountSubType(String downAccountSubType) {
		this.downAccountSubType = downAccountSubType;
	}

	public void setDownWithdrawType(String downWithdrawType) {
		this.downWithdrawType = downWithdrawType;
	}

	public void setDownOpenDate(String downOpenDate) {
		this.downOpenDate = downOpenDate;
	}

	public void setDownValidDate(String downValidDate) {
		this.downValidDate = downValidDate;
	}

	public void setDownFreezeMatDate(String downFreezeMatDate) {
		this.downFreezeMatDate = downFreezeMatDate;
	}

	public void setDownSourceAcct(String downSourceAcct) {
		this.downSourceAcct = downSourceAcct;
	}

	public void setDownTermPeriod(String downTermPeriod) {
		this.downTermPeriod = downTermPeriod;
	}

	public void setDownBasisPeriod(String downBasisPeriod) {
		this.downBasisPeriod = downBasisPeriod;
	}

	public void setDownWithdrawIntFreq(String downWithdrawIntFreq) {
		this.downWithdrawIntFreq = downWithdrawIntFreq;
	}

	public void setDownContinueDep(String downContinueDep) {
		this.downContinueDep = downContinueDep;
	}

	public void setDownMatNotice(String downMatNotice) {
		this.downMatNotice = downMatNotice;
	}

	public void setDownMatDate(String downMatDate) {
		this.downMatDate = downMatDate;
	}

	public void setDownRateChgInd(String downRateChgInd) {
		this.downRateChgInd = downRateChgInd;
	}

	public void setDownRateType(String downRateType) {
		this.downRateType = downRateType;
	}

	public void setDownGroupID(String downGroupID) {
		this.downGroupID = downGroupID;
	}

	public void setDownFiller1(String downFiller1) {
		this.downFiller1 = downFiller1;
	}

	public void setDownRatePeriod(String downRatePeriod) {
		this.downRatePeriod = downRatePeriod;
	}

	public void setDownTransferIntMth(String downTransferIntMth) {
		this.downTransferIntMth = downTransferIntMth;
	}

	public void setDownTransferAcct(String downTransferAcct) {
		this.downTransferAcct = downTransferAcct;
	}

	public void setDownCustLimitCode(String downCustLimitCode) {
		this.downCustLimitCode = downCustLimitCode;
	}

	public void setDownFiller2(String downFiller2) {
		this.downFiller2 = downFiller2;
	}

	public void setDownRateIntMth(String downRateIntMth) {
		this.downRateIntMth = downRateIntMth;
	}

	public void setDownRateLnkInd(String downRateLnkInd) {
		this.downRateLnkInd = downRateLnkInd;
	}

	public void setDownSumOverdraw(String downSumOverdraw) {
		this.downSumOverdraw = downSumOverdraw;
	}

	public void setDownAppID(String downAppID) {
		this.downAppID = downAppID;
	}

	public void setDownFeeBonusCode(String downFeeBonusCode) {
		this.downFeeBonusCode = downFeeBonusCode;
	}

	public void setDownNoticeDealInd(String downNoticeDealInd) {
		this.downNoticeDealInd = downNoticeDealInd;
	}

	public void setDownNoticeInd(String downNoticeInd) {
		this.downNoticeInd = downNoticeInd;
	}

	public void setDownNoticeCust(String downNoticeCust) {
		this.downNoticeCust = downNoticeCust;
	}

	public void setDownStatePeriod(String downStatePeriod) {
		this.downStatePeriod = downStatePeriod;
	}

	public void setDownCycle(String downCycle) {
		this.downCycle = downCycle;
	}

	public void setDownDay(String downDay) {
		this.downDay = downDay;
	}

	public void setDownCopies(String downCopies) {
		this.downCopies = downCopies;
	}

	public void setDownLanguageCode(String downLanguageCode) {
		this.downLanguageCode = downLanguageCode;
	}

	public void setDownPostalInd(String downPostalInd) {
		this.downPostalInd = downPostalInd;
	}

	public void setDownAgentCode(String downAgentCode) {
		this.downAgentCode = downAgentCode;
	}

	public void setDownRegion(String downRegion) {
		this.downRegion = downRegion;
	}

	public void setDownTeamInd(String downTeamInd) {
		this.downTeamInd = downTeamInd;
	}

	public void setDownImpawnInd(String downImpawnInd) {
		this.downImpawnInd = downImpawnInd;
	}

	public void setDownForeignAccountAttr(String downForeignAccountAttr) {
		this.downForeignAccountAttr = downForeignAccountAttr;
	}

	public void setDownNegRate(String downNegRate) {
		this.downNegRate = downNegRate;
	}

	public void setDownRateAddCode(String downRateAddCode) {
		this.downRateAddCode = downRateAddCode;
	}

}
