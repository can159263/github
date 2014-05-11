package cn.szboc.uniformproxy.frontend.server.process.exception;

import java.math.BigDecimal;

/**
 * 账户余额不足
 */
public class AccountBalanceInsufficientException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final BigDecimal ZERO = new BigDecimal("0.00");

	/**
	 * 当前账户余额
	 */
	private final BigDecimal accountBalance;

	/**
	 * 应扣款项
	 */
	private final BigDecimal preDedcutAmt;

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public BigDecimal getPreDedcutAmt() {
		return preDedcutAmt;
	}

	/** 构造函数  */
	public AccountBalanceInsufficientException(BigDecimal accountBalance, BigDecimal preDedcutAmt) {
		if (accountBalance == null) {
			throw new IllegalArgumentException("账户金额不能为空");
		}
		if (accountBalance.compareTo(ZERO) < 0) {
			throw new IllegalArgumentException("账户金额不能为负数");
		}
		if (preDedcutAmt == null) {
			throw new IllegalArgumentException("应扣款金额不能为空");
		}
		if (preDedcutAmt.compareTo(accountBalance) <= 0) {
			throw new IllegalArgumentException("应扣款金额必须大于账户余额");
		}
		this.accountBalance = accountBalance;
		this.preDedcutAmt = preDedcutAmt;
	}

}
