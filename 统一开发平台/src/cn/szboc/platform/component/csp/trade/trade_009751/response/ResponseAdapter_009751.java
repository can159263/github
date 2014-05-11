package cn.szboc.platform.component.csp.trade.trade_009751.response;

import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 009751通用应答格式
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 319)
public abstract class ResponseAdapter_009751 extends CommonResponse {

	// ===========================下载数据域=====================================
    	/** 交易状态 			*/		private String downTransStatus;
    	/** 关联的后台bancs流水号 	*/		private String downBancsNo;
    	/** 关联的后台bancs日期	*/		private String downBancsDate;
	// ========================= set & get =====================================

	public String getDownTransStatus() {
		return downTransStatus;
	}

	public String getDownBancsNo() {
		return downBancsNo;
	}

	public String getDownBancsDate() {
		return downBancsDate;
	}

	public void setDownTransStatus(String downTransStatus) {
		this.downTransStatus = downTransStatus;
	}

	public void setDownBancsNo(String downBancsNo) {
		this.downBancsNo = downBancsNo;
	}

	public void setDownBancsDate(String downBancsDate) {
		this.downBancsDate = downBancsDate;
	}
    	
}
