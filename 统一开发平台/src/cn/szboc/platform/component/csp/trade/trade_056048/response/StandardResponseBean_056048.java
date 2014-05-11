package cn.szboc.platform.component.csp.trade.trade_056048.response;

import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.To;

@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 326)
public class StandardResponseBean_056048 extends ResponseAdapter_056048 {

	public String getDownErrorCode() {
		return super.getDownErrorCode();
	}

	public String getDownProcCode() {
		return super.getDownProcCode();
	}

	public String getDownIpcsCode() {
		return super.getDownIpcsCode();
	}

	/**
	 * 错误码
	 * 
	 * @param downErrorCode
	 */
	@Override
	@MessageField(startPos = 300, length = 4)
	public void setDownErrorCode(String downErrorCode) {
		super.setDownErrorCode(downErrorCode);
	}

	/**
	 * OK信息,若交易执行成功则为固定值：空格+O.K.
	 * 
	 * @param downProcCode
	 */
	@Override
	@MessageField(startPos = 304, length = 6)
	public void setDownProcCode(String downProcCode) {
		super.setDownProcCode(downProcCode);
	}

	/**
	 * 汇款编号,核心系统自动生成
	 * 
	 * @param downIpcsCode
	 */
	@Override
	@MessageField(startPos = 310, length = 16)
	public void setDownIpcsCode(String downIpcsCode) {
		super.setDownIpcsCode(downIpcsCode);
	}

}
