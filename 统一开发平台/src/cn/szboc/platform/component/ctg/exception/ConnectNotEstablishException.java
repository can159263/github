package cn.szboc.platform.component.ctg.exception;

/**
 * 在连接ctg中间服务器前出现的异常,此异常出现,可视为交易并没有发送出去
 * 该异常表明此次交易,明确失败
 */
public class ConnectNotEstablishException extends CtgCommonException {

	private static final long serialVersionUID = 1L;

	public ConnectNotEstablishException() {
		super();
	}

	public ConnectNotEstablishException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnectNotEstablishException(String message) {
		super(message);
	}

	public ConnectNotEstablishException(Throwable cause) {
		super(cause);
	}

}
