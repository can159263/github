package cn.szboc.platform.component.csp.trade.trade_056048.response;

import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 对CSP交易056048交易SET方法的抽象
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 326)
public abstract class ResponseAdapter_056048 extends CommonResponse {

	// ===========================下载数据域=====================================
    	/** 错误码		*/		private String downErrorCode;
    	/** OK信息	*/		private String downProcCode;
    	/** 汇款编号	*/		private String downIpcsCode;
	// ========================= set & get =====================================

    public String getDownErrorCode() {
		return downErrorCode;
	}

	public String getDownProcCode() {
		return downProcCode;
	}

	public String getDownIpcsCode() {
		return downIpcsCode;
	}

	public void setDownErrorCode(String downErrorCode) {
		this.downErrorCode = downErrorCode;
	}

	public void setDownProcCode(String downProcCode) {
		this.downProcCode = downProcCode;
	}

	public void setDownIpcsCode(String downIpcsCode) {
		this.downIpcsCode = downIpcsCode;
	}
}
