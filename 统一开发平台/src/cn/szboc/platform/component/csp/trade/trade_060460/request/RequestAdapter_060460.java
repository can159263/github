package cn.szboc.platform.component.csp.trade.trade_060460.request;

import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.requestbuilder.CommonRequest;
import cn.szboc.platform.component.csp.trade.commons.TradeCode;
import cn.szboc.platform.component.csp.trade.trade_060460.response.ResponseAdapter_060460;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 对于060460交易的所有请求字段的GET方法的抽象
 * @author
 * 
 * @param <R>
 */
@MessageBean(Target = To.TO_BYTES, ExpectedReadSize = 356)
public abstract class RequestAdapter_060460<R extends ResponseAdapter_060460, SR extends R> extends CommonRequest<R, SR>
{
	// ===========================上送数据域(共7个栏位)=============================
	/** 客户号/账号 */
	private String upALinkAccount;
	/** 客户类型 */
	private String upCusType;
	/** 客户/账号 */
	private String upStdDcFlag;
	/** 查询选项 */
	private String upStdQueryOption;
	/** 选项分区 */
	private String upStdProption;
	/** 证件号码 */
	private String upStdPassNo;
	/** 证件类型 */
	private String upStdPassType;
	
	// ====================================getters & setters==================================
	@Override
	protected TradeCode withTradeCode()
	{
		return TradeCode.TRADE_060460;
	}
	
	public String getUpALinkAccount()
	{
		return upALinkAccount;
	}
	public String getUpCusType()
	{
		return upCusType;
	}
	public String getUpStdDcFlag()
	{
		return upStdDcFlag;
	}
	public String getUpStdQueryOption()
	{
		return upStdQueryOption;
	}
	public String getUpStdProption()
	{
		return upStdProption;
	}
	public String getUpStdPassNo()
	{
		return upStdPassNo;
	}
	public String getUpStdPassType()
	{
		return upStdPassType;
	}
	
	/**
	 * 栏位:17
	 * [必输]客户号/账号
	 * @param upALinkAccount
	 * @return
	 */
	public RequestAdapter_060460<R, SR> setUpALinkAccount(String upALinkAccount)
	{
		this.upALinkAccount = upALinkAccount;
		return this;
	}
	
	/**
	 * 栏位:2
	 * [非必输]客户类型
	 * 01－个人客户 02－企业客户 03－金融机构客户 04－客户群
	 * 第21域(客户/账号)为“C－客户”时，此域必输
	 * @param upCusType
	 * @return
	 */
	public RequestAdapter_060460<R, SR> setUpCusType(String upCusType)
	{
		this.upCusType = upCusType;
		return this;
	}
	
	/**
	 * 栏位:1
	 * [必输]客户/账号
	 * @param upStdDcFlag
	 * @return
	 */
	public RequestAdapter_060460<R, SR> setUpStdDcFlag(String upStdDcFlag)
	{
		this.upStdDcFlag = upStdDcFlag;
		return this;
	}
	
	/**
	 * 栏位:1
	 * [必输]查询选项
	 * A－个人客户基本信息 B－企业客户基本信息
	 * @param upStdQueryOption
	 * @return
	 */
	public RequestAdapter_060460<R, SR> setUpStdQueryOption(String upStdQueryOption)
	{
		this.upStdQueryOption = upStdQueryOption;
		return this;
	}
	
	/**
	 * 栏位:23
	 * [非必输]选项分区
	 * 不涉及翻页，此域送空即可第一次查询时输入”E”, 翻页查询时输入”M”
	 * @param upStdProption
	 * @return
	 */
	public RequestAdapter_060460<R, SR> setUpStdProption(String upStdProption)
	{
		this.upStdProption = upStdProption;
		return this;
	}
	
	/**
	 * 栏位:2
	 * [非必输]证件号码
	 * @param upStdPassNo
	 * @return
	 */
	public RequestAdapter_060460<R, SR> setUpStdPassNo(String upStdPassNo)
	{
		this.upStdPassNo = upStdPassNo;
		return this;
	}
	
	/**
	 * 栏位:25
	 * [非必输]证件类型
	 * @param upStdPassType
	 * @return
	 */
	public RequestAdapter_060460<R, SR> setUpStdPassType(String upStdPassType)
	{
		this.upStdPassType = upStdPassType;
		return this;
	}
	
	@Override
	protected void checkBeforeSend() throws RequestBuildingException
	{
		super.checkBeforeSend();
	}
}