package cn.szboc.uniformproxy.frontend.server.preprocess.exception;

/**
 * MD5验证异常时,抛出此异常实例
 */
public class MD5ParseException extends Exception {

	private static final long serialVersionUID = 1L;

	public MD5ParseException() {
	}

	public MD5ParseException(String message) {
		super(message);
	}

	public MD5ParseException(Throwable cause) {
		super(cause);
	}

	public MD5ParseException(String message, Throwable cause) {
		super(message, cause);
	}

}
