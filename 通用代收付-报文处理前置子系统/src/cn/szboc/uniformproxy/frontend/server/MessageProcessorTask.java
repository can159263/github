package cn.szboc.uniformproxy.frontend.server;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.xml.sax.SAXParseException;

import cn.szboc.platform.commons.ByteUtils;
import cn.szboc.platform.commons.DateUtils;
import cn.szboc.uniformproxy.frontend.server.postprocessor.PostProcessor;
import cn.szboc.uniformproxy.frontend.server.preprocess.PreProcessor;
import cn.szboc.uniformproxy.frontend.server.preprocess.exception.DesParseException;
import cn.szboc.uniformproxy.frontend.server.preprocess.exception.InflateParseException;
import cn.szboc.uniformproxy.frontend.server.preprocess.exception.MD5ParseException;
import cn.szboc.uniformproxy.frontend.server.process.processor.Processor;
import cn.szboc.uniformproxy.frontend.server.process.processor.ProcessorFactory;
import cn.szboc.uniformproxy.frontend.server.process.processor.bean.MessageBeanInfo;
import cn.szboc.uniformproxy.frontend.system.SYS;
import cn.szboc.uniformproxy.frontend.system.SysReg;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESULTCODE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TTRANSMSGTYPE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

/**
 * 报文处理任务
 * 每一次任务处理一笔报文
 */
public class MessageProcessorTask implements Runnable {

	/**
	 * 日志组件
	 */
	private static Logger _logger = LoggerFactory.getLogger(MessageProcessorTask.class);

	
	public static final int minLength = 16;
	
	/**
	 * 用于标记唯一任务处理
	 */
	private final String token = RandomStringUtils.randomAlphabetic(20);

	/**
	 * 报文ID
	 */
	private String msgId;

	/**
	 * 请求文件目录
	 */
	private File recvFileDir;

	/**
	 * 响应文件目录
	 */
	private File sendFileDir;

	/**
	 * 接收到的原始报文信息所保存的文件
	 */
	private File recvRawFile;

	/**
	 * 请求报文
	 */
	private File recvXmlFile;

	/**
	 * 响应报文
	 */
	private File sendXmlFile;

	/**
	 * 报文交易类型
	 */
	private TTRANSMSGTYPE msgType;

	/**
	 * 前置处理器
	 */
	private PreProcessor preProcessor = SysReg.getPreProcessor();

	/**
	 * 后置处理器
	 */
	private PostProcessor postProcessor = SysReg.getPostProcessor();

	/**
	 * IO通道
	 */
	private Channel channel;

	/**
	 * 接收到的报文信息
	 */
	private byte[] requestRawData;
	
	/**
	 * 返回码
	 */
	private TRESULTCODE rtnCode;

	/**
	 * 构造函数
	 * @param channel 物理链路通道
	 * @param message 二进制报文(原始未解密的报文(MD5+压缩格式))
	 */
	public MessageProcessorTask(Channel channel, byte[] requestRawData) {

		if (channel == null) {
			throw new IllegalArgumentException("通道不能为null");
		} else {
			this.channel = channel;
		}

		if (requestRawData == null) {
			throw new IllegalArgumentException("消息实体不能为null");
		} else {
			this.requestRawData = requestRawData;
		}


		// 检查消息长度
		if (requestRawData.length <= minLength) {
			_logger.error("报文处理任务处理原始请求二进制数据不能低于{}个字节,而接收到的报文长度为{}", new Object[] { minLength, requestRawData.length });
			throw new IllegalArgumentException("报文处理任务处理原始请求二进制数据不能低于" + minLength + "个字节");
		}

	}

	@Override
	public void run() {

		MDC.put("TOKEN", token);

		try {
			_logger.info("报文处理开始");
			this.process();
		} catch (Throwable t) {
			this.processError(ChannelResponseCode.EXP_OTHER, "服务器端报文处理异常", t);
		} finally {
			_logger.info("报文处理结束");
			MDC.clear();
		}
	}

	/**
	 * 处理方法
	 * 
	 * @return
	 * @throws MessageProcessException
	 */
	public void process() throws Exception {

		// 保证文件要存储的目录已经存在
		ensureFileSaveDir();

		// 如果需要保存原始请求数据,则保存
		if (SysReg.sysCfg().isSaveRawData()) {
			saveRecvRawData();
		}

		byte[] requestXmlData = null;
		// 调用前置处理器进行解码
		try {
			requestXmlData = preProcessor.decode(requestRawData);
		} catch (Exception e) {
			// 判断异常类型决定返回码
			if (e instanceof MD5ParseException) {
				processError(ChannelResponseCode.EXP_MD5, "服务器接收数据MD5校验异常", e);
			} else if (e instanceof InflateParseException) {
				processError(ChannelResponseCode.EXP_INFLATE, "服务器接收数据解压缩异常", e);
			} else if (e instanceof DesParseException) {
				processError(ChannelResponseCode.EXP_DES, "服务器接收数据解密解密异常", e);
			} else {
				processError(ChannelResponseCode.EXP_OTHER, "服务器端未知异常", e);
			}
			return;
		}

		// 解码后保存xml明文文件
		saveRecvXmlMessage(requestXmlData);

		// 调用前置处理器对xml数据进行转换
		CommonRequestMessage requestBean = null;
		try {
			requestBean = preProcessor.process(requestXmlData);
		} catch (Exception e) {

			// 获取最里面的异常
			Throwable t = e;
			while (t.getCause() != null) {
				t = t.getCause();
			}

			// 如果是xml报文解析异常,则要返回实际的内部错误信息
			if (t instanceof SAXParseException) {
				processError(ChannelResponseCode.EXP_XML_PARSE, t.getMessage(), e);
			} else {
				processError(ChannelResponseCode.EXP_XML_PARSE, "解析XML报文未知异常", e);
			}

			return;
		}
		
		// 成功获取msgId,用于打印日志MDC
		this.msgId = requestBean.getHEAD().getMSGID();
		this.msgType = requestBean.getTransType();

		MDC.put("MSG_ID", this.msgId);
		MDC.put("MSG_TYPE", this.msgType.value());
		_logger.info("请求报文ID与报文类型已解析完毕,准备重命名XML报文");

		// 获取msgId后重命名文件,包括原始数据文件(有开关控制)和xml报文
		this.renameRequestFile();

		// 获取交易处理器
		final Processor processor = ProcessorFactory.getProcessor(this.msgType);

		// 调用处理器进行处理
		final CommonResponseMessage responseBean;
		try {
			// 调用通用处理逻辑
			responseBean = processor.commonProcess(requestBean, this.recvXmlFile.getAbsolutePath());
			// 此处统一设置响应报文的时间与报文头
			responseBean.getHEAD().setSENDTIMESTAMP(new Date());
			responseBean.getHEAD().setSYSCODE(requestBean.getHEAD().getSYSCODE());
		} catch (Throwable t) {
			processError(ChannelResponseCode.EXP_OTHER, "服务器端交易处理异常", t);
			return;
		}

		rtnCode = responseBean.getHEAD().getRESULTCODE();
		
		// 响应数据
		byte[] xmlData;
		byte[] responseData;

		// bean转xml
		try {
			xmlData = postProcessor.process(responseBean);
		} catch (Exception e) {
			processError(ChannelResponseCode.EXP_OTHER, "服务器端未知异常", new Exception("响应Bean转换xml数据时发生异常", e));
			return;
		}

		// 保存响应明文XML文件
		try {
			this.saveSendXmlMessage(xmlData);
		} catch (Exception e) {
			_logger.error("服务器保存发送XML报文异常,msg_id为{}", requestBean.getHEAD().getMSGID());
		}

		// 转码
		try {
			responseData = postProcessor.decode(xmlData);

		} catch (Exception e) {
			processError(ChannelResponseCode.EXP_OTHER, "服务器端未知异常", new Exception("响应XML数据转码失败", e));
			return;
		}

		// 保存响应编码后的文件
		try {
			if (SysReg.sysCfg().isSaveRawData()) {
				saveSendRawData(responseData);
			}

		} catch (Exception e) {
			_logger.error("服务器保存发送二进制编码后的数据报文异常,msg_id为{}", requestBean.getHEAD().getMSGID());
		}

		// 创建响应缓冲
		ChannelBuffer buffer;
		try {
			byte[] writeData = ByteUtils.byteJoin(SYS.CODE_IN_BYTES, ChannelResponseCode.NORMAL.value().getBytes(),
					ByteUtils.transformInteger(responseData.length), responseData);
			buffer = ChannelBuffers.wrappedBuffer(writeData);
		} catch (Throwable t) {
			processError(ChannelResponseCode.EXP_OTHER, "创建响应数据时异常", t);
			return;
		}

		if (!channel.isConnected()) {
			_logger.error("报文处理完成,生成响应报文后,准备响应时,发现通道已经关闭");
			try {
				channel.close();
			} catch (Exception e) {
				_logger.error("channel关闭异常");
			}

			return;
		}

		channel.write(buffer).addListener(new ChannelFutureListener() {

			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				
				MDC.put("TOKEN", token);
				MDC.put("MSG_ID", msgId);
				MDC.put("MSG_TYPE", msgType.value());
				
				if (future.isSuccess()) {
					_logger.info("报文响应成功");
				} else {
					_logger.error("报文响应异常", future.getCause());
				}
				
				try {
					
					MessageBeanInfo bean = new MessageBeanInfo();
					bean.setSysCode(SYS.CODE);
					bean.setMsgId(msgId);
					bean.setSendDatetime(new Date());
					bean.setSendPath(sendXmlFile.getAbsolutePath());
					bean.setRetCode(rtnCode.value());
					bean.setMsgSendDatetime(new Date());
					processor.logResponse(bean);
					
				} catch (Exception e) {
					_logger.error("更新响应报文信息异常", e);
				} finally {
					future.getChannel().close();
					_logger.info("通道异步关闭");
				}
				
				MDC.clear();
			}
		});

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

	/**
	 * 保存原始报文数据(未处理前的二进制数据)
	 * 
	 * @param dir
	 * @return
	 * @throws Exception
	 */
	private void saveRecvRawData() throws Exception {

		// 创建临时文件
		this.recvRawFile = File.createTempFile("recv", ".raw", this.recvFileDir);
		String tmpFilePath = this.recvRawFile.getAbsolutePath();

		_logger.info("原始数据临时文件创建成功,路径为{}", tmpFilePath);

		try {
			FileUtils.writeByteArrayToFile(this.recvRawFile, requestRawData);
		} catch (IOException e) {
			_logger.error("保存报文到临时文件失败", e);
			throw new Exception("保存报文到临时文件失败");
		}

		_logger.info("原始数据写入成功, 目标文件路径为{}", tmpFilePath);
	}

	/**
	 * 保存二进制响应数据
	 * 本函数不外抛异常
	 * @throws Exception
	 */
	private void saveSendRawData(byte[] data) throws Exception {

		// 时间戳
		String datetime = DateUtils.getDateTimeStrNo();

		// 新报文名称,加入时间戳和随机数,防止同一个报文
		StringBuilder rawFileName = new StringBuilder("send_").append(datetime).append("_").append(this.msgId).append("_").append(this.token)
				.append(".raw");

		File targetRawFile = new File(this.sendFileDir, rawFileName.toString());

		FileUtils.writeByteArrayToFile(targetRawFile, data);

		_logger.info("响应报文编码后的数据写入文件成功, 目标文件路径为{}", targetRawFile.getAbsolutePath());
	}

	/**
	 * 保存接收的XML报文
	 * 
	 * @throws Exception
	 */
	private void saveRecvXmlMessage(byte[] xmlData) throws Exception {

		// 创建临时文件保存原始数据
		this.recvXmlFile = File.createTempFile("recv_", ".xml", this.recvFileDir);

		String xmlFilePath = this.recvXmlFile.getAbsolutePath();

		_logger.info("xml格式临时数据文件创建成功,路径为{}", xmlFilePath);

		try {
			FileUtils.writeByteArrayToFile(this.recvXmlFile, xmlData);
		} catch (IOException e) {
			_logger.error("xml格式临时数据文件写入失败", e);
			throw new MessageProcessException("xml格式临时数据文件写入失败");
		}

		_logger.info("xml格式临时数据文件写入成功, 生成的临时文件路径为{}", xmlFilePath);
	}

	/**
	 * 保存回送的XML报文
	 * 
	 * @throws Exception
	 */
	private void saveSendXmlMessage(byte[] xmlData) throws Exception {

		// 时间戳
		String datetime = DateUtils.getDateTimeStrNo();

		// 新报文名称,加入时间戳和随机数,防止同一个报文
		StringBuilder xmlFileName = new StringBuilder("send_").append(datetime).append("_").append(this.msgId).append("_").append(this.token)
				.append(".xml");

		// 要保存的最终文件
		this.sendXmlFile = new File(this.sendFileDir, xmlFileName.toString());

		String xmlFilePath = this.sendXmlFile.getAbsolutePath();

		_logger.info("xml格式响应文件创建成功,路径为{}", xmlFilePath);

		try {
			FileUtils.writeByteArrayToFile(this.sendXmlFile, xmlData);
		} catch (IOException e) {
			_logger.error("xml格式响应文件创建成功", e);
			throw new MessageProcessException("xml格式响应文件创建成功");
		}

		_logger.info("xml格式响应文件写入成功, 生成的文件路径为{}", xmlFilePath);
	}

	/**
	 * 重命名请求文件,包括原始二进制文件和xml文件
	 * 加入了MSG_ID信息与MSG_TYPE信息,方便查找
	 * @throws Exception
	 */
	public void renameRequestFile() throws Exception {

		// 时间戳
		String datetime = DateUtils.getDateTimeStrNo();

		// 新报文名称,加入时间戳和随机数,防止同一个报文
		StringBuilder rawFileName = new StringBuilder("recv_").append(datetime).append("_").append(this.msgId).append("_").append(this.token)
				.append("_").append(this.msgType.value()).append(".raw");

		StringBuilder xmlFileName = new StringBuilder("recv_").append(datetime).append("_").append(this.msgId).append("_").append(this.token)
				.append("_").append(this.msgType.value()).append(".xml");

		// 要保存的最终文件
		File rawTargetFile = new File(this.recvFileDir, rawFileName.toString());
		File xmlTargetFile = new File(this.recvFileDir, xmlFileName.toString());

		if (SYS.IS_SAVE_RAW_DATA) {
			_logger.info("原始请求报文重命名,最终原始报文路径修改为{}", rawTargetFile.getAbsolutePath());
			if (!this.recvRawFile.renameTo(rawTargetFile)) {
				_logger.error("原始请求报文重命名修改失败,此日志仅作记录");
			}
		}

		if (this.recvXmlFile.renameTo(xmlTargetFile)) {
			this.recvXmlFile = xmlTargetFile;
			_logger.info("XML报文重命名成功,目标xml报文路径改为{}", xmlTargetFile.getAbsolutePath());
		} else {
			_logger.error("XML报文重命名失败,目标xml报文路径改为{}", xmlTargetFile.getAbsolutePath());
			throw new Exception("报文重命名失败");
		}

	}

	/**
	 * 将返回信息错误信息打包成字节数组  (4位系统码 +2位响应码+4位长度+不定长明文数据)
	 * 
	 * @param respCode
	 * @param info
	 * @return
	 * @throws Exception 
	 */
	private byte[] packRtnMsg(ChannelResponseCode respCode, String info) throws Exception {
		if (StringUtils.isEmpty(info)) {
			throw new IllegalArgumentException("返回信息不能为空");
		}

		byte[] systemCodeInBytes = SYS.CODE_IN_BYTES;
		byte[] respBytes = respCode.value().getBytes();
		byte[] infoInBytes = info.getBytes("UTF-8");
		byte[] lengthInBytes = ByteUtils.transformInteger(infoInBytes.length);
		byte[] rtn = ByteUtils.byteJoin(systemCodeInBytes, respBytes, lengthInBytes, infoInBytes);

		return rtn;
	}

	/**
	 * 处理报文通信时的各种异常情况,该情况适用于使用通道响应码不为成功的情况
	 * 
	 * @param respCode
	 * @param errorInfo
	 * @param t
	 */
	private void processError(ChannelResponseCode respCode, final String errorInfo, Throwable t) {

		_logger.error("报文处理异常:" + errorInfo, t);

		ChannelBuffer buffer = null;

		// 组装响应数据
		try {
			byte[] writeData = packRtnMsg(respCode, errorInfo);
			buffer = ChannelBuffers.wrappedBuffer(writeData);
		} catch (Throwable tx) {
			_logger.error("报文处理异常后,输出异常响应流时再次发生异常,准备强制关闭报文通道", tx);
			channel.close();
		}

		// 输出响应
		channel.write(buffer).addListener(new ChannelFutureListener() {

			@Override
			public void operationComplete(ChannelFuture future) throws Exception {

				// 该段代码可能在不同线程中执行,故需要手工输出token标记
				if (future.isSuccess()) {
					_logger.info("数据输出正常完毕, TOKEN:[{}]", token);
				} else {
					_logger.error("数据输出异常, TOKEN:[{" + token + "}]", future.getCause());
				}

				_logger.error("准备关闭通信通道, TOKEN:[{}]", token);

				future.getChannel().close().addListener(new ChannelFutureListener() {

					@Override
					public void operationComplete(ChannelFuture future) throws Exception {
						if (future.isSuccess()) {
							_logger.info("通信通道顺利关闭, TOKEN:[{}]", token);
						} else {
							_logger.error("通信通道关闭异常, TOKEN:[{" + token + "}]", future.getCause());
						}
					}
				});
			}
		});

	}

}
