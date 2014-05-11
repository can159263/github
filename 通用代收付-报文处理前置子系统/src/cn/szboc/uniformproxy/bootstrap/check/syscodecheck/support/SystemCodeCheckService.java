package cn.szboc.uniformproxy.bootstrap.check.syscodecheck.support;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("systemCodeCheckService")
public class SystemCodeCheckService {

	@Autowired
	@Qualifier("systemCodeCheckDao")
	private SystemCodeCheckDao dao;

	@Transactional(readOnly = true)
	public int check(String systemCode) {
		if (StringUtils.isEmpty(systemCode)) {
			throw new IllegalArgumentException("系统别不能为空!");
		}
		return dao.checkSystemCodeExists(systemCode);
	}
	
	@Transactional(readOnly = true)
	public SystemCodeBean findSystemCodeBean(String systemCode){
		return dao.findSystemCodeBean(systemCode);
	}
}
