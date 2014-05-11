package cn.szboc.platform.component.csp.trade.trade_001045.response;

import java.math.BigDecimal;

import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 001045交易通用应答的格式
 * 
 * 本类中的所有金额字段均为BigDecimal类型,格式是不包含小数点的定长两位标度显示,即99999表示999.99
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 507)
public abstract class ResponseAdapter_001045 extends CommonResponse {

	// ===========================下载数据域=====================================
    	/** 日期				*/	private String downDate;
    	/** 时间				*/	private String downTime;
    	/** 客户号				*/	private String downCusId;
    	/** 转出账户当前余额		*/	private BigDecimal downOutCurrentAmt;
    	/** 转出账户可用余额		*/	private BigDecimal downOutAvailableAmt;
    	/** 转出帐户开户行		*/	private String downOutBranch;
    	/** 转入帐户开户行		*/	private String downInBranch;
    	/** 转入帐号当前余额		*/	private BigDecimal downInCurrentAmt;    	
    	/** 转入帐号可用余额		*/	private BigDecimal downInAvailableAmt;    	
    	/** 第一种费用的费用金额	*/	private BigDecimal downFeeAmt1;    	
    	/** 第二种费用的费用金额	*/	private BigDecimal downFeeAmt2;    	
    	/** 第三种费用的费用金额	*/	private BigDecimal downFeeAmt3;    	
    	/** 第四种费用的费用金额	*/	private BigDecimal downFeeAmt4;    	
    	/** 第五种费用的费用金额	*/	private BigDecimal downFeeAmt5;    	
    	/** 转出帐号一本通的册号	*/	private String downOutBookNo;    	
    	/** 转出帐号一本通的序号	*/	private String downOutSeqNo;    	
    	/** 转入帐号一本通的册号	*/	private String downInBookNo;    	
    	/** 转入帐号一本通的序号	*/	private String downInSeqNo;    	
    	/** 成交汇率			*/	private BigDecimal downTradeRate;    	
	// ========================= set & get =====================================
    	
    	/**
    	 * 栏位: 1
    	 * 日期,格式为YYYYMMDD
    	 * 
    	 * @return
    	 */
    	public String getDownDate() {
    		return downDate;
    	}
    
    	/**
    	 * 栏位: 2
    	 * 时间,格式为HHMMSSHS
    	 * 
    	 * @return
    	 */
    	public String getDownTime() {
    		return downTime;
    	}
    
    	/**
    	 * 栏位: 3
    	 * 客户号
    	 * 
    	 * @return
    	 */
    	public String getDownCusId() {
    		return downCusId;
    	}
    
    	/**
    	 * 栏位: 4
    	 * 转出账户当前余额
    	 * 
    	 * @return
    	 */
    	public BigDecimal getDownOutCurrentAmt() {
    		return downOutCurrentAmt;
    	}
    
    	/**
    	 * 栏位: 5
    	 * 转出账户可用余额
    	 * 
    	 * @return
    	 */
    	public BigDecimal getDownOutAvailableAmt() {
    		return downOutAvailableAmt;
    	}
    
    	/**
    	 * 栏位: 6
    	 * 转出账户开户行
    	 * 
    	 * @return
    	 */
    	public String getDownOutBranch() {
    		return downOutBranch;
    	}
    
    	/**
    	 * 栏位: 7
    	 * 转入账户开户行
    	 * 
    	 * @return
    	 */
    	public String getDownInBranch() {
    		return downInBranch;
    	}
        
    	/**
    	 * 栏位: 8
    	 * 转入账户当前余额
    	 * 
    	 * @return
    	 */    
    	public BigDecimal getDownInCurrentAmt() {
    		return downInCurrentAmt;
    	}
    
    	/**
    	 * 栏位: 9
    	 * 转入账户可用余额
    	 * 
    	 * @return
    	 */  
    	public BigDecimal getDownInAvailableAmt() {
    		return downInAvailableAmt;
    	}
        
    	/**
    	 * 栏位: 10
    	 * 第1种费用的费用金额
    	 * 
    	 * @return
    	 */  
    	public BigDecimal getDownFeeAmt1() {
    		return downFeeAmt1;
    	}
    
    	/**
    	 * 栏位: 11
    	 * 第2种费用的费用金额
    	 * 
    	 * @return
    	 */  
    	public BigDecimal getDownFeeAmt2() {
    		return downFeeAmt2;
    	}
        
