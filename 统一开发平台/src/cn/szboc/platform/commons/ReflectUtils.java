package cn.szboc.platform.commons;

import java.lang.reflect.Method;

@SuppressWarnings("all")
public class ReflectUtils {
	
	/** 判断是否是8种包装类型 */
	public static boolean isWrapClass(Class<?> clazz) {
		try {
			return ((Class<?>) clazz.getField("TYPE").get(null)).isPrimitive();
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 根据方法返回指定的Class的Method对象。（不考虑形参类型，若存在多个重载方法，返回第一个）
	 * 
	 * @param clazz
	 * @param methodName
	 * @return
	 */
	public static Method getMethodByName(Class<?> clazz, String methodName) {
		Method[] methods = clazz.getMethods();
		for (Method element : methods) {
			if (element.getName().equals(methodName)) {
				return element;
			}
		}
		return null;
	}

	/**
	 * 根据指定的方法名（getter方法），从提供的bean对象中提取bean成员变量的值。
	 * 
	 * @param bean
	 * @param methodName
	 * @return
	 * @throws Exception
	 */
	public static Object getValueByBean(Object bean, String methodName) throws Exception {
		Object retValue = null;

		if (null == bean) {
			throw new Exception("bean对象为null");
		} else if (StringUtils.checkEmpty(methodName)) {
			throw new Exception("未指定方法名");
		}

		Method getter = ReflectUtils.getMethodByName(bean.getClass(), methodName);
		if (getter != null) {
			try {
				retValue = getter.invoke(bean);
			} catch (Exception e) {
				throw new Exception("在调用bean的" + methodName + "方法时发生错误。" + e.getMessage());
			}
		} else {
			throw new Exception(bean.getClass().getName() + "中并未发现名为" + methodName + "的方法");
		}

		return retValue;
	}

}
