package cn.szboc.platform.component.csp.exception;

/**
 * CSP交易发生时,或者发生后出现的异常,CSP交易通用上抛异常,拦截此异常,可拦截即可所有checked异常,但还要注意一些空指针,异常参数等运行时异常的拦截
 */
public abstract class CspTradeException extends Exception{

	private static final long serialVersionUID = 1L;

	public CspTradeException() {
		super();
	}

	public CspTradeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CspTradeException(String message) {
		super(message);
	}

	public CspTradeException(Throwable cause) {
		super(cause);
	}

}
