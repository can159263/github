package cn.szboc.platform.component.channelcontrol.channel;

import java.util.concurrent.TimeoutException;

public interface Controller {
	public void setMaxQuantity();
	public void queue();
	public void queueNoWait(long millis) throws TimeoutException;
}
