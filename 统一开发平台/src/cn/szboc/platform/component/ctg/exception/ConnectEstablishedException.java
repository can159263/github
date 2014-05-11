package cn.szboc.platform.component.ctg.exception;

/**
 * 在连接ctg中间服务器时和连接服务器之后出现的异常
 * 该异常无法判断交易的明确结果
 */
public class ConnectEstablishedException extends CtgCommonException {

	private static final long serialVersionUID = 1L;
	
	public ConnectEstablishedException() {
		super();
	}

	public ConnectEstablishedException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ConnectEstablishedException(String message) {
		super(message);
	}

	public ConnectEstablishedException(Throwable cause) {
		super(cause);
	}

}
