package cn.szboc.platform.component.csp.trade.trade_097511.response;

import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 000440交易通用应答的格式
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 323)
public abstract class ResponseAdapter_097511 extends CommonResponse {

	// ===========================下载数据域=====================================
    	/** 交易状态 			*/		private String downTransStatus;
    	/** 查询交易的后台流水号 	*/		private String downQqueryBackgroundTransNo;
    	/** 4位原返回码			*/		private String downRetCode;
    	/** 查询交易的CSP流水号	*/		private String downQueryCspTransNo;
	// ========================= set & get =====================================
	public String getDownTransStatus() {
		return downTransStatus;
	}

	public String getDownQqueryBackgroundTransNo() {
		return downQqueryBackgroundTransNo;
	}

	public String getDownRetCode() {
		return downRetCode;
	}

	public String getDownQueryCspTransNo() {
		return downQueryCspTransNo;
	}

	public void setDownTransStatus(String downTransStatus) {
		this.downTransStatus = downTransStatus;
	}

	public void setDownQueryBackgroundTransNo(String downQqueryBackgroundTransNo) {
		this.downQqueryBackgroundTransNo = downQqueryBackgroundTransNo;
	}

	public void setDownRetCode(String downRetCode) {
		this.downRetCode = downRetCode;
	}

	public void setDownQueryCspTransNo(String downQueryCspTransNo) {
		this.downQueryCspTransNo = downQueryCspTransNo;
	}

}
