package cn.szboc.platform.component.csp.trade.trade_000440.request;

import org.apache.commons.lang3.StringUtils;

import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.requestbuilder.CommonRequest;
import cn.szboc.platform.component.csp.trade.commons.TradeCode;
import cn.szboc.platform.component.csp.trade.trade_000440.response.ResponseAdapter_000440;
import cn.szboc.platform.component.csp.trade.trade_000440.response.StandardResponseBean_000440;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 通用000440请求交易格式
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 331)
public abstract class RequestAdapter_000440 extends CommonRequest<ResponseAdapter_000440, StandardResponseBean_000440> {
	
	//===========================上送数据域=====================================
    	/**	账号		*/	private String	upAccountNo;
    	/**	子帐户类别	*/	private String	upAccountSubType;
    	/**	定一本序号	*/	private String	upBookNo;
    	/**	定一本序号	*/	private String	upSheetNo;
	//======================================================================
	
	@Override
	protected TradeCode withTradeCode() {
		return TradeCode.TRADE_000440;
	}

	public String getUpAccountNo() {
		return upAccountNo;
	}

	public String getUpAccountSubType() {
		return upAccountSubType;
	}

	public String getUpBookNo() {
		return upBookNo;
	}

	public String getUpSheetNo() {
		return upSheetNo;
	}

	public RequestAdapter_000440 setUpAccountNo(String upAccountNo) {
		this.upAccountNo = upAccountNo;
		return this;
	}

	public RequestAdapter_000440 setUpAccountSubType(String upAccountSubType) {
		this.upAccountSubType = upAccountSubType;
		return this;
	}

	public RequestAdapter_000440 setUpBookNo(String upBookNo) {
		this.upBookNo = upBookNo;
		return this;
	}

	public RequestAdapter_000440 setUpSheetNo(String upSheetNo) {
		this.upSheetNo = upSheetNo;
		return this;
	}

	
	/**
	 * 对440交易上传的信息进行校验
	 */
	@Override
	protected void checkBeforeSend() throws RequestBuildingException {
		
		super.checkBeforeSend();
		
		if(StringUtils.isEmpty(getUpAccountNo()) || getUpAccountNo().length() > 22){
			throw new RequestBuildingException("账号[upAccountNo]字段必填,且最大长度为22,当前值为:" + getUpAccountNo());
		}
		
		if(StringUtils.isNotEmpty(getUpAccountSubType()) && getUpAccountSubType().length() > 4){
			throw new RequestBuildingException("子账户类别[upAccountSubType]如果有上送,则该字段最大长度为4,当前值为:" + getUpAccountSubType());
		}
		
		if(StringUtils.isNotEmpty(getUpBookNo()) && getUpBookNo().length() > 3){
			throw new RequestBuildingException("定一本册号[upBookNo]如果有上送,则该字段最大长度为3,当前值为:" + getUpBookNo());
		}
		
		if(StringUtils.isNotEmpty(getUpSheetNo()) && getUpSheetNo().length() > 2){
			throw new RequestBuildingException("定一本序号[upSheetNo]如果有上送,则该字段最大长度为2,当前值为:" + getUpSheetNo());
		}
		
	}
}
