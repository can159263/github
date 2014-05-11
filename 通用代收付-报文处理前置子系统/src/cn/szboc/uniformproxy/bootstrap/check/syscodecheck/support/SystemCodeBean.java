package cn.szboc.uniformproxy.bootstrap.check.syscodecheck.support;

import java.sql.Timestamp;

/**
 * 系统别domain对象
 */
public class SystemCodeBean {

	/**
	 * 系统别
	 */
	private String systemCode;
	
	/**
	 * 系统名称
	 */
	private String systemName;
	
	public String getSystemCode() {
		return systemCode;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

}
