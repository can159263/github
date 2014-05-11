package cn.szboc.platform.modules.parameter.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.szboc.platform.exception.PlatformRtException;
import cn.szboc.platform.modules.parameter.dao.SystemParameterDao;
import cn.szboc.platform.modules.parameter.domain.ParameterItemType;
import cn.szboc.platform.modules.parameter.domain.SystemParameterItem;

@Service("systemParameterService")
public class SystemParamterService {

	private SystemParameterDao parameterDao;

	public SystemParameterDao getParameterDao() {
		return parameterDao;
	}

	@Autowired
	@Qualifier("systemParameterDao")
	public void setParameterDao(SystemParameterDao parameterDao) {
		this.parameterDao = parameterDao;
	}

	private Logger logger = LoggerFactory.getLogger(SystemParamterService.class);

	@Transactional(readOnly = true)
	public boolean checkItemExist(String qName) {
		// 参数不能为空
		if (StringUtils.isEmpty(qName)) {
			throw new PlatformRtException("参数查询异常", new IllegalArgumentException("参数qName不能为空"));
		}

		if (getParameterDao().countWithQname(qName) == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 查询某一参数的参数Bean
	 */
	@Transactional(readOnly = true)
	public SystemParameterItem getParameterItem(String qName) {

		// 参数不能为空
		if (StringUtils.isEmpty(qName)) {
			throw new PlatformRtException("参数查询异常", new IllegalArgumentException("参数qName不能为空"));
		}

		SystemParameterItem spb = null;

		try {
			spb = getParameterDao().querySystemParameterItem(qName);
		} catch (Exception e) {
			logger.error("查询参数异常,qName={}, error={}", new Object[] { qName, e.getMessage() });
			throw new PlatformRtException("参数查询异常", e);
		}

		// 检查是否已经明确查询到结果
		if (spb == null) {
			throw new PlatformRtException("参数查询异常", new IllegalArgumentException("系统中并未配置参数[" + qName + "]"));
		}

		return spb;
	}

	/**
	 * 查询某一项目的类型
	 */
	@Transactional(readOnly = true)
	public ParameterItemType getItemType(String qName) {
		SystemParameterItem item = this.getParameterItem(qName);
		return item.getItemType();
	}

	public int insertParameterItem(SystemParameterItem item) {
		if (item == null) {
			throw new PlatformRtException("参数新增异常", new IllegalArgumentException("参数item不能为空"));
		}

		return getParameterDao().insertParameterItem(item);
	}

	public int deleteParameterItem(String itemQname) {
		if (StringUtils.isEmpty(itemQname)) {
			throw new PlatformRtException("参数删除异常", new IllegalArgumentException("参数itemQname不能为空"));
		}

		return getParameterDao().deleteParameterItem(itemQname);
	}
	
}
