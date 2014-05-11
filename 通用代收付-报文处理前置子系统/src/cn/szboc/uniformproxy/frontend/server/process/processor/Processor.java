package cn.szboc.uniformproxy.frontend.server.process.processor;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.remoting.RemoteConnectFailureException;

import cn.szboc.platform.commons.DateUtils;
import cn.szboc.uniformproxy.frontend.server.process.processor.bean.MessageBeanInfo;
import cn.szboc.uniformproxy.frontend.server.process.processor.service.MessgeService;
import cn.szboc.uniformproxy.frontend.system.SYS;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.ObjectFactory;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TREQUESTHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESULTCODE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

/**
 * 报文抽象处理器的基类
 */
public abstract class Processor {

	private static Logger _logger = LoggerFactory.getLogger(Processor.class);

	/** JAXB默认报文工厂  */
	public final static ObjectFactory of = new ObjectFactory();

	/** 报文服务层 */
	private MessgeService messgeService;

	@Autowired
	@Qualifier("messgeService")
	public void setMessgeService(MessgeService messgeService) {
		this.messgeService = messgeService;
	}

	/**
	 * 交易的通用处理流程
	 * 
	 * @param request 请求bean
	 * @param recvFilePath 报文接收地址
	 * @return
	 * @throws Exception
	 */
	public CommonResponseMessage commonProcess(CommonRequestMessage request, String recvFilePath) throws Exception {

		// 调用子类创建相应的默认响应Bean
		CommonResponseMessage response = this.getDefaultResposne();

		// 分别拿到请求头和响应头信息
		TREQUESTHEAD reqHead = request.getHEAD();
		TRESPONSEHEAD responseHead = response.getHEAD();

		// 1_报文头要素校验 
		if (this.checkMsgHeadElement(reqHead, responseHead)) {
			return response;
		}

		// 2_校验通过后,存储在报文表中
		if (this.logRequestMsg(request, responseHead, recvFilePath)) {
			return response;
		}

		// 3_获取交易类型,处理交易时间窗口
		if (checkMsgControl(request, responseHead)) {
			return response;
		}

		// 4_调用子类的具体请求参数校验
		if (checkRequestElement(request, responseHead)) {
			return response;
		}

		// 5_调用子类的具体交易实现
		try {
			return this.process(request);
		} catch(RemoteConnectFailureException e){
			// 如果连接不到后台服务,那么会进入此catch块
			_logger.error("报文未处理, 远程服务不可用");
			CommonResponseMessage pureResponse = this.getDefaultResposne();
			responseHead = pureResponse.getHEAD();
			responseHead.setRESULTCODE(TRESULTCODE.SERVICE_NOT_AVALIABLE);
			responseHead.setRESULTDESC("后台服务暂时不可用");
			return pureResponse;
		} catch (Throwable t) {
			// 若子类处理异常,则需要new出默认的响应bean并设置相关报文头字段
			_logger.error("报文处理异常,组装默认响应bean并返回银行内部错误标识", t);
			CommonResponseMessage pureResponse = this.getDefaultResposne();
			responseHead = pureResponse.getHEAD();
			responseHead.setRESULTCODE(TRESULTCODE.BANK_EXCEPTION);
			responseHead.setRESULTDESC("银行内部错误");
			return pureResponse;
		}

	}

	public abstract CommonResponseMessage process(CommonRequestMessage request) throws Exception;

	/**
	 * 将请求Bean持久化
	 * @param requestBean
	 * @param info
	 * @throws Exception
	 */
	public void logRequest(MessageBeanInfo bean) throws Exception {

		if (bean == null) {
			throw new IllegalArgumentException("报文信bean不能为空");
		}

		this.messgeService.insertMessageBean(bean);
	}

	/**
	 * 报文交易时间控制
	 * 
	 * @param requestBean
	 * @return true表示交易已经处理完毕,可以返回给外围系统了
	 */
	private boolean checkMsgControl(CommonRequestMessage requestBean, TRESPONSEHEAD respHead) {

		// 系统别
		String systemCode = requestBean.getHEAD().getSYSCODE();

		// 交易码
		String transCode = requestBean.getTransType().value();

		try {
			Boolean result = this.messgeService.checkMsgControl(systemCode, transCode);
			if (result == null) {
				_logger.error("查找不到关于系统别{}与交易码{}的通道控制信息,请维护", new Object[] { systemCode, transCode });
				throw new Exception("未维护通道控制信息");
			} else if (result) {
				return false;
			} else {
				respHead.setRESULTCODE(TRESULTCODE.CHANNEL_CLOSED);
				respHead.setRESULTDESC("交易通道已关闭");
				return true;
			}
		} catch (Exception e) {
			_logger.error("银行内部检测交易通道开启时发生异常", e);
			respHead.setRESULTCODE(TRESULTCODE.BANK_EXCEPTION);
			respHead.setRESULTDESC("银行内部检测交易通道开启时发生异常");
			return true;
		}

	}

	/** 获取默认响应Bean */
	protected abstract CommonResponseMessage getDefaultResposne();

