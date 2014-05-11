package cn.szboc.platform.component.csp.trade.trade_001045.request;

import java.math.BigDecimal;

import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.requestbuilder.CommonRequest;
import cn.szboc.platform.component.csp.trade.commons.TradeCode;
import cn.szboc.platform.component.csp.trade.trade_001045.response.ResponseAdapter_001045;
import cn.szboc.platform.component.csp.trade.trade_001045.response.StandardResponseBean_001045;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 通用001045请求交易格式
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 331)
public abstract class RequestAdapter_001045 extends CommonRequest<ResponseAdapter_001045, StandardResponseBean_001045> {
	
	//===========================上送数据域=====================================
    	/**	转出账号	*/	private String	upAccountNoOut;
    	/**	转出金额	*/	private BigDecimal	upAmt;
    	/**	提示码		*/	private String	upPromptCode;
    	/**	转入账号	*/	private String	upAccountNoIn;  
    	/**	币别		*/	private String	upCurrcyNo;  
    	/**	对账单摘要	*/	private String	upBrief;  
    	/**	定一本序号	*/	private String	upBookNo;
    	/**	定一本序号	*/	private String	upSheetNo;
    	/**	子账户类别	*/	private String	upLinkCurFlag;
    	/**	产品码		*/	private String	upPcBancsCode;
    	/**	存期 		*/	private String	upPcTerm;
    	/**	基期 		*/	private String	upPcBasis;
    	/**	凭证类别 	*/	private String	upVoteType;
    	/**	凭证号码 	*/	private String	upVoteNo;
    	/**	支取方式 	*/	private String	upWithType;
    	/**	凭证签发日期	*/	private String	upOpenDate;
    	/**	客户密码 	*/	private String	upCusPwd;
    	/**	转出卡号  	*/	private String	upCardNoOut;
    	/**	转入卡号 	*/	private String	upCardNoIn;
    	/**	支付密码标识	*/	private String	upPwdCheckFlag;
	//======================================================================
	
	@Override
	protected TradeCode withTradeCode() {
		return TradeCode.TRADE_001045;
	}

	public String getUpAccountNoOut() {
		return upAccountNoOut;
	}

	public BigDecimal getUpAmt() {
		return upAmt;
	}

	public String getUpPromptCode() {
		return upPromptCode;
	}

	public String getUpAccountNoIn() {
		return upAccountNoIn;
	}

	public String getUpCurrcyNo() {
		return upCurrcyNo;
	}

	public String getUpBrief() {
		return upBrief;
	}

	public String getUpBookNo() {
		return upBookNo;
	}

	public String getUpSheetNo() {
		return upSheetNo;
	}

	public String getUpLinkCurFlag() {
		return upLinkCurFlag;
	}

	public String getUpPcBancsCode() {
		return upPcBancsCode;
	}

	public String getUpPcTerm() {
		return upPcTerm;
	}

	public String getUpPcBasis() {
		return upPcBasis;
	}

	public String getUpVoteType() {
		return upVoteType;
	}

	public String getUpVoteNo() {
		return upVoteNo;
	}

	public String getUpWithType() {
		return upWithType;
	}

	public String getUpOpenDate() {
		return upOpenDate;
	}

	public String getUpCusPwd() {
		return upCusPwd;
	}

	public String getUpCardNoOut() {
		return upCardNoOut;
	}

	public String getUpCardNoIn() {
		return upCardNoIn;
	}

	public String getUpPwdCheckFlag() {
		return upPwdCheckFlag;
	}

	public RequestAdapter_001045 setUpAccountNoOut(String upAccountNoOut) {
		this.upAccountNoOut = upAccountNoOut;
		return this;
	}

	public RequestAdapter_001045 setUpAmt(BigDecimal upAmt) {
		this.upAmt = upAmt;
		return this;
	}

	public RequestAdapter_001045 setUpPromptCode(String upPromptCode) {
		this.upPromptCode = upPromptCode;
		return this;
	}

	public RequestAdapter_001045 setUpAccountNoIn(String upAccountNoIn) {
		this.upAccountNoIn = upAccountNoIn;
		return this;
	}

	public RequestAdapter_001045 setUpCurrcyNo(String upCurrcyNo) {
		this.upCurrcyNo = upCurrcyNo;
		return this;
	}

	public RequestAdapter_001045 setUpBrief(String upBrief) {
		this.upBrief = upBrief;
		return this;
	}

	public RequestAdapter_001045 setUpBookNo(String upBookNo) {
		this.upBookNo = upBookNo;
		return this;
	}

	public RequestAdapter_001045 setUpSheetNo(String upSheetNo) {
		this.upSheetNo = upSheetNo;
		return this;
	}

	public RequestAdapter_001045 setUpLinkCurFlag(String upLinkCurFlag) {
		this.upLinkCurFlag = upLinkCurFlag;
		return this;
	}

	public RequestAdapter_001045 setUpPcBancsCode(String upPcBancsCode) {
		this.upPcBancsCode = upPcBancsCode;
		return this;
	}

	public RequestAdapter_001045 setUpPcTerm(String upPcTerm) {
		this.upPcTerm = upPcTerm;
		return this;
	}

	public RequestAdapter_001045 setUpPcBasis(String upPcBasis) {
		this.upPcBasis = upPcBasis;
		return this;
	}

	public RequestAdapter_001045 setUpVoteType(String upVoteType) {
		this.upVoteType = upVoteType;
		return this;
	}

	public RequestAdapter_001045 setUpVoteNo(String upVoteNo) {
		this.upVoteNo = upVoteNo;
		return this;
	}

	public RequestAdapter_001045 setUpWithType(String upWithType) {
		this.upWithType = upWithType;
		return this;
	}

	public RequestAdapter_001045 setUpOpenDate(String upOpenDate) {
		this.upOpenDate = upOpenDate;
		return this;
	}

	public RequestAdapter_001045 setUpCusPwd(String upCusPwd) {
		this.upCusPwd = upCusPwd;
		return this;
	}

	public RequestAdapter_001045 setUpCardNoOut(String upCardNoOut) {
		this.upCardNoOut = upCardNoOut;
		return this;
	}

	public RequestAdapter_001045 setUpCardNoIn(String upCardNoIn) {
		this.upCardNoIn = upCardNoIn;
		return this;
	}

	public RequestAdapter_001045 setUpPwdCheckFlag(String upPwdCheckFlag) {
		this.upPwdCheckFlag = upPwdCheckFlag;
		return this;
	}

	/**
	 * 对001045交易上传的信息进行校验
	 */
	@Override
	protected void checkBeforeSend() throws RequestBuildingException {
		
		super.checkBeforeSend();
		
		// TODO
		
	}
}
