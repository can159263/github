package cn.szboc.uniformproxy.bootstrap.check.syscodecheck;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.bootstrap.check.syscodecheck.support.SystemCodeBean;
import cn.szboc.uniformproxy.bootstrap.check.syscodecheck.support.SystemCodeCheckService;

@Component("systemCodeChecker")
public class SystemCodeChecker {

	@Autowired
	@Qualifier("systemCodeCheckService")
	private SystemCodeCheckService service;

	/**
	 * 检查系统别,如果存在,则返回它
	 * @param systemCode
	 * @return
	 * @throws Exception
	 */
	public SystemCodeBean check(String systemCode) throws Exception {
		if (service.check(systemCode) != 1) {
			throw new Exception("系统别非法!请联系管理员维护该系统别:" + systemCode);
		}
		return service.findSystemCodeBean(systemCode);
	}

	public static void main(String[] args) {
		System.out.println(RandomStringUtils.randomAlphanumeric(20).toUpperCase());
	}
	
}
