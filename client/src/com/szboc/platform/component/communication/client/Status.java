package com.szboc.platform.component.communication.client;

/**
 * 请求的状态<br>
 * @author 刺客
 *
 */
public enum Status {
	/**
	 * 初始状态：发送之前的状态
	 */
	INITIAL,

	/**
	 * 请求成功：本次与服务器交互成功
	 */
	SUCCESS,

	/**
	 * 请求失败：本次与服务器交互失败，包括通信前的异常，以及通信后响应报文的解析异常
	 */
	FAILURE,

	/**
	 * 状态未明：与服务器交互时发生异常，状态无法明确
	 */
	NOT_SURE;

	private String value = null;

	private Status() {
		this.value = "S" + this.ordinal();
	}

	public String value() {
		return this.value;
	}

	public static Status fromValue(String value) {
		for (Status s : Status.values()) {
			if (value.equals(s.value())) {
				return s;
			}
		}
		throw new IllegalArgumentException(value);
	}
}
