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
public abstract class ResponseAdapter_000400_OPT_1 extends ResponseAdapter_000400 {

// ===========================下载数据域=====================================
	/** 帐号		*/		private String downAccountNo;
	/** 币别 		*/		private String downCurrencyNo;
	/** 机构号 		*/		private String downBranchNo;
	/** 产品码		*/		private String downPcBancsCode;
	/** 客户名称 	*/		private String downAccountName;
	/** 客户名称	*/		private String downCustomerName;
	/** 金额		*/		private BigDecimal downAmt;
// ========================= set & get =====================================
	
	public String getDownAccountNo() {
		return downAccountNo;
	}

	public String getDownCurrencyNo() {
		return downCurrencyNo;
	}

	public String getDownBranchNo() {
		return downBranchNo;
	}

	public String getDownPcBancsCode() {
		return downPcBancsCode;
	}

	public String getDownAccountName() {
		return downAccountName;
	}

	public String getDownCustomerName() {
		return downCustomerName;
	}

	public BigDecimal getDownAmt() {
		return downAmt;
	}

	/**
	 * 实际上,总行在下行的数据域中,都填写了对应的新账号,并且左补0,补全17位,后5位留空白
	 * 
	 * @param downAccountNo
	 */
	@MessageField(startPos = 300, length = 22)
	public void setDownAccountNo(String downAccountNo) {
		this.downAccountNo = downAccountNo;
	}

	@MessageField(startPos = 322, length = 3)
	public void setDownCurrencyNo(String downCurrencyNo) {
		this.downCurrencyNo = downCurrencyNo;
	}

	@MessageField(startPos = 325, length = 5)
	public void setDownBranchNo(String downBranchNo) {
		this.downBranchNo = downBranchNo;
	}

	@MessageField(startPos = 330, length = 8)
	public void setDownPcBancsCode(String downPcBancsCode) {
		this.downPcBancsCode = downPcBancsCode;
	}

	@MessageField(startPos = 338, length = 60)
	public void setDownAccountName(String downAccountName) {
		this.downAccountName = downAccountName;
	}

	@MessageField(startPos = 398, length = 60)
	public void setDownCustomerName(String downCustomerName) {
		this.downCustomerName = downCustomerName;
	}

	/**
	 * 此字段左侧补空白,右侧最后一位是符号位,为空默认是正数,格式带小数点
	 * 
	 * @param downAmt
	 */
	@MessageField(startPos = 458, length = 16, type = PadType.LEFT)
	@MessageSetEnhance(beforeSet = QueryTradeAmtFormatInterseptor.class, afterSet = BigDecimalScaleInterceptor.class)
	public void setDownAmt(BigDecimal downAmt) {
		this.downAmt = downAmt;
	}

}
