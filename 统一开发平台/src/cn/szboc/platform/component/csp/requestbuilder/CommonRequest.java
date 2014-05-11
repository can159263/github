package cn.szboc.platform.component.csp.requestbuilder;

import org.apache.commons.lang3.StringUtils;

import cn.szboc.platform.commons.DateUtils;
import cn.szboc.platform.component.csp.exception.CspTradeException;
import cn.szboc.platform.component.csp.exception.QueryResultException;
import cn.szboc.platform.component.csp.exception.QueryResultFailureException;
import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.trade.commons.CspTrade;
import cn.szboc.platform.component.csp.trade.commons.CspTradeCommonBean;
import cn.szboc.platform.component.csp.trade.commons.CspTradeCommonField;
import cn.szboc.platform.component.csp.trade.commons.TradeCode;
import cn.szboc.platform.component.csp.trade.commons.TradeStatus;
import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.csp.trade.commons.response.CspTradeResult;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.csp.trade.trade_097511.response.StandardResponseBean_097511;
import cn.szboc.platform.component.ctg.ICtgMessageSend;
import cn.szboc.platform.component.msgbean.MessageBeanCotext;

/**
 * CSP通用查询请求 T代表要上送的通用数据结构,是个抽象的Adapter,每支交易都应该有这样一个请求bean适配器
 * 
 * R代表要下载的通用数据结构,是个抽象的Adapter,每支交易都应该有这样一个或多个响应bean适配器
 * SR表示Standard Response,是默认的响应Bean类型
 */
public abstract class CommonRequest<R extends CommonResponse, SR extends R> extends CspTradeCommonBean {

	protected boolean sended = false;
	protected boolean builded = false;

	protected CspTransactionRequestBuilderFactory factory;

	protected ExecuteResponse<? extends R> responseBean;

	public ExecuteResponse<? extends R> getResponseBean() {
		return responseBean;
	}

	protected void setCspTransactionRequestBuilderFactory(CspTransactionRequestBuilderFactory factory) {
		if (factory == null) {
			throw new IllegalArgumentException("CspTransactionRequestBuilderFactory不能为空");
		}
		this.factory = factory;
		this.ctgMessageSender = factory.getCtgMessageSender();
		if (this.ctgMessageSender == null) {
			throw new IllegalArgumentException("CspTransactionRequestBuilderFactory.ICtgMessageSend不能为空");
		}
		this.mbCtx = factory.getMbCtx();
		if (this.mbCtx == null) {
			throw new IllegalArgumentException("CspTransactionRequestBuilderFactory.MessageBeanCotext不能为空");
		}
	}

	/**
	 * CTG报文发射器
	 */
	private ICtgMessageSend ctgMessageSender;

	/**
	 * MessageBean映射器
	 */
	private MessageBeanCotext mbCtx;

	/**
	 * 默认响应bean的类
	 */
	private Class<SR> responseBeanClazz;

	protected void setResponseBeanClazz(Class<SR> responseBeanClazz) {
		this.responseBeanClazz = responseBeanClazz;
	}

	/**
	 * 由具体的交易子类实现,返回对应的交易码
	 * 
	 * @return 交易码
	 */
	protected abstract TradeCode withTradeCode();

