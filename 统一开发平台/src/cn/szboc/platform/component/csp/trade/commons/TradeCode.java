package cn.szboc.platform.component.csp.trade.commons;

/**
 * 6位CSP交易码
 */
/**@author 邢路
 * @description
 *         2012-3-26 JDK_6
 */
public enum TradeCode {

	/**
	 * 440_帐户详细资料查询交易
	 */
	TRADE_000440("000440"),
	
	/**
	 * 400_短查询
	 */
	TRADE_000400("000400"),
	
	/**
	 * A00400_返回所有栏位
	 */
	TRADE_A00400("A00400"),
	
	/**
	 * 001045_本地客户帐转客户帐交易
	 */
	TRADE_001045("001045"),
	
	/**
	 * 056048_统内客户(非存折户)转帐汇款交易
	 */
	TRADE_056048("056048"),
	
	/**
	 * 056148_统内客户(非存折户)转帐汇款冲正交易
	 */
	TRADE_056148("056148"),
	
	/**
	 * 060460_客户综合信息查询交易
	 */
	TRADE_060460("060460"),
	
	/**
	 * 009751_BANCS查询
	 */
	TRADE_009751("009751"),
	
	/**
	 * 097511_CSP查询
	 */
	TRADE_097511("097511"),
	
	/**
	 * 020400_BGL余额查询
	 */
	TRADE_020400("020400");
	
	private String code;
	
	TradeCode(String code){
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
	
	@Override
	public String toString() {
		return this.code;
	}

}
