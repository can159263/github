package cn.szboc.uniformproxy.mange;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

import cn.szboc.platform.commons.ByteUtils;
import cn.szboc.platform.commons.DateUtils;
import cn.szboc.platform.commons.IOUtils;
import cn.szboc.platform.commons.digest.MD5Util;
import cn.szboc.platform.component.xmlbean.nospring.XmlBeanMapping;
import cn.szboc.platform.modules.parameter.SystemParameterHelper;
import cn.szboc.uniformproxy.batchtrade.transaction.BatchDeductResponseServer;
import cn.szboc.uniformproxy.frontend.server.MessageRecvNettyServer;
import cn.szboc.uniformproxy.frontend.system.SYS;
import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.batch.bean.recv.BatchDeductResponseRecvBean;
import cn.szboc.uniformproxy.remoteinvoke.batch.bean.send.BatchDeductResponseSendBean;

/**
 * 后台管理处理任务
 */
public class MangeBackGroundTask implements Runnable {

	private static Logger _logger = LoggerFactory.getLogger(MangeBackGroundTask.class);

	private Socket socket;

	private InputStream is;

	private OutputStream os;
	
	public MangeBackGroundTask(Socket socket) {
		this.socket = socket;
	}
	
	private BatchDeductResponseServer batchServer;
	
	private MessageRecvNettyServer messageRecvNettyserver;
	
	private MangeBackGroundServer mangeBackGroundServer;
	
	public void setBatchServer(BatchDeductResponseServer batchServer) {
		this.batchServer = batchServer;
	}
	
	public void setMessageRecvNettyServer(MessageRecvNettyServer messageRecvNettyserver) {
		this.messageRecvNettyserver = messageRecvNettyserver;
	}
	
	public void setMangeBackGroundServer(MangeBackGroundServer mangeBackGroundServer) {
		this.mangeBackGroundServer = mangeBackGroundServer;
	}
	

	

	@Override
	public void run() {

		try {
			this.process();
		} catch (Exception e) {
			_logger.error("后台管理命令处理失败", e);
			
			try {
				String exceptionMsg = e.getMessage();
				
				// 写异常信息
				os.write(exceptionMsg.getBytes());
				
				os.flush();
				
			} catch (Exception e2) {
				_logger.error("后台管理响应处理失败,再返回响应信息时又出现异常", e2);
			}
			
		} finally {
			org.apache.commons.io.IOUtils.closeQuietly(is);
			org.apache.commons.io.IOUtils.closeQuietly(os);
			org.apache.commons.io.IOUtils.closeQuietly(socket);
		}

	}

	private void process() throws Exception {

		this.is = socket.getInputStream();
		this.os = socket.getOutputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String command = br.readLine();
		
		if (Command.STOP.equalsIgnoreCase(command))
		{
			// 关闭批量异步回盘服务器
			try
			{
				this.batchServer.shutdown();
			}
			catch (Exception e)
			{
				_logger.error("批量报文异步回盘处理器关闭时异常", e);
			}
			
			// 关闭报文处理服务器
			try
			{
				if (this.messageRecvNettyserver != null)
				{
					this.messageRecvNettyserver.shutdown();
				}
			}
			catch (Exception e)
			{
				_logger.error("报文NettyServer关闭时异常", e);
			}
			
			// 关闭后台服务管理服务器
			try
			{
				this.mangeBackGroundServer.shutdown();
			}
			catch (Exception e)
			{
				_logger.error("后台管理监听关闭时异常", e);
			}
		}
		
		os.write("frontend is stop success".getBytes());
		
		os.flush();
		
		_logger.info("后台管理保温响应完毕, 本次回盘处理结束");
	}

	
}
