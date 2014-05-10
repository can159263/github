package com.szboc.platform.component.communication.client.model;

import com.szboc.platform.component.communication.client.Status;

/**
 * 请求后响应的结果对象，根据<code>localStatus<code>的值判断此次交易是否成功<br>
 * 
 * @see Status
 * 
 * @author 刺客
 * 
 */
public class Response {

	/**
	 * 内部使用状态
	 */
	private Status localStatus = null;

	/**
	 * 内部使用返回信息
	 */
	private String localRtnMsg = null;

	/**
	 * 外部响应实例的引用
	 */
	private Object refOutterResponse = null;

	public Status getLocalStatus() {
		return this.localStatus;
	}

	public void setLocalStatus(Status status) {
		this.localStatus = status;
	}

	public String getLocalRtnMsg() {
		return localRtnMsg;
	}

	public void setLocalRtnMsg(String localRtnMsg) {
		this.localRtnMsg = localRtnMsg;
	}

	public Object getRefOutterResponse() {
		return refOutterResponse;
	}

	public void setRefOutterResponse(Object refOutterResponse) {
		this.refOutterResponse = refOutterResponse;
	}
}