    	/**
    	 * 栏位: 12
    	 * 第3种费用的费用金额
    	 * 
    	 * @return
    	 */ 
    	public BigDecimal getDownFeeAmt3() {
    		return downFeeAmt3;
    	}
        
    	/**
    	 * 栏位: 13
    	 * 第4种费用的费用金额
    	 * 
    	 * @return
    	 */ 
    	public BigDecimal getDownFeeAmt4() {
    		return downFeeAmt4;
    	}
        
    	/**
    	 * 栏位: 14
    	 * 第5种费用的费用金额
    	 * 
    	 * @return
    	 */ 
    	public BigDecimal getDownFeeAmt5() {
    		return downFeeAmt5;
    	}
        
    	/**
    	 * 栏位: 15
    	 * 转出帐号一本通的册号
    	 * 
    	 * @return
    	 */ 
    	public String getDownOutBookNo() {
    		return downOutBookNo;
    	}
 
    	/**
    	 * 栏位: 16
    	 * 转出帐号一本通的序号
    	 * 
    	 * @return
    	 */ 
    	public String getDownOutSeqNo() {
    		return downOutSeqNo;
    	}
    
    	/**
    	 * 栏位: 17
    	 * 转入帐号一本通的册号
    	 * 
    	 * @return
    	 */
    	public String getDownInBookNo() {
    		return downInBookNo;
    	}
    	
    	/**
    	 * 栏位: 18
    	 * 转入帐号一本通的序号
    	 * 
    	 * @return
    	 */
    	public String getDownInSeqNo() {
    		return downInSeqNo;
    	}
    
    	/**
    	 * 栏位: 19
    	 * 成交汇率
    	 * 
    	 * @return
    	 */
    	public BigDecimal getDownTradeRate() {
    		return downTradeRate;
    	}
    
    	public void setDownDate(String downDate) {
    		this.downDate = downDate;
    	}
    
    	public void setDownTime(String downTime) {
    		this.downTime = downTime;
    	}
    
    	public void setDownCusId(String downCusId) {
    		this.downCusId = downCusId;
    	}
    
    	public void setDownOutCurrentAmt(BigDecimal downOutCurrentAmt) {
    		this.downOutCurrentAmt = downOutCurrentAmt;
    	}
    
    	public void setDownOutAvailableAmt(BigDecimal downOutAvailableAmt) {
    		this.downOutAvailableAmt = downOutAvailableAmt;
    	}
    
    	public void setDownOutBranch(String downOutBranch) {
    		this.downOutBranch = downOutBranch;
    	}
    
    	public void setDownInBranch(String downInBranch) {
    		this.downInBranch = downInBranch;
    	}
    
    	public void setDownInCurrentAmt(BigDecimal downInCurrentAmt) {
    		this.downInCurrentAmt = downInCurrentAmt;
    	}
    
    	public void setDownInAvailableAmt(BigDecimal downInAvailableAmt) {
    		this.downInAvailableAmt = downInAvailableAmt;
    	}
    
    	public void setDownFeeAmt1(BigDecimal downFeeAmt1) {
    		this.downFeeAmt1 = downFeeAmt1;
    	}
    
    	public void setDownFeeAmt2(BigDecimal downFeeAmt2) {
    		this.downFeeAmt2 = downFeeAmt2;
    	}
    
    	public void setDownFeeAmt3(BigDecimal downFeeAmt3) {
    		this.downFeeAmt3 = downFeeAmt3;
    	}
    
    	public void setDownFeeAmt4(BigDecimal downFeeAmt4) {
    		this.downFeeAmt4 = downFeeAmt4;
    	}
    
    	public void setDownFeeAmt5(BigDecimal downFeeAmt5) {
    		this.downFeeAmt5 = downFeeAmt5;
    	}
    
    	public void setDownOutBookNo(String downOutBookNo) {
    		this.downOutBookNo = downOutBookNo;
    	}
    
    	public void setDownOutSeqNo(String downOutSeqNo) {
    		this.downOutSeqNo = downOutSeqNo;
    	}
    
    	public void setDownInBookNo(String downInBookNo) {
    		this.downInBookNo = downInBookNo;
    	}
    
    	public void setDownInSeqNo(String downInSeqNo) {
    		this.downInSeqNo = downInSeqNo;
    	}
    
    	public void setDownTradeRate(BigDecimal downTradeRate) {
    		this.downTradeRate = downTradeRate;
    	}

}
