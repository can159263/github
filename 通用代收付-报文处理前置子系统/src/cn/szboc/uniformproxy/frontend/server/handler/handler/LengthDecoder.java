package cn.szboc.uniformproxy.frontend.server.handler.handler;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.szboc.uniformproxy.frontend.server.handler.exception.ReceiveSizeExceededException;
import cn.szboc.uniformproxy.frontend.server.handler.exception.ReceiveSizeIllegalException;

/**
 * 长度解码器,按照报文约定,报文头4字节是后续报文长度标志,返回后续缓存字节数组
 */
public class LengthDecoder extends FrameDecoder {

    /** 固定的报文头长度,禁止修改此参数,否则影响代码里面的readInt()方法,此方法固定就是读4个字节 */
    public static final int headInfoSize = 4;

    /** 日志 */
    private static Logger logger = LoggerFactory.getLogger(LengthDecoder.class);

    /** 最大字节长度(后续报文),超过该流量视为异常报文 */
    private int readMaxLength;

    private String identityHashCode = "LengthDecoder.identity:" + System.identityHashCode(this);

    /**
     * 唯一构造函数
     * 
     * @param messageHeadLength
     *            报文头长度信息头
     * @param readMaxLength
     *            最大读取字节数
     */
    public LengthDecoder(int readMaxLength) {

        this.readMaxLength = readMaxLength;
        logger.info("{}长度解码器头部长度字节数为{}, 并且限制了最大的报文长度{}", new Object[] { identityHashCode, headInfoSize, this.readMaxLength });

    }

    /** 是否已经读完头部长度 */
    private boolean headLengthAlreadyReaded = false;

    /** 预计要读取的后续报文长度,(MD5+压缩(加密))总长度,不含报文头长度信息字节,即报文头长度信息字节转成的int值 */
    private int totalLengthExpect = 0;

    /** 本次connection连接成功后已经读取的字节长度,不包括报文头长度信息字节 */
    private int lengthReadedNotIncHead = 0;

    /** 缓存(由于限制了流的长度,屏蔽了大容量报文的可能性,故这里使用内存块来缓存报文,而不必担心内存溢出) */
    private ByteArrayOutputStream cache = new ByteArrayOutputStream();

    /**
     * 解析头部4字节长度
     */
    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {

        // 没有读完头部并且可读字节少于4个
        if (!headLengthAlreadyReaded && buffer.readableBytes() < headInfoSize) {
            return null;
        }

        // 可读字节超过4个,且还没有设置读完四个字节,那么开始计算报文长度头
        if (!headLengthAlreadyReaded) {
            totalLengthExpect = buffer.readInt();
            headLengthAlreadyReaded = true;
            logger.info("{}服务器收到的报文总长度标识{}", new Object[] { identityHashCode, totalLengthExpect });
        }

        if (totalLengthExpect > readMaxLength) {
            logger.error("{}网络接收发现超大报文长度值{}, 超出了系统阈值{}, 本次网络连接视为异常, 终止处理, 远程地址为{}", new Object[] { identityHashCode, totalLengthExpect,
                    readMaxLength, ctx.getChannel().getRemoteAddress() });
            throw new ReceiveSizeExceededException(totalLengthExpect, readMaxLength, "超出流量大小标识");
        }

        return cacheData(ctx, channel, buffer);

    }

    /**
     * 处理小量的字节
     * 
     * @param ctx
     * @param channel
     * @param buffer
     * @return 如果没有读够数据,则返回null,否则返回具体数据
     * @throws Exception
     */
    private byte[] cacheData(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {

        // 本次读取的长度
        int readableLength = buffer.readableBytes();

        // 递增已经读取的总长度
        this.lengthReadedNotIncHead += readableLength;

        // 如果预判总长度读取非法超限,则判断非法报文
        if (this.totalLengthExpect < this.lengthReadedNotIncHead) {
            logger.error("{}网络接收实际长度值{}, 超出了长度头{}, 本次网络连接视为异常, 终止处理, 远程地址为{}", new Object[] { identityHashCode, lengthReadedNotIncHead, totalLengthExpect,
                    ctx.getChannel().getRemoteAddress() });
            throw new ReceiveSizeIllegalException(lengthReadedNotIncHead, totalLengthExpect, "超出报文预计长度");
        }

        // 缓存数据
        if (this.totalLengthExpect >= this.lengthReadedNotIncHead) {
            byte[] dst = new byte[buffer.readableBytes()];
            buffer.readBytes(dst);
            // 继续缓存
            cache.write(dst);
        }
        
        // 如果还没达到总长度,则先缓存一下,然后返回null表示还需要进一步读取
        if(this.totalLengthExpect > this.lengthReadedNotIncHead){
        	return null;
        } else {
        	// 否则刚好到达
        	return cache.toByteArray();
        }
    }

    /**
     * 异常传递给下个handler进行处理,如果只有此一个handler,要注意关闭channel
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        super.exceptionCaught(ctx, e);
    }
}
