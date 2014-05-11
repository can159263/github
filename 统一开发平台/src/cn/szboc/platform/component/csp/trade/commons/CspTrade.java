package cn.szboc.platform.component.csp.trade.commons;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.szboc.platform.component.csp.exception.BeforeCspTradeSendException;
import cn.szboc.platform.component.csp.exception.CspTradeException;
import cn.szboc.platform.component.csp.exception.CspTradeNotSureExecption;
import cn.szboc.platform.component.csp.exception.CspTradeSendingException;
import cn.szboc.platform.component.csp.exception.CspTradeSureFailureExecption;
import cn.szboc.platform.component.csp.exception.ParseCspResultBeanException;
import cn.szboc.platform.component.csp.requestbuilder.CommonRequest;
import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.csp.trade.commons.response.CspTradeResult;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;
import cn.szboc.platform.component.ctg.ICtgMessageSend;
import cn.szboc.platform.component.msgbean.MessageBeanCotext;

/**
 * 所有CSP交易抽象基类 代表了一支交易的发出与接收
 */
public class CspTrade {

	/** CSP晚上标准长度 */
	private final int stdLength = 300;
	
	/**
	 * CSP交易成功返回码
	 */
	protected final String CSP_SUCCESS_RTN_CODE = "0000";
	
	/**
	 * CSP交易成功返回码
	 */
	protected final byte[] CSP_SUCCESS_RTN_CODE_IN_BYTES = "0000".getBytes();
	
	/**
	 * CSP交易特殊交易码,都是成功失败均只返回300字节的交易
	 */
	protected final Set<String> CSP_SPECIAL_TRADE_CODE = new HashSet<String>();
	
	{
		CSP_SPECIAL_TRADE_CODE.add("001110"); // 1010现金－客户账 冲正 交易接口
		CSP_SPECIAL_TRADE_CODE.add("001130"); // 1030无折存款贷记交易 冲正 交易接口
		CSP_SPECIAL_TRADE_CODE.add("001145"); // 1045客户帐转客户帐 冲正 交易接口
		CSP_SPECIAL_TRADE_CODE.add("001155"); // 1045客户帐转客户帐冲正（外币兑换） 交易接口
		CSP_SPECIAL_TRADE_CODE.add("001150"); // 1050无折存款借记 冲正 交易接口
		CSP_SPECIAL_TRADE_CODE.add("C01150"); // 1050无折存款借记 冲正（新增对手信息） 交易接口
		CSP_SPECIAL_TRADE_CODE.add("020130"); // 20030内部账户贷记过账 冲正 交易接口
		CSP_SPECIAL_TRADE_CODE.add("020145"); // 20045资金转账 冲正 交易接口
		CSP_SPECIAL_TRADE_CODE.add("120145"); // 20045资金转账冲正（外币兑换） 交易接口
		CSP_SPECIAL_TRADE_CODE.add("020150"); // 20050内部账户借记过账 冲正 交易接口
		CSP_SPECIAL_TRADE_CODE.add("020160"); // 20060现金付款 冲正 交易接口
		CSP_SPECIAL_TRADE_CODE.add("021110"); // 21010现金－bgl 冲正 交易接口
		CSP_SPECIAL_TRADE_CODE.add("021131"); // 21031无折存款转内部账户 冲正 交易接口
		CSP_SPECIAL_TRADE_CODE.add("C21131"); // 21031无折存款转内部账户 冲正（新增对手信息） 交易接口
		CSP_SPECIAL_TRADE_CODE.add("121131"); // 21031无折存款转内部账户冲正（外币兑换） 交易接口
		CSP_SPECIAL_TRADE_CODE.add("021151"); // 21051无折内部账户转存款账户 冲正 交易接口
		CSP_SPECIAL_TRADE_CODE.add("C21151"); // 21051无折内部账户转存款账户 冲正（新增对手信息） 交易接口
		CSP_SPECIAL_TRADE_CODE.add("121151"); // 21051无折内部账户转存款账户冲正（外币兑换） 交易接口
		CSP_SPECIAL_TRADE_CODE.add("056148"); // 56148系统内客户(非存折户)转帐汇款冲正 交易接口
	}

	/**
	 * CSP依赖的底层CTG使用字符集编码
	 */
	private static Charset cs = Charset.forName("GB18030");

	/**
	 * 日志组件,用于打印CTG即时通信日志
	 */
	private static Logger logger = LoggerFactory.getLogger(CspTrade.class);

	/**
	 * CTG发报器
	 */
	private ICtgMessageSend ctgMessageSender;

	/**
	 * 转换上下文
	 */
	private MessageBeanCotext mbCtx;

	/**
	 * 唯一构造函数
	 * 
	 * @param mbCtx
	 *            底层发报前,bean与byte[]转换的组件
	 * @param ctgMessageSender
	 *            底层发报组件
	 */
	public CspTrade(MessageBeanCotext mbCtx, ICtgMessageSend ctgMessageSender) {

		if (mbCtx == null) {
			throw new IllegalArgumentException("参数mbCtx不能为空");
		}
		if (ctgMessageSender == null) {
			throw new IllegalArgumentException("参数ctgMessageSender不能为空");
		}

		this.mbCtx = mbCtx;
		this.ctgMessageSender = ctgMessageSender;
	}

