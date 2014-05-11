package cn.szboc.platform.exception;

/**
 * 平台检查型异常
 */
public class PlatformCheckedException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlatformCheckedException() {
		super();
	}

	public PlatformCheckedException(String message) {
		super(message);
	}

	public PlatformCheckedException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlatformCheckedException(Throwable cause) {
		super(cause);
	}

}
