package cn.szboc.platform.component.csp.trade.commons.response;

import cn.szboc.platform.component.csp.exception.CspTradeNotSureExecption;

/**
 * CSP交易响应结果返回结果包装类 所有CSP交易内部并不会抛出任何异常(包括运行期异常)
 * 所有CSP交易的调用方法都将会得到一个ExecuteResponse的实例
 * 所以CSP调用程序必须检查该返回实例中的result字段已确定具体的调用结果和内部可能发生的异常
 */
public class ExecuteResponse<T extends CommonResponse> {

	/**
	 * 交易正常返回的构造函数
	 * 
	 * @param result
	 *            交易的结果描述
	 * @param tradeResultBean
	 *            交易响应信息
	 * @throws CspTradeNotSureExecption
	 */
	public ExecuteResponse(CspTradeResult result, T tradeResultBean) {

		if (result == null) {
			throw new IllegalArgumentException("返回结果不能为空!");
		}

		if (!result.isTradeNormal()) {
			throw new IllegalArgumentException("本构造方法只允许在交易正常返回时进行填充");
		}

		// 处理正常时,其内部交易结果bean必须存在
		if (tradeResultBean == null) {
			throw new IllegalArgumentException("当CSP交易正常返回时,其内部交易结果bean不能为空!");
		}

		this.result = result;
		this.tradeResultBean = tradeResultBean;
	}

	/**
	 * 交易异常返回的构造函数
	 * 
	 * @param result
	 *            交易的结果描述
	 * @param throwable
	 *            交易的异常信息
	 * @throws CspTradeNotSureExecption
	 */
	public ExecuteResponse(CspTradeResult result, Throwable throwable) {

		// 返回码必填
		if (result == null) {
			throw new IllegalArgumentException("返回结果不能为空!");
		}

		if (!result.isTradeException()) {
			throw new IllegalArgumentException("本构造方法只允许在交易异常返回时进行填充");
		}

		// 处理异常时,必须填充具体异常信息
		if (throwable == null) {
			throw new IllegalArgumentException("当CSP交易异常返回时,必须附带其内部抛出的具体异常信息!");
		}

		this.result = result;
		this.throwable = throwable;
	}

	/**
	 * 执行结果,外部方法要先查看该属性以此判断交易的成功/失败/异常等情况
	 */
	private CspTradeResult result;

	/**
	 * 如果交易正常,则此域存放解析后的交易结果bean
	 */
	private T tradeResultBean;

	/**
	 * 如果交易异常,则此域存在具体的异常引用
	 */
	private Throwable throwable;

	public CspTradeResult getResult() {
		return result;
	}

	public T getTradeResultBean() {
		return tradeResultBean;
	}

	public void setResult(CspTradeResult result) {
		this.result = result;
	}

	public void setTradeResultBean(T tradeResultBean) {
		this.tradeResultBean = tradeResultBean;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
	
	/**
	 * 判断该交易码代表的交易是否是交易正常完成,和isTradeException正好相反
	 * 
	 * @see CspTradeResult#isTradeException
	 */
	public boolean isTradeNormal() {
		switch (this.result) {
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
		switch (this.result) {
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
		switch (this.result) {
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
		switch (this.result) {
			case TRADE_FAILURE:
				return true;
			default:
				return false;
		}
	}

}
