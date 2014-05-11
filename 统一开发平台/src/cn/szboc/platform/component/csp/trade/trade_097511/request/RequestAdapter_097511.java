package cn.szboc.platform.component.csp.trade.trade_097511.request;

import org.apache.commons.lang3.StringUtils;

import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.requestbuilder.CommonRequest;
import cn.szboc.platform.component.csp.trade.commons.TradeCode;
import cn.szboc.platform.component.csp.trade.trade_097511.response.ResponseAdapter_097511;
import cn.szboc.platform.component.csp.trade.trade_097511.response.StandardResponseBean_097511;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 通用000440请求交易格式
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 340)
public abstract class RequestAdapter_097511 extends CommonRequest<ResponseAdapter_097511, StandardResponseBean_097511> {
	
	//===========================上送数据域=====================================
    	/**	交易日期	*/	private String	upTransDate;
    	/**	外围流水号	*/	private String	upSystemTransNo;
	//======================================================================
	
	@Override
	protected TradeCode withTradeCode() {
		return TradeCode.TRADE_097511;
	}

	public String getUpTransDate() {
		return upTransDate;
	}

	public String getUpSystemTransNo() {
		return upSystemTransNo;
	}

	public RequestAdapter_097511 setUpTransDate(String upTransDate) {
		this.upTransDate = upTransDate;
		return this;
	}

	public RequestAdapter_097511 setUpSystemTransNo(String upSystemTransNo) {
		this.upSystemTransNo = upSystemTransNo;
		return this;
	}

	/**
	 * 对097511交易上传的信息进行校验
	 */
	@Override
	protected void checkBeforeSend() throws RequestBuildingException {
		
		super.checkBeforeSend();
		
		if(StringUtils.isEmpty(getUpTransDate()) || getUpTransDate().length() != 8){
			throw new RequestBuildingException("交易日期[upTransDate]字段必填,且长度必须为8,当前值为:" + getUpTransDate());
		}
		
		if(StringUtils.isEmpty(getUpSystemTransNo()) || getUpSystemTransNo().length() > 32){
			throw new RequestBuildingException("交易流水号[upSystemTransNo]字段必填,且最大长度为32,当前值为:" + getUpSystemTransNo());
		}
		
	}
}
