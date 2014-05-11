package cn.szboc.platform.component.ctg.exception;

/**
 * CTG模块发出的异常通用基类
 */
public abstract class CtgCommonException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CtgCommonException() {
		super();
	}

	public CtgCommonException(String message, Throwable cause) {
		super(message, cause);
	}

	public CtgCommonException(String message) {
		super(message);
	}

	public CtgCommonException(Throwable cause) {
		super(cause);
	}

}
