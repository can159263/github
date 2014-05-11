package cn.szboc.platform.commons.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 网络相关的辅助类
 */
public class NetUtils {

	private static Logger _logger = LoggerFactory.getLogger(NetUtils.class);

	private static final int MIN_PORT_NUMBER = 0;
	private static final int MAX_PORT_NUMBER = 65536;

	/**
	 * 判断某个端口是否可以被使用
	 * 
	 * @param port
	 *            端口的有效范围应该是在0~65536范围之内
	 * @return
	 */
	public static boolean available(int port) {

		if (port < MIN_PORT_NUMBER || port > MAX_PORT_NUMBER) {
			throw new IllegalArgumentException("不合法的端口数值: " + port);
		}

		ServerSocket ss = null;
		try {
			ss = new ServerSocket(port);
			ss.setReuseAddress(true);
			return true;
		} catch (IOException e) {
			_logger.error("检测端口可用性时捕获到了异常,此异常通常为检测性异常", e);
		} finally {
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					_logger.error("检测端口可用性后,在关闭检测ServerSocket时抛出了异常", e);
				}
			}
		}
		return false;
	}
	
	public static boolean available(String lstnIp, int port) {
		
		if(StringUtils.isEmpty(lstnIp)){
			throw new IllegalArgumentException("IP地址不能为空");
		}
		
		if (port < MIN_PORT_NUMBER || port > MAX_PORT_NUMBER) {
			throw new IllegalArgumentException("不合法的端口数值: " + port);
		}
		
		ServerSocket ss = null;
		try {
			ss = new ServerSocket();
			ss.bind(new InetSocketAddress(lstnIp, port));
			ss.setReuseAddress(true);
			return true;
		} catch (IOException e) {
			_logger.error("检测端口可用性时捕获到了异常,此异常通常为检测性异常", e);
		} finally {
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					_logger.error("检测端口可用性后,在关闭检测ServerSocket时抛出了异常", e);
				}
			}
		}
		
		return false;
	}
	
}
