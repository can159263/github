package cn.szboc.platform.component.csp.trade.trade_060460.response;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 
 * @author
 * 
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 1283)
public class StandardResponseBean_060460_OPT_A extends ResponseAdapter_060460_OPT_A
{
	@MessageField(startPos = 300, length = 1, type = PadType.RIGHT, material = 48)
	public void setDownFillerStart(String downFillerStart)
	{
		super.setDownFillerStart(downFillerStart);
	}
	
	/**
	 * 实际测试中客户号是左侧补0的
	 */
	@MessageField(startPos = 301, length = 16, type = PadType.LEFT, material = 48)
	public void setDownCusNo(String downCusNo)
	{
		super.setDownCusNo(downCusNo);
	}
	
	@MessageField(startPos = 317, length = 2)
	public void setDownCusType(String downCusType)
	{
		super.setDownCusType(downCusType);
	}
	
	@MessageField(startPos = 319, length = 3)
	public void setDownCusSubType(String downCusSubType)
	{
		super.setDownCusSubType(downCusSubType);
	}
	
	@MessageField(startPos = 322, length = 2)
	public void setDownPassType(String downPassType)
	{
		super.setDownPassType(downPassType);
	}
	
	@MessageField(startPos = 324, length = 32)
	public void setDownPassNo(String downPassNo)
	{
		super.setDownPassNo(downPassNo);
	}
	
	@MessageField(startPos = 356, length = 5)
	public void setDownBelongingBranch(String downBelongingBranch)
	{
		super.setDownBelongingBranch(downBelongingBranch);
	}
	
	@MessageField(startPos = 361, length = 2)
	public void setDownCusStatus(String downCusStatus)
	{
		super.setDownCusStatus(downCusStatus);
	}
	
	@MessageField(startPos = 363, length = 2)
	public void setDownCusStatus2(String downCusStatus2)
	{
		super.setDownCusStatus2(downCusStatus2);
	}
	
	@MessageField(startPos = 365, length = 2)
	public void setDownCusStatus3(String downCusStatus3)
	{
		super.setDownCusStatus3(downCusStatus3);
	}
	
	@MessageField(startPos = 367, length = 2)
	public void setDownCommunicateLanguage(String downCommunicateLanguage)
	{
		super.setDownCommunicateLanguage(downCommunicateLanguage);
	}
	
	@MessageField(startPos = 369, length = 5)
	public void setDownCreatingBranch(String downCreatingBranch)
	{
		super.setDownCreatingBranch(downCreatingBranch);
	}
	
	@MessageField(startPos = 374, length = 8)
	public void setDownLastMaintainDate(String downLastMaintainDate)
	{
		super.setDownLastMaintainDate(downLastMaintainDate);
	}
	
	@MessageField(startPos = 382, length = 7)
	public void setDownLastMaintainAct(String downLastMaintainAct)
	{
		super.setDownLastMaintainAct(downLastMaintainAct);
	}
	
	@MessageField(startPos = 389, length = 5)
	public void setDownLastMaintainBranch(String downLastMaintainBranch)
	{
		super.setDownLastMaintainBranch(downLastMaintainBranch);
	}
	
	@MessageField(startPos = 394, length = 1)
	public void setDownStuffFlag(String downStuffFlag)
	{
		super.setDownStuffFlag(downStuffFlag);
	}
	
	@MessageField(startPos = 395, length = 40)
	public void setDownFirstName(String downFirstName)
	{
		super.setDownFirstName(downFirstName);
	}
	
	@MessageField(startPos = 435, length = 40)
	public void setDownSecondName(String downSecondName)
	{
		super.setDownSecondName(downSecondName);
	}
	
	@MessageField(startPos = 475, length = 20)
	public void setDownCustomerOtherName(String downCustomerOtherName)
	{
		super.setDownCustomerOtherName(downCustomerOtherName);
	}
	
	@MessageField(startPos = 495, length = 2)
	public void setDownNationality(String downNationality)
	{
		super.setDownNationality(downNationality);
	}
	
	@MessageField(startPos = 497, length = 1)
	public void setDownGender(String downGender)
	{
		super.setDownGender(downGender);
	}
	
	@MessageField(startPos = 498, length = 1)
	public void setDownIsResident(String downIsResident)
	{
		super.setDownIsResident(downIsResident);
	}
	
	@MessageField(startPos = 499, length = 1)
	public void setDownCheckAccountCycle(String downCheckAccountCycle)
	{
		super.setDownCheckAccountCycle(downCheckAccountCycle);
	}
	
	@MessageField(startPos = 500, length = 2)
	public void setDownIterator(String downIterator)
	{
		super.setDownIterator(downIterator);
	}
	
	@MessageField(startPos = 502, length = 2)
	public void setDownDay(String downDay)
	{
		super.setDownDay(downDay);
	}
	
	@MessageField(startPos = 504, length = 1)
	public void setDownAccountBillPostType(String downAccountBillPostType)
	{
		super.setDownAccountBillPostType(downAccountBillPostType);
	}
	
	@MessageField(startPos = 505, length = 2)
	public void setDownAccountBillAddrNo(String downAccountBillAddrNo)
	{
		super.setDownAccountBillAddrNo(downAccountBillAddrNo);
	}
	
	@MessageField(startPos = 507, length = 1)
	public void setDownHasKeepCase(String downHasKeepCase)
	{
		super.setDownHasKeepCase(downHasKeepCase);
	}
	
	@MessageField(startPos = 508, length = 1)
	public void setDownTaxFlag(String downTaxFlag)
	{
		super.setDownTaxFlag(downTaxFlag);
	}
	
	@MessageField(startPos = 509, length = 8)
	public void setDownTaxDiscountInvalidDate(String downTaxDiscountInvalidDate)
	{
		super.setDownTaxDiscountInvalidDate(downTaxDiscountInvalidDate);
	}
	
	@MessageField(startPos = 517, length = 18)
	public void setDownPersonalSalary(String downPersonalSalary)
	{
		super.setDownPersonalSalary(downPersonalSalary);
	}
	
	@MessageField(startPos = 535, length = 1)
	public void setDownMarrageStatus(String downMarrageStatus)
	{
		super.setDownMarrageStatus(downMarrageStatus);
	}
	
	@MessageField(startPos = 536, length = 8)
	public void setDownFillerMiddle(String downFillerMiddle)
	{
		super.setDownFillerMiddle(downFillerMiddle);
	}
	
	@MessageField(startPos = 544, length = 2)
	public void setDownTaxRateType(String downTaxRateType)
	{
		super.setDownTaxRateType(downTaxRateType);
	}
	
	@MessageField(startPos = 546, length = 1)
	public void setDownKycRiskLevel(String downKycRiskLevel)
	{
		super.setDownKycRiskLevel(downKycRiskLevel);
	}
	
	@MessageField(startPos = 547, length = 736, type = PadType.RIGHT)
	public void setDownFillerEnd(String downFillerEnd)
	{
		super.setDownFillerEnd(downFillerEnd);
	}
}