package cn.szboc.platform.component.csp.trade.trade_020400.response;

import java.math.BigDecimal;

import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 020400通用应答格式
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 319)
public abstract class ResponseAdapter_020400 extends CommonResponse {

	// ===========================下载数据域=====================================
    	/** BGL账号 			*/		private String downBglAcct;
    	/** 分类帐户名       	*/		private String downAcctName;
    	/** 分行号       		*/		private String downBranchNo;
    	/** 币别				*/		private String downCurrcyNo;
    	/** 帐户余额			*/		private BigDecimal downAmt;
	// ========================= set & get =====================================
    	
	public String getDownBglAcct()
	{
		return downBglAcct;
	}
	
	public void setDownBglAcct(String downBglAcct)
	{
		this.downBglAcct = downBglAcct;
	}
	
	public String getDownAcctName()
	{
		return downAcctName;
	}
	
	public void setDownAcctName(String downAcctName)
	{
		this.downAcctName = downAcctName;
	}
	
	public String getDownBranchNo()
	{
		return downBranchNo;
	}

	public void setDownBranchNo(String downBranchNo)
	{
		this.downBranchNo = downBranchNo;
	}

	public String getDownCurrcyNo()
	{
		return downCurrcyNo;
	}
	
	public void setDownCurrcyNo(String downCurrcyNo)
	{
		this.downCurrcyNo = downCurrcyNo;
	}
	
	public BigDecimal getDownAmt()
	{
		return downAmt;
	}
	
	public void setDownAmt(BigDecimal downAmt)
	{
		this.downAmt = downAmt;
	}
		
}
