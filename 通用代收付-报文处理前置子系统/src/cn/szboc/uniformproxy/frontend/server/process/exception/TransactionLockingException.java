package cn.szboc.uniformproxy.frontend.server.process.exception;

/**
 * 交易被锁定
 */
public class TransactionLockingException extends Exception {

	private static final long serialVersionUID = 1L;

	public TransactionLockingException() {
		// TODO Auto-generated constructor stub
	}

	public TransactionLockingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TransactionLockingException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public TransactionLockingException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
