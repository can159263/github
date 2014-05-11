package cn.szboc.uniformproxy.frontend.server.process.processor.bean;

import java.io.Serializable;

/**
 * 报文控制bean
 */
public class MessageControlBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 系统别 */
	private String sysCode;

	/** 交易码 */
	private String transCode;

	/** 是否开通 */
	private boolean isOpen;

	/** 开启时间 */
	private String openTimeStart;

	/** 结束时间 */
	private String openTimeEnd;

	public String getSysCode() {
		return sysCode;
	}

	public String getTransCode() {
		return transCode;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public String getOpenTimeStart() {
		return openTimeStart;
	}

	public String getOpenTimeEnd() {
		return openTimeEnd;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public void setOpenTimeStart(String openTimeStart) {
		this.openTimeStart = openTimeStart;
	}

	public void setOpenTimeEnd(String openTimeEnd) {
		this.openTimeEnd = openTimeEnd;
	}

}
