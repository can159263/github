package com.szboc.platform.component.communication.server;

/**
 * 服务器
 * @author 刺客
 *
 */
public interface IServer {
	/**
	 * 启动服务器
	 */
	public void start();

	/**
	 * 停止服务器
	 */
	public void shutdown();
	
	/**
	 * 获取处理程序
	 * @return
	 */
	public IHandler getHandler();
}