	/**
	 * CSP交易执行入口
	 * 
	 * @param requestBean
	 * @return
	 */
	public <R extends CommonResponse> ExecuteResponse<R> doTrade(CommonRequest<?, ?> requestBean, Class<R> clazz) {

		ExecuteResponse<R> response = null;

		try {

			if (requestBean == null) {
				throw new CspTradeSureFailureExecption("参数requestBean不允许为null!");
			}
			if (clazz == null) {
				throw new CspTradeSureFailureExecption("参数clazz不允许为null!");
			}

			// 内部发送并对返回信息进行解析
			R responseBean = send(requestBean, clazz);

			if (responseBean == null) {
				throw new CspTradeNotSureExecption("探测到异常情况:从MessageBeanContext中解析出来的结果bean为null");
			}

			// 正常返回后,区分交易成功还是失败
			if (CSP_SUCCESS_RTN_CODE.equals(responseBean.getCommonReturnCode())) {
				// 成功返回码,对应设置成功返回bean
				response = new ExecuteResponse<R>(CspTradeResult.TRADE_SUCCESS, responseBean);
			} else {
				// 失败返回码,对应设置失败返回bean
				response = new ExecuteResponse<R>(CspTradeResult.TRADE_FAILURE, responseBean);
			}

		} catch (CspTradeSureFailureExecption e) {

			logger.error("处理CSP交易明确失败", e);
			logger.error("引起上述异常的请求bean具体信息为{}", requestBean);

			response = new ExecuteResponse<R>(CspTradeResult.EXCEPTION_BEFORE_SEND, e);

		} catch (Throwable t) {

			logger.error("处理CSP交易异常,未能明确确认具体结果,需要系统自查或者维护人员进行处理", t);
			logger.error("引起上述异常的请求bean具体信息为{}", requestBean);

			response = new ExecuteResponse<R>(CspTradeResult.EXCEPTION_AFTER_SEND, t);
		}

		// 设置成功
		return response;
	}

	/**
	 * 内部对返回信息进行解释,形成返回bean
	 * 
	 * @param requestBean
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	private <R extends CommonResponse> R send(CommonRequest<?, ?> requestBean, Class<R> clazz) throws CspTradeException {

		// 准备发送的字节数据
		byte[] sendData = null;

		try {
			sendData = mbCtx.marshal(requestBean);
			logger.info("CTG发送信息:{}", new String(sendData), cs);
		} catch (Exception e) {
			throw new BeforeCspTradeSendException("CSP发送bean组装bean时失败", e);
		}

		byte[] recvData = null;

		try {
			recvData = ctgMessageSender.execute(sendData);
			if (recvData == null) {
				throw new Exception("CSP底层通信组件返回的响应字节数组为非法null值");
			}
			logger.info("CTG返回信息:{}", new String(recvData, cs));
		} catch (Exception e) {
			throw new CspTradeSendingException("CSP底层通信交互失败", e);
		}

		// 如果是300长度,则代表交易失败,按照CommonTradeBean格式进行解析
		R responseBean = null;
		try {
			// 长度不够,直接抛异常
			if(recvData.length < stdLength){
				throw new ParseCspResultBeanException("CSP返回字节信息数组长度" + recvData.length + "小于标准长度" + stdLength + ", 视为非法");
			}
			// 如果长度大于300字节,则代表交易成功,按照预定义class严格进行转换
			if (recvData.length > 300) {
				responseBean = mbCtx.unMarshal(recvData, clazz, true);
			} else {
				// 如果长度正好是300字节,那么要区分是否是特殊交易
				String tradeCode = new String(Arrays.copyOfRange(recvData, 0, 6));
				// 如果交易码是特殊交易码,判断不出是成功还是失败, 都要进行严格转换
				if(CSP_SPECIAL_TRADE_CODE.contains(tradeCode)){
					responseBean = mbCtx.unMarshal(recvData, clazz, true);
				} else {
					// 如果不是特殊交易码,就代表交易失败了,还要判断返回码是否是0000
					byte[] rtnCodeBytes = Arrays.copyOfRange(recvData, 93, 97);
					// 如果是0000,则判定本次交易异常
					if(Arrays.equals(CSP_SUCCESS_RTN_CODE_IN_BYTES, rtnCodeBytes)){
						throw new ParseCspResultBeanException("CSP返回字节数组信息结果标志为成功,但只返回300字节,CSP交易码是:" + tradeCode);
					}
					// 用宽松默认解析,只解析报文头,报文体部分都是默认值,不进行填充
					responseBean = mbCtx.unMarshal(recvData, clazz, false);
				}
			}
		} catch (Exception e) {
			throw new ParseCspResultBeanException("解析CSP响应字节到bean时出现异常", e);
		}

		return responseBean;
	}

}
