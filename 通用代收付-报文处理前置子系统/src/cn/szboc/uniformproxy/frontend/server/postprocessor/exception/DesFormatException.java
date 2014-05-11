package cn.szboc.uniformproxy.frontend.server.postprocessor.exception;

/**
 * DES加密时异常
 */
public class DesFormatException extends Exception {

	private static final long serialVersionUID = 1L;

	public DesFormatException() {
	}

	public DesFormatException(String message) {
		super(message);
	}

	public DesFormatException(Throwable cause) {
		super(cause);
	}

	public DesFormatException(String message, Throwable cause) {
		super(message, cause);
	}

}
