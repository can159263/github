package cn.szboc.platform.component.csp.trade.trade_000400.response;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.MessageSetEnhance;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;
import cn.szboc.platform.component.msgbean.interseptor.buildin.DateFormatDDMMYYYYInterceptor;

@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 439)
public class ResponseAdapter_000400_OPT_6 extends ResponseAdapter_000400 {

	// ===========================下载数据域=====================================
    	/** 帐号		*/		private String downAccountNo;
    	/** 客户号		*/		private String downCustomerNo;
    	/** 子账户类别	*/		private String downAccountSubType;
    	/** 册号		*/		private String downBookNo;
    	/** 序号		*/		private String downSheetNo;
    	/** 客户名称	*/		private String downCustomerName;
    	/** 国籍		*/		private String downNation;
    	/** 机构号		*/		private String downBranchNo;
    	/** 产品码		*/		private String downPcBancsCode;
    	/** 开户日期	*/		private String downOpenDate;
    	/** 冻结到期日	*/		private String downFreezeDate;
	// ========================= set & get =====================================

	public String getDownAccountNo() {
		return downAccountNo;
	}

	public String getDownCustomerNo() {
		return downCustomerNo;
	}

	public String getDownAccountSubType() {
		return downAccountSubType;
	}

	public String getDownBookNo() {
		return downBookNo;
	}

	public String getDownSheetNo() {
		return downSheetNo;
	}

	public String getDownCustomerName() {
		return downCustomerName;
	}

	public String getDownNation() {
		return downNation;
	}

	public String getDownBranchNo() {
		return downBranchNo;
	}

	public String getDownPcBancsCode() {
		return downPcBancsCode;
	}

	public String getDownOpenDate() {
		return downOpenDate;
	}

	public String getDownFreezeDate() {
		return downFreezeDate;
	}

	/**
	 * 实际上,总行在下行的数据域中,都填写了对应的新账号,并且左补0,补全17位,后5位留空白
	 * 
	 * @param downAccountNo
	 */
	@MessageField(startPos = 300, length = 22)
	public void setDownAccountNo(String downAccountNo) {
		this.downAccountNo = downAccountNo;
	}

	@MessageField(startPos = 322, length = 17, type = PadType.LEFT, material = 48)
	public void setDownCustomerNo(String downCustomerNo) {
		this.downCustomerNo = downCustomerNo;
	}

	@MessageField(startPos = 339, length = 4)
	public void setDownAccountSubType(String downAccountSubType) {
		this.downAccountSubType = downAccountSubType;
	}

	@MessageField(startPos = 343, length = 3)
	public void setDownBookNo(String downBookNo) {
		this.downBookNo = downBookNo;
	}

	@MessageField(startPos = 346, length = 2)
	public void setDownSheetNo(String downSheetNo) {
		this.downSheetNo = downSheetNo;
	}

	@MessageField(startPos = 348, length = 60)
	public void setDownCustomerName(String downCustomerName) {
		this.downCustomerName = downCustomerName;
	}

	@MessageField(startPos = 408, length = 2)
	public void setDownNation(String downNation) {
		this.downNation = downNation;
	}

	@MessageField(startPos = 410, length = 5)
	public void setDownBranchNo(String downBranchNo) {
		this.downBranchNo = downBranchNo;
	}

	@MessageField(startPos = 415, length = 8)
	public void setDownPcBancsCode(String downPcBancsCode) {
		this.downPcBancsCode = downPcBancsCode;
	}

	@MessageField(startPos = 423, length = 8)
	@MessageSetEnhance(beforeSet = DateFormatDDMMYYYYInterceptor.class)
	public void setDownOpenDate(String downOpenDate) {
		this.downOpenDate = downOpenDate;
	}

	@MessageField(startPos = 431, length = 8)
	@MessageSetEnhance(beforeSet = DateFormatDDMMYYYYInterceptor.class)
	public void setDownFreezeDate(String downFreezeDate) {
		this.downFreezeDate = downFreezeDate;
	}

}
