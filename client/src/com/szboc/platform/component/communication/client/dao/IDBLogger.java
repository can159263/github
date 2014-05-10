package com.szboc.platform.component.communication.client.dao;

import com.szboc.platform.component.communication.client.model.Request;
import com.szboc.platform.component.communication.client.model.Response;

public interface IDBLogger {
	
	/**
	 * 保存原始发送对象
	 * @param request
	 * @return
	 */
	public int insert(Request request);

	/**
	 * 依据response更新通信结果
	 * @param request
	 * @param response
	 * @return
	 */
	public int update(Request request, Response response);
}
