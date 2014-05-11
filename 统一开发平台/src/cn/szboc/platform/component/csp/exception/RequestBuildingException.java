package cn.szboc.platform.component.csp.exception;

/**
 * 请求bean构建异常
 */
public class RequestBuildingException extends CspTradeSureFailureExecption {

	private static final long serialVersionUID = 1L;

	public RequestBuildingException() {
		super();
	}

	public RequestBuildingException(String message, Throwable cause) {
		super(message, cause);
	}

	public RequestBuildingException(String message) {
		super(message);
	}

	public RequestBuildingException(Throwable cause) {
		super(cause);
	}

}
