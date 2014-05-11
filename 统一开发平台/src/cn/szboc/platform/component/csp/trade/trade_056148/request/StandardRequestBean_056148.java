package cn.szboc.platform.component.csp.trade.trade_056148.request;

import java.math.BigDecimal;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.MessageGetEnhance;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;
import cn.szboc.platform.component.msgbean.interseptor.buildin.BigDecimalAdjust100TimesInterceptor;

/**
 * 
 * @author
 * 
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 508)
public class StandardRequestBean_056148 extends RequestAdapter_056148
{
	/**
	 * 扣款账号
	 */
	@Override
	@MessageField(startPos = 300, length = 18)
	public String getUpAccountOut()
	{
		return super.getUpAccountOut();
	}
	
	/**
	 * 原汇款编号
	 */
	@Override
	@MessageField(startPos = 318, length = 16)
	public String getUpChqNo()
	{
		return super.getUpChqNo();
	}
	
	/**
	 * 兑换金额
	 */
	@Override
	@MessageField(startPos = 334, length = 16, type = PadType.LEFT, material = 48)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public BigDecimal getUpCusAmtStr()
	{
		return super.getUpCusAmtStr();
	}
	
	/**
	 * 兑换货币
	 */
	@Override
	@MessageField(startPos = 350, length = 3)
	public String getUpPcCurrency()
	{
		return super.getUpPcCurrency();
	}
	
	/**
	 * 汇款金额
	 */
	@Override
	@MessageField(startPos = 353, length = 16, type = PadType.LEFT, material = 48)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public BigDecimal getUpStrAmt()
	{
		return super.getUpStrAmt();
	}
	
	/**
	 * 汇款货币
	 */
	@Override
	@MessageField(startPos = 369, length = 3)
	public String getUpCurrencyNo()
	{
		return super.getUpCurrencyNo();
	}
	
	/**
	 * 本币金额
	 */
	@Override
	@MessageField(startPos = 372, length = 16, type = PadType.LEFT, material = 48)
	@MessageGetEnhance(beforeGet = BigDecimalAdjust100TimesInterceptor.class)
	public BigDecimal getUpResultAmt()
	{
		return super.getUpResultAmt();
	}
	
	/**
	 * 汇率类型 01现钞 02现汇
	 */
	@Override
	@MessageField(startPos = 388, length = 2)
	public String getUpRateTypeIn()
	{
		return super.getUpRateTypeIn();
	}
	
	/**
	 * 备注
	 */
	@Override
	@MessageField(startPos = 390, length = 110)
	public String getUpStatNar()
	{
		return super.getUpStatNar();
	}
	
	/**
	 * CSP流水号
	 */
	@Override
	@MessageField(startPos = 500, length = 8)
	public String getUpRevsTraceNo()
	{
		return super.getUpRevsTraceNo();
	}
}