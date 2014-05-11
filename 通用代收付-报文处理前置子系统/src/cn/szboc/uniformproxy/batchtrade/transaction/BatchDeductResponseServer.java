package cn.szboc.uniformproxy.batchtrade.transaction;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import cn.szboc.platform.component.xmlbean.nospring.XmlBeanMapping;
import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;

/**
 * 批量扣款异步回盘监听器
 */
public class BatchDeductResponseServer {

	private static Logger _logger = LoggerFactory.getLogger(BatchDeductResponseServer.class);

	private ExecutorService server = Executors.newFixedThreadPool(10);

	/** 监听端口 */
	private int lstnPort;
	/** 接收解析bean */
	private XmlBeanMapping recvMapping;
	/** 同步响应解析工具 */
	private XmlBeanMapping sendMapping;

	@Required
	public void setLstnPort(int lstnPort) {
		this.lstnPort = lstnPort;
	}

	@Required
	public void setRecvMapping(XmlBeanMapping recvMapping) {
		this.recvMapping = recvMapping;
	}

	@Required
	public void setSendMapping(XmlBeanMapping sendMapping) {
		this.sendMapping = sendMapping;
	}

	private RemoteInvokeService remoteInvokeService;

	@Required
	public void setRemoteInvokeService(RemoteInvokeService remoteInvokeService) {
		this.remoteInvokeService = remoteInvokeService;
	}

	/** 服务socket */
	private ServerSocket serverSocket;

	/**
	 * 启动
	 * @throws Exception 
	 */
	public void startup() throws Exception {

		new Thread(new Runnable() {

			public void process() throws Exception  {
				_logger.info("批量扣款异步回盘监听器准备启动...");

				serverSocket = new ServerSocket(lstnPort);

				_logger.info("批量扣款异步回盘监听器已成功绑定端口{}", lstnPort);

				while (true) {

					Socket client = serverSocket.accept();

					_logger.info("监听到远程批量账务回盘请求");

					BatchDeductResponseDealTask task = new BatchDeductResponseDealTask(client);

					task.setRecvMapping(recvMapping);
					task.setSendMapping(sendMapping);
					task.setService(remoteInvokeService);

					submitTask(task);
				}
			}

			@Override
			public void run() {
				try {
					process();
				} catch (Exception e) {
					_logger.error("批量报文回盘监听程序异常", e);
				}
			}
		}).start();

	}

	public void shutdown() {
		try {
			if (serverSocket != null) {
				serverSocket.close();
			}
		} catch (Exception e) {
			_logger.error("批量报文异步响应服务关闭异常", e);
		}
		
		try
		{
			this.server.shutdownNow();
		}
		catch (Exception e)
		{
			_logger.error("批量报文异步响应服务线程池关闭时异常", e);
		}
	}

	public void submitTask(BatchDeductResponseDealTask task) {

		if (task == null) {
			throw new NullPointerException("提交任务不能为空");
		}

		this.server.submit(task);
	}

}
