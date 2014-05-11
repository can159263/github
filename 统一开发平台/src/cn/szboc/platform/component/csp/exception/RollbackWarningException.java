package cn.szboc.platform.component.csp.exception;

/**
 * 回滚的一些特殊警告
 */
public class RollbackWarningException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 要回滚的传票号
	 */
	private final String seqNo;
	
	/**
	 * 回滚交易的返回码
	 * 特别注意: (这里有可能存放CE05,表明原交易属于重发,默认rollback操作不会进行冲正)
	 */
	private final String cspRtnCode;

	public String getSeqNo() {
		return seqNo;
	}

	public String getCspRtnCode() {
		return cspRtnCode;
	}

	/**
	 * 唯一构造函数 
	 * @param seqNo
	 * @param cspRtnCode
	 */
	public RollbackWarningException(String seqNo, String cspRtnCode) {
		this.seqNo = seqNo;
		this.cspRtnCode = cspRtnCode;
	}

}
