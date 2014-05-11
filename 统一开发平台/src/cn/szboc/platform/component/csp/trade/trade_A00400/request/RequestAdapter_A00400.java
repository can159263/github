package cn.szboc.platform.component.csp.trade.trade_A00400.request;

import org.apache.commons.lang3.StringUtils;

import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.requestbuilder.CommonRequest;
import cn.szboc.platform.component.csp.trade.commons.TradeCode;
import cn.szboc.platform.component.csp.trade.trade_A00400.response.ResponseAdapter_A00400;

/**
 * 通用A00440请求交易格式
 */
public abstract class RequestAdapter_A00400<R extends ResponseAdapter_A00400, SR extends R> extends CommonRequest<R, SR> {

	@Override
	protected TradeCode withTradeCode() {
		return TradeCode.TRADE_A00400;
	}
	
	//===========================上送数据域(共8个栏位)=============================
    	/**	账号				*/	private String	upAccountNo;
    	/**	子帐户类别			*/	private String	upSubAccountType;
    	/**	查询选项			*/	private String	upQueryOption;
    	/**	省行代码			*/	private String	upProvinceCode;
    	/**	定一本册号			*/	private String	upBookNo;
    	/**	定一本序号			*/	private String	upSheetNo;
    	/**	每月最低清算余额查询	*/	private String	upLeastAmt;
    	/**	每月最低存折余额查询	*/	private String	upLeastMoney;
	//======================================================================

	public String getUpAccountNo() {
		return upAccountNo;
	}

	public String getUpSubAccountType() {
		return upSubAccountType;
	}

	public String getUpQueryOption() {
		return upQueryOption;
	}

	public String getUpProvinceCode() {
		return upProvinceCode;
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

	public RequestAdapter_A00400<R, SR> setUpAccountNo(String upAccountNo) {
		this.upAccountNo = upAccountNo;
		return this;
	}

	public RequestAdapter_A00400<R, SR> setUpSubAccountType(String upSubAccountType) {
		this.upSubAccountType = upSubAccountType;
		return this;
	}

	public RequestAdapter_A00400<R, SR> setUpQueryOption(String upQueryOption) {
		this.upQueryOption = upQueryOption;
		return this;
	}

	public RequestAdapter_A00400<R, SR> setUpProvinceCode(String upProvinceCode) {
		this.upProvinceCode = upProvinceCode;
		return this;
	}

	public RequestAdapter_A00400<R, SR> setUpBookNo(String upBookNo) {
		this.upBookNo = upBookNo;
		return this;
	}

	public RequestAdapter_A00400<R, SR> setUpSheetNo(String upSheetNo) {
		this.upSheetNo = upSheetNo;
		return this;
	}

	public RequestAdapter_A00400<R, SR> setUpLeastAmt(String upLeastAmt) {
		this.upLeastAmt = upLeastAmt;
		return this;
	}

	public RequestAdapter_A00400<R, SR> setUpLeastMoney(String upLeastMoney) {
		this.upLeastMoney = upLeastMoney;
		return this;
	}

	/**
	 * 对A00400交易上传的信息进行校验
	 */
	@Override
	protected void checkBeforeSend() throws RequestBuildingException {

		super.checkBeforeSend();

		if (StringUtils.isEmpty(this.getUpAccountNo()) || this.getUpAccountNo().length() > 22) {
			throw new RequestBuildingException("产生CSP交易A00400请求Bean时异常,账号[upAccountNo]字段必填,且最大长度为22,当前值为:" + this.getUpAccountNo());
		}

		if (StringUtils.isNotEmpty(this.getUpSubAccountType()) && this.getUpSubAccountType().length() > 4) {
			throw new IllegalArgumentException("产生CSP交易A00400请求Bean时异常,子账户类别[upSubAccountType]长度不能超过4位,当前值为:" + this.getUpSubAccountType());
		}

		if (StringUtils.isEmpty(this.getUpQueryOption()) || (!"1".equals(this.getUpQueryOption()) && !"6".equals(this.getUpQueryOption()))) {
			throw new IllegalArgumentException("产生CSP交易A00400请求Bean时异常,查询选项[upQueryOption]不能为空,且只能为1或者6,当前值为:" + this.getUpQueryOption());
		}

		if (StringUtils.isEmpty(this.getUpProvinceCode()) || this.getUpProvinceCode().length() > 2) {
			throw new IllegalArgumentException("产生CSP交易A00400请求Bean时异常,省行代码[upProvinceCode]不能为空,且该该字段长度不能超过2位,当前值为:" + this.getUpProvinceCode());
		}

		if (StringUtils.isNotEmpty(this.getUpBookNo()) && this.getUpBookNo().length() > 3) {
			throw new RequestBuildingException("产生CSP交易A00400请求Bean时异常,定一本册号[upBookNo]如果有上送,则该字段最大长度为3,当前值为:" + this.getUpBookNo());
		}

		if (StringUtils.isNotEmpty(this.getUpSheetNo()) && this.getUpSheetNo().length() > 2) {
			throw new RequestBuildingException("产生CSP交易A00400请求Bean时异常,定一本序号[upSheetNo]如果有上送,则该字段最大长度为2,当前值为:" + this.getUpSheetNo());
		}

		if (StringUtils.isNotEmpty(this.getUpLeastAmt()) && this.getUpLeastAmt().length() > 1) {
			throw new IllegalArgumentException("产生CSP交易A00440请求Bean时异常,每月最低清算余额查询[upLeastAmt]如果有上送,则最大长度为1位,当前值为" + this.getUpLeastAmt());
		}

		if (StringUtils.isNotEmpty(this.getUpLeastMoney()) && this.getUpLeastMoney().length() > 1) {
			throw new IllegalArgumentException("产生CSP交易A00440请求Bean时异常,每月最低清算余额查询[upLeastMoney]如果有上送,则最大长度为1位,当前值为" + this.getUpLeastMoney());
		}

	}

}
