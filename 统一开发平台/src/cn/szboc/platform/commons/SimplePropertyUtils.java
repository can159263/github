package cn.szboc.platform.commons;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * 属性操作的一些简答工具方法
 */
@SuppressWarnings("all")
public class SimplePropertyUtils {

	/** 判断是否是8种包装类型 */
	public static boolean isWrapClass(Class<?> clazz) {
		try {
			return ((Class<?>) clazz.getField("TYPE").get(null)).isPrimitive();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 通用的值设置方法
	 * 
	 * @param obj
	 * @param propName
	 * @param value
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public static void setProperty(Object bean, String propName, Object objValue) throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, SQLException, ParseException {
		if (bean == null) {
			throw new IllegalArgumentException("bean不能为空");
		}
		if (propName == null || propName.length() == 0) {
			throw new IllegalArgumentException("propName不能为空");
		}

		// 如果值为空,则设置属性值也为空
		if (objValue == null) {
			PropertyUtils.setProperty(bean, propName, null);
			return;
		}

		// 获取bean中属性类型
		Class<?> propType = PropertyUtils.getPropertyType(bean, propName);

		// 值的类型
		Class<?> valueType = objValue.getClass();

		// 如果目标Bean的属性与结果集对应列的属性属于派生关系,则可以直接赋值
		if (propType.isAssignableFrom(valueType)) {
			PropertyUtils.setProperty(bean, propName, objValue);
		}

		// 如果类型之间不是之间继承兼容的,则进行二次兼容性处理
		Object value = ConvertUtils.convert(objValue, propType);

		// 进行设置
		PropertyUtils.setProperty(bean, propName, value);
	}

	/**
	 * 常用类型的转换,从某个对象数据类型转为目标数据类型,对于格式不兼容的情况进行最大程度上的兼容性
	 * 
	 * @param objValue
	 *            对象值
	 * @param stringValue
	 *            对象的更通用的string标识,如果传入null,则默认使用toString方式
	 * @param simpleClazz
	 *            要转换得到的类型
	 * @return
	 * @throws SQLException
	 */
	public static <E> E getValue(Object objValue, String stringValue, Class<E> simpleClazz) {

		// 如果对象本身为null,则直接返回null值
		if (objValue == null) {
			return null;
		}

		// 如果对象本身类型是目标类型的同类/子类,则直接可以返回
		if (simpleClazz.isAssignableFrom(objValue.getClass())) {
			return (E) objValue;
		}

		if (stringValue == null) {
			return ConvertUtils.convert(objValue, simpleClazz);
		} else {
			return ConvertUtils.convert(stringValue, simpleClazz);
		}

	}

}
