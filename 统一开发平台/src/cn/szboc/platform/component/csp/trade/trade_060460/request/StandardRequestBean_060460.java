package cn.szboc.platform.component.csp.trade.trade_060460.request;

import cn.szboc.platform.component.csp.trade.trade_060460.response.ResponseAdapter_060460;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * @author
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 356)
public class StandardRequestBean_060460<R extends ResponseAdapter_060460, SR extends R> extends RequestAdapter_060460<R, SR> {
	/**
	 * 客户号/账号
	 */
	@Override
	@MessageField(startPos = 300, length = 17, type = PadType.LEFT, material = 48)
	public String getUpALinkAccount() {
		return super.getUpALinkAccount();
	}

	/**
	 * 客户类型
	 */
	@Override
	@MessageField(startPos = 317, length = 2)
	public String getUpCusType() {
		return super.getUpCusType();
	}

	/**
	 * 客户/账号
	 */
	@Override
	@MessageField(startPos = 319, length = 1)
	public String getUpStdDcFlag() {
		return super.getUpStdDcFlag();
	}

	/**
	 * 查询选项
	 */
	@Override
	@MessageField(startPos = 320, length = 1)
	public String getUpStdQueryOption() {
		return super.getUpStdQueryOption();
	}

	/**
	 * 选项分区
	 */
	@Override
	@MessageField(startPos = 321, length = 1)
	public String getUpStdProption() {
		return super.getUpStdProption();
	}

	/**
	 * 证件号码
	 */
	@Override
	@MessageField(startPos = 322, length = 32)
	public String getUpStdPassNo() {
		return super.getUpStdPassNo();
	}

	/**
	 * 证件类型
	 */
	@Override
	@MessageField(startPos = 354, length = 2)
	public String getUpStdPassType() {
		return super.getUpStdPassType();
	}
}