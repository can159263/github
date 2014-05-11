package cn.szboc.platform.component.csp.trade.trade_097511.request;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 全量的CSP.000440交易请求Bean 覆写了4个请求字段的get方法,增加了长度等注解信息
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 340)
public class StandardRequestBean_097511 extends RequestAdapter_097511 {

	@MessageField(startPos = 300, length = 8)
	public String getUpTransDate() {
		return super.getUpTransDate();
	}

	@MessageField(startPos = 308, length = 32)
	public String getUpSystemTransNo() {
		return super.getUpSystemTransNo();
	}

}
