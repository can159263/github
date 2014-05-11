package cn.szboc.platform.component.channelcontrol.channel.concrete.simple;


/**===================================================================================
 *	单个类型控制通道,可以设定通道初始并发数来支持对同一种类型资源的并发争夺
 *	@author xinglu 2011-3-17 20:00:54
 *	=================================================================================*/
public class SingleController {
	
	/**
	 * 允许并发的最大数量
	 */
	private int _maxQuantity;
	
	/**
	 * 当前已被占用的数量
	 */
	public int _usedQuantity;
	
	/**
	 * 构造函数
	 * @param maxQuantity  最大容量
	 */
	public SingleController(int maxQuantity){
		if(maxQuantity <= 0){
			throw new IllegalArgumentException("maxQuantity必须是正整数");
		}
		_usedQuantity = 0;
		_maxQuantity = maxQuantity;
	}
	
	/**
	 * 申请报文通道
	 */
	public void applyChannel(){
		synchronized (this) {
			while(_usedQuantity == _maxQuantity){
				//释放当前资源并等待被唤醒重新争夺资源
				try {
					wait();
				} catch (InterruptedException e) {
					//若被打断,则直接返回
					return;
				}
			}
			//如果中断标志已经被置,则不进行再申请资源,直接返回
			if(!Thread.currentThread().isInterrupted()){
				_usedQuantity++;
			}
		}
	}
	
	/**
	 * 外围调用者申请通道,带有超时限制,预期则返回,不再一直等待
	 * @param millis 毫秒数
	 * @return 如果取得权限,则返回true,否则返回false
	 */
	public boolean applyChannel(long millis){
		synchronized (this) {
			if(_usedQuantity == _maxQuantity){
				//释放当前资源并等待被唤醒重新争夺资源
				try {
					wait(millis);
				} catch (InterruptedException e) {
					//若被打断,则直接返回
					return false;
				}
				
				if(_usedQuantity == _maxQuantity){
					return false;
				}
			}
			//如果中断标志已经被置,则不进行再申请资源,直接返回
			if(!Thread.currentThread().isInterrupted()){
				_usedQuantity++;
			}
			return true;
		}
	}

	/**
	 * 释放报文通道
	 */
	public void freeChannel(){
		synchronized (this) {
			if(_usedQuantity-- == _maxQuantity){
				notifyAll();
			}
		}
	}
	
}
