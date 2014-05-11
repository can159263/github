package cn.szboc.platform.component.channelcontrol.channel.concrete.context;

import java.util.HashMap;
import java.util.Map;

import cn.szboc.platform.component.channelcontrol.channel.concrete.simple.SingleController;
import cn.szboc.platform.component.channelcontrol.channel.exception.ChannelAlreadyUsedException;

/**
 * 可以同时控制多个通道资源的并发
 * @author xinglu 2011-3-17 21:02:48
 */
public class MultiContextController {
	private Map<String, SingleController> controlMap;

	public MultiContextController() {
		controlMap = new HashMap<String, SingleController>();
	}

	/**
	 * 注册报文通道
	 */
	public void regeditChannel(String channelName, int maxQuantity, Map context)
			throws ChannelAlreadyUsedException {
		if (!controlMap.containsKey(channelName)) {
			synchronized (this) {
				if (!controlMap.containsKey(channelName)) {
					SingleController controller = new SingleController(
							maxQuantity);
					controlMap.put(channelName, controller);
				} else {
					throw new ChannelAlreadyUsedException("channel["
							+ channelName + "] already regedited");
				}
			}
		} else {
			throw new ChannelAlreadyUsedException("channel[" + channelName
					+ "] already regedited");
		}

	}

	/**
	 * 申请报文通道
	 */
	public void applyChannel(String channelName) {
		controlMap.get(channelName).applyChannel();
	}

	/**
	 * 释放报文通道
	 */
	public void freeChannel(String channelName) {
		controlMap.get(channelName).freeChannel();
	}
}
