package cn.szboc.platform.component.csp.trade.commons;

/**
 * CSP头部交易的字段,共18个字段
 */
public enum CspTradeCommonField {

	/**
	 * 交易码
	 */
	TRADE_CODE,

	/**
	 * 网点号
	 */
	BRANCH_NO,

	/**
	 * 终端号
	 */
	TERMINAL_NO,

	/**
	 * 工作站号
	 */
	WORKSTATION_NO,

	/**
	 * 柜员号
	 */
	OPERATOR,

	/**
	 * 产品码
	 */
	PRODUCT_CODE,

	/**
	 * 外围系统日期
	 */
	SYSTEM_DATE,

	/**
	 * 外围系统时间
	 */
	SYSTEM_TIME,

	/**
	 * 外围交易序号
	 */
	TRANS_NO,

	/**
	 * 外围交易子序号
	 */
	SUB_TRANS_NO,

	/**
	 * 返回码
	 */
	RETURN_CODE,

	/**
	 * BANCS系统日期
	 */
	BANCS_DATE,

	/**
	 * CSP流水号
	 */
	CSP_NO,

	/**
	 * 接口平台流水号
	 */
	TRACE_NO,

	/**
	 * BANCS流水号
	 */
	BANCS_NO,

	/**
	 * 错误系统
	 */
	ERROR_SYSTEM_ID,

	/**
	 * 错误信息
	 */
	ERROR_INFO,

	/**
	 * 预留
	 */
	RESERVED_PROPERTY

}
