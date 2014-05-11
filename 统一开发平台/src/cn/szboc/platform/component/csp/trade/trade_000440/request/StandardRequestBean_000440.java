package cn.szboc.platform.component.csp.trade.trade_000440.request;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 全量的CSP.000440交易请求Bean 覆写了4个请求字段的get方法,增加了长度等注解信息
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 331)
public class StandardRequestBean_000440 extends RequestAdapter_000440 {

	@MessageField(startPos = 300, length = 22)
	public String getUpAccountNo() {
		return super.getUpAccountNo();
	}

	@MessageField(startPos = 322, length = 4)
	public String getUpAccountSubType() {
		return super.getUpAccountSubType();
	}

	@MessageField(startPos = 326, length = 3)
	public String getUpBookNo() {
		return super.getUpBookNo();
	}

	@MessageField(startPos = 329, length = 2)
	public String getUpSheetNo() {
		return super.getUpSheetNo();
	}

}
