package cn.szboc.platform.core;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import cn.szboc.platform.commons.thread.annotation.ThreadSafe;

/**
 * 系统全局注册表(单例模式)
 * 提供两个主要功能: 
 * 	1_整合提供Spring容器的单点访问方法
 * 	2_提供Map的缓存,系统存放全局共享的对象(这些对象可能不方便存在于Spring容器中,比如是在运行过程中动态产生而不是系统初始化时产生的对象等)
 */
@ThreadSafe
@SuppressWarnings("all")
public class PlatformRegister implements ApplicationContextAware {

	/** 日志 */
	private static Logger _logger = LoggerFactory.getLogger(PlatformRegister.class);

	/** 单例 */
	private static PlatformRegister regedit;

	/** Spring容器 */
	private ApplicationContext _ctx;

	private PlatformRegister() {

	}

	/** 内部缓存 */
	private Map<String, Object> cache = Collections.synchronizedMap(new HashMap<String, Object>());

	/**
	 * 单例模式
	 * 
	 * @return 返回唯一实例
	 */
	public static PlatformRegister getInstance() {
		if (regedit == null) {
			synchronized (PlatformRegister.class) {
				if (regedit == null) {
					regedit = new PlatformRegister();
				}
				return regedit;
			}
		}
		return regedit;
	}

	/**
	 * 通用注册器
	 */
	public void setToCache(String key, Object value) {
		this.cache.put(key, value);
	}

	/**
	 * 通用获取入口
	 */
	public Object getFromCache(String key) {
		return this.cache.get(key);
	}

	/**
	 * 泛型获取入口
	 */
	public <T> T getFromCache(String key, Class<T> clazz) {
		return (T) this.cache.get(key);
	}

	/**
	 * 获取容器实例
	 * 
	 * @return
	 */
	public ApplicationContext getCtx() {
		return _ctx;
	}

	/**
	 * 获取容器中的实例
	 * 
	 * @param name
	 * @return
	 */
	public Object get(String name) {
		return _ctx.getBean(name);
	}

	/**
	 * 获取容器中的实例,自动转型
	 * 
	 * @param name
	 * @param requiredType
	 * @return
	 */
	public <T> T get(String name, Class<T> requiredType) {
		return _ctx.getBean(name, requiredType);
	}

	/**
	 * 容器启动时会将自己注入进来
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this._ctx = applicationContext;
		_logger.info("平台注册表已登记Spring容器实例,类型为{}", _ctx.getClass().getCanonicalName());
	}

	// ===========================================

	/** 目录之间的分隔符,windows系统为"\", Unix, AIX, linux系统为"/" */
	public static final String separator = File.separator;

	/** 文本文件中的换行符,windows系统为"\r\n", Unix, AIX, linux系统为"\n" */
	public static final String lineSeparator = System.getProperty("line.separator");

	/** PATH环境变量中的分隔符,windows系统为";", Unix, AIX, linux系统为":" */
	public static final String pathSeparator = File.pathSeparator;

}
