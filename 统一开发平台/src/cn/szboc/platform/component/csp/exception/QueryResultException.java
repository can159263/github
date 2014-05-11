package cn.szboc.platform.component.csp.exception;

/**
 * 查询异常
 */
public class QueryResultException extends Exception {

	private static final long serialVersionUID = 1L;

	public QueryResultException() {
		super();
	}

	public QueryResultException(String message, Throwable cause) {
		super(message, cause);
	}

	public QueryResultException(String message) {
		super(message);
	}

	public QueryResultException(Throwable cause) {
		super(cause);
	}

}
