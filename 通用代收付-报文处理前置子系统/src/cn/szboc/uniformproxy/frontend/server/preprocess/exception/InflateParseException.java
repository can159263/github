package cn.szboc.uniformproxy.frontend.server.preprocess.exception;

/**
 * Infalte解压异常时,抛出此异常实例
 */
public class InflateParseException extends Exception {

	private static final long serialVersionUID = 1L;

	public InflateParseException() {
	}

	public InflateParseException(String message) {
		super(message);
	}

	public InflateParseException(Throwable cause) {
		super(cause);
	}

	public InflateParseException(String message, Throwable cause) {
		super(message, cause);
	}

}
