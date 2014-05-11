package cn.szboc.uniformproxy.bootstrap.check.netaddresscheck;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.platform.commons.net.MachineAddressUtils;
import cn.szboc.platform.commons.net.NetUtils;
import cn.szboc.uniformproxy.bootstrap.check.netaddresscheck.support.NetAddressCheckBean;
import cn.szboc.uniformproxy.bootstrap.check.netaddresscheck.support.NetAddressCheckService;

@Component("netAddressChecker")
public class NetAddressChecker {

	@Autowired
	@Qualifier("netAddressCheckService")
	private NetAddressCheckService service;

	private static Logger _logger = LoggerFactory.getLogger(NetAddressChecker.class);

	// 对当前机器地址进行校验
	public void check(String systemCode, String lstnIp, int port) throws Exception {

		if (systemCode == null || systemCode.length() != 4) {
			throw new IllegalArgumentException("非法系统别[" + systemCode + "],必须是4位字节长度");
		}

		if (StringUtils.isEmpty(lstnIp)) {
			throw new IllegalArgumentException("IP地址格式不能为空");
		}

		// 获取本机IP地址
		String[] ips = MachineAddressUtils.getAllLocalHostIP();
		if (ArrayUtils.isEmpty(ips)) {
			throw new IllegalStateException("当前机器没有任何有效IP地址!");
		}

		_logger.info("当前检测到的本机IP地址分别如下:");
		for (String ip : ips) {
			_logger.info("IP: {}", ip);
		}

		if (ArrayUtils.contains(ips, lstnIp)) {
			_logger.info("探测到要监听的IP地址{}在本机地址列表中", lstnIp);
		} else {
			throw new IllegalArgumentException("当前端口" + port + "不可用!");
		}

		if (NetUtils.available(lstnIp, port)) {
			_logger.info("当前监听配置{}:{}可用,开始检测状态", new Object[] { lstnIp, port });
		} else {
			throw new IllegalArgumentException("当前端口" + port + "不可用!");
		}

		List<NetAddressCheckBean> netInfos = service.getSystemDispatchBeans(systemCode);

		if (netInfos == null || netInfos.isEmpty()) {
			throw new IllegalStateException("没有查询到针对系统别" + systemCode + "的任何分派信息!");
		}

		_logger.info("从系统中取得的对应系统码{}的IP/端口信息分别如下:");
		for (NetAddressCheckBean netInfo : netInfos) {
			_logger.info("IP: {}, 端口: {},  状态: {}",
					new Object[] { netInfo.getSocketAddressIp(), netInfo.getSocketAddressPort(), netInfo.getServerStatus() });

			if (!lstnIp.equals(netInfo.getSocketAddressIp()) || port != netInfo.getSocketAddressPort()) {
				_logger.info("IP/端口不匹配,继续遍历");
			} else {
				_logger.info("IP/端口匹配,检测状态");
				switch (netInfo.getServerStatus()) {
					case READY:
						_logger.info("配置匹配成功,ip={}, port={}", new Object[] { netInfo.getSocketAddressIp(), netInfo.getSocketAddressPort() });
						return;
					case NOT_READY:
						_logger.info("该IP/PORT当前状态不可用!");
						throw new IllegalArgumentException("当前ip/端口配置不可用!");
					default:
						throw new IllegalArgumentException("缺少当前ip/端口状态,无法做出判断!");
				}
			}
		}
		throw new IllegalArgumentException("未检测到相关合法配置!禁止系统启动");
	}
}
