package cn.szboc.platform.component.csp.exception;

/**
 * 交易发送前抛出的异常
 */
public class BeforeCspTradeSendException extends CspTradeSureFailureExecption {

	private static final long serialVersionUID = 1L;

	public BeforeCspTradeSendException() {
		super();
	}

	public BeforeCspTradeSendException(String message, Throwable cause) {
		super(message, cause);
	}

	public BeforeCspTradeSendException(String message) {
		super(message);
	}

	public BeforeCspTradeSendException(Throwable cause) {
		super(cause);
	}

}
