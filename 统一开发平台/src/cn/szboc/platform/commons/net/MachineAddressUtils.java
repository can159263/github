package cn.szboc.platform.commons.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 机器地址工具类
 */
public class MachineAddressUtils {

	/**
	 * 获取本机IP地址
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public static String getLocalHostIP() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		return addr.getHostAddress();
	}

	public static String getLocalHostName() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		return addr.getHostName();
	}

	/**
	 * 返回本机所有IP
	 * 
	 * @return
	 * @throws UnknownHostException 
	 */
	public static String[] getAllLocalHostIP() throws UnknownHostException {
		String[] ret = null;
		String hostName = getLocalHostName();
		if (hostName.length() > 0) {
			InetAddress[] addrs = InetAddress.getAllByName(hostName);
			if (addrs.length > 0) {
				ret = new String[addrs.length];
				for (int i = 0; i < addrs.length; i++) {
					ret[i] = addrs[i].getHostAddress();
				}
			}
		}

		return ret;
	}

	public static String[] getAllHostIPByName(String hostName) {
		String[] ret = null;
		try {
			if (hostName.length() > 0) {
				InetAddress[] addrs = InetAddress.getAllByName(hostName);
				if (addrs.length > 0) {
					ret = new String[addrs.length];
					for (int i = 0; i < addrs.length; i++) {
						ret[i] = addrs[i].getHostAddress();
					}
				}
			}

		} catch (Exception ex) {
			ret = null;
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("本机IP:" + getLocalHostIP());
		System.out.println("主机名：" + getLocalHostName());

		String[] localIP = getAllLocalHostIP();
		for (int i = 0; i < localIP.length; i++) {
			System.out.println(localIP[i]);
		}
		
		System.out.println(getHostAddress());
	}
	
	public static String getHostAddress() throws Exception {
		String adress = null;
		InetAddress[] a = getAllHostAddress();
		for (int i = 0; i < a.length; i++) {
			// 过滤掉127.0.0.1
			if (a[i].isLoopbackAddress()) {
				continue;
			}

			adress = a[i].getLocalHost().getHostAddress();

			if (adress != null)
				break;
		}

		return adress;
	}

	public static InetAddress[] getAllHostAddress() throws Exception {
		Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
		List addresses = new ArrayList();

		while (networkInterfaces.hasMoreElements()) {
			NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
			Enumeration inetAddresses = networkInterface.getInetAddresses();

			while (inetAddresses.hasMoreElements()) {
				InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
				addresses.add(inetAddress);
			}
		}

		return (InetAddress[]) addresses.toArray(new InetAddress[0]);
	}
	
}
