package com.szboc.platform.component.communication.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.szboc.platform.component.communication.client.connector.IConnector;
import com.szboc.platform.component.communication.client.dao.IDBLogger;
import com.szboc.platform.component.communication.client.model.Request;
import com.szboc.platform.component.communication.client.model.Response;

public class Client {

	/**
	 * 日志记录者
	 */
	private static Logger logger = LoggerFactory.getLogger(Client.class);

	/**
	 * 负责将发送对象、以及通信结果序列化到数据库
	 */
	private IDBLogger dbLogger = null;

	/**
	 * 负责与服务器交互
	 */
	private IConnector connector = null;

	/**
	 * 1. 将请求对象保存至数据库<br>
	 * 2. 调用连接器发送报文<br>
	 * 3. 依据服务器返回的结果更新数据库中的状态<br>
	 * 
	 * @param request
	 * @return
	 */
	public Response send(Object outterRequest) {

		if (null == outterRequest) {
			throw new NullPointerException("待发送的对象outterRequest不能为null");
		}

		if (null == this.connector) {
			throw new NullPointerException("内部连接器对象connector不能为null");
		}

		Request request = new Request();
		request.setRefOutterRequest(outterRequest);
		request.setLocalStatus(Status.INITIAL);

		if (null != dbLogger) {
			logger.info("将发送对象保存至数据库");
			try {
				this.dbLogger.insert(request);
			} catch (Exception e) {
				logger.error("保存原始发报数据时异常,明确失败：" + e, e);
				Response response = this.createFailureResponse(e.getMessage());
				response.setLocalStatus(Status.FAILURE);
				return response;
			}
		}

		logger.info("调用连接器，与服务器进行通信");
		Response response = connector.send(request);

		if (null == response) {
			logger.error("内部通信返回的对象为null,状态未明");
			response = this.createFailureResponse("内部通信返回的对象为null,状态未明");
			response.setLocalStatus(Status.NOT_SURE);
			return response;
		}

		if (null != this.dbLogger) {
			logger.info("将通讯后的结果保存至数据库");
			this.dbLogger.update(request, response);
		}

		return response;
	}

	public IDBLogger getDbLogger() {
		return dbLogger;
	}

	public void setDbLogger(IDBLogger dbLogger) {
		this.dbLogger = dbLogger;
	}

	public IConnector getConnector() {
		return connector;
	}

	public void setConnector(IConnector connector) {
		this.connector = connector;
	}

	private Response createFailureResponse(String failureReason) {
		Response response = new Response();
		response.setLocalStatus(Status.FAILURE);
		response.setLocalRtnMsg(failureReason);
		return response;
	}

}