	/**
	 * 构造前进行校验,子类可覆盖该方法进行自己特定字段,逻辑的检查
	 * 
	 * @throws Exception
	 */
	protected void checkBeforeSend() throws RequestBuildingException {

		if (sended) {
			throw new RequestBuildingException("本支交易已经发送过,不允许再次发送本交易,请重新创建一支交易进行发送");
		}

		if (withTradeCode() == null) {
			throw new RequestBuildingException("必须返回有效的交易码");
		}

		this.setCommonTradeCode(withTradeCode().getCode());

		// 对必须输入的几个通用上传字段进行校验
		String commonTradeCode = this.getCommonTradeCode();
		String commonBranchNo = this.getCommonBranchNo();
		String commonTerminalNo = this.getCommonTerminalNo();
		String commonWorkstationNo = this.getCommonWorkstationNo();
		String commonOperator = this.getCommonOperator();
		String commonProductCode = this.getCommonProductCode();
		String commonSystemDate = this.getCommonSystemDate();
		String commonSystemTime = this.getCommonSystemTime();

		// 设置系统当前日期和时间,如果外层调用没有设置,则默认设置当前系统日期和时间
		if (StringUtils.isEmpty(commonSystemDate)) {
			commonSystemDate = DateUtils.getDateStrNO();
			this.setCommonSystemDate(commonSystemDate);
		}
		if (StringUtils.isEmpty(commonSystemTime)) {
			commonSystemTime = DateUtils.getTimeStrNo();
			this.setCommonSystemTime(commonSystemTime);
		}

		// 对报文头的常规字段进行检验
		if (StringUtils.isEmpty(commonTradeCode) || commonTradeCode.length() != 6) {
			throw new RequestBuildingException("交易码[commonTradeCode]不能为空,且长度必须为6位,传入值为:" + commonTradeCode);
		}

		if (StringUtils.isEmpty(commonBranchNo) || commonBranchNo.length() > 5) {
			throw new RequestBuildingException("机构号[commonBranchNo]不能为空且长度不能大于5,传入值为:" + commonBranchNo);
		}

		if (StringUtils.isNotEmpty(commonTerminalNo) && commonTerminalNo.length() > 6) {
			throw new RequestBuildingException("终端号[commonTerminalNo]如果有上送,则该字段长度不能大于6,传入值为:" + commonTerminalNo);
		}

		if (StringUtils.isNotEmpty(commonWorkstationNo) && commonWorkstationNo.length() > 3) {
			throw new RequestBuildingException("工作站号[commonWorkstationNo]如果有上送,则该字段长度不能大于3,传入值为:" + commonWorkstationNo);
		}

		if (StringUtils.isEmpty(commonOperator) || commonOperator.length() > 7) {
			throw new RequestBuildingException("柜员号[commonOperator]不能为空且长度不能大于7,传入值为:" + commonOperator);
		}

		if (StringUtils.isNotEmpty(commonProductCode) && commonProductCode.length() > 20) {
			throw new RequestBuildingException("产品码[commonProductCode]如果有上送,则该字段长度不能大于20,传入值为:" + commonProductCode);
		}

		if (StringUtils.isEmpty(commonSystemDate) || commonSystemDate.length() > 8) {
			throw new RequestBuildingException("外围系统日期[commonSystemDate]不能为空且长度不能大于8,传入值为:" + commonSystemDate);
		}

		if (StringUtils.isEmpty(commonSystemTime) || commonSystemTime.length() > 6) {
			throw new RequestBuildingException("外围系统日期[commonSystemTime]不能为空且长度不能大于6,传入值为:" + commonSystemTime);
		}

		// 开始检查交易类的报文的外围系统交易流水号有无填充好
		switch (withTradeCode()) {
			case TRADE_001045:
			case TRADE_056048:
				checkTransNo();
		}
	}

	/**
	 * 对于账务性的交易,要检查外围交易序号和子序号
	 * 
	 * @throws RequestBuildingException
	 */
	public final void checkTransNo() throws RequestBuildingException {
		String transNo = this.getCommonTransNo();
		if (StringUtils.isEmpty(transNo) || transNo.length() > 30) {
			throw new RequestBuildingException("外围交易序号[commonTransNo]不能为空且长度不能大于30");
		}
		String subStransNo = this.getCommonSubTransNo();
		if (mustCheckSubTransNo() && StringUtils.isEmpty(subStransNo)) {
			throw new RequestBuildingException("外围交易子序号[commonSubTransNo]不能为空");
		}
		if (StringUtils.isNotEmpty(subStransNo) && subStransNo.length() > 2) {
			throw new RequestBuildingException("外围交易子序号[commonSubTransNo]如果有上送,则该字段长度不能大于2");
		}
	}

	/**
	 * 交易子序号是否必填,如果有子类交易必输该项,则需要覆盖该方法并返回true
	 * 
	 * @return 默认非必填
	 */
	protected boolean mustCheckSubTransNo() {
		return false;
	};

