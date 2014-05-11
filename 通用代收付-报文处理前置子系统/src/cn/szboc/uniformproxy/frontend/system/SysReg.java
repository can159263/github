package cn.szboc.uniformproxy.frontend.system;

import cn.szboc.platform.core.PlatformRegister;
import cn.szboc.uniformproxy.frontend.server.postprocessor.PostProcessor;
import cn.szboc.uniformproxy.frontend.server.preprocess.PreProcessor;

/**
 * 系统注册表
 */
public final class SysReg {

	private static final PlatformRegister register = PlatformRegister.getInstance();

	public static final String KEY_SYSTEM_CONFIG_BEAN = "KEY_SYSTEM_CONFIG_BEAN";
	
	public static final String KEY_MESSAGE_PRE_PROCESSOR = "PreProcessor";
	
	public static final String KEY_MESSAGE_POST_PROCESSOR = "PostProcessor";

	
	
	/**
	 * 获取系统配置参数Bean
	 * @return
	 */
	public static SystemConfigBean sysCfg() {
		return register.get(KEY_SYSTEM_CONFIG_BEAN, SystemConfigBean.class);
	}

	public static final <T> T get(String key, Class<T> clazz) {
		return register.get(key, clazz);
	}

	public static final <T> T getCache(String key, Class<T> clazz) {
		return register.getFromCache(key, clazz);
	}

	/**
	 * 获取前置处理器
	 * @return
	 */
	public static final PreProcessor getPreProcessor(){
		return register.get(KEY_MESSAGE_PRE_PROCESSOR, PreProcessor.class);
	}
	
	/**
	 * 获取后置处理器
	 * @return
	 */
	public static final PostProcessor getPostProcessor(){
		return register.get(KEY_MESSAGE_POST_PROCESSOR, PostProcessor.class);
	}
	
}
