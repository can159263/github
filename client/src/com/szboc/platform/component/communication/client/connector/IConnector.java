package com.szboc.platform.component.communication.client.connector;

import com.szboc.platform.component.communication.client.model.Request;
import com.szboc.platform.component.communication.client.model.Response;

/**
 * 连接器接口
 * @author 刺客
 *
 */
public interface IConnector {
	public Response send(Request request);
}
