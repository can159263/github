package cn.szboc.uniformproxy.bootstrap.check.netaddresscheck.support;

public enum NetAddressServerStatus {

	/**
	 * 当前可以分派
	 */
	READY("00"),

	/**
	 * 当前不可以分派
	 */
	NOT_READY("01");

	private String status;

	private NetAddressServerStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return status;
	}

	public String printReadableInfo() {
		if (this == READY) {
			return "当前设备可以接收分配";
		}
		if (this == NOT_READY) {
			return "当前设备暂不可以接收分配";
		}
		return "当前设备状态不明";
	}

}
