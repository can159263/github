package cn.szboc.uniformproxy.frontend.system;

import org.springframework.beans.factory.annotation.Required;

/**
 * 系统配置bean
 */
public class SystemConfigBean {

	/**
	 * 系统别
	 */
	private String systemCode;

	/**
	 * 要监听的IP地址
	 */
	private String lstnIp;

	/**
	 * 要监听的端口地址
	 */
	private int lstnPort;


	/**
	 * 最大读取长度,单位为M
	 */
	private int maxSizeInM;
	
	/**
	 * 数据库表前缀名
	 */
	private String prefixOfTable;
	

	/**
	 * 接收报文保存路径
	 */
	private String msgRecvPath;
	
	/**
	 * 发送报文保存路径
	 */
	private String msgSendPath;
	
	/**
	 * 是否保留原始二进制数据
	 */
	private boolean saveRawData;
	
	
	private byte[] desKey;
	
	
	public String getSystemCode() {
		return systemCode;
	}

	@Required
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getLstnIp() {
		return lstnIp;
	}

	@Required
	public void setLstnIp(String lstnIp) {
		this.lstnIp = lstnIp;
	}

	public int getLstnPort() {
		return lstnPort;
	}

	@Required
	public void setLstnPort(int lstnPort) {
		this.lstnPort = lstnPort;
	}

	public int getMaxSizeInM() {
		return maxSizeInM;
	}

	@Required
	public void setMaxSizeInM(int maxSizeInM) {
		this.maxSizeInM = maxSizeInM;
	}

	public String getPrefixOfTable() {
		return prefixOfTable;
	}
	
	@Required
	public void setPrefixOfTable(String prefixOfTable) {
		this.prefixOfTable = prefixOfTable;
	}

	public String getMsgRecvPath() {
		return msgRecvPath;
	}

	public String getMsgSendPath() {
		return msgSendPath;
	}
	
	@Required
	public void setMsgRecvPath(String msgRecvPath) {
		this.msgRecvPath = msgRecvPath;
	}
	
	@Required
	public void setMsgSendPath(String msgSendPath) {
		this.msgSendPath = msgSendPath;
	}

	public boolean isSaveRawData() {
		return saveRawData;
	}

	@Required
	public void setSaveRawData(boolean saveRawData) {
		this.saveRawData = saveRawData;
	}

	public byte[] getDesKey() {
		return desKey;
	}

	@Required
	public void setDesKey(byte[] desKey) {
		this.desKey = desKey;
	}
	
	
}
