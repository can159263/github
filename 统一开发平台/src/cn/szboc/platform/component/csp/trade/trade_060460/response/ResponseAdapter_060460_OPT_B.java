package cn.szboc.platform.component.csp.trade.trade_060460.response;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 对CSP交易060460交易SET方法的抽象
 * 
 * @author
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 1283)
public abstract class ResponseAdapter_060460_OPT_B extends ResponseAdapter_060460 {
	// ===========================下载数据域=====================================
	/** FILLER */
	private String downFillerStart;
	/** 客户号 */
	private String downCusNo;
	/** 客户类型 */
	private String downCusType;
	/** 客户子类型 */
	private String downCusSubType;
	/** 证件类型 */
	private String downPassType;
	/** 证件号码 */
	private String downPassNo;
	/** 所属行 */
	private String downBelongingBranch;
	/** 客户状态 */
	private String downCusStatus;
	/** 客户状态2 */
	private String downCusStatus2;
	/** 客户状态3 */
	private String downCusStatus3;
	/** 通讯语言 */
	private String downCommunicateLanguage;
	/** 开户行 */
	private String downCreatingBranch;
	/** 最后维护日期 */
	private String downLastMaintainDate;
	/** 最后维护柜员 */
	private String downLastMaintainAct;
	/** 最后维护柜员所属行 */
	private String downLastMaintainBranch;
	/** 客户名称 */
	private String downCusName;
	/** 行业分类 */
	private String downIndustry;
	/** 注册国家 */
	private String downRegisterCountry;
	/** 企业性质 */
	private String downCorpProperty;
	/** 企业经济成分 */
	private String downCorpEconomyProperty;
	/** 法定代表人(负责人)姓名 */
	private String downOwnerName;
	/** 法定代表人(负责人)证件类型 */
	private String downOwnerPassType;
	/** 法定代表人(负责人)证件号码 */
	private String downOwnerPassNo;
	/** 联系人姓名 */
	private String downLinkName;
	/** 联系人电话 */
	private String downLinkPhone;
	/** 联系人电子邮件 */
	private String downLinkEmail;
	/** 主营业务 */
	private String downMainBusiness;
	/** 财务负责人姓名 */
	private String downFinancialExecName;
	/** 财务负责人电话 */
	private String downFinancialExecPhone;
	/** 注册资本金额 */
	private String downRegisterAmt;
	/** 注册资本货币 */
	private String downRegisterCurrency;
	/** 复合柜员 */
	private String downCheckAct;
	/** 复合柜员密码 */
	private String downCheckActPwd;
	/** KYC风险等级 */
	private String downKycRiskLevel;
	/** 法定代表人（负责人）证件到期日期 */
	private String downOwnerPassInvalidDate;
	/** FILLER */
	private String downFillerEnd;

	// ====================================getters &
	// setters==================================
	public String getDownFillerStart() {
		return downFillerStart;
	}

	public String getDownCusNo() {
		return downCusNo;
	}

	public String getDownCusType() {
		return downCusType;
	}

	public String getDownCusSubType() {
		return downCusSubType;
	}

	public String getDownPassType() {
		return downPassType;
	}

	public String getDownPassNo() {
		return downPassNo;
	}

	public String getDownBelongingBranch() {
		return downBelongingBranch;
	}

	public String getDownCusStatus() {
		return downCusStatus;
	}

	public String getDownCusStatus2() {
		return downCusStatus2;
	}

	public String getDownCusStatus3() {
		return downCusStatus3;
	}

	public String getDownCommunicateLanguage() {
		return downCommunicateLanguage;
	}

	public String getDownCreatingBranch() {
		return downCreatingBranch;
	}

	public String getDownLastMaintainDate() {
		return downLastMaintainDate;
	}

	public String getDownLastMaintainAct() {
		return downLastMaintainAct;
	}

	public String getDownLastMaintainBranch() {
		return downLastMaintainBranch;
	}

	public String getDownCusName() {
		return downCusName;
	}

	public String getDownIndustry() {
		return downIndustry;
	}

	public String getDownRegisterCountry() {
		return downRegisterCountry;
	}

	public String getDownCorpProperty() {
		return downCorpProperty;
	}

	public String getDownCorpEconomyProperty() {
		return downCorpEconomyProperty;
	}

	public String getDownOwnerName() {
		return downOwnerName;
	}

	public String getDownOwnerPassType() {
		return downOwnerPassType;
	}

	public String getDownOwnerPassNo() {
		return downOwnerPassNo;
	}

	public String getDownLinkName() {
		return downLinkName;
	}

	public String getDownLinkPhone() {
		return downLinkPhone;
	}

	public String getDownLinkEmail() {
		return downLinkEmail;
	}

	public String getDownMainBusiness() {
		return downMainBusiness;
	}

	public String getDownFinancialExecName() {
		return downFinancialExecName;
	}

	public String getDownFinancialExecPhone() {
		return downFinancialExecPhone;
	}

	public String getDownRegisterAmt() {
		return downRegisterAmt;
	}

	public String getDownRegisterCurrency() {
		return downRegisterCurrency;
	}

	public String getDownCheckAct() {
		return downCheckAct;
	}

	public String getDownCheckActPwd() {
		return downCheckActPwd;
	}

	public String getDownKycRiskLevel() {
		return downKycRiskLevel;
	}

	public String getDownOwnerPassInvalidDate() {
		return downOwnerPassInvalidDate;
	}

	public String getDownFillerEnd() {
		return downFillerEnd;
	}

	public void setDownFillerStart(String downFillerStart) {
		this.downFillerStart = downFillerStart;
	}

	public void setDownCusNo(String downCusNo) {
		this.downCusNo = downCusNo;
	}

	public void setDownCusType(String downCusType) {
		this.downCusType = downCusType;
	}

	public void setDownCusSubType(String downCusSubType) {
		this.downCusSubType = downCusSubType;
	}

	public void setDownPassType(String downPassType) {
		this.downPassType = downPassType;
	}

	public void setDownPassNo(String downPassNo) {
		this.downPassNo = downPassNo;
	}

	public void setDownBelongingBranch(String downBelongingBranch) {
		this.downBelongingBranch = downBelongingBranch;
	}

	public void setDownCusStatus(String downCusStatus) {
		this.downCusStatus = downCusStatus;
	}

	public void setDownCusStatus2(String downCusStatus2) {
		this.downCusStatus2 = downCusStatus2;
	}

	public void setDownCusStatus3(String downCusStatus3) {
		this.downCusStatus3 = downCusStatus3;
	}

	public void setDownCommunicateLanguage(String downCommunicateLanguage) {
		this.downCommunicateLanguage = downCommunicateLanguage;
	}

	public void setDownCreatingBranch(String downCreatingBranch) {
		this.downCreatingBranch = downCreatingBranch;
	}

	public void setDownLastMaintainDate(String downLastMaintainDate) {
		this.downLastMaintainDate = downLastMaintainDate;
	}

	public void setDownLastMaintainAct(String downLastMaintainAct) {
		this.downLastMaintainAct = downLastMaintainAct;
	}

	public void setDownLastMaintainBranch(String downLastMaintainBranch) {
		this.downLastMaintainBranch = downLastMaintainBranch;
	}

	public void setDownCusName(String downCusName) {
		this.downCusName = downCusName;
	}

	public void setDownIndustry(String downIndustry) {
		this.downIndustry = downIndustry;
	}

	public void setDownRegisterCountry(String downRegisterCountry) {
		this.downRegisterCountry = downRegisterCountry;
	}

	public void setDownCorpProperty(String downCorpProperty) {
		this.downCorpProperty = downCorpProperty;
	}

	public void setDownCorpEconomyProperty(String downCorpEconomyProperty) {
		this.downCorpEconomyProperty = downCorpEconomyProperty;
	}

	public void setDownOwnerName(String downOwnerName) {
		this.downOwnerName = downOwnerName;
	}

	public void setDownOwnerPassType(String downOwnerPassType) {
		this.downOwnerPassType = downOwnerPassType;
	}

	public void setDownOwnerPassNo(String downOwnerPassNo) {
		this.downOwnerPassNo = downOwnerPassNo;
	}

	public void setDownLinkName(String downLinkName) {
		this.downLinkName = downLinkName;
	}

	public void setDownLinkPhone(String downLinkPhone) {
		this.downLinkPhone = downLinkPhone;
	}

	public void setDownLinkEmail(String downLinkEmail) {
		this.downLinkEmail = downLinkEmail;
	}

	public void setDownMainBusiness(String downMainBusiness) {
		this.downMainBusiness = downMainBusiness;
	}

	public void setDownFinancialExecName(String downFinancialExecName) {
		this.downFinancialExecName = downFinancialExecName;
	}

	public void setDownFinancialExecPhone(String downFinancialExecPhone) {
		this.downFinancialExecPhone = downFinancialExecPhone;
	}

	public void setDownRegisterAmt(String downRegisterAmt) {
		this.downRegisterAmt = downRegisterAmt;
	}

	public void setDownRegisterCurrency(String downRegisterCurrency) {
		this.downRegisterCurrency = downRegisterCurrency;
	}

	public void setDownCheckAct(String downCheckAct) {
		this.downCheckAct = downCheckAct;
	}

	public void setDownCheckActPwd(String downCheckActPwd) {
		this.downCheckActPwd = downCheckActPwd;
	}

	public void setDownKycRiskLevel(String downKycRiskLevel) {
		this.downKycRiskLevel = downKycRiskLevel;
	}

	public void setDownOwnerPassInvalidDate(String downOwnerPassInvalidDate) {
		this.downOwnerPassInvalidDate = downOwnerPassInvalidDate;
	}

	public void setDownFillerEnd(String downFillerEnd) {
		this.downFillerEnd = downFillerEnd;
	}
}