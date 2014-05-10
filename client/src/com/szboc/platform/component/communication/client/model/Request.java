package com.szboc.platform.component.communication.client.model;

import com.szboc.platform.component.communication.client.Status;

/**
 * 内部请求信息bean
 * 
 * @author 刺客
 * 
 */
public class Request {

	private Status localStatus = null;

	/**
	 * 外部请求实例的引用
	 */
	private Object refOutterRequest = null;

	public Status getLocalStatus() {
		return localStatus;
	}

	public void setLocalStatus(Status localStatus) {
		this.localStatus = localStatus;
	}

	public Object getRefOutterRequest() {
		return refOutterRequest;
	}

	public void setRefOutterRequest(Object refOutterRequest) {
		this.refOutterRequest = refOutterRequest;
	}

}
