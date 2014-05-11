package cn.szboc.platform.component.csp2.trade.commons;

import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.PadType;

/**
 * CSP交易请求信息的抽象父类
 */
public abstract class CommonRequestBean{

	//========================报文头部(开始),上送和下行均需要此头部信息=======================
    	/**	01_交易码			*/		private String commonTradeCode;
    	/**	02_网点号			*/		private String commonBranchNo;
    	/**	03_终端号			*/		private String commonTerminalNo;
    	/**	04_工作站号			*/		private String commonWorkstationNo;
    	/**	05_柜员号			*/		private String commonOperator;
    	/**	06_产品码			*/		private String commonProductCode;
    	/**	07_系统日期			*/		private String commonSystemDate;
    	/**	08_系统时间			*/		private String commonSystemTime;
    	/**	09_外围交易序号		*/		private String commonTransNo;
    	/**	11_返回码			*/		private String commonReturnCode;
    	/**	10_外围交易子序号		*/		private String commonSubTransNo;
    	/**	12_BANCS系统日期	*/		private String commonBancsDate;
    	/**	13_CSP流水号		*/		private String commonCspNo;
    	/**	14_接口平台流水号		*/		private String commonTraceNo;
    	/**	15_BANCS流水号		*/		private String commonBancsNo;
    	/**	16_错误系统ID		*/		private String commonErrorSystemId;
    	/**	17_错误信息			*/		private String commonErrorInfo;
    	/**	18_保留字段			*/		private String commonReservedProperty;
	//========================报文头部(结束),上送和下行均需要此头部信息=======================

	@MessageField(startPos = 0, length = 6, type = PadType.MATCH)
	public String getCommonTradeCode() {
		return commonTradeCode;
	}

	@MessageField(startPos = 0, length = 6, type = PadType.MATCH)
	public void setCommonTradeCode(String commonTradeCode) {
		this.commonTradeCode = commonTradeCode;
	}

	@MessageField(startPos = 6, length = 5, type = PadType.MATCH)
	public String getCommonBranchNo() {
		return commonBranchNo;
	}

	@MessageField(startPos = 6, length = 5, type = PadType.MATCH)
	public void setCommonBranchNo(String commonBranchNo) {
		this.commonBranchNo = commonBranchNo;
	}

	@MessageField(startPos = 11, length = 6, type = PadType.LEFT, material = 48)
	public String getCommonTerminalNo() {
		return commonTerminalNo;
	}

	@MessageField(startPos = 11, length = 6, type = PadType.LEFT, material = 48)
	public void setCommonTerminalNo(String commonTerminalNo) {
		this.commonTerminalNo = commonTerminalNo;
	}

	@MessageField(startPos = 17, length = 3, type = PadType.LEFT, material = 48)
	public String getCommonWorkstationNo() {
		return commonWorkstationNo;
	}

	@MessageField(startPos = 17, length = 3, type = PadType.LEFT, material = 48)
	public void setCommonWorkstationNo(String commonWorkstationNo) {
		this.commonWorkstationNo = commonWorkstationNo;
	}

	@MessageField(startPos = 20, length = 7)
	public String getCommonOperator() {
		return commonOperator;
	}

	@MessageField(startPos = 20, length = 7)
	public void setCommonOperator(String commonOperator) {
		this.commonOperator = commonOperator;
	}

	@MessageField(startPos = 27, length = 20)
	public String getCommonProductCode() {
		return commonProductCode;
	}

	@MessageField(startPos = 27, length = 20)
	public void setCommonProductCode(String commonProductCode) {
		this.commonProductCode = commonProductCode;
	}

	@MessageField(startPos = 47, length = 8)
	public String getCommonSystemDate() {
		return commonSystemDate;
	}

	@MessageField(startPos = 47, length = 8)
	public void setCommonSystemDate(String commonSystemDate) {
		this.commonSystemDate = commonSystemDate;
	}

	@MessageField(startPos = 55, length = 6)
	public String getCommonSystemTime() {
		return commonSystemTime;
	}

	@MessageField(startPos = 55, length = 6)
	public void setCommonSystemTime(String commonSystemTime) {
		this.commonSystemTime = commonSystemTime;
	}

	@MessageField(startPos = 61, length = 30)
	public String getCommonTransNo() {
		return commonTransNo;
	}

	@MessageField(startPos = 61, length = 30)
	public void setCommonTransNo(String commonTransNo) {
		this.commonTransNo = commonTransNo;
	}

	@MessageField(startPos = 91, length = 2)
	public String getCommonSubTransNo() {
		return commonSubTransNo;
	}

	@MessageField(startPos = 91, length = 2)
	public void setCommonSubTransNo(String commonSubTransNo) {
		this.commonSubTransNo = commonSubTransNo;
	}

	@MessageField(startPos = 93, length = 4, type = PadType.NOP)
	public String getCommonReturnCode() {
		return commonReturnCode;
	}

	@MessageField(startPos = 93, length = 4, type = PadType.MATCH)
	public void setCommonReturnCode(String commonReturnCode) {
		this.commonReturnCode = commonReturnCode;
	}

	@MessageField(startPos = 97, length = 8, type = PadType.NOP)
	public String getCommonBancsDate() {
		return commonBancsDate;
	}

	@MessageField(startPos = 97, length = 8)
	public void setCommonBancsDate(String bancsDate) {
		this.commonBancsDate = bancsDate;
	}

	@MessageField(startPos = 105, length = 12, type = PadType.NOP)
	public String getCommonCspNo() {
		return commonCspNo;
	}

	@MessageField(startPos = 105, length = 12)
	public void setCommonCspNo(String commonCspNo) {
		this.commonCspNo = commonCspNo;
	}

	@MessageField(startPos = 117, length = 32, type = PadType.NOP)
	public String getCommonTraceNo() {
		return commonTraceNo;
	}

	@MessageField(startPos = 117, length = 32)
	public void setCommonTraceNo(String commonTraceNo) {
		this.commonTraceNo = commonTraceNo;
	}

	@MessageField(startPos = 149, length = 9, type = PadType.NOP)
	public String getCommonBancsNo() {
		return commonBancsNo;
	}

	@MessageField(startPos = 149, length = 9, type = PadType.LEFT, material = 48)
	public void setCommonBancsNo(String commonBancsNo) {
		this.commonBancsNo = commonBancsNo;
	}

	@MessageField(startPos = 158, length = 2, type = PadType.NOP)
	public String getCommonErrorSystemId() {
		return commonErrorSystemId;
	}

	@MessageField(startPos = 158, length = 2)
	public void setCommonErrorSystemId(String commonErrorSystemId) {
		this.commonErrorSystemId = commonErrorSystemId;
	}

	@MessageField(startPos = 160, length = 65, type = PadType.NOP)
	public String getCommonErrorInfo() {
		return commonErrorInfo;
	}

	@MessageField(startPos = 160, length = 65)
	public void setCommonErrorInfo(String commonErrorInfo) {
		this.commonErrorInfo = commonErrorInfo;
	}

	@MessageField(startPos = 225, length = 75, type = PadType.NOP)
	public String getCommonReservedProperty() {
		return commonReservedProperty;
	}

	@MessageField(startPos = 225, length = 75, type = PadType.NOP)
	public void setCommonReservedProperty(String commonReservedProperty) {
		this.commonReservedProperty = commonReservedProperty;
	}
}
