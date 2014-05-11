package cn.szboc.uniformproxy.frontend.server.handler.handler;


import java.util.Arrays;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.szboc.platform.commons.ArrayUtils;
import cn.szboc.uniformproxy.frontend.server.handler.exception.SystemCodeErrorException;

/**
 * 系统魔数解析器
 * IO流的头4个字节是系统别魔数,这个魔数是在系统启动的时候由Spring容器注入的
 * 必须校验该魔数已确定数据来源
 */
public class SystemCodeHeadDecoder extends FrameDecoder {

	private static Logger _logger = LoggerFactory.getLogger(SystemCodeHeadDecoder.class);
	
	/** 系统别的字符串形式 */
	private String systemCodeInString;
	
	/** 系统别的字节数组形式 */
	private byte[] systemCodeInBytes;

	/** 此方法固定就是读4个字节的系统别信息 */
	public static final int headInfoSize = 4;
	
	/** 保存通道组 */
	private ChannelGroup allChannels;

	/**
	 * 唯一构造函数
	 */
	public SystemCodeHeadDecoder(ChannelGroup allChannels, String systemCode) {
		if(allChannels == null){
			throw new IllegalArgumentException("通道组不能为空");
		}
		this.allChannels = allChannels;
		if (systemCode == null) {
			throw new IllegalArgumentException("系统别不能为空");
		}
		if (systemCode.length() != 4) {
			throw new IllegalArgumentException("系统别字符串长度必须为4位");
		}
		this.systemCodeInString = systemCode;

		this.systemCodeInBytes = this.systemCodeInString.getBytes();
		if (systemCodeInBytes.length != 4) {
			throw new IllegalArgumentException("系统别字节数组长度必须为4位");
		}
	}

	/** 是否已经校验完毕 */
	private boolean valid = false;

	

	@Override
	public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		// 添加到通道中
		allChannels.add(e.getChannel());
		_logger.info("远程新连接请求,来自" + ctx.getChannel().getRemoteAddress());
		super.channelOpen(ctx, e);
	}
	
	
	/**
	 * 解析头部4字节长度
	 */
	@Override
	protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {

		// 没有读完头部并且可读字节少于4个,则返回null表示继续期望获取
		if (!valid && buffer.readableBytes() < headInfoSize) {
			return null;
		}

		// 已经校验完毕后
		if (valid) {
			ChannelBuffer bufferRtn = ChannelBuffers.copiedBuffer(buffer);
			buffer.skipBytes(buffer.readableBytes());
			return bufferRtn;
		}

		byte[] systemCodeReceived = new byte[4];

		// 填充4个字节
		buffer.readBytes(systemCodeReceived);

		// 检测IO读入的系统别和合法系统别是否匹配
		if (Arrays.equals(this.systemCodeInBytes, systemCodeReceived)) {
			valid = true;
		} else {
			throw new SystemCodeErrorException("系统别异常!系统监控合法系统别为" + this.systemCodeInString + ",但实际读到的是:" + new String(systemCodeReceived)
					+ ",其字节表示为:" + ArrayUtils.dumpBytes(systemCodeReceived));
		}

		return buffer;

	}

	/**
	 * 异常传递给下个handler进行处理,如果只有此一个handler,要注意关闭channel
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		super.exceptionCaught(ctx, e);
	}
}
