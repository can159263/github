package cn.szboc.platform.component.csp.exception;

/**
 * CSP交易底层发送时出现的异常
 */
public class CspTradeSendingException extends CspTradeNotSureExecption {

	private static final long serialVersionUID = 1L;

	public CspTradeSendingException() {
		super();
	}

	public CspTradeSendingException(String message, Throwable cause) {
		super(message, cause);
	}

	public CspTradeSendingException(String message) {
		super(message);
	}

	public CspTradeSendingException(Throwable cause) {
		super(cause);
	}

}
