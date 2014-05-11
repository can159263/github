package cn.szboc.platform.component.csp.trade.trade_020400.request;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 020400查询交易.请求格式
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 322)
public class StandardRequestBean_020400 extends RequestAdapter_020400 {

	@MessageField(startPos = 300, length = 22)
	public String getUpBglAct() {
		return super.getUpBglAct();
	}
}
