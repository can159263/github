package cn.szboc.platform.component.csp.exception;

/**
 * 查询失败
 */
public class QueryResultFailureException extends Exception {

	public QueryResultFailureException() {
		super();
	}

	public QueryResultFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public QueryResultFailureException(String message) {
		super(message);
	}

	public QueryResultFailureException(Throwable cause) {
		super(cause);
	}

}
