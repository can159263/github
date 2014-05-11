package cn.szboc.platform.component.csp.trade.trade_000440.response;

import java.math.BigDecimal;

import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 000440交易通用应答的格式
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 453)
public abstract class ResponseAdapter_000440 extends CommonResponse {

	// ===========================下载数据域=====================================
    	/** 帐号		*/		private String downAccountNo;
    	/** 币别		*/		private String downCurrencyNo;
    	/** 机构号		*/		private String downBranchNo;
    	/** 状态		*/		private String downStatus;
    	/** 客户名称	*/		private String downCustomerName;
    	/** 金额		*/		private BigDecimal downAmt;
    	/** 冻结金额	*/		private BigDecimal downFrozenAmt;
    	/** 有效金额	*/		private BigDecimal downEffectAmt;
    	/** 产品码		*/		private String downPcBancsCode;
	// ========================= set & get =====================================

	/**
	 * 返回对应的17位新账号
	 * 
	 * @param downAccountNo
	 */
	public void setDownAccountNo(String downAccountNo) {
		this.downAccountNo = downAccountNo;
	}

	/**
	 * 返回对应账号的币别
	 * 
	 * @param downCurrencyNo
	 */
	public void setDownCurrencyNo(String downCurrencyNo) {
		this.downCurrencyNo = downCurrencyNo;
	}

	/**
	 * 返回对应账号的机构号
	 * 
	 * @param downBranchNo
	 */
	public void setDownBranchNo(String downBranchNo) {
		this.downBranchNo = downBranchNo;
	}

	/**
	 * 返回对应账号的状态 实际生产上,此字段为中文字段,右补空白,通常为"正常"二字,故该字段并无实际意义,可视为一般描述
	 * 
	 * @param downStatus
	 */
	public void setDownStatus(String downStatus) {
		this.downStatus = downStatus;
	}

	/**
	 * 返回账号对应的客户名称 注意,此字段为客户名称,不是账户名称,要获取对应的账户名称,请使用000400交易
	 * 
	 * @param downCustomerName
	 */
	public void setDownCustomerName(String downCustomerName) {
		this.downCustomerName = downCustomerName;
	}

	/**
	 * 返回账号对应的金额 此字段左侧补空白,右侧最后一位是符号位,为空默认是正数,格式带小数点
	 * 
	 * @param downAmt
	 */
	public void setDownAmt(BigDecimal downAmt) {
		this.downAmt = downAmt;
	}

	/**
	 * 返回账号对应的冻结金额 此字段左侧补空白,右侧最后一位是符号位,为空默认是正数,格式带小数点
	 * 
	 * @param downAmt
	 */
	public void setDownFrozenAmt(BigDecimal downFrozenAmt) {
		this.downFrozenAmt = downFrozenAmt;
	}

	/**
	 * 返回账号对应的有效金额 此字段左侧补空白,右侧最后一位是符号位,为空默认是正数,格式带小数点
	 * 
	 * @param downAmt
	 */
	public void setDownEffectAmt(BigDecimal downEffectAmt) {
		this.downEffectAmt = downEffectAmt;
	}

	/**
	 * 返回账号对应的产品码, 通常为8位字节,有前四位产品主码和后四位产品字码组成
	 * 
	 * @param downPcBancsCode
	 */
	public void setDownPcBancsCode(String downPcBancsCode) {
		this.downPcBancsCode = downPcBancsCode;
	}

	public String getDownAccountNo() {
		return downAccountNo;
	}

	public String getDownCurrencyNo() {
		return downCurrencyNo;
	}

	public String getDownBranchNo() {
		return downBranchNo;
	}

	public String getDownStatus() {
		return downStatus;
	}

	public String getDownCustomerName() {
		return downCustomerName;
	}

	public BigDecimal getDownAmt() {
		return downAmt;
	}

	public BigDecimal getDownFrozenAmt() {
		return downFrozenAmt;
	}

	public BigDecimal getDownEffectAmt() {
		return downEffectAmt;
	}

	public String getDownPcBancsCode() {
		return downPcBancsCode;
	}

}
