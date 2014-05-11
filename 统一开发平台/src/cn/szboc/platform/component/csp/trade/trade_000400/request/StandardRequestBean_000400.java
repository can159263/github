package cn.szboc.platform.component.csp.trade.trade_000400.request;

import cn.szboc.platform.component.csp.trade.trade_000400.response.ResponseAdapter_000400;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 覆写父类的get方法,完成对上行数据域的所有字段的全部定义
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 334)
public class StandardRequestBean_000400<R extends ResponseAdapter_000400, SR extends R> extends RequestAdapter_000400<R, SR> {

	@MessageField(startPos = 300, length = 22)
	public String getUpAccountNo() {
		return super.getUpAccountNo();
	}

	@MessageField(startPos = 322, length = 3)
	public String getUpCurrencyNo() {
		return super.getUpCurrencyNo();
	}

	@MessageField(startPos = 325, length = 1)
	public String getUpQueryOption() {
		return super.getUpQueryOption();
	}

	@MessageField(startPos = 326, length = 1)
	public String getUpCashFlag() {
		return super.getUpCashFlag();
	}

	@MessageField(startPos = 327, length = 3)
	public String getUpBookNo() {
		return super.getUpBookNo();
	}

	@MessageField(startPos = 330, length = 2)
	public String getUpSheetNo() {
		return super.getUpSheetNo();
	}

	@MessageField(startPos = 332, length = 1)
	public String getUpLeastAmt() {
		return super.getUpLeastAmt();
	}

	@MessageField(startPos = 333, length = 1)
	public String getUpLeastMoney() {
		return super.getUpLeastMoney();
	}

}
