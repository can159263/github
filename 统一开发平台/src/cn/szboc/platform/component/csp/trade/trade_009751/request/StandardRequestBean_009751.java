package cn.szboc.platform.component.csp.trade.trade_009751.request;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 009751查询交易.请求格式
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 309)
public class StandardRequestBean_009751 extends RequestAdapter_009751 {

	@MessageField(startPos = 300, length = 8)
	public String getUpCspTransNo() {
		return super.getUpCspTransNo();
	}

	@MessageField(startPos = 308, length = 1)
	public String getUpCompareFlag() {
		return super.getUpCompareFlag();
	}

}
