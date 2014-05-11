package cn.szboc.uniformproxy.frontend.server;

/**
 * 二进制数据转换异常
 */
public class RawDataConvertException extends Exception {

	public RawDataConvertException() {
	}

	public RawDataConvertException(String message) {
		super(message);
	}

	public RawDataConvertException(Throwable cause) {
		super(cause);
	}

	public RawDataConvertException(String message, Throwable cause) {
		super(message, cause);
	}

}
