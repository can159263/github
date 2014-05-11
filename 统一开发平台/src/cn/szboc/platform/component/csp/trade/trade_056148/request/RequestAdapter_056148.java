package cn.szboc.platform.component.csp.trade.trade_056148.request;

import java.math.BigDecimal;

import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.requestbuilder.CommonRequest;
import cn.szboc.platform.component.csp.trade.commons.TradeCode;
import cn.szboc.platform.component.csp.trade.trade_056148.response.ResponseAdapter_056148;
import cn.szboc.platform.component.csp.trade.trade_056148.response.StandardResponseBean_056148;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 对于056148交易的所有请求字段的GET方法的抽象
 * @author
 * 
 * @param <R>
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 508)
public abstract class RequestAdapter_056148 extends CommonRequest<ResponseAdapter_056148, StandardResponseBean_056148>
{
	// ===========================上送数据域(共10个栏位)=============================
	/** 扣款账号 */
	private String 		upAccountOut;
	/** 原汇款编号 */
	private String 		upChqNo;
	/** 兑换金额 */
	private BigDecimal 	upCusAmtStr;
	/** 兑换货币 */
	private String 		upPcCurrency;
	/** 汇款金额 */
	private BigDecimal 	upStrAmt;
	/** 汇款货币 */
	private String 		upCurrencyNo;
	/** 本币金额 */
	private BigDecimal 	upResultAmt;
	/** 汇率类型 01现钞 02现汇(非必输) */
	private String 		upRateTypeIn;
	/** 备注(非必输) */
	private String 		upStatNar;
	/** CSP流水号 */
	private String 		upRevsTraceNo;
	
	// ====================================getters & setters==================================
	@Override
	protected TradeCode withTradeCode()
	{
		return TradeCode.TRADE_056148;
	}
	
	public String getUpAccountOut()
	{
		return upAccountOut;
	}
	public String getUpChqNo()
	{
		return upChqNo;
	}
	public BigDecimal getUpCusAmtStr()
	{
		return upCusAmtStr;
	}
	public String getUpPcCurrency()
	{
		return upPcCurrency;
	}
	public BigDecimal getUpStrAmt()
	{
		return upStrAmt;
	}
	public String getUpCurrencyNo()
	{
		return upCurrencyNo;
	}
	public BigDecimal getUpResultAmt()
	{
		return upResultAmt;
	}
	public String getUpRateTypeIn()
	{
		return upRateTypeIn;
	}
	public String getUpStatNar()
	{
		return upStatNar;
	}
	public String getUpRevsTraceNo()
	{
		return upRevsTraceNo;
	}
	
	/**
	 * 栏位:19
	 * [必输]扣款账号
	 * @param upAccountOut
	 * @return
	 */
	public RequestAdapter_056148 setUpAccountOut(String upAccountOut)
	{
		this.upAccountOut = upAccountOut;
		return this;
	}
	
	/**
	 * 栏位:20
	 * [必输]原汇款编号
	 * @param upChqNo
	 * @return
	 */
	public RequestAdapter_056148 setUpChqNo(String upChqNo)
	{
		this.upChqNo = upChqNo;
		return this;
	}
	
	/**
	 * 栏位:21
	 * [必输]兑换金额
	 * @param upCusAmtStr
	 * @return
	 */
	public RequestAdapter_056148 setUpCusAmtStr(BigDecimal upCusAmtStr)
	{
		this.upCusAmtStr = upCusAmtStr;
		return this;
	}
	
	/**
	 * 栏位:22
	 * [必输]兑换货币
	 * @param upPcCurrency
	 * @return
	 */
	public RequestAdapter_056148 setUpPcCurrency(String upPcCurrency)
	{
		this.upPcCurrency = upPcCurrency;
		return this;
	}
	
	/**
	 * 栏位:23
	 * [必输]汇款金额
	 * @param upStrAmt
	 * @return
	 */
	public RequestAdapter_056148 setUpStrAmt(BigDecimal upStrAmt)
	{
		this.upStrAmt = upStrAmt;
		return this;
	}
	
	/**
	 * 栏位:24
	 * [必输]汇款货币
	 * @param upCurrencyNo
	 * @return
	 */
	public RequestAdapter_056148 setUpCurrencyNo(String upCurrencyNo)
	{
		this.upCurrencyNo = upCurrencyNo;
		return this;
	}
	
	/**
	 * 栏位:25
	 * [必输]本币金额
	 * @param upResultAmt
	 * @return
	 */
	public RequestAdapter_056148 setUpResultAmt(BigDecimal upResultAmt)
	{
		this.upResultAmt = upResultAmt;
		return this;
	}
	
	/**
	 * 栏位:26
	 * [非必输]汇率类型 01现钞 02现汇
	 * @param upRateTypeIn
	 * @return
	 */
	public RequestAdapter_056148 setUpRateTypeIn(String upRateTypeIn)
	{
		this.upRateTypeIn = upRateTypeIn;
		return this;
	}
	
	/**
	 * 栏位:27
	 * [非必输]备注
	 * @param upStatNar
	 * @return
	 */
	public RequestAdapter_056148 setUpStatNar(String upStatNar)
	{
		this.upStatNar = upStatNar;
		return this;
	}
	
	/**
	 * 栏位:28
	 * [必输]CSP流水号
	 * @param upRevsTraceNo
	 * @return
	 */
	public RequestAdapter_056148 setUpRevsTraceNo(String upRevsTraceNo)
	{
		this.upRevsTraceNo = upRevsTraceNo;
		return this;
	}
	
	@Override
	protected void checkBeforeSend() throws RequestBuildingException
	{
		super.checkBeforeSend();
	}
}