package cn.szboc.platform.component.csp.trade.trade_009751.response;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 全量的CSP.009751交易响应Bean
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 319)
public class StandardResponseBean_009751 extends ResponseAdapter_009751 {

	@Override
	@MessageField(startPos = 300, length = 2)
	public void setDownTransStatus(String downTransStatus) {
		super.setDownTransStatus(downTransStatus);
	}

	@Override
	@MessageField(startPos = 302, length = 9)
	public void setDownBancsNo(String downBancsNo) {
		super.setDownBancsNo(downBancsNo);
	}
	
	@Override
	@MessageField(startPos = 311, length = 8)
	public void setDownBancsDate(String downBancsDate) {
		super.setDownBancsDate(downBancsDate);
	}
	
}
