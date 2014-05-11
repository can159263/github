package cn.szboc.uniformproxy.batchtrade.transaction;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.szboc.platform.commons.ByteUtils;
import cn.szboc.platform.commons.DateUtils;
import cn.szboc.platform.commons.IOUtils;
import cn.szboc.platform.commons.digest.MD5Util;
import cn.szboc.platform.component.xmlbean.nospring.XmlBeanMapping;
import cn.szboc.platform.modules.parameter.SystemParameterHelper;
import cn.szboc.uniformproxy.frontend.system.SYS;
import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.batch.bean.recv.BatchDeductResponseRecvBean;
import cn.szboc.uniformproxy.remoteinvoke.batch.bean.send.BatchDeductResponseSendBean;

/**
 * 批量扣款异步回盘接收任务
 */
public class BatchDeductResponseDealTask implements Runnable {

	private static Logger _logger = LoggerFactory.getLogger(BatchDeductResponseDealTask.class);

	private Socket socket;

	private InputStream is;

	private OutputStream os;

	private RemoteInvokeService service;

	/**
	 * 请求文件目录
	 */
	private File recvFileDir;

	/**
	 * 响应文件目录
	 */
	private File sendFileDir;
	
	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}
	
	
	public BatchDeductResponseDealTask(Socket socket) {
		this.socket = socket;
	}

	/** 接收解析bean */
	private XmlBeanMapping recvMapping;

	/** 同步响应解析工具 */
	private XmlBeanMapping sendMapping;

	public void setRecvMapping(XmlBeanMapping recvMapping) {
		this.recvMapping = recvMapping;
	}

	public void setSendMapping(XmlBeanMapping sendMapping) {
		this.sendMapping = sendMapping;
	}

	@Override
	public void run() {

		try {
			this.process();
		} catch (Exception e) {
			_logger.error("批量报文回盘处理失败", e);
			
			BatchDeductResponseSendBean bean = new BatchDeductResponseSendBean();
			BatchDeductResponseSendBean.Header header = new BatchDeductResponseSendBean.Header();
			bean.setHeader(header);
			
			try {
				// 当抛出异常时
				header.setRtnCode("N");
				header.setRtnMsg("报文处理失败");
				header.setTradeType("0020");
				
				byte[] respData = sendMapping.beanToBytes(bean);
				
				byte[] MD5 = ByteUtils.binaryToHexString(MD5Util.caculate(respData)).getBytes();
				
				int length = respData.length;
				
				// 报文最前面是8位的报文长度
				String lengthStr = ("00000000" + length);
				lengthStr = lengthStr.substring(lengthStr.length() - 8);
				
				// 写长度头
				os.write(lengthStr.getBytes());
				// 写系统别
				os.write(SystemParameterHelper.getParam("SYSTEM.BATCH.SYSCODE").getBytes());
				os.write("0020".getBytes());
				os.write(MD5);
				os.write(respData);
				
				os.flush();
				
			} catch (Exception e2) {
				_logger.error("批量报文响应处理失败,再返回响应信息时又出现异常", e2);
			}
			
		} finally {
			org.apache.commons.io.IOUtils.closeQuietly(is);
			org.apache.commons.io.IOUtils.closeQuietly(os);
			org.apache.commons.io.IOUtils.closeQuietly(socket);
		}

	}

	private void process() throws Exception {

		ensureFileSaveDir();
		
		this.is = socket.getInputStream();
		this.os = socket.getOutputStream();

		// 回盘报文长度
		byte[] lengthBytes = new byte[8];

		IOUtils.readUntilFill(is, lengthBytes);

		int length = Integer.parseInt(new String(lengthBytes));

		_logger.info("ECES批量报文返回报文长度为{}", length);

		// 跳过4字节系统别, 跳过4字节0020交易别, 跳过32字节MD5码
		is.skip(40);

		byte[] msgData = new byte[length];

		IOUtils.readUntilFill(is, msgData);

		_logger.info(new String(msgData, "GBK"));
		
		File recvXmlFile = null;
		try {
			recvXmlFile = File.createTempFile("BATCH_", ".xml", this.recvFileDir);
			FileUtils.writeByteArrayToFile(recvXmlFile, msgData);
			_logger.info("ECES响应请求报文保存成功, 路径为{}", recvXmlFile.getAbsolutePath());
		} catch (Exception e) {
			_logger.error("ECES响应请求报文保存失败", e);
		}

		BatchDeductResponseRecvBean recvBean = null;
		try {
			recvBean = (BatchDeductResponseRecvBean) recvMapping.bytesToBean(msgData);
		} catch (Exception e) {
			_logger.error("解析ECES返回报文异常,本次批量报文回盘处理结束");
			throw e;
		}
		
		String token = RandomStringUtils.randomAlphanumeric(10).toUpperCase();
		
		try {
			File newRecvFile = new File(this.recvFileDir, "ECES_RESP_RECV_" + recvBean.getHeader().getBatchNo() + "_" + token + ".xml");
			recvXmlFile.renameTo(newRecvFile);
			_logger.info("ECES响应请求报文重命名成功, 路径为{}", newRecvFile.getAbsolutePath());
		} catch (Exception e) {
			_logger.error("ECES响应请求报文重命名失败", e);
		}
		
		_logger.info("报文bean转换成功,开始远程调用");
		BatchDeductResponseSendBean response = service.dealEcesBatchAccountResponse(recvBean);
		
		_logger.info("远程调用完毕,开始将响应bean转换成报文数据");
		
		byte[] respData = null;
		try {
			respData = sendMapping.beanToBytes(response);
		} catch (Exception e) {
			_logger.error("转换后台交易系统返回的响应bean为xml二进制数据时异常,本次批量报文回盘处理结束");
			throw e;
		}
		
		try {
			File sendXmlFile = new File(this.sendFileDir, "ECES_RESP_SEND_" + recvBean.getHeader().getBatchNo() + "_" + token + ".xml");
			FileUtils.writeByteArrayToFile(sendXmlFile, respData);
			_logger.info("ECES响应回执报文保存成功, 路径为{}", sendXmlFile.getAbsolutePath());
		} catch (Exception e) {
			_logger.error("ECES响应回执报文保存失败", e);
		}
		
		
		_logger.info("响应报文数据转换成功,开始响应");
		byte[] MD5 = ByteUtils.binaryToHexString(MD5Util.caculate(respData)).getBytes();
		
		int respLength = respData.length;
		
		// 报文最前面是8位的报文长度
		String lengthStr = ("00000000" + respLength);
		lengthStr = lengthStr.substring(lengthStr.length() - 8);
		
		// 写长度头
		os.write(lengthStr.getBytes());
		// 写系统别
		os.write(SystemParameterHelper.getParam("SYSTEM.BATCH.SYSCODE").getBytes());
		os.write("0020".getBytes());
		os.write(MD5);
		os.write(respData);
		
		os.flush();
		
		_logger.info("批量报文响应完毕, 本次回盘处理结束");
	}

	/**
	 * 保证文件保存的目录已经创建
	 */
	private void ensureFileSaveDir() {

		String dateStr = DateUtils.getDateStrNO();

		// 创建文件要保存的目录, recv目录下按yyyyMMdd再进行一次子目录分级
		File recvDir = new File(SYS.MSG_RECV_PATH, dateStr);
		File sendDir = new File(SYS.MSG_SEND_PATH, dateStr);

		// 如果目录已经存在,则不需要创建
		if (!recvDir.exists()) {
			recvDir.mkdirs();
		}

		if (!sendDir.exists()) {
			sendDir.mkdirs();
		}

		// 保存处理信息
		this.recvFileDir = recvDir;
		this.sendFileDir = sendDir;
	}
	
}
