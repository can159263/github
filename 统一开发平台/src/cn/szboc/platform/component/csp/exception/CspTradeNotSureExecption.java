package cn.szboc.platform.component.csp.exception;

/**
 * CSP交易不能明确失败的异常
 */
public class CspTradeNotSureExecption extends CspTradeException {

	private static final long serialVersionUID = 1L;

	public CspTradeNotSureExecption() {
		super();
	}

	public CspTradeNotSureExecption(String message, Throwable cause) {
		super(message, cause);
	}

	public CspTradeNotSureExecption(String message) {
		super(message);
	}

	public CspTradeNotSureExecption(Throwable cause) {
		super(cause);
	}

}
