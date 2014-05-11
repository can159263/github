package cn.szboc.uniformproxy.bootstrap.check.netaddresscheck.support;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("netAddressCheckService")
public class NetAddressCheckService {

	@Autowired
	@Qualifier("netAddressCheckDao")
	private NetAddressCheckDao dao;

	public void setDao(NetAddressCheckDao dao) {
		this.dao = dao;
	}

	@Transactional(readOnly = true)
	public List<NetAddressCheckBean> getSystemDispatchBeans(String systemCode) {
		if (StringUtils.isEmpty(systemCode)) {
			throw new IllegalArgumentException("系统别不能为空");
		}
		return dao.getSystemDispatchBeans(systemCode);
	}
}
