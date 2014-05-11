package cn.szboc.platform.component.channelcontrol.channel.exception;

public class ChannelInterruptedException extends RuntimeException {
	
	public ChannelInterruptedException() {
		super();
	}

	public ChannelInterruptedException(String message, java.lang.InterruptedException e) {
		super(message, e);
	}

	public ChannelInterruptedException(String message) {
		super(message);
	}

	public ChannelInterruptedException(java.lang.InterruptedException e) {
		super(e);
	}
}
