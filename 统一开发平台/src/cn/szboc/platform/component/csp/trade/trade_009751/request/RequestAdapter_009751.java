package cn.szboc.platform.component.csp.trade.trade_009751.request;

import org.apache.commons.lang3.StringUtils;

import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.requestbuilder.CommonRequest;
import cn.szboc.platform.component.csp.trade.commons.TradeCode;
import cn.szboc.platform.component.csp.trade.trade_009751.response.ResponseAdapter_009751;
import cn.szboc.platform.component.csp.trade.trade_009751.response.StandardResponseBean_009751;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 009751通用请求格式
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 309)
public abstract class RequestAdapter_009751 extends CommonRequest<ResponseAdapter_009751, StandardResponseBean_009751> {
	
	//===========================上送数据域=====================================
    	/**	CSP接口流水号	*/	private String	upCspTransNo;
    	/**	对账标志		*/	private String	upCompareFlag;
	//======================================================================
	
	@Override
	protected TradeCode withTradeCode() {
		return TradeCode.TRADE_009751;
	}

	public String getUpCspTransNo() {
		return upCspTransNo;
	}

	public String getUpCompareFlag() {
		return upCompareFlag;
	}

	public RequestAdapter_009751 setUpCspTransNo(String upCspTransNo) {
		this.upCspTransNo = upCspTransNo;
		return this;
	}

	public RequestAdapter_009751 setUpCompareFlag(String upCompareFlag) {
		this.upCompareFlag = upCompareFlag;
		return this;
	}

	/**
	 * 对009751交易上传的信息进行校验
	 */
	@Override
	protected void checkBeforeSend() throws RequestBuildingException {
		
		super.checkBeforeSend();
		
		if(StringUtils.isEmpty(getUpCspTransNo())){
			throw new RequestBuildingException("CSP接口流水号[upCspTransNo]字段必填");
		}
		
		if(getUpCspTransNo().length() > 8){
			throw new RequestBuildingException("CSP接口流水号[upCspTransNo]字段长度不能超过8,当前值为:" + getUpCspTransNo());
		}
		
		if(getUpCompareFlag() != null && getUpCompareFlag().length() > 1){
			throw new RequestBuildingException("CSP接口流水号[upCompareFlag]字段长度不能超过1,当前值为:" + getUpCompareFlag());
		}
		
	}
}
