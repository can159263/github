package cn.szboc.uniformproxy.frontend.server;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.szboc.uniformproxy.frontend.server.handler.handler.LengthDecoder;
import cn.szboc.uniformproxy.frontend.server.handler.handler.MessageDataHandler;
import cn.szboc.uniformproxy.frontend.server.handler.handler.SystemCodeHeadDecoder;

/**
 * 用Netty实现的消息接收服务器
 */
public class MessageRecvNettyServer {

	private static Logger logger = LoggerFactory.getLogger(MessageRecvNettyServer.class);

	/**
	 * 报文最大长度,单位字节
	 */
	private int maxLength;

	/**
	 * 监听IP
	 */
	private String lstnIp;

	/**
	 * 监听端口
	 */
	private int lstnPort;

	/**
	 * 服务启动器
	 */
	private ServerBootstrap bootstrap;

	/**
	 * 通道组,用于关闭通道
	 */
	private ChannelGroup allChannels = new DefaultChannelGroup();

	/**
	 * 要监听的TCP端口(支持多个)
	 * 
	 * @param LSTN_PORT
	 */
	public MessageRecvNettyServer(final String systemCode, int maxLength, String ip, int port) {

		// 扩大1024*1024倍
		this.maxLength = maxLength * 1024 * 1024;
		String display = FileUtils.byteCountToDisplaySize(this.maxLength);

		logger.info("服务器最大容忍单次报文长度是{}", display);

		final int mxLength = this.maxLength;

		this.lstnIp = ip;
		this.lstnPort = port;

		bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));

		bootstrap.setPipelineFactory(new ChannelPipelineFactory() {

			@Override
			public ChannelPipeline getPipeline() throws Exception {
				return Channels.pipeline(

						// 系统别解码器
						new SystemCodeHeadDecoder(allChannels, systemCode),

						// 长度头解码器
						new LengthDecoder(mxLength),

						// 数据处理器
						new MessageDataHandler());

			}

		});

	}

	/**
	 * 开始监听
	 */
	public void start() {
		if (this.lstnIp == null) {
			bootstrap.bind(new InetSocketAddress(this.lstnPort));
			logger.info("报文前置处理服务器已在所有IP上面绑定端口:{}", this.lstnPort);
		} else {
			bootstrap.bind(new InetSocketAddress(this.lstnIp, this.lstnPort));
			logger.info("报文前置处理服务器已绑定IP:{}和端口:{}", new Object[] { this.lstnIp, this.lstnPort });
		}
	}

	public void shutdown() {

		if (this.allChannels == null) {
			throw new IllegalStateException("服务器并未启动");
		}
		logger.info("等待所有通道关闭......");
		ChannelGroupFuture future = allChannels.close();
		future.awaitUninterruptibly();
		logger.info("所有通道已关闭,开始释放资源");
		bootstrap.releaseExternalResources();
		logger.info("资源已释放,服务关闭成功");
	}
}
