package cn.szboc.uniformproxy.frontend.server.postprocessor.exception;

/**
 * MD5计算时出现异常
 */
public class MD5FormatException extends Exception {

	private static final long serialVersionUID = 1L;

	public MD5FormatException() {
	}

	public MD5FormatException(String message) {
		super(message);
	}

	public MD5FormatException(Throwable cause) {
		super(cause);
	}

	public MD5FormatException(String message, Throwable cause) {
		super(message, cause);
	}

}