	/**
	 * 将响应Bean持久化
	 * @param responseBean
	 * @param info
	 * @throws Exception
	 */
	public void logResponse(MessageBeanInfo bean) throws Exception {
		this.messgeService.updateMessageBean(bean);
	}

	/** 调用子类的具体参数验证 */
	private boolean checkRequestElement(CommonRequestMessage request, TRESPONSEHEAD responseHead) {
		try {
			this.checkRequestElement(request);
			return false;
		} catch (IllegalArgumentException e) {
			responseHead.setRESULTCODE(TRESULTCODE.ELEMENT_ERROR);
			responseHead.setRESULTDESC("报文请求要素错误," + e.getMessage());
			return true;
		} catch (Exception e) {
			_logger.error("子类具体报文体要素校验时发生异常", e);
			responseHead.setRESULTCODE(TRESULTCODE.TRANSACTION_FAILURE);
			responseHead.setRESULTDESC("具体报文体要素校验时发生异常");
			return true;
		}
	}

	/** 各交易子类通过实现该类进行子类特定要素(位于报文体)的检测 */
	protected void checkRequestElement(CommonRequestMessage request) throws Exception {
		// 父类无法校验子类报文体要素,该步骤交由子类自己实现
	};

	/** 验证报文头交易要素,返回true表示交易已经处理完毕,可以提前返回 */
	private boolean checkMsgHeadElement(TREQUESTHEAD requestHead, TRESPONSEHEAD responseHead) throws Exception {

		try {
			// 获取报文头部的系统别, 校验系统别
			String msgSystemCode = requestHead.getSYSCODE();
			checkSystemCode(msgSystemCode);

			// 获取报文时间, 检测报文时间误差
			Date msgDate = requestHead.getSENDTIMESTAMP();
			checkMsgTime(msgDate);

			// 校验成功,返回false,表明后续需要继续处理
			return false;
		} catch (IllegalArgumentException e) {
			responseHead.setRESULTCODE(TRESULTCODE.ELEMENT_ERROR);
			responseHead.setRESULTDESC("报文要素错误," + e.getMessage());
			return true;
		} catch (Exception e) {
			_logger.error("报文头要素校验时发生异常", e);
			responseHead.setRESULTCODE(TRESULTCODE.TRANSACTION_FAILURE);
			responseHead.setRESULTDESC("银行内部异常,在报文头要素检查时发生");
			return true;
		}

	}

	/** 校验系统别 */
	private void checkSystemCode(String msgSystemCode) throws Exception {

		// 检查系统别
		if (!SYS.CODE.equals(msgSystemCode)) {
			_logger.error("报文头校验错误,系统别不匹配,期望是是{},报文传递的是{}", new Object[] { SYS.CODE, msgSystemCode });
			throw new IllegalArgumentException("非法系统别");
		}

	}

	/** 检测报文时间 */
	private void checkMsgTime(Date msgDateTime) throws Exception {

		// 获取当前时间
		Date nowDate = new Date();

		if(true){
			return;
		}
		
		// 误差控制在6小时之内
		if (Math.abs(msgDateTime.getTime() - nowDate.getTime()) > 1000L * 60L * 60L * 6L) {
			_logger.error("报文头校验错误,报文时间与前置系统时间差异过大,期望的时间范围为{}前后6小时,报文传递的是",
					new Object[] { DateUtils.getDateTimeStr(nowDate), DateUtils.getDateTimeStr(msgDateTime) });
			throw new IllegalArgumentException("报文时间超出误差范围,请矫正外围系统时间");
		}

	}

	/**
	 * 记录报文请求信息
	 */
	public boolean logRequestMsg(CommonRequestMessage request, TRESPONSEHEAD responseHead, String recvFilePath) throws Exception {

		TREQUESTHEAD head = request.getHEAD();

		// 记录请求信息,请求记录登记失败,则直接抛出异常,不会继续处理
		try {
			MessageBeanInfo msgBean = new MessageBeanInfo();

			msgBean.setSysCode(head.getSYSCODE());
			msgBean.setMsgType(request.getTransType().value());
			msgBean.setMsgId(head.getMSGID());
			msgBean.setRecvDatetime(new Date());
			msgBean.setRecvPath(recvFilePath);
			msgBean.setMsgRecvDatetime(head.getSENDTIMESTAMP());

			this.logRequest(msgBean);
		} catch (DataIntegrityViolationException e) {
			_logger.error("报文头信息记录时发生主键冲突,报文ID为", head.getMSGID());
			responseHead.setRESULTCODE(TRESULTCODE.ELEMENT_ERROR);
			responseHead.setRESULTDESC("报文ID重复发送,请更换MSG_ID字段");
			return true;
		} catch (Exception e) {
			_logger.error("报文登记异常, 处理信息为{}");
			_logger.error("报文登记异常堆栈打印", e);
			responseHead.setRESULTCODE(TRESULTCODE.BANK_EXCEPTION);
			responseHead.setRESULTDESC("银行方面报文入库异常,该报文支持重发");
			return true;
		}

		return false;
	}
}