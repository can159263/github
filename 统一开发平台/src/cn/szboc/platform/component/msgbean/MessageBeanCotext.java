package cn.szboc.platform.component.msgbean;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

import cn.szboc.platform.commons.ByteUtils;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.MessageField;
import cn.szboc.platform.component.msgbean.annotation.MessageGetEnhance;
import cn.szboc.platform.component.msgbean.annotation.MessageSetEnhance;
import cn.szboc.platform.component.msgbean.annotation.PadType;
import cn.szboc.platform.component.msgbean.annotation.To;
import cn.szboc.platform.component.msgbean.enhance.ICustomGetConvertor;
import cn.szboc.platform.component.msgbean.enhance.ICustomSetConvertor;
import cn.szboc.platform.component.msgbean.exception.MsgBeanContextInitException;
import cn.szboc.platform.component.msgbean.exception.MsgBeanConvertException;
import cn.szboc.platform.component.msgbean.interseptor.AfterGetInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.AfterSetInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.BeforeGetInterceptor;
import cn.szboc.platform.component.msgbean.interseptor.BeforeSetInterceptor;

/**
 * message与bean互转的上下文 也是转换的主要入口
 */
@SuppressWarnings("all")
public class MessageBeanCotext {

	/**
	 * bean->message时所需要的内部结构
	 */
	private Map<Class<?>, MessageBeanDefinition> readCache = Collections.synchronizedMap(new HashMap<Class<?>, MessageBeanDefinition>());

	/**
	 * message->bean时所需要的内部结构
	 */
	private Map<Class<?>, MessageBeanDefinition> writeCache = Collections.synchronizedMap(new HashMap<Class<?>, MessageBeanDefinition>());

	public MessageBeanCotext() {
	}

	/**
	 * 传入要支持的转换Bean的Class对象进行初始化
	 * 
	 * @param clazzes
	 *            要注册的class对象,该对象必须被MessageBean注解所修饰
	 * @throws MsgBeanContextInitException
	 *             当内部初始化异常时抛出该异常
	 */
	public MessageBeanCotext(Class<?>... clazzes) throws MsgBeanContextInitException {

		if (clazzes == null) {
			throw new NullPointerException("至少传入一个Class");
		}

		// 每个Class都必须处理
		for (Class<?> clazz : clazzes) {
			this.analyse(clazz);
		}
	}

	/**
	 * 根据bean的注解,将bean转为byte[]
	 * 
	 * @param bean
	 * @return
	 * @throws MsgBeanConvertException
	 */
	public byte[] marshal(Object bean) throws MsgBeanConvertException {

		// 1, 首先拿到object的class,如果有多个Class是给bean的类(继承关系),那么选最下面的类
		Class<?> clazz = getMatchedClass(bean.getClass(), false);

		// 2, 根据Class对象拿到相关配置,这时的Field应该是已经排好序的
		MessageBeanDefinition msgBeanDefinition = null;

		msgBeanDefinition = readCache.get(clazz);

		// 获取配置
		ArrayList<FieldTranslateProperty> mappingConfig = msgBeanDefinition.getFieldProperties();

		// 4, 预计转换后得到的总长度
		int expectTotalLength = msgBeanDefinition.getExpectedSize();

		// 5, 转换后的字节流
		ByteArrayOutputStream resultBytes = new ByteArrayOutputStream();

		// 3, 根据每个字段的配置进行解析
		for (int idx = 0; idx < mappingConfig.size(); idx++) {

			// 3.1 获取该属性对应的配置
			FieldTranslateProperty fieldProperty = mappingConfig.get(idx);

			// 3.2 属性名称
			String propertyName = fieldProperty.getName();

			// 3.2 该属性的类型
			Class<?> fieldDeclaringClass = fieldProperty.getFieldClass();

			// 3.3 该属性的字符集
			Charset charset = msgBeanDefinition.getCs();

			// 字段属性转换成的字节值
			byte[] propertyByteValue;

			// 属性的值
			Object wrapValue;
			try {
				wrapValue = PropertyUtils.getProperty(bean, propertyName);
			} catch (Exception e) {
				throw new MsgBeanConvertException("不能够正常获取bean中属性", e);
			}

			// NOP 操作下,填满原料后即可,不对拦截器进行处理
			if (fieldProperty.getPadType() == PadType.NOP) {
				propertyByteValue = new byte[fieldProperty.getLength()];
				Arrays.fill(propertyByteValue, fieldProperty.getMaterial());
				try {
					resultBytes.write(propertyByteValue);
				} catch (IOException e) {
					throw new MsgBeanConvertException("内部字节IO缓存异常", e);
				}
				continue;
			}

			// 存在读前置处理器,则进行与处理
			if (fieldProperty.getBeforeGetInterceptors() != null && fieldProperty.getBeforeGetInterceptors().size() != 0) {
				for (BeforeGetInterceptor interceptor : fieldProperty.getBeforeGetInterceptors()) {
					wrapValue = interceptor.beforeGetToBytes(wrapValue, fieldProperty);
				}
			}

			if (wrapValue == null) {
				propertyByteValue = new byte[0];
			} else {

				// 如果Field是8个简单数据类型或者包装类型
				if (fieldDeclaringClass.isPrimitive() || isWrapClass(fieldDeclaringClass)) {
					propertyByteValue = String.valueOf(wrapValue).getBytes(charset);
					// 如果是String,StringBuffer, StringBuilder,直接用toString转
				} else if (String.class == fieldDeclaringClass || StringBuffer.class == fieldDeclaringClass
						|| StringBuilder.class == fieldDeclaringClass) {
					propertyByteValue = wrapValue.toString().getBytes(charset);
					// 如果是BigDecimal,用plainString转
				} else if (BigDecimal.class == fieldDeclaringClass) {
					propertyByteValue = ((BigDecimal) wrapValue).toPlainString().getBytes(charset);
				} else if (BigInteger.class == fieldDeclaringClass) {
					propertyByteValue = ((BigInteger) wrapValue).toString().getBytes(charset);
					// 如果该字段也是被MessageBean注解所修饰,则进行递归
				} else if (fieldDeclaringClass.getAnnotation(MessageBean.class) != null) {
					propertyByteValue = this.marshal(wrapValue);
					// 如果字段是Enum类型,则使用name属性进行转换
				} else if (fieldDeclaringClass.isEnum()) {
					propertyByteValue = ((Enum) wrapValue).name().getBytes(charset);
				} else {
					throw new MsgBeanConvertException("不支持该类型");
				}
			}

			switch (fieldProperty.getPadType()) {
				case LEFT:
					propertyByteValue = ByteUtils.leftPad(propertyByteValue, fieldProperty.getLength(), fieldProperty.getMaterial());
					break;
				case RIGHT:
					propertyByteValue = ByteUtils.rightPad(propertyByteValue, fieldProperty.getLength(), fieldProperty.getMaterial());
					break;
				case MATCH:
					if (propertyByteValue.length != fieldProperty.getLength()) {
						throw new MsgBeanConvertException("字段名称为" + propertyName + "的值转换的字节数不一致,期望是" + fieldProperty.getLength() + ",实际是"
								+ propertyByteValue.length);
					}
					break;
				default:
					throw new MsgBeanConvertException("字段名称为" + propertyName + "的值填充方式必须设置");
			}

			// 存在读后置处理器,则进行与处理
			if (fieldProperty.getAfterGetInterceptors() != null && fieldProperty.getAfterGetInterceptors().size() != 0) {
				for (AfterGetInterceptor interceptor : fieldProperty.getAfterGetInterceptors()) {
					propertyByteValue = interceptor.afterGetToBytes(propertyByteValue, fieldProperty);
				}
			}

			if (propertyByteValue.length != fieldProperty.getLength()) {
				throw new MsgBeanConvertException("字段名称为" + propertyName + "的值再经过拦截器处理之后的字节数发生变化,期望是" + fieldProperty.getLength() + ",实际是"
						+ propertyByteValue.length);
			}

			try {
				resultBytes.write(propertyByteValue);
			} catch (IOException e) {
				throw new MsgBeanConvertException("内部字节缓存异常", e);
			}
		}

		if (resultBytes.size() != expectTotalLength) {
			throw new MsgBeanConvertException("期望的bean长度" + expectTotalLength + "与转换出来的bean长度" + resultBytes.size() + "不一致");
		}

		return resultBytes.toByteArray();
	}

	/**
	 * 根据bean的注解,将byte[]转为bean 严格按照Annotation进行匹配
	 * 
	 * @param bytes
	 * @param clazz
	 * @return
	 * @throws MsgBeanConvertException
	 */
	public <T> T unMarshal(byte[] bytes, Class<?> T) throws MsgBeanConvertException {
		return this.unMarshal(bytes, T, true);
	}

	/**
	 * 按照字节数组长度来转换,而不是按照Class中的注解来转换
	 * 
	 * @param bytes
	 * @param T
	 * @param strictMode
	 *            true是严格按照Annotation false指看bytes的字节数和注解的长度,两边有一边提前借宿则截止转换
	 * @return
	 * @throws MsgBeanConvertException
	 */
	public <T> T unMarshal(byte[] bytes, Class<?> T, boolean strictMode) throws MsgBeanConvertException {

		// 1, 首先拿到对应的class,如果有多个Class是给bean的类(继承关系),那么选最下面的类
		Class<?> clazz = getMatchedClass(T, true);

		if (bytes == null) {
			return null;
		}

		// 2, 根据Class对象拿到相关配置,这时的Field应该是已经排好序的
		MessageBeanDefinition msgBeanDefinition = null;

		msgBeanDefinition = writeCache.get(clazz);

		// 3, 获得配置
		ArrayList<FieldTranslateProperty> mappingConfig = msgBeanDefinition.getFieldProperties();

		// 4, 预计转换后得到的总长度
		int expectTotalLength = msgBeanDefinition.getExpectedSize();

		// 如果是严格模式,则要求双方长度必须相等
		if (strictMode) {
			if (expectTotalLength != bytes.length) {
				throw new MsgBeanConvertException("转换" + T.getCanonicalName() + "类过程中,预计字节数组长度为" + expectTotalLength + ",但实际为" + bytes.length);
			}
		}

		// 5, 反射出一个bean,该bean最后会被返回
		T rtnBean = null;

		try {
			rtnBean = (T) T.newInstance();
		} catch (Exception e) {
			throw new MsgBeanConvertException("至少提供一个默认构造函数在类" + T.getCanonicalName() + "中");
		}

		// 6, 根据每个字段的配置进行解析
		for (int idx = 0; idx < mappingConfig.size(); idx++) {

			// 6.1 获取该属性对应的配置
			FieldTranslateProperty fieldProperty = mappingConfig.get(idx);

			// 如果是宽松模式
			if (!strictMode) {
				// 如果字节数组较短
				if (bytes.length < expectTotalLength) {
					if (fieldProperty.getStartPos() == bytes.length) {
						break;
					}
					if (fieldProperty.getStartPos() > bytes.length) {
						throw new MsgBeanConvertException("按照字节数组长度转换bean时,未能成功切割字段,字节长度是" + bytes.length + ", 而当前字段起始位置是"
								+ fieldProperty.getStartPos());
					}
				}
				// 如果字节数组正好或者较长,则由于后面主要依赖属性配置进行遍历,所以属性遍历完会自动停止,无须特殊处理
			}

			// 6.2 属性名称
			String propertyName = fieldProperty.getName();

			// 6.2 该属性的类型
			Class<?> fieldDeclaringClass = fieldProperty.getFieldClass();

			// 6.3 该属性的字符集
			Charset charset = msgBeanDefinition.getCs();

			// 6.4 字段属性转换成的字节值
			byte[] propertyByteValue = Arrays
					.copyOfRange(bytes, fieldProperty.getStartPos(), fieldProperty.getStartPos() + fieldProperty.getLength());

			// 存在set前置处理器,则进行与处理
			if (fieldProperty.getBeforeSetInterceptors() != null && fieldProperty.getBeforeSetInterceptors().size() != 0) {
				for (BeforeSetInterceptor interceptor : fieldProperty.getBeforeSetInterceptors()) {
					propertyByteValue = interceptor.beforeSetToProperty(propertyByteValue, fieldProperty);
				}
			}

			// 6,5 进行trim
			switch (fieldProperty.getPadType()) {
				case LEFT:
					propertyByteValue = ByteUtils.leftTrim(propertyByteValue, fieldProperty.getMaterial());
					break;
				case RIGHT:
					propertyByteValue = ByteUtils.rightTrim(propertyByteValue, fieldProperty.getMaterial());
					break;
				// MATCH 类型,不进行PAD和TRIM操作
				case MATCH:
					break;
				// 如果是NOP类型,不进行任何操作直接遍历下一个属性
				case NOP:
					continue;
				default:
					throw new MsgBeanConvertException("字段名称为" + propertyName + "的值填充方式必须设置");
			}

			String wrapValue = new String(propertyByteValue, charset);

			Object objectValue = wrapValue;

			try {
				// 如果Field是8个简单数据类型或者包装类型
				if (fieldDeclaringClass.isPrimitive() || isWrapClass(fieldDeclaringClass)) {
					if (fieldDeclaringClass == int.class || fieldDeclaringClass == Integer.class) {
						objectValue = Integer.parseInt(wrapValue);
					} else if (fieldDeclaringClass == double.class || fieldDeclaringClass == Double.class) {
						objectValue = Double.parseDouble(wrapValue);
					} else if (fieldDeclaringClass == long.class || fieldDeclaringClass == Long.class) {
						objectValue = Long.parseLong(wrapValue);
					} else if (fieldDeclaringClass == byte.class || fieldDeclaringClass == Byte.class) {
						objectValue = Byte.parseByte(wrapValue);
					} else if (fieldDeclaringClass == boolean.class || fieldDeclaringClass == Boolean.class) {
						objectValue = Boolean.parseBoolean(wrapValue);
					} else if (fieldDeclaringClass == float.class || fieldDeclaringClass == Float.class) {
						objectValue = Float.parseFloat(wrapValue);
					} else if (fieldDeclaringClass == char.class || fieldDeclaringClass == Character.class) {
						if (wrapValue.length() != 1) {
							throw new Exception("字段名称为" + propertyName + "的值" + wrapValue + "不能转成有效char类型");
						}
						objectValue = wrapValue.charAt(0);
					} else if (fieldDeclaringClass == short.class || fieldDeclaringClass == Short.class) {
						objectValue = Short.parseShort(wrapValue);
					}
					// 如果是String,StringBuffer, StringBuilder,直接用toString转
				} else if (String.class == fieldDeclaringClass) {
					objectValue = wrapValue;
				} else if (BigDecimal.class == fieldDeclaringClass) {
					objectValue = new BigDecimal(wrapValue);
				} else if (BigInteger.class == fieldDeclaringClass) {
					objectValue = new BigInteger(wrapValue);
					// 如果该字段还是MsgBean标注,则进行递归
				} else if (fieldDeclaringClass.getAnnotation(MessageBean.class) != null) {
					objectValue = this.unMarshal(propertyByteValue, fieldDeclaringClass);
				} else if (StringBuilder.class == fieldDeclaringClass) {
					objectValue = new StringBuilder(wrapValue);
				} else if (StringBuffer.class == fieldDeclaringClass) {
					objectValue = new StringBuffer(wrapValue);
					// 如果是enum类型,则按照name进行转换
				} else if (fieldDeclaringClass.isEnum()) {
					objectValue = Enum.valueOf((Class<? extends Enum>) fieldDeclaringClass, wrapValue);
				} else {
					throw new Exception("不支持该类型");
				}
			} catch (Exception e) {
				throw new MsgBeanConvertException("类型转换异常", e);
			}

			// 存在set后置处理器,则进行与处理
			if (fieldProperty.getAfterSetInterceptors() != null && fieldProperty.getAfterSetInterceptors().size() != 0) {
				for (AfterSetInterceptor interceptor : fieldProperty.getAfterSetInterceptors()) {
					objectValue = interceptor.afterSetToProperty(objectValue, fieldProperty);
				}
			}

			try {
				PropertyUtils.setProperty(rtnBean, propertyName, objectValue);
			} catch (Exception e) {
				throw new MsgBeanConvertException("给类型为[" + clazz.getCanonicalName() + "]的属性[" + propertyName + "]赋值时出现异常", e);
			}

		}

		return rtnBean;
	}

	/**
	 * 查找符合条件的Class
	 * 
	 * @param clazz
	 * @param writeOrRead
	 *            write是true,read是false
	 * @return
	 * @throws MsgBeanContextInitException
	 */
	private Class<?> getMatchedClass(Class<?> clazz, boolean writeOrRead) throws MsgBeanContextInitException {
		if (clazz == null) {
			throw new NullPointerException("传入clazz不能为空");

		}
		Map<Class<?>, MessageBeanDefinition> cache = writeOrRead ? writeCache : readCache;

		Class<?> tmp = clazz;
		while (tmp != Object.class) {
			boolean contain;

			if (cache.containsKey(clazz)) {
				return tmp;
			} else {
				tmp = tmp.getSuperclass();
			}
		}
		throw new MsgBeanContextInitException("容器并未初始化该Class" + clazz);
	}

	/**
	 * 判断一个类是否被注册
	 * 
	 * @param clazz
	 * @param writeOrRead
	 *            true是读,false是写
	 * @return
	 */
	public synchronized boolean isRegedit(Class<?> clazz, boolean writeOrRead) {

		if (writeOrRead) {
			return writeCache.containsKey(clazz);
		} else {
			return readCache.containsKey(clazz);
		}

	}

	/**
	 * 判断类型是否为包装类型
	 * 
	 * @param clazz
	 * @return
	 */
	private boolean isWrapClass(Class<?> clazz) {
		try {
			return ((Class<?>) clazz.getField("TYPE").get(null)).isPrimitive();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 动态注册解析类
	 * 
	 * @param clazz
	 * @param msgBean
	 * @throws MsgBeanContextInitException
	 */
	public synchronized void analyse(Class<?> clazz, MessageBean msgBean) throws MsgBeanContextInitException {
		// 必须被该注解所修饰
		if (msgBean == null) {
			throw new MsgBeanContextInitException("Class " + clazz.getCanonicalName() + " 必须被注解  " + MessageBean.class.getCanonicalName() + " 修饰");
		}

		// 根据方向进行校验
		switch (msgBean.Target()) {
			case TO_BYTES:
				analyse(clazz, msgBean, false);
				break;
			case TO_BEAN:
				analyse(clazz, msgBean, true);
				break;
			case BOTH:
				analyse(clazz, msgBean, true);
				analyse(clazz, msgBean, false);
				break;
			default:
				throw new MsgBeanContextInitException("必须明确指定转换方向to");
		}
	}

	/**
	 * 分析某个被MessageBean修饰的class文件
	 * 
	 * @param clazz
	 * @return
	 * @throws MsgBeanContextInitException
	 */
	public synchronized void analyse(Class<?> clazz) throws MsgBeanContextInitException {

		// 获取该类的MessageBean注解
		MessageBean msgBean = clazz.getAnnotation(MessageBean.class);

		analyse(clazz, msgBean);
	}

	/**
	 * 内部校验
	 * 
	 * @param clazz
	 * @param messageBean
	 * @param writeOrRead
	 *            校验write为true, read为false
	 * @return
	 * @throws MsgBeanContextInitException
	 */
	private synchronized void analyse(Class<?> clazz, MessageBean messageBean, boolean writeOrRead) throws MsgBeanContextInitException {

		// 如果已经注册过了,则抛出异常
		if (writeOrRead) {
			if (writeCache.containsKey(clazz)) {
				throw new MsgBeanContextInitException("Class:" + clazz.getCanonicalName() + " 已经被注册在write缓存中,禁止再次注册");
			}
		} else {
			if (readCache.containsKey(clazz)) {
				throw new MsgBeanContextInitException("Class:" + clazz.getCanonicalName() + " 已经被注册在read缓存中,禁止再次注册");
			}
		}

		// 新建定义bean
		MessageBeanDefinition defintion = new MessageBeanDefinition();

		defintion.setClazz(clazz);
		defintion.setTo(writeOrRead ? To.TO_BEAN : To.TO_BYTES);

		// 获取bean所对应的长度
		int totalLength = writeOrRead ? messageBean.ExpectedWriteSize() : messageBean.ExpectedReadSize();
		if (totalLength <= 0) {
			throw new MsgBeanContextInitException(clazz.getCanonicalName() + "的注解MessageBean中必须指定长度" + (writeOrRead ? "writeLength" : "readLength")
					+ ",且必须是正数");
		}

		defintion.setExpectedSize(totalLength);

		// 获取bean所对应的字符集
		Charset charset = messageBean.Charset().getCharset();

		defintion.setCs(charset);

		// 对应转换前后的字节数组,用于后面的读写是否全部正确对应的校验
		boolean[] beanBytes = new boolean[totalLength];

		// 全部填充false
		Arrays.fill(beanBytes, false);

		// 准备返回的Field数组,待排序
		ArrayList<FieldTranslateProperty> fields = defintion.getFieldProperties();

		// 这里只看属性(set/get),不看字段,原因是字段的反射是看不到父类的,只能依赖属性,这样就避免了JAXB那种不支持继承的问题
		PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(clazz);

		// 遍历每个属性
		for (int i = 0; i < propertyDescriptors.length; i++) {

			// 获得属性描述
			PropertyDescriptor propertyDescriptor = propertyDescriptors[i];

			// 根据参数拉去对应的get/set方法
			Method method = writeOrRead ? propertyDescriptor.getWriteMethod() : propertyDescriptor.getReadMethod();

			// 如果没有该属性的对应方法,则继续下一个属性
			if (method == null) {
				continue;
			}

			MessageField messageField = method.getAnnotation(MessageField.class);

			// 如果没有被注解,则继续下一个属性
			if (messageField == null) {
				continue;
			}

			// 新建要绑定的信息bean
			FieldTranslateProperty fieldTranslateProperty = new FieldTranslateProperty();

			int startPos = messageField.startPos();
			int length = messageField.length();

			// 长度校验
			if (startPos + length > totalLength) {
				throw new MsgBeanContextInitException("MsgField定义有误,在位置[" + startPos + "]处开始的字段长度过长,超出Class:" + clazz.getCanonicalName() + "标识总长度");
			}

			// 有无字节映射间的相互重叠
			for (int idx = 0; idx < length; idx++) {
				if (beanBytes[startPos + idx] == false) {
					beanBytes[startPos + idx] = true;
				} else {
					throw new MsgBeanContextInitException("MsgField定义有误,在位置[" + (startPos + idx) + "]处有多个字段引用,Class为" + clazz.getCanonicalName());
				}
			}

			// 设置相关属性
			fieldTranslateProperty.setStartPos(startPos);
			fieldTranslateProperty.setLength(length);
			fieldTranslateProperty.setPadType(messageField.type());
			fieldTranslateProperty.setMaterial(messageField.material());
			fieldTranslateProperty.setCharset(charset);
			fieldTranslateProperty.setName(propertyDescriptor.getName());

			// 探测get拦截器
			if (method.getAnnotation(MessageGetEnhance.class) != null) {

				if (messageField.type() == PadType.NOP) {
					throw new MsgBeanContextInitException("NOP填充类型的字段,不允许关联任何增强器,因为该字段根本就不会被映射");
				}

				// 增加注解
				MessageGetEnhance enhance = method.getAnnotation(MessageGetEnhance.class);

				try {
					// 对拦截器进行解析
					for (Class<? extends BeforeGetInterceptor> interseptor : enhance.beforeGet()) {
						fieldTranslateProperty.addBeforeGetInterseptor(interseptor.newInstance());
					}
					for (Class<? extends AfterGetInterceptor> interseptor : enhance.afterGet()) {
						fieldTranslateProperty.addAfterGetInterseptor(interseptor.newInstance());
					}
					// 对自定义处理器进行解析
					if (enhance.convertor() != ICustomGetConvertor.class) {
						fieldTranslateProperty.setGetConvetor(enhance.convertor().newInstance());
					}
				} catch (Exception e) {
					throw new MsgBeanContextInitException("处理类[" + clazz.getCanonicalName() + "]的属性[" + propertyDescriptor.getName() + "]的转换增强时发生异常",
							e);
				}

			}

			// 探测set拦截器
			if (method.getAnnotation(MessageSetEnhance.class) != null) {

				// 增加注解
				MessageSetEnhance enhance = method.getAnnotation(MessageSetEnhance.class);

				try {
					// 对拦截器进行解析
					for (Class<? extends BeforeSetInterceptor> interseptor : enhance.beforeSet()) {
						fieldTranslateProperty.addBeforeSetInterseptor(interseptor.newInstance());
					}
					for (Class<? extends AfterSetInterceptor> interseptor : enhance.afterSet()) {
						fieldTranslateProperty.addAfterSetInterseptor(interseptor.newInstance());
					}
					// 对自定义处理器进行解析
					if (enhance.convertor() != ICustomSetConvertor.class) {
						fieldTranslateProperty.setSetConvetor(enhance.convertor().newInstance());
					}
				} catch (Exception e) {
					throw new MsgBeanContextInitException("处理类[" + clazz.getCanonicalName() + "]的属性[" + propertyDescriptor.getName() + "]的转换增强时发生异常",
							e);
				}

			}

			// 属性的类型
			fieldTranslateProperty.setFieldClass(propertyDescriptor.getPropertyType());

			// 如果字段本身也是一个MsgBean,那么也要进行标记
			if (method.getReturnType().getAnnotation(MessageBean.class) != null) {
				if (method.getReturnType().getAnnotation(MessageBean.class).Charset() != messageBean.Charset()) {
					throw new MsgBeanContextInitException("传入的类引用字符集不匹配,请先统一字符集");
				}
			}

			// 处理完成后添加到列表中
			fields.add(fieldTranslateProperty);
		}

		// 检查是否有字节没有被bean中的属性所标记
		for (int i = 0; i < beanBytes.length; i++) {
			if (beanBytes[i] == false) {
				throw new MsgBeanContextInitException("从位置[" + i + "]开始的字节没有映射到ClassName:" + clazz.getName() + ",ClassCanonicalName:"
						+ clazz.getCanonicalName() + "的属性中");
			}
		}

		// 至少该bean应该有一个字段被MsgField标记
		if (fields.size() == 0) {
			throw new MsgBeanContextInitException("至少应该找到一个MessageField注解的字段在该类中:" + clazz.getCanonicalName());
		}

		// 全部检查通过后,根据startPos进行排序
		Collections.sort(fields);

		// 然后根据具体类型放入不通缓存中
		if (writeOrRead) {
			writeCache.put(clazz, defintion);
		} else {
			readCache.put(clazz, defintion);
		}

	}

}
