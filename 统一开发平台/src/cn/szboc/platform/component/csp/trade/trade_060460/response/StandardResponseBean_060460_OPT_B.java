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
public class StandardResponseBean_060460_OPT_B extends ResponseAdapter_060460_OPT_B
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
	
	@MessageField(startPos = 394, length = 80)
	public void setDownCusName(String downCusName)
	{
		super.setDownCusName(downCusName);
	}
	
	@MessageField(startPos = 474, length = 5)
	public void setDownIndustry(String downIndustry)
	{
		super.setDownIndustry(downIndustry);
	}
	
	@MessageField(startPos = 479, length = 2)
	public void setDownRegisterCountry(String downRegisterCountry)
	{
		super.setDownRegisterCountry(downRegisterCountry);
	}
	
	@MessageField(startPos = 481, length = 1)
	public void setDownCorpProperty(String downCorpProperty)
	{
		super.setDownCorpProperty(downCorpProperty);
	}
	
	@MessageField(startPos = 482, length = 1)
	public void setDownCorpEconomyProperty(String downCorpEconomyProperty)
	{
		super.setDownCorpEconomyProperty(downCorpEconomyProperty);
	}
	
	@MessageField(startPos = 483, length = 20)
	public void setDownOwnerName(String downOwnerName)
	{
		super.setDownOwnerName(downOwnerName);
	}
	
	@MessageField(startPos = 503, length = 2)
	public void setDownOwnerPassType(String downOwnerPassType)
	{
		super.setDownOwnerPassType(downOwnerPassType);
	}
	
	@MessageField(startPos = 505, length = 32)
	public void setDownOwnerPassNo(String downOwnerPassNo)
	{
		super.setDownOwnerPassNo(downOwnerPassNo);
	}
	
	@MessageField(startPos = 537, length = 20)
	public void setDownLinkName(String downLinkName)
	{
		super.setDownLinkName(downLinkName);
	}
	
	@MessageField(startPos = 557, length = 22)
	public void setDownLinkPhone(String downLinkPhone)
	{
		super.setDownLinkPhone(downLinkPhone);
	}
	
	@MessageField(startPos = 579, length = 30)
	public void setDownLinkEmail(String downLinkEmail)
	{
		super.setDownLinkEmail(downLinkEmail);
	}
	
	@MessageField(startPos = 609, length = 30)
	public void setDownMainBusiness(String downMainBusiness)
	{
		super.setDownMainBusiness(downMainBusiness);
	}
	
	@MessageField(startPos = 639, length = 20)
	public void setDownFinancialExecName(String downFinancialExecName)
	{
		super.setDownFinancialExecName(downFinancialExecName);
	}
	
	@MessageField(startPos = 659, length = 22)
	public void setDownFinancialExecPhone(String downFinancialExecPhone)
	{
		super.setDownFinancialExecPhone(downFinancialExecPhone);
	}
	
	@MessageField(startPos = 681, length = 18)
	public void setDownRegisterAmt(String downRegisterAmt)
	{
		super.setDownRegisterAmt(downRegisterAmt);
	}
	
	@MessageField(startPos = 699, length = 3)
	public void setDownRegisterCurrency(String downRegisterCurrency)
	{
		super.setDownRegisterCurrency(downRegisterCurrency);
	}
	
	@MessageField(startPos = 702, length = 7)
	public void setDownCheckAct(String downCheckAct)
	{
		super.setDownCheckAct(downCheckAct);
	}
	
	@MessageField(startPos = 709, length = 10)
	public void setDownCheckActPwd(String downCheckActPwd)
	{
		super.setDownCheckActPwd(downCheckActPwd);
	}
	
	@MessageField(startPos = 719, length = 1)
	public void setDownKycRiskLevel(String downKycRiskLevel)
	{
		super.setDownKycRiskLevel(downKycRiskLevel);
	}
	
	@MessageField(startPos = 720, length = 8)
	public void setDownOwnerPassInvalidDate(String downOwnerPassInvalidDate)
	{
		super.setDownOwnerPassInvalidDate(downOwnerPassInvalidDate);
	}
	
	@MessageField(startPos = 728, length = 555, type = PadType.RIGHT)
	public void setDownFillerEnd(String downFillerEnd)
	{
		super.setDownFillerEnd(downFillerEnd);
	}
}