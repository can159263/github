package cn.szboc.uniformproxy.frontend.server.handler.handler;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelConfig;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.szboc.platform.commons.ByteUtils;
import cn.szboc.uniformproxy.frontend.server.ChannelResponseCode;
import cn.szboc.uniformproxy.frontend.server.MessageProcessorTask;
import cn.szboc.uniformproxy.frontend.system.SysReg;
import cn.szboc.uniformproxy.frontend.system.SystemConfigBean;

/**
 * 对于字节报文数据的处理
 */
public class MessageDataHandler extends SimpleChannelHandler {

	/** 日志 */
	private static Logger logger = LoggerFactory.getLogger(MessageDataHandler.class);

	/** 任务池(容量20) */
	private static ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 20, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

	/** 执行的交易任务 */
	private MessageProcessorTask task;

	private static int maxConcurrenceSize = 100;

	private static String systemCode;

	/** 超过流量负载时的提示性语句 */
	private static byte[] limitInfoInBytes;

	private static String info = "System load is too heavy, the message handling be ignored, please try again later !";
	
	// 初始化必要预置信息
	static {

		// 初始化limitInfoInBytes
		int length = info.getBytes().length;
		byte[] byteLength = new byte[4];
		byteLength[0] = (byte) ((length >>> 24) & 0xFF);
		byteLength[1] = (byte) ((length >>> 16) & 0xFF);
		byteLength[2] = (byte) ((length >>> 8) & 0xFF);
		byteLength[3] = (byte) ((length >>> 0) & 0xFF);

		SystemConfigBean cfgBean = SysReg.sysCfg();
		systemCode = cfgBean.getSystemCode();

		// 初始化当超出处理能力时,要返回的异常信息
		limitInfoInBytes = ByteUtils.byteJoin(systemCode.getBytes(), ChannelResponseCode.EXP_EXCESSIVE_FLOW.value().getBytes(), byteLength, info.getBytes());
	}
	
	/**
	 * 报文处理的统一入口
	 */
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {

		Channel channel = ctx.getChannel();

		// 获取系统中等待队列长度
		int concurrenceSize = executor.getQueue().size();

		// 判断并发压力
		if (concurrenceSize >= maxConcurrenceSize) {

			logger.info("当前系统等待处理任务已达到{},超过阈值,此次交易被忽略,提前返回!", concurrenceSize);

			channel.write(ChannelBuffers.wrappedBuffer(limitInfoInBytes)).addListener(new ChannelFutureListener() {

				@Override
				public void operationComplete(ChannelFuture future) throws Exception {
					future.getChannel().close();
				}

			});

			return;
		}

		// 否则转成任务并放入池中等待处理
		byte[] message = (byte[]) e.getMessage();

		// 创建报文处理任务
		task = new MessageProcessorTask(channel, message);

		// 放入线程池中,由任务进行调度
		executor.execute(task);

		// 至此前置Netty任务转发完成,任务完成后会自行关闭Channel
	}

	/**
	 * 发生异常时,要关闭通道
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {

		logger.error("捕获到通道发生异常,准备开始关闭通道", e.getCause());

		// step1.对外关闭连接
		try {
			String info = e.getCause().getMessage();
			if(StringUtils.isEmpty(info)){
				info = "报文处理未知异常";
			}
			byte[] infos = info.getBytes("UTF-8");
			byte[] sendData = ByteUtils.byteJoin(systemCode.getBytes(), ChannelResponseCode.EXP_OTHER.value().getBytes(), ByteUtils.transformInteger(infos.length), infos);
			ChannelBuffer buffer = ChannelBuffers.wrappedBuffer(sendData);
			e.getChannel().write(buffer).addListener(new ChannelFutureListener() {
				
				@Override
				public void operationComplete(ChannelFuture future) throws Exception {
					future.getChannel().close();
					
				}
			});
		} catch (Exception e2) {
			logger.error("通道关闭失败", e2);
		} finally {
			logger.error("发生异常的通道对应的远程地址是{}", new Object[] { ctx.getChannel().getRemoteAddress() });
		}

		// step2.尝试线程池中的未提交任务
		if (task != null) {
			if (executor.remove(task)) {
				logger.info("任务并未运行,已删除");
			} else {
				logger.info("任务已经运行,暂时无法删除");
				// 此处应对记录相关事宜,待完善,如果账务已经完成,这种情况要依赖外围系统的对账进行处理,因为已经切断了Channel
			}
		}
	}

}
