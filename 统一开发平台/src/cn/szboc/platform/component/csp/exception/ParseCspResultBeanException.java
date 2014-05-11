package cn.szboc.platform.component.csp.exception;

/**
 * CSP交易底层发送后,在解析返回bean时出现的异常
 */
public class ParseCspResultBeanException extends CspTradeNotSureExecption {

	private static final long serialVersionUID = 1L;

	public ParseCspResultBeanException() {
		super();
	}

	public ParseCspResultBeanException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParseCspResultBeanException(String message) {
		super(message);
	}

	public ParseCspResultBeanException(Throwable cause) {
		super(cause);
	}

}
