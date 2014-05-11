package cn.szboc.uniformproxy.mange;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import cn.szboc.uniformproxy.batchtrade.transaction.BatchDeductResponseServer;
import cn.szboc.uniformproxy.frontend.server.MessageRecvNettyServer;

/**
 * 后台管理监听器
 */
public class MangeBackGroundServer {

	private static Logger _logger = LoggerFactory.getLogger(MangeBackGroundServer.class);

	private ExecutorService server = Executors.newFixedThreadPool(1);

	/** 监听端口 */
	private int lstnPort;

	@Required
	public void setLstnPort(int lstnPort) {
		this.lstnPort = lstnPort;
	}
	
	/** 服务socket */
	private ServerSocket serverSocket;
	
	private BatchDeductResponseServer batchServer;
	
	private MessageRecvNettyServer messageRecvNettyserver;
	
	@Required
	public void setBatchServer(BatchDeductResponseServer batchServer) {
		this.batchServer = batchServer;
	}
	
	public void setMessageRecvNettyServer(MessageRecvNettyServer messageRecvNettyserver) {
		this.messageRecvNettyserver = messageRecvNettyserver;
	}
	

	/**
	 * 启动
	 * @throws Exception 
	 */
	public void startup() throws Exception {

		new Thread(new Runnable() {

			public void process() throws Exception  {
				_logger.info("后台管理监听器准备启动...");

				serverSocket = new ServerSocket(lstnPort);

				_logger.info("后台管理监听器已成功绑定端口{}", lstnPort);

				while (true) {

					Socket client = serverSocket.accept();

					_logger.info("监听到后台管理请求");

					MangeBackGroundTask task = new MangeBackGroundTask(client);

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
	}

	public void submitTask(MangeBackGroundTask task) {

		if (task == null) {
			throw new NullPointerException("提交任务不能为空");
		}
		
		task.setBatchServer(this.batchServer);
		task.setMessageRecvNettyServer(this.messageRecvNettyserver);
		task.setMangeBackGroundServer(this);

		this.server.submit(task);
	}

}
