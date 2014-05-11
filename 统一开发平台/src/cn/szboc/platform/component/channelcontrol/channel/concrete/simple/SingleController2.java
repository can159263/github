package cn.szboc.platform.component.channelcontrol.channel.concrete.simple;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**===================================================================================
 *	单个类型控制通道,可以设定通道初始并发数来支持对同一种类型资源的并发争夺
 *	@author xinglu 2011-3-17 20:00:54
 *	=================================================================================*/
public class SingleController2 {
	
	/**
	 * 同步时需要的简单对象
	 */
	private static final Object o = new Object();
	
	/**
	 * 允许并发的最大数量
	 */
	BlockingQueue<Object> que;
	
	/**
	 * 初始函数,为防止传入负数,内部对通道数做了取绝对值处理
	 * @param maxQuantity
	 */
	public SingleController2(int maxQuantity){
		if(maxQuantity <= 0){
			throw new IllegalArgumentException("maxQuantity必须是正整数");
		}
		que = new ArrayBlockingQueue<Object>(maxQuantity);
	}
	
	/**
	 * 申请报文通道
	 * @throws InterruptedException 
	 */
	public void applyChannel() throws InterruptedException{
		que.take();
	}

	/**
	 * 释放报文通道
	 * @throws InterruptedException 
	 */
	public void freeChannel() throws InterruptedException{
		que.put(o);
	}
	
}



