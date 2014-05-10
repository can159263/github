package com.szboc.platform.component.communication.server;

public abstract class AbstractSocketServer implements IServer {

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public abstract IHandler getHandler();

}
