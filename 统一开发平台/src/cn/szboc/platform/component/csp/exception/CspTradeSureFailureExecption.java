package cn.szboc.platform.component.csp.exception;

/**
 * CSP交易明确失败的异常
 */
public class CspTradeSureFailureExecption extends CspTradeException {

	private static final long serialVersionUID = 1L;

	public CspTradeSureFailureExecption() {
		super();
	}

	public CspTradeSureFailureExecption(String message, Throwable cause) {
		super(message, cause);
	}

	public CspTradeSureFailureExecption(String message) {
		super(message);
	}

	public CspTradeSureFailureExecption(Throwable cause) {
		super(cause);
	}

}
