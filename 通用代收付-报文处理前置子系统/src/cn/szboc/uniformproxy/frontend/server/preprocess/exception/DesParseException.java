package cn.szboc.uniformproxy.frontend.server.preprocess.exception;

/**
 * DES解密异常时,抛出此异常实例
 */
public class DesParseException extends Exception {

	private static final long serialVersionUID = 1L;

	public DesParseException() {
	}

	public DesParseException(String message) {
		super(message);
	}

	public DesParseException(Throwable cause) {
		super(cause);
	}

	public DesParseException(String message, Throwable cause) {
		super(message, cause);
	}

}
