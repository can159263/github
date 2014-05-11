package cn.szboc.platform.component.csp.trade.trade_000400.request;

import org.apache.commons.lang3.StringUtils;

import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.requestbuilder.CommonRequest;
import cn.szboc.platform.component.csp.trade.commons.TradeCode;
import cn.szboc.platform.component.csp.trade.trade_000400.response.ResponseAdapter_000400;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 通用000440请求交易格式
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 334)
public abstract class RequestAdapter_000400<R extends ResponseAdapter_000400, SR extends R> extends CommonRequest<R, SR> {

	//===========================上送数据域=====================================
    	/** 查询账号 */				private String upAccountNo;
    	/** 币别 */ 				private String upCurrencyNo;
    	/** 查询选项 */ 			private String upQueryOption;
    	/** 钞汇标志 */ 			private String upCashFlag;
    	/** 定一本册号 */ 			private String upBookNo;
    	/** 定一本序号 */ 			private String upSheetNo;
    	/** 每月最低清算余额查询 */ 		private String upLeastAmt;
    	/** 每月最低存折余额查询 */ 		private String upLeastMoney;
	//======================================================================

	@Override
	protected TradeCode withTradeCode() {
		return TradeCode.TRADE_000400;
	}

	public String getUpAccountNo() {
		return upAccountNo;
	}

	public String getUpCurrencyNo() {
		return upCurrencyNo;
	}

	public String getUpQueryOption() {
		return upQueryOption;
	}

	public String getUpCashFlag() {
		return upCashFlag;
	}

	public String getUpBookNo() {
		return upBookNo;
	}

	public String getUpSheetNo() {
		return upSheetNo;
	}

	public String getUpLeastAmt() {
		return upLeastAmt;
	}

	public String getUpLeastMoney() {
		return upLeastMoney;
	}

	public RequestAdapter_000400<R, SR> setUpAccountNo(String upAccountNo) {
		this.upAccountNo = upAccountNo;
		return this;
	}

	public RequestAdapter_000400<R, SR> setUpCurrencyNo(String upCurrencyNo) {
		this.upCurrencyNo = upCurrencyNo;
		return this;
	}

	public RequestAdapter_000400<R, SR> setUpQueryOption(String upQueryOption) {
		this.upQueryOption = upQueryOption;
		return this;
	}

	public RequestAdapter_000400<R, SR> setUpCashFlag(String upCashFlag) {
		this.upCashFlag = upCashFlag;
		return this;
	}

	public RequestAdapter_000400<R, SR> setUpBookNo(String upBookNo) {
		this.upBookNo = upBookNo;
		return this;
	}

	public RequestAdapter_000400<R, SR> setUpSheetNo(String upSheetNo) {
		this.upSheetNo = upSheetNo;
		return this;
	}

	public RequestAdapter_000400<R, SR> setUpLeastAmt(String upLeastAmt) {
		this.upLeastAmt = upLeastAmt;
		return this;
	}

	public RequestAdapter_000400<R, SR> setUpLeastMoney(String upLeastMoney) {
		this.upLeastMoney = upLeastMoney;
		return this;
	}

	/**
	 * 对400交易上传的信息进行校验
	 */
	@Override
	protected void checkBeforeSend() throws RequestBuildingException {

		super.checkBeforeSend();

		if (StringUtils.isEmpty(getUpAccountNo()) || getUpAccountNo().length() > 22) {
			throw new RequestBuildingException("产生CSP交易400请求Bean时异常,账号[upAccountNo]字段必填,且最大长度为22,当前值为:" + getUpAccountNo());
		}

		if (StringUtils.isNotEmpty(getUpCurrencyNo()) && getUpCurrencyNo().length() > 3) {
			throw new IllegalArgumentException("产生CSP交易400请求Bean时异常,币别[upCurrencyNo]长度不能超过3位,当前值为:" + getUpCurrencyNo());
		}

		if (StringUtils.isEmpty(getUpQueryOption()) || (!"1".equals(getUpQueryOption()) && !"6".equals(getUpQueryOption()))) {
			throw new IllegalArgumentException("产生CSP交易400请求Bean时异常,查询选项[upQueryOption]不能为空,且只能为1或者6,当前值为:" + getUpQueryOption());
		}

		if (StringUtils.isNotEmpty(getUpCashFlag()) && getUpCashFlag().length() != 1) {
			throw new IllegalArgumentException("产生CSP交易400请求Bean时异常,钞汇[upCashFlag]如果有上送,则该该字段长度不能超过1位,当前值为:" + getUpCashFlag());
		}

		if (StringUtils.isNotEmpty(getUpBookNo()) && getUpBookNo().length() > 3) {
			throw new RequestBuildingException("产生CSP交易400请求Bean时异常,定一本册号[upBookNo]如果有上送,则该字段最大长度为3,当前值为:" + getUpBookNo());
		}

		if (StringUtils.isNotEmpty(getUpSheetNo()) && getUpSheetNo().length() > 2) {
			throw new RequestBuildingException("产生CSP交易400请求Bean时异常,定一本序号[upSheetNo]如果有上送,则该字段最大长度为2,当前值为:" + getUpSheetNo());
		}

		if (StringUtils.isNotEmpty(getUpLeastAmt()) && getUpLeastAmt().length() > 1) {
			throw new IllegalArgumentException("产生CSP交易440请求Bean时异常,每月最低清算余额查询[upLeastAmt]如果有上送,则最大长度为1位,当前值为" + getUpLeastAmt());
		}

		if (StringUtils.isNotEmpty(getUpLeastMoney()) && getUpLeastMoney().length() > 1) {
			throw new IllegalArgumentException("产生CSP交易440请求Bean时异常,每月最低清算余额查询[upLeastMoney]如果有上送,则最大长度为1位,当前值为" + getUpLeastMoney());
		}

		// 币种和钞汇要么同时输入,要么都不要输入(异或关系)
		if (StringUtils.isEmpty(getUpCurrencyNo()) ^ StringUtils.isEmpty(getUpCashFlag())) {
			throw new RequestBuildingException("币种和钞汇要么同时输入,要么都不要输入");
		}

	}

}
