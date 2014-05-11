package cn.szboc.platform.component.csp.trade.trade_097511.response;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 全量的CSP.000440交易响应Bean
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 323)
public class StandardResponseBean_097511 extends ResponseAdapter_097511 {

	@MessageField(startPos = 300, length = 2)
	public void setDownTransStatus(String downTransStatus) {
		super.setDownTransStatus(downTransStatus);
	}

	@MessageField(startPos = 302, length = 9)
	public void setDownQueryBackgroundTransNo(String downQueryBackgroundTransNo) {
		super.setDownQueryBackgroundTransNo(downQueryBackgroundTransNo);
	}

	@MessageField(startPos = 311, length = 4)
	public void setDownRetCode(String downRetCode) {
		super.setDownRetCode(downRetCode);
	}

	@MessageField(startPos = 315, length = 8)
	public void setDownQueryCspTransNo(String downQueryCspTransNo) {
		super.setDownQueryCspTransNo(downQueryCspTransNo);
	}
}
