package cn.szboc.platform.component.csp.trade.trade_000400.response;

import java.math.BigDecimal;

import cn.szboc.platform.component.csp.trade.commons.interceptor.BigDecimalScaleInterceptor;
import cn.szboc.platform.component.csp.trade.commons.interceptor.QueryTradeAmtFormatInterseptor;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.MessageSetEnhance;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;

@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 474)
public class StandardResponseBean_000400_OPT_1 extends ResponseAdapter_000400_OPT_1 {

	public String getDownAccountNo() {
		return super.getDownAccountNo();
	}

	public String getDownCurrencyNo() {
		return super.getDownCurrencyNo();
	}

	public String getDownBranchNo() {
		return super.getDownBranchNo();
	}

	public String getDownPcBancsCode() {
		return super.getDownPcBancsCode();
	}

	public String getDownAccountName() {
		return super.getDownAccountName();
	}

	public String getDownCustomerName() {
		return super.getDownCustomerName();
	}

	public BigDecimal getDownAmt() {
		return super.getDownAmt();
	}

	/**
	 * 实际上,总行在下行的数据域中,都填写了对应的新账号,并且左补0,补全17位,后5位留空白
	 * 
	 * @param downAccountNo
	 */
	@MessageField(startPos = 300, length = 22)
	public void setDownAccountNo(String downAccountNo) {
		super.setDownAccountNo(downAccountNo);
	}

	@MessageField(startPos = 322, length = 3)
	public void setDownCurrencyNo(String downCurrencyNo) {
		super.setDownCurrencyNo(downCurrencyNo);
	}

	@MessageField(startPos = 325, length = 5)
	public void setDownBranchNo(String downBranchNo) {
		super.setDownBranchNo(downBranchNo);
	}

	@MessageField(startPos = 330, length = 8)
	public void setDownPcBancsCode(String downPcBancsCode) {
		super.setDownPcBancsCode(downPcBancsCode);
	}

	@MessageField(startPos = 338, length = 60)
	public void setDownAccountName(String downAccountName) {
		super.setDownAccountName(downAccountName);
	}

	@MessageField(startPos = 398, length = 60)
	public void setDownCustomerName(String downCustomerName) {
		super.setDownCustomerName(downCustomerName);
	}

	/**
	 * 此字段左侧补空白,右侧最后一位是符号位,为空默认是正数,格式带小数点
	 * 
	 * @param downAmt
	 */
	@MessageField(startPos = 458, length = 16, type = PadType.LEFT)
	@MessageSetEnhance(beforeSet = QueryTradeAmtFormatInterseptor.class, afterSet = BigDecimalScaleInterceptor.class)
	public void setDownAmt(BigDecimal downAmt) {
		super.setDownAmt(downAmt);
	}

}