	/**
	 * 只允许对其中几个头部字段进行设置,对其它应该由CSP端返回的信息禁止设置
	 * 
	 * @param field
	 *            对应的头部enum
	 * @param fieldValue
	 *            头部字段的值
	 * @return 返回调用的自身引用
	 */
	public final CommonRequest<R, SR> setCommonFiled(CspTradeCommonField field, String fieldValue) {

		if (builded) {
			throw new IllegalArgumentException("CSP请求Bean编译过后,不允许进行任何字段的修改");
		}

		// 按照约定进行头部公共信息块的定义
		switch (field) {
			case TRADE_CODE:
				this.setCommonTradeCode(fieldValue);
				break;
			case BRANCH_NO:
				this.setCommonBranchNo(fieldValue);
				break;
			case TERMINAL_NO:
				this.setCommonTerminalNo(fieldValue);
				break;
			case WORKSTATION_NO:
				this.setCommonWorkstationNo(fieldValue);
				break;
			case OPERATOR:
				this.setCommonOperator(fieldValue);
				break;
			case PRODUCT_CODE:
				this.setCommonProductCode(fieldValue);
				break;
			case SYSTEM_DATE:
				this.setCommonSystemDate(fieldValue);
				break;
			case SYSTEM_TIME:
				this.setCommonSystemTime(fieldValue);
				break;
			case TRANS_NO:
				this.setCommonTransNo(fieldValue);
				break;
			case SUB_TRANS_NO:
				this.setCommonSubTransNo(fieldValue);
				break;
			case RESERVED_PROPERTY:
				this.setCommonReservedProperty(fieldValue);
				break;
			default:
				throw new IllegalArgumentException("非法的头部上送字段设置,CspTradeCommonField=" + field + ",value=" + fieldValue);
		}

		return this;
	}

	/**
	 * send之前可选的调用该方法进行显示验证参数合法性
	 */
	public CommonRequest<R, SR> build() {
		try {
			this.checkBeforeSend();
			builded = true;
		} catch (RequestBuildingException e) {
			throw new IllegalArgumentException("编译时发现请求bean参数异常", e);
		}
		return this;
	}

	/**
	 * 对其内部引用的request对象进行发送 使用泛型支持客户端调用时指定自定义接收bean
	 * 
	 * @param clazz
	 * @return
	 * @throws RequestBuildingException
	 * @throws CspTradeException
	 */
	public <X extends R> ExecuteResponse<X> send(Class<X> clazz) {

		if (!builded) {
			Exception e = new Exception("发送前必须调用build方法进行编译");
			ExecuteResponse<X> rtn = new ExecuteResponse<X>(CspTradeResult.EXCEPTION_BEFORE_SEND, e);
			return rtn;
		}

		// 新创建一条交易
		CspTrade trade = new CspTrade(mbCtx, ctgMessageSender);

		ExecuteResponse<X> rtn = trade.doTrade(this, clazz);

		// 设置已经发送过
		this.sended = true;

		// 设置响应Bean
		responseBean = rtn;

		// 如果自己是个账务类交易,则进行
		if (this.isAccountOperationTrade()) {
			// 如果当前开启了事务,则进行标记
			if (factory.isInTransaction()) {
				factory.markTrade(this);
			}
		}

		return rtn;
	}

	public ExecuteResponse<SR> send() {
		return this.send(responseBeanClazz);
	}

	/**
	 * 是否是账务操作类交易
	 */
	public boolean isAccountOperationTrade() {
		return false;
	}

	/**
	 * 查询交易结果
	 */
	public TradeStatus queryRequestResult() throws Exception {

		// 不支持查询,则抛出异常
		if (!isAccountOperationTrade()) {
			throw new IllegalAccessError("非账务类交易禁止使用联机查询!");
		}

		ExecuteResponse<StandardResponseBean_097511> result = null;
		result = factory.newRequestBuilder_097511().newRequest(this.getCommonBranchNo(), this.getCommonOperator())
				.setUpTransDate(this.getCommonSystemDate()).setUpSystemTransNo(this.getCommonTransNo()).send();

		// 查询异常
		if (result.isTradeException()) {
			throw new QueryResultException("查询CSP交易异常[" + result.getResult() + "],外围系统日期为" + this.getCommonSystemDate() + ",外围系统流水号是"
					+ this.getCommonTransNo(), result.getThrowable());
		}

		// 查询失败的
		if (result.isTradeFailure()) {
			throw new QueryResultFailureException("查询CSP交易异常,外围系统日期为" + this.getCommonSystemDate() + ",外围系统流水号是" + this.getCommonTransNo(),
					result.getThrowable());
		}

		// 剩下的是查询成功的
		StandardResponseBean_097511 responseBean = result.getTradeResultBean();
		String status = responseBean.getDownTransStatus();
		return TradeStatus._valueOf(status);

	}

	/**
	 * 进行冲正
	 * @return 是否有冲正
	 * 			true 有冲正行为, false 无须发送冲正报文
	 * @throws Exception
	 */
	public boolean rollback() throws Exception {
		// 不支持查询,则抛出异常
		if (!isAccountOperationTrade()) {
			throw new Exception("非账务类交易禁止使用冲正操作!");
		}
		return false;
	}

}
