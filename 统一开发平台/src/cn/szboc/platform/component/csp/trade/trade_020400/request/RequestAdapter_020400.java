package cn.szboc.platform.component.csp.trade.trade_020400.request;

import org.apache.commons.lang3.StringUtils;

import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.requestbuilder.CommonRequest;
import cn.szboc.platform.component.csp.trade.commons.TradeCode;
import cn.szboc.platform.component.csp.trade.trade_020400.response.ResponseAdapter_020400;
import cn.szboc.platform.component.csp.trade.trade_020400.response.StandardResponseBean_020400;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 020400通用请求格式
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 322)
public abstract class RequestAdapter_020400 extends CommonRequest<ResponseAdapter_020400, StandardResponseBean_020400> {
	
	//===========================上送数据域=====================================
    	/**	BGL帐号	*/	private String upBglAcct;
	//======================================================================

	@Override
	protected TradeCode withTradeCode() {
		return TradeCode.TRADE_020400;
	}

	public String getUpBglAct()
	{
		return upBglAcct;
	}

	public RequestAdapter_020400 setUpBglAct(String upBglAct)
	{
		this.upBglAcct = upBglAct;
		return this;
	}

	/**
	 * 对020400交易上传的信息进行校验
	 */
	@Override
	protected void checkBeforeSend() throws RequestBuildingException {
		
		super.checkBeforeSend();
		
		if(StringUtils.isEmpty(getUpBglAct())){
			throw new RequestBuildingException("BGL帐号[upBglAct]字段必填");
		}
		
		if(getUpBglAct().length() > 22){
			throw new RequestBuildingException("BGL帐号[upBglAct]字段长度不能超过22,当前值为:" + getUpBglAct());
		}
	}
}
