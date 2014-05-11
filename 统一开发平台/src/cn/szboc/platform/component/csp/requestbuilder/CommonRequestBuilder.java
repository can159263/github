package cn.szboc.platform.component.csp.requestbuilder;

import cn.szboc.platform.commons.thread.annotation.NotThreadSafe;
import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.trade.commons.CspTradeCommonField;
import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.msgbean.MessageBeanCotext;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;

/**
 * CSP请求生成器基类 主要作用: 1, 负责生成请求bean 2, 负责发送请求bean 3, 负责调用MsgBean转换组件转换响应信息到响应bean
 * 
 * T代表了CSP请求的抽象 
 * R代表了CSP响应的抽象 
 * 
 * ST代表了T的实现
 * SR代表了R的实现
 */
@NotThreadSafe
public abstract class CommonRequestBuilder<T extends CommonRequest<R, SR>, ST extends T, R extends CommonResponse, SR extends R> {

	/**
	 * 标准响应Class
	 */
	private Class<SR> stdResponseClazz;

	/**
	 * 引用工厂,必要时向工厂请求相关资源
	 */
	protected CspTransactionRequestBuilderFactory factory;

	public CommonRequestBuilder(CspTransactionRequestBuilderFactory factory, Class<SR> clazz) {
		if (factory == null) {
			throw new IllegalArgumentException("参数CspTransactionRequestBuilderFactory不能为空");
		}
		this.factory = factory;
		this.stdResponseClazz = clazz;
	}

	public Class<SR> getStdResponseClazz() {
		return stdResponseClazz;
	}

	public void setStdResponseClazz(Class<SR> stdResponseClazz) {
		this.stdResponseClazz = stdResponseClazz;
	}

	protected abstract ST getStandardRequestBean();

	/**
	 * 创建系统自带的内置请求bean,该bean必须是该交易的全量字段的实现
	 * 
	 * @param branchNo
	 *            交易上送时的必输字段,网点号
	 * @param operator
	 *            交易上送时的必输字段,柜员号
	 * @return
	 * @throws RequestBuildingException
	 */
	public ST newRequest(String branchNo, String operator) {
		// 创建默认的请求bean
		ST requestBean = getStandardRequestBean();

		// 设置工厂
		requestBean.setCspTransactionRequestBuilderFactory(factory);

		requestBean.setResponseBeanClazz(stdResponseClazz);

		requestBean.setCommonFiled(CspTradeCommonField.BRANCH_NO, branchNo);
		requestBean.setCommonFiled(CspTradeCommonField.OPERATOR, operator);

		return requestBean;
	}

	/**
	 * 创建一个扩展的自定义的请求bean,但内置实现的字段太多时,可以用此方法,在自定义类或者匿名内部类中实现相关注解
	 * 
	 * @param requestAdapter
	 *            该模版要提供必须的字段和属性
	 */
	public T newRequest(String branchNo, String operator, T requestAdapter) throws RequestBuildingException {

		// 传入实体的类
		Class<?> clazz = requestAdapter.getClass();

		MessageBeanCotext ctx = factory.getMbCtx();

		// 如果并没有注册读解析,则进行动态解析
		if (!ctx.isRegedit(clazz, false)) {
			// 上锁,防止多个线程同时注册
			synchronized (ctx) {
				// 再次检查,防止别的线程提前解析
				if (!ctx.isRegedit(clazz, false)) {
					try {
						// 如果本身有注解,那么用它自己的注解信息
						if (ctx.getClass().getAnnotation(MessageBean.class) != null) {
							ctx.analyse(clazz);
						} else { // 否则使用它的父类的注解进行解析
							if (clazz.getSuperclass().getAnnotation(MessageBean.class) != null) {
								ctx.analyse(clazz, clazz.getSuperclass().getAnnotation(MessageBean.class));
							} else { // 如果父类仍没有配置注解,则任务是异常现象,抛出
								throw new IllegalArgumentException("本类及其父类均没有注册MessageBeanContext解析.请先注册再进行调用,className=" + clazz.getName()
										+ ", ClassCanonicalName=" + clazz.getCanonicalName());
							}
						}
					} catch (Exception e) {
						throw new RequestBuildingException("创建交易请求时发现异常传入类并未注册MessageBean注解,在后期动态解析时出现异常,className=" + clazz.getName()
								+ ", ClassCanonicalName=" + clazz.getCanonicalName(), e);
					}
				}
			}
		}
		
		// 设置工厂
		requestAdapter.setCspTransactionRequestBuilderFactory(factory);

		requestAdapter.setResponseBeanClazz(stdResponseClazz);
		
		requestAdapter.setCommonFiled(CspTradeCommonField.BRANCH_NO, branchNo);
		requestAdapter.setCommonFiled(CspTradeCommonField.OPERATOR, operator);

		return requestAdapter;
	}

}