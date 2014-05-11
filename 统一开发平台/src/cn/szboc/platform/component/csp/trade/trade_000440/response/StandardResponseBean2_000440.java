package cn.szboc.platform.component.csp.trade.trade_000440.response;

import java.math.BigDecimal;

import cn.szboc.platform.component.csp.trade.commons.interceptor.BigDecimalScaleInterceptor;
import cn.szboc.platform.component.csp.trade.commons.interceptor.QueryTradeAmtFormatInterseptor;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.MessageSetEnhance;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 全量的CSP.000440交易响应Bean
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 453)
public class StandardResponseBean2_000440 extends ResponseAdapter_000440 {

	/**
	 * 实际上,总行在下行的数据域中,都填写了对应的新账号,并且左补0,补全17位,后5位留空白
	 * 
	 * @param downAccountNo
	 */
	@Override
	@MessageField(startPos = 300, length = 22)
	public void setDownAccountNo(String downAccountNo) {
		super.setDownAccountNo(downAccountNo);
	}

	@Override
	@MessageField(startPos = 322, length = 3)
	public void setDownCurrencyNo(String downCurrencyNo) {
		super.setDownCurrencyNo(downCurrencyNo);
	}

	@Override
	@MessageField(startPos = 325, length = 5)
	public void setDownBranchNo(String downBranchNo) {
		super.setDownBranchNo(downBranchNo);
	}

	/**
	 * 此字段为中文字段,右补空白,通常为"正常"二字
	 * 
	 * @param downStatus
	 */
	@Override
	@MessageField(startPos = 330, length = 7)
	public void setDownStatus(String downStatus) {
		super.setDownStatus(downStatus);
	}

	@Override
	@MessageField(startPos = 337, length = 60)
	public void setDownCustomerName(String downCustomerName) {
		super.setDownCustomerName(downCustomerName);
	}

	/**
	 * 此字段左侧补空白,右侧最后一位是符号位,为空默认是正数,格式带小数点
	 * 
	 * @param downAmt
	 */
	@Override
	@MessageField(startPos = 397, length = 16, type = PadType.LEFT)
	@MessageSetEnhance(beforeSet = QueryTradeAmtFormatInterseptor.class, afterSet = BigDecimalScaleInterceptor.class)
	public void setDownAmt(BigDecimal downAmt) {
		super.setDownAmt(downAmt);
	}

	/**
	 * 此字段左侧补空白,右侧最后一位是符号位,为空默认是正数,格式带小数点
	 * 
	 * @param downAmt
	 */
	@Override
	@MessageField(startPos = 413, length = 16, type = PadType.LEFT)
	@MessageSetEnhance(beforeSet = QueryTradeAmtFormatInterseptor.class, afterSet = BigDecimalScaleInterceptor.class)
	public void setDownFrozenAmt(BigDecimal downFrozenAmt) {
		super.setDownFrozenAmt(downFrozenAmt);
	}

	/**
	 * 此字段左侧补空白,右侧最后一位是符号位,为空默认是正数,格式带小数点
	 * 
	 * @param downAmt
	 */
	@Override
	@MessageField(startPos = 429, length = 16, type = PadType.LEFT)
	@MessageSetEnhance(beforeSet = QueryTradeAmtFormatInterseptor.class, afterSet = BigDecimalScaleInterceptor.class)
	public void setDownEffectAmt(BigDecimal downEffectAmt) {
		super.setDownEffectAmt(downEffectAmt);
	}

	@Override
	@MessageField(startPos = 445, length = 8)
	public void setDownPcBancsCode(String downPcBancsCode) {
		super.setDownPcBancsCode(downPcBancsCode);
	}

	public String getDownAccountNo() {
		return super.getDownAccountNo();
	}

	public String getDownCurrencyNo() {
		return super.getDownCurrencyNo();
	}

	public String getDownBranchNo() {
		return super.getDownBranchNo();
	}

	public String getDownStatus() {
		return super.getDownStatus();
	}

	public String getDownCustomerName() {
		return super.getDownCustomerName();
	}

	public BigDecimal getDownAmt() {
		return super.getDownAmt();
	}

	public BigDecimal getDownFrozenAmt() {
		return super.getDownFrozenAmt();
	}

	public BigDecimal getDownEffectAmt() {
		return super.getDownEffectAmt();
	}

	public String getDownPcBancsCode() {
		return super.getDownPcBancsCode();
	}

}
