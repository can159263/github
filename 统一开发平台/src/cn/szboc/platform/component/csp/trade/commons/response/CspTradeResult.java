package cn.szboc.platform.component.csp.trade.commons.response;

/**
 * CSP交易的逻辑返回码 注意: 不是具体的CSP交易返回码,而是调用CSP接口方法的整个流程的返回码
 */
public enum CspTradeResult {

	/**
	 * 处理正常,交易成功,指CSP返回0000成功码
	 */
	TRADE_SUCCESS,

	/**
	 * 处理正常,交易失败,指CSP返回[非0000]响应码
	 */
	TRADE_FAILURE,

	/**
	 * 处理异常 该异常发生于交易发报前,此异常可明确失败 远程主机并未接收到请求
	 */
	EXCEPTION_BEFORE_SEND,

	/**
	 * 处理异常 该异常发生于CSP底层通信正在进行,或者通信返回后在后续的内部处理(例如解析)时
	 * 该状态不能断定远端主机交易的具体结果,有可能交易有接收并处理,有可能主机根本没收到 该状态需要后期调用其它交易进行结果查询
	 */
	EXCEPTION_AFTER_SEND;

	/**
	 * 判断该交易码代表的交易是否是交易正常完成,和isTradeException正好相反
	 * 
	 * @see CspTradeResult#isTradeException
	 */
	public boolean isTradeNormal() {
		switch (this) {
			case TRADE_SUCCESS:
			case TRADE_FAILURE:
				return true;
			default:
				return false;
		}
	}

	/**
	 * 判断该交易码代表的交易是否是发生了异常,和isTradeNormal正好相反
	 * 
	 * @see CspTradeResult#isTradeNormal
	 */
	public boolean isTradeException() {
		switch (this) {
			case EXCEPTION_BEFORE_SEND:
			case EXCEPTION_AFTER_SEND:
				return true;
			default:
				return false;
		}
	}

	/**
	 * 判断该交易码代表的交易是否成功
	 */
	public boolean isTradeSuccess() {
		switch (this) {
			case TRADE_SUCCESS:
				return true;
			default:
				return false;
		}
	}

	/**
	 * 判断该交易码代表的交易是否失败
	 */
	public boolean isTradeFailure() {
		switch (this) {
			case TRADE_FAILURE:
				return true;
			default:
				return false;
		}
	}

}
