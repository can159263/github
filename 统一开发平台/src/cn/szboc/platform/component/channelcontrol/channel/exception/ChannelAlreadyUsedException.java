package cn.szboc.platform.component.channelcontrol.channel.exception;

public class ChannelAlreadyUsedException extends RuntimeException {
	
	public ChannelAlreadyUsedException() {
		super();
	}

	public ChannelAlreadyUsedException(String message) {
		super(message);
	}

	public ChannelAlreadyUsedException(Throwable t) {
		super(t);
	}

	public ChannelAlreadyUsedException(String message, Throwable t) {
		super(message, t);
	}
}
