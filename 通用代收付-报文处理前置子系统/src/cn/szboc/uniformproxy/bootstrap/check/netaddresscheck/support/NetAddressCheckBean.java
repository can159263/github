package cn.szboc.uniformproxy.bootstrap.check.netaddresscheck.support;

import org.apache.commons.lang3.StringUtils;

/**
 * 网络流量分派bean
 */
public class NetAddressCheckBean {

	/**
	 * 系统别
	 */
	private String systemId;

	/**
	 * IP地址
	 */
	private String socketAddressIp;

	/**
	 * 端口
	 */
	private Integer socketAddressPort;

	/**
	 * 状态
	 */
	private NetAddressServerStatus serverStatus;

	public String getSystemId() {
		return systemId;
	}

	public String getSocketAddressIp() {
		return socketAddressIp;
	}

	public Integer getSocketAddressPort() {
		return socketAddressPort;
	}

	public NetAddressServerStatus getServerStatus() {
		return serverStatus;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public void setSocketAddressIp(String socketAddressIp) {
		this.socketAddressIp = socketAddressIp;
	}

	public void setSocketAddressPort(Integer socketAddressPort) {
		this.socketAddressPort = socketAddressPort;
	}

	public void setServerStatus(NetAddressServerStatus serverStatus) {
		this.serverStatus = serverStatus;
	}

	public void setServerStatusWithString(String serverStatus) {
		if (StringUtils.isEmpty(serverStatus)) {
			new IllegalArgumentException("状态标识符不能为空");
		}
		for (NetAddressServerStatus status : NetAddressServerStatus.values()) {
			if (status.getStatus().equals(serverStatus)) {
				this.serverStatus = status;
				return;
			}
		}
		throw new IllegalArgumentException("状态标识符[" + serverStatus + "]无法匹配到Enum:" + NetAddressServerStatus.class.getCanonicalName());
	}

}
