package cn.szboc.platform.component.csp.trade.trade_020400.response;

import java.math.BigDecimal;

import cn.szboc.platform.component.csp.trade.commons.interceptor.BigDecimalScaleInterceptor;
import cn.szboc.platform.component.csp.trade.commons.interceptor.QueryTradeAmtFormatInterseptor;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.MessageSetEnhance;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 全量的CSP.020400交易响应Bean
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 389)
public class StandardResponseBean_020400 extends ResponseAdapter_020400 {

	@Override
	@MessageField(startPos = 300, length = 22)
	public void setDownBglAcct(String downBglAcct)
	{
		super.setDownBglAcct(downBglAcct);
	}

	@Override
	@MessageField(startPos = 322, length = 40)
	public void setDownAcctName(String downAcctName)
	{
		super.setDownAcctName(downAcctName);
	}

	@Override
	@MessageField(startPos = 362, length = 5, type = PadType.MATCH)
	public void setDownBranchNo(String downBranchNo)
	{
		super.setDownBranchNo(downBranchNo);
	}

	@Override
	@MessageField(startPos = 367, length = 3, type = PadType.MATCH)
	public void setDownCurrcyNo(String downCurrcyNo)
	{
		super.setDownCurrcyNo(downCurrcyNo);
	}

	@Override
	@MessageField(startPos = 370, length = 19, type = PadType.LEFT)
	@MessageSetEnhance(beforeSet = QueryTradeAmtFormatInterseptor.class)
	public void setDownAmt(BigDecimal downAmt)
	{
		super.setDownAmt(downAmt);
	}

	
	
}
