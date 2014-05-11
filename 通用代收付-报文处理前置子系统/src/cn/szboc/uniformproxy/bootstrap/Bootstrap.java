package cn.szboc.uniformproxy.bootstrap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.szboc.uniformproxy.batchtrade.transaction.BatchDeductResponseServer;
import cn.szboc.uniformproxy.bootstrap.check.netaddresscheck.NetAddressChecker;
import cn.szboc.uniformproxy.bootstrap.check.syscodecheck.SystemCodeChecker;
import cn.szboc.uniformproxy.bootstrap.check.syscodecheck.support.SystemCodeBean;
import cn.szboc.uniformproxy.frontend.server.MessageRecvNettyServer;
import cn.szboc.uniformproxy.frontend.system.SYS;
import cn.szboc.uniformproxy.frontend.system.SysReg;
import cn.szboc.uniformproxy.frontend.system.SystemConfigBean;
import cn.szboc.uniformproxy.mange.MangeBackGroundServer;

/**
 * 外围代收付前置报文预处理系统启动器
 */
public class Bootstrap {

	private static Logger _logger = LoggerFactory.getLogger(Bootstrap.class);

	/**
	 * Spring配置文件
	 */
	private static String[] springCfgPaths = { "classpath*:MessageRecvApplicatonContext.xml" };

	/**
	 * 单例模式
	 */
	private static Bootstrap bootStap = new Bootstrap();

	public static Bootstrap getInstance() {
		return bootStap;
	}

	/**
	 * 检查系统码是否正常
	 */
	private SystemCodeChecker systemCodeChecker;
	private NetAddressChecker netAddressChecker;
	private BatchDeductResponseServer batchServer;
	private MangeBackGroundServer mangeBackGroundServer;
	
	
	@Required
	public void setSystemCodeChecker(SystemCodeChecker systemCodeChecker) {
		this.systemCodeChecker = systemCodeChecker;
	}

	@Required
	public void setNetAddressChecker(NetAddressChecker netAddressChecker) {
		this.netAddressChecker = netAddressChecker;
	}

	@Required
	public void setBatchServer(BatchDeductResponseServer batchServer) {
		this.batchServer = batchServer;
	}
	
	@Required
	public void setMangeBackGroundServer(MangeBackGroundServer mangeBackGroundServer) {
		this.mangeBackGroundServer = mangeBackGroundServer;
	}

	/**
	 * 启动
	 * 
	 * @param ctx
	 * @throws Exception
	 */
	public void startUp() throws Exception {

		SystemConfigBean configBean = SysReg.sysCfg();

		if (configBean == null) {
			throw new Exception("前置代收付系统必须初始化系统配置bean:{}" + SystemConfigBean.class.getCanonicalName());
		}

		SYS.init(configBean);
		_logger.info("系统常量类SYS初始化完毕,常量信息为");
		_logger.info(SYS.printStatus());
		
		String systemCode = configBean.getSystemCode();
		if (StringUtils.isEmpty(systemCode)) {
			throw new IllegalArgumentException("系统别不能为空!");
		}
		_logger.info("系统启动配置:系统别为{}", systemCode);

		// 校验系统别是否存在
		SystemCodeBean scb = systemCodeChecker.check(systemCode);

		_logger.info("系统启动的监听业务是{}", scb.getSystemName());

		// 校验监听的IP/端口是否正确
		_logger.info("系统启动的监听IP为{}, 端口为{}, 开始检测", new Object[] { configBean.getLstnIp(), configBean.getLstnPort() });
		
		/*
		 * 中行信科提供的测试环境下,该检测方法抛出不能获取主机名的异常,故该步骤暂时省略
		 * netAddressChecker.check(systemCode, configBean.getLstnIp(), configBean.getLstnPort());
		 */

		// 检测完毕
		_logger.info("系统检测完毕,开始启动网络监听...");

		if (configBean.getMaxSizeInM() <= 0) {
			throw new IllegalArgumentException("最大报文接收长度不能为负数");
		}

		
		// 3, 启动netty网络监听
		final MessageRecvNettyServer server = new MessageRecvNettyServer(systemCode, configBean.getMaxSizeInM(), configBean.getLstnIp(),
				configBean.getLstnPort());
		
		server.start();
		
		_logger.info("启动批量报文监听");
		
		// 4, 启动批量报文异步回盘监听
		batchServer.startup();
		
		// 5, 启动后台管理监听
		this.mangeBackGroundServer.setMessageRecvNettyServer(server);
		this.mangeBackGroundServer.startup();
		
		_logger.info("系统启动完毕");
	}

	public static void main(String[] args) {

		_logger.info("前置代收付报文接收预处理系统启动,正在初始化中,请稍后..");

		_logger.info("开始初始化Spring容器,所用到的配置文件共有{}个,分别是", springCfgPaths.length);

		for (String path : springCfgPaths) {
			_logger.info("使用配置文件:{}", path);
		}

		// 1, 启动容器
		ApplicationContext ctx = null;
		Bootstrap bootStrap = null;

		try {
			ctx = new ClassPathXmlApplicationContext(springCfgPaths);
			bootStrap = ctx.getBean("bootStrap", Bootstrap.class);
		} catch (Throwable t) {
			_logger.error("前置代收付报文接收预处理系统Spring容器启动异常", t);
			_logger.error("系统退出");
			System.exit(-1);
		}

		try {
			bootStrap.startUp();
		} catch (Throwable t) {
			_logger.error("前置代收付报文接收预处理系统启动异常", t);
			_logger.error("系统退出");
			System.exit(-1);
		}

		_logger.info("前置代收付报文接收预处理系统启动完毕!");

	}

}
