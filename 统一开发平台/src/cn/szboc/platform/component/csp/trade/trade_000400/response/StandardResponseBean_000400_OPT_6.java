package cn.szboc.platform.component.csp.trade.trade_000400.response;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.MessageSetEnhance;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;
import cn.szboc.platform.component.msgbean.interseptor.buildin.DateFormatDDMMYYYYInterceptor;

@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 439)
public class StandardResponseBean_000400_OPT_6 extends ResponseAdapter_000400_OPT_6 {
	public String getDownAccountNo() {
		return super.getDownAccountNo();
	}

	public String getDownCustomerNo() {
		return super.getDownCustomerNo();
	}

	public String getDownAccountSubType() {
		return super.getDownAccountSubType();
	}

	public String getDownBookNo() {
		return super.getDownBookNo();
	}

	public String getDownSheetNo() {
		return super.getDownSheetNo();
	}

	public String getDownCustomerName() {
		return super.getDownCustomerName();
	}

	public String getDownNation() {
		return super.getDownNation();
	}

	public String getDownBranchNo() {
		return super.getDownBranchNo();
	}

	public String getDownPcBancsCode() {
		return super.getDownPcBancsCode();
	}

	public String getDownOpenDate() {
		return super.getDownOpenDate();
	}

	public String getDownFreezeDate() {
		return super.getDownFreezeDate();
	}

	/**
	 * 实际上,总行在下行的数据域中,都填写了对应的新账号,并且左补0,补全17位,后5位留空白
	 * 
	 * @param downAccountNo
	 */
	@MessageField(startPos = 300, length = 22)
	public void setDownAccountNo(String downAccountNo) {
		super.setDownAccountNo(downAccountNo);
	}

	@MessageField(startPos = 322, length = 17, type = PadType.LEFT, material = 48)
	public void setDownCustomerNo(String downCustomerNo) {
		super.setDownCustomerNo(downCustomerNo);
	}

	@MessageField(startPos = 339, length = 4)
	public void setDownAccountSubType(String downAccountSubType) {
		super.setDownAccountSubType(downAccountSubType);
	}

	@MessageField(startPos = 343, length = 3)
	public void setDownBookNo(String downBookNo) {
		super.setDownBookNo(downBookNo);
	}

	@MessageField(startPos = 346, length = 2)
	public void setDownSheetNo(String downSheetNo) {
		super.setDownSheetNo(downSheetNo);
	}

	@MessageField(startPos = 348, length = 60)
	public void setDownCustomerName(String downCustomerName) {
		super.setDownCustomerName(downCustomerName);
	}

	@MessageField(startPos = 408, length = 2)
	public void setDownNation(String downNation) {
		super.setDownNation(downNation);
	}

	@MessageField(startPos = 410, length = 5)
	public void setDownBranchNo(String downBranchNo) {
		super.setDownBranchNo(downBranchNo);
	}

	@MessageField(startPos = 415, length = 8)
	public void setDownPcBancsCode(String downPcBancsCode) {
		super.setDownPcBancsCode(downPcBancsCode);
	}

	@MessageField(startPos = 423, length = 8)
	@MessageSetEnhance(beforeSet = DateFormatDDMMYYYYInterceptor.class)
	public void setDownOpenDate(String downOpenDate) {
		super.setDownOpenDate(downOpenDate);
	}

	@MessageField(startPos = 431, length = 8)
	@MessageSetEnhance(beforeSet = DateFormatDDMMYYYYInterceptor.class)
	public void setDownFreezeDate(String downFreezeDate) {
		super.setDownFreezeDate(downFreezeDate);
	}

}
