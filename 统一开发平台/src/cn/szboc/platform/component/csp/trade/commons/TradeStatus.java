package cn.szboc.platform.component.csp.trade.commons;

/**
 * 账务类交易的状态
 */
public enum TradeStatus {

	/**
	 * 交易成功,未有冲正过
	 */
	SUCCESS("00"),

	/**
	 * 交易成功,冲正成功
	 */
	ROLLBACK("01"),

	/**
	 * 交易成功,冲正失败
	 */
	ROLLBACK_FAILURE("02"),

	/**
	 * 交易不存在
	 */
	NOT_EXISTS("03"),

	/**
	 * 冲正中,状态不明
	 */
	ROLLBACKING("04"),

	/**
	 * 状态不明
	 */
	NOT_EXPLICIT("05");

	private String code;
	

	private TradeStatus(String code) {
		this.code = code;
	}

	/**
	 * 从code中反射出本enum表示
	 * @param code
	 * @return
	 */
	public static TradeStatus _valueOf(String code) {
		if (code == null) {
			return null;
		}
		for (TradeStatus status : TradeStatus.values()) {
			if (status.code.equals(code)) {
				return status;
			}
		}
		throw new IllegalArgumentException("不存在匹配的类型,code=" + code);
	}
}
