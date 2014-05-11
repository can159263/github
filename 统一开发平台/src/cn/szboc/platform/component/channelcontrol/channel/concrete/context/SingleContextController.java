package cn.szboc.platform.component.channelcontrol.channel.concrete.context;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import cn.szboc.platform.component.channelcontrol.channel.exception.ChannelInterruptedException;

/**===================================================================================
 *	单个类型控制通道,可以设定通道初始并发数来支持对某一种类型资源的并发争夺
 *	@author xinglu 2011-3-17 20:00:54
 *	=================================================================================*/
public class SingleContextController {
	
	/**
	 * 允许并发的最大数量
	 */
	private int _maxQuantity;
	
	/**
	 * 当前已被占用的数量
	 */
	private int _usedQuantity;
	
	/**
	 * 通道上下文
	 */
	private Map _context;
	
	/**
	 * 初始函数,为防止传入负数,内部对通道数做了取绝对值处理
	 * @param maxQuantity	通道最大容量
	 * @param context	初始化上下文,如果传入null,则默认给一个空的Map
	 */
	public SingleContextController(int maxQuantity, Map context){
		if(maxQuantity <= 0){
			throw new IllegalArgumentException("maxQuantity必须是正整数");
		}
		_usedQuantity = 0;
		_maxQuantity = maxQuantity;
		_context = Collections.synchronizedMap(new HashMap());
		_context.putAll(context);
	}
	
	/**
	 * 申请报文通道
	 */
	public Map applyChannel(){
		synchronized (this) {
			while(_usedQuantity == _maxQuantity){
				//释放当前资源并等待被唤醒重新争夺资源
				try {
					wait();
				} catch (java.lang.InterruptedException e) {
					throw new ChannelInterruptedException("等待通道数时被打断", e);
				}
			}
			_usedQuantity++;
			return _context;
		}
	}

	/**
	 * 释放报文通道
	 */
	public Map freeChannel(){
		synchronized (this) {
			if(_usedQuantity-- == _maxQuantity){
				notifyAll();
			}
			return _context;
		}
	}
	
}
