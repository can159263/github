package cn.szboc.uniformproxy.frontend.system;

import javax.annotation.PostConstruct;

import cn.szboc.platform.core.PlatformDao;

/**
 * 抽象父类
 * 默认先执行
 */
public abstract class FrontendDaoSupport extends PlatformDao<FrontendDatabaseObjects> {

	@PostConstruct
	public void init() {
		initSQL(getPlatformDatabaseObjects());
	}

	protected abstract void initSQL(FrontendDatabaseObjects dbObjects);

}
