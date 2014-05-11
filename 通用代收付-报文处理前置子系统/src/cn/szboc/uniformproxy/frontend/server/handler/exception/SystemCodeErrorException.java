package cn.szboc.uniformproxy.frontend.server.handler.exception;

import cn.szboc.uniformproxy.frontend.server.MessageProcessException;

/**
 * 字节流头部系统别异常
 */
public class SystemCodeErrorException extends MessageProcessException {

	private static final long serialVersionUID = 1L;

	public SystemCodeErrorException() {
		super();
	}

	public SystemCodeErrorException(String message) {
		super(message);
	}

	public SystemCodeErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemCodeErrorException(Throwable cause) {
		super(cause);
	}

}
