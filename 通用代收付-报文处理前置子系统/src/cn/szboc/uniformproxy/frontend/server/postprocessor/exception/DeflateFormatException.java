package cn.szboc.uniformproxy.frontend.server.postprocessor.exception;

/**
 * Deflate压缩时异常
 */
public class DeflateFormatException extends Exception {

	private static final long serialVersionUID = 1L;

	public DeflateFormatException() {
	}

	public DeflateFormatException(String message) {
		super(message);
	}

	public DeflateFormatException(Throwable cause) {
		super(cause);
	}

	public DeflateFormatException(String message, Throwable cause) {
		super(message, cause);
	}

}
