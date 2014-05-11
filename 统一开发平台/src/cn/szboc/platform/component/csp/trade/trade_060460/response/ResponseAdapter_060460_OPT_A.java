package cn.szboc.platform.component.csp.trade.trade_060460.response;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 对CSP交易060460交易SET方法的抽象
 * 
 * @author
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 1283)
public abstract class ResponseAdapter_060460_OPT_A extends ResponseAdapter_060460 {
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
	/** 员工标识 */
	private String downStuffFlag;
	/** 姓 */
	private String downFirstName;
	/** 名 */
	private String downSecondName;
	/** 客户其他姓名 */
	private String downCustomerOtherName;
	/** 国家/地区 */
	private String downNationality;
	/** 性别 */
	private String downGender;
	/** 居民/非居民 */
	private String downIsResident;
	/** 综合对帐周期 */
	private String downCheckAccountCycle;
	/** 循环 */
	private String downIterator;
	/** 天 */
	private String downDay;
	/** 对帐单邮寄方法 */
	private String downAccountBillPostType;
	/** 综合对帐单地址编号 */
	private String downAccountBillAddrNo;
	/** 是否持有保管箱 */
	private String downHasKeepCase;
	/** 利息税标志 */
	private String downTaxFlag;
	/** 利息税优惠到期日期 */
	private String downTaxDiscountInvalidDate;
	/** 个人月收入 */
	private String downPersonalSalary;
	/** 婚姻状况 */
	private String downMarrageStatus;
	/** FILLER */
	private String downFillerMiddle;
	/** 税率类型 */
	private String downTaxRateType;
	/** KYC风险等级 */
	private String downKycRiskLevel;
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

	public String getDownStuffFlag() {
		return downStuffFlag;
	}

	public String getDownFirstName() {
		return downFirstName;
	}

	public String getDownSecondName() {
		return downSecondName;
	}

	public String getDownCustomerOtherName() {
		return downCustomerOtherName;
	}

	public String getDownNationality() {
		return downNationality;
	}

	public String getDownGender() {
		return downGender;
	}

	public String getDownIsResident() {
		return downIsResident;
	}

	public String getDownCheckAccountCycle() {
		return downCheckAccountCycle;
	}

	public String getDownIterator() {
		return downIterator;
	}

	public String getDownDay() {
		return downDay;
	}

	public String getDownAccountBillPostType() {
		return downAccountBillPostType;
	}

	public String getDownAccountBillAddrNo() {
		return downAccountBillAddrNo;
	}

	public String getDownHasKeepCase() {
		return downHasKeepCase;
	}

	public String getDownTaxFlag() {
		return downTaxFlag;
	}

	public String getDownTaxDiscountInvalidDate() {
		return downTaxDiscountInvalidDate;
	}

	public String getDownPersonalSalary() {
		return downPersonalSalary;
	}

	public String getDownMarrageStatus() {
		return downMarrageStatus;
	}

	public String getDownFillerMiddle() {
		return downFillerMiddle;
	}

	public String getDownTaxRateType() {
		return downTaxRateType;
	}

	public String getDownKycRiskLevel() {
		return downKycRiskLevel;
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

	public void setDownStuffFlag(String downStuffFlag) {
		this.downStuffFlag = downStuffFlag;
	}

	public void setDownFirstName(String downFirstName) {
		this.downFirstName = downFirstName;
	}

	public void setDownSecondName(String downSecondName) {
		this.downSecondName = downSecondName;
	}

	public void setDownCustomerOtherName(String downCustomerOtherName) {
		this.downCustomerOtherName = downCustomerOtherName;
	}

	public void setDownNationality(String downNationality) {
		this.downNationality = downNationality;
	}

	public void setDownGender(String downGender) {
		this.downGender = downGender;
	}

	public void setDownIsResident(String downIsResident) {
		this.downIsResident = downIsResident;
	}

	public void setDownCheckAccountCycle(String downCheckAccountCycle) {
		this.downCheckAccountCycle = downCheckAccountCycle;
	}

	public void setDownIterator(String downIterator) {
		this.downIterator = downIterator;
	}

	public void setDownDay(String downDay) {
		this.downDay = downDay;
	}

	public void setDownAccountBillPostType(String downAccountBillPostType) {
		this.downAccountBillPostType = downAccountBillPostType;
	}

	public void setDownAccountBillAddrNo(String downAccountBillAddrNo) {
		this.downAccountBillAddrNo = downAccountBillAddrNo;
	}

	public void setDownHasKeepCase(String downHasKeepCase) {
		this.downHasKeepCase = downHasKeepCase;
	}

	public void setDownTaxFlag(String downTaxFlag) {
		this.downTaxFlag = downTaxFlag;
	}

	public void setDownTaxDiscountInvalidDate(String downTaxDiscountInvalidDate) {
		this.downTaxDiscountInvalidDate = downTaxDiscountInvalidDate;
	}

	public void setDownPersonalSalary(String downPersonalSalary) {
		this.downPersonalSalary = downPersonalSalary;
	}

	public void setDownMarrageStatus(String downMarrageStatus) {
		this.downMarrageStatus = downMarrageStatus;
	}

	public void setDownFillerMiddle(String downFillerMiddle) {
		this.downFillerMiddle = downFillerMiddle;
	}

	public void setDownTaxRateType(String downTaxRateType) {
		this.downTaxRateType = downTaxRateType;
	}

	public void setDownKycRiskLevel(String downKycRiskLevel) {
		this.downKycRiskLevel = downKycRiskLevel;
	}

	public void setDownFillerEnd(String downFillerEnd) {
		this.downFillerEnd = downFillerEnd;
	}
}