package cn.szboc.platform.component.csp.trade.trade_A00400.request;

import cn.szboc.platform.component.csp.trade.trade_A00400.response.ResponseAdapter_A00400;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.To;

@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 336)
public class StandardRequestBean_A00400<R extends ResponseAdapter_A00400, SR extends R> extends RequestAdapter_A00400<R, SR> {

	@MessageField(startPos = 300, length = 22)
	public String getUpAccountNo() {
		return super.getUpAccountNo();
	}

	@MessageField(startPos = 322, length = 4)
	public String getUpSubAccountType() {
		return super.getUpSubAccountType();
	}

	@MessageField(startPos = 326, length = 1)
	public String getUpQueryOption() {
		return super.getUpQueryOption();
	}

	@MessageField(startPos = 327, length = 2)
	public String getUpProvinceCode() {
		return super.getUpProvinceCode();
	}

	@MessageField(startPos = 329, length = 3)
	public String getUpBookNo() {
		return super.getUpBookNo();
	}

	@MessageField(startPos = 332, length = 2)
	public String getUpSheetNo() {
		return super.getUpSheetNo();
	}

	@MessageField(startPos = 334, length = 1)
	public String getUpLeastAmt() {
		return super.getUpLeastAmt();
	}

	@MessageField(startPos = 335, length = 1)
	public String getUpLeastMoney() {
		return super.getUpLeastMoney();
	}

}
