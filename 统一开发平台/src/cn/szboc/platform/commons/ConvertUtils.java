package cn.szboc.platform.commons;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

@SuppressWarnings("all")
public class ConvertUtils {

	/**
	 * 类型转换工具类
	 * 
	 * @param value
	 * @param targetClazz
	 * @return
	 */
	public static <E> E convert(Object value, Class<E> targetClazz) {

		if (value == null) {
			return null;
		}

		if (targetClazz == null) {
			throw new IllegalArgumentException("目标class参数不能为空");
		}

		// 如果类型兼容,则直接返回
		if (targetClazz.isAssignableFrom(value.getClass())) {
			return (E) value;
		}

		if (String.class == targetClazz) {
			return (E) convertToString(value);
		}
		if (StringBuilder.class == targetClazz) {
			return (E) convertToStringBuilder(value);
		}
		if (StringBuffer.class == targetClazz) {
			return (E) convertToStringBuffer(value);
		}
		if (BigDecimal.class == targetClazz) {
			return (E) convertToBigDecimal(value);
		}
		if (BigInteger.class == targetClazz) {
			return (E) convertToBigInteger(value);
		}
		if (java.util.Date.class == targetClazz) {
			return (E) convertToJavaUtilDate(value);
		}
		if (java.sql.Date.class == targetClazz) {
			return (E) convertToJavaSqlDate(value);
		}
		if (java.sql.Time.class == targetClazz) {
			return (E) convertToJavaSqlTime(value);
		}
		if (java.sql.Timestamp.class == targetClazz) {
			return (E) convertToJavaSqlTimestamp(value);
		}
		if (Byte.class == targetClazz || byte.class == targetClazz) {
			return (E) convertToByte(value);
		}
		if (Short.class == targetClazz || short.class == targetClazz) {
			return (E) convertToShort(value);
		}
		if (Character.class == targetClazz || char.class == targetClazz) {
			return (E) convertToCharacter(value);
		}
		if (Integer.class == targetClazz || int.class == targetClazz) {
			return (E) convertToInteger(value);
		}
		if (Long.class == targetClazz || long.class == targetClazz) {
			return (E) convertToLong(value);
		}
		if (Float.class == targetClazz || float.class == targetClazz) {
			return (E) convertToFloat(value);
		}
		if (Double.class == targetClazz || double.class == targetClazz) {
			return (E) convertToDouble(value);
		}
		if (Boolean.class == targetClazz || boolean.class == targetClazz) {
			return (E) convertToBoolean(value);
		}
		if (byte[].class == targetClazz || Byte[].class == targetClazz) {
			return (E) convertToBytes(value);
		}
		if (targetClazz.isEnum()) {
			if (value == null) {
				return null;
			}
			return (E) Enum.valueOf((Class<? extends Enum>) targetClazz, convertToString(value));
		}

		throw new IllegalArgumentException("]类型不兼容,无法进行转换,值[" + value + "]类型为:" + value.getClass().getCanonicalName() + ",要转换为的类型是:"
				+ targetClazz.getCanonicalName());
	}

	/**
	 * 任何类型均可以转成String 特殊处理: BigDecimal, 日期类型等
	 * 
	 * @param value
	 * @return
	 */
	private static String convertToString(Object value) {
		if (value == null) {
			return null;
		}
		Class<?> clazz = value.getClass();

		// 如果是派生,则直接返回
		if (String.class.isAssignableFrom(clazz)) {
			return (String) value;
		}

		if (BigDecimal.class == clazz) {
			return ((BigDecimal) value).toPlainString();
		}
		if (java.util.Date.class == clazz) {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((java.util.Date) value);
		}
		if (java.sql.Timestamp.class == clazz) {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((java.sql.Timestamp) value);
		}
		if (java.sql.Date.class == clazz) {
			return new SimpleDateFormat("yyyy-MM-dd").format((java.sql.Date) value);
		}
		if (java.sql.Time.class == clazz) {
			return new SimpleDateFormat("HH:mm:ss").format((java.sql.Time) value);
		}
		if (Calendar.class == clazz) {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(((Calendar) value).getTime());
		}
		if (value instanceof Clob) {
			Clob clob = (Clob) value;
			try {
				return clob.getSubString(1L, (int) clob.length());
			} catch (SQLException e) {
				throw new IllegalArgumentException("转换Clob类型时异常", e);
			}
		}
		if (value instanceof Map) {
			return dump((Map) value);
		}
		if (value instanceof List) {
			return dump((List) value);
		}
		// 其它类型直接调用toString返回默认值
		return value.toString();
	}

	/**
	 * 调用此方法时需谨慎,大数据量或者死循环调用均会造成系统宕机
	 * 
	 * @param list
	 * @return
	 */
	public static String dump(Map map) {
		if (map == null) {
			return null;
		}
		if (map.isEmpty()) {
			return "{}";
		}
		StringBuilder rtn = new StringBuilder("{");
		Object k = null;
		Object v = null;
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			k = iterator.next();
			v = map.get(k);
			rtn.append(convertToString(k));
			rtn.append("=");
			rtn.append(convertToString(v));
			rtn.append(",");
		}
		// 去除最后一个逗号
		if (rtn.length() != 1) {
			rtn.setLength(rtn.length() - 1);
		}
		rtn.append("}");
		return rtn.toString();
	}

	/**
	 * 调用此方法时需谨慎,大数据量或者死循环调用均会造成系统宕机
	 * 
	 * @param list
	 * @return
	 */
	public static String dump(List list) {
		if (list == null) {
			return null;
		}
		if (list.isEmpty()) {
			return "[]";
		}
		StringBuilder rtn = new StringBuilder("[");
		Object item = null;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			item = iterator.next();
			rtn.append(convertToString(item));
			rtn.append(",");
		}
		// 去除最后一个逗号
		if (rtn.length() != 1) {
			rtn.setLength(rtn.length() - 1);
		}
		rtn.append("]");
		return rtn.toString();
	}

	private static StringBuilder convertToStringBuilder(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		// 如果是派生,则直接返回
		if (StringBuilder.class.isAssignableFrom(clazz)) {
			return (StringBuilder) value;
		}

		return new StringBuilder(convertToString(value));
	}

	private static StringBuffer convertToStringBuffer(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		// 如果是派生,则直接返回
		if (StringBuffer.class.isAssignableFrom(clazz)) {
			return (StringBuffer) value;
		}

		return new StringBuffer(convertToString(value));
	}

	private static BigDecimal convertToBigDecimal(Object value) {
		if (value == null) {
			return null;
		}
		Class<?> clazz = value.getClass();

		// 如果是派生,则直接返回
		if (BigDecimal.class.isAssignableFrom(clazz)) {
			return (BigDecimal) value;
		}

		if (Boolean.TRUE.equals(value)) {
			return new BigDecimal("1");
		}
		if (Boolean.FALSE.equals(value)) {
			return new BigDecimal("0");
		}
		
		try {
			return new BigDecimal(value.toString());
		} catch (Exception e) {
			throw new IllegalArgumentException("]类型转换异常,值[" + value + "]类型为:" + value.getClass().getCanonicalName()
					+ ",要转换为的类型是:java.math.BigDecimal");
		}
	}

	private static BigInteger convertToBigInteger(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		// 如果是派生,则直接返回
		if (BigInteger.class.isAssignableFrom(clazz)) {
			return (BigInteger) value;
		}

		if (Boolean.TRUE.equals(value)) {
			return new BigInteger("1");
		}
		if (Boolean.FALSE.equals(value)) {
			return new BigInteger("0");
		}

		try {
			return new BigInteger(value.toString());
		} catch (Exception e) {
			throw new IllegalArgumentException("]类型转换异常,值[" + value + "]类型为:" + value.getClass().getCanonicalName()
					+ ",要转换为的类型是:java.math.BigInteger");
		}
	}

	private static java.util.Date convertToJavaUtilDate(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		// 如果是派生关系,则可以直接返回
		if (java.util.Date.class.isAssignableFrom(clazz)) {
			return (java.util.Date) value;
		}

		// Calender可以和java.util.Date类型进行互转
		if (Calendar.class.isAssignableFrom(clazz)) {
			return ((Calendar) value).getTime();
		}

		// Long类型倍当作毫秒数
		if (Long.class == clazz) {
			return new java.util.Date((Long) value);
		}

		// BigInteger类型倍当作毫秒数
		if (BigInteger.class == clazz) {
			return new java.util.Date(((BigInteger) value).longValue());
		}

		// 当BigDecimal没有小数部分时,其整数部分也可以被当初毫秒数
		if (BigDecimal.class == clazz && ((BigDecimal) value).scale() == 0) {
			return new java.util.Date(((BigDecimal) value).longValueExact());
		}

		// 获取字符串值
		String strValue = convertToString(value);

		int length = strValue.length();

		SimpleDateFormat sdf = null;

		switch (length) {
			case 23:
			case 22:
			case 21:
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				break;
			case 19:
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				break;
			case 15:
				sdf = new SimpleDateFormat("yyyyMMdd HHmmss");
				break;
			case 10:
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				break;
			case 8:
				sdf = new SimpleDateFormat("HH:mm:ss");
				break;
			case 6:
				sdf = new SimpleDateFormat("HHmmss");
				break;
			case 4:
				sdf = new SimpleDateFormat("mmss");
				break;
		}

		if (sdf == null) {
			throw new IllegalArgumentException("]类型转换无法进行,值[" + value + "]类型为:" + value.getClass().getCanonicalName() + ",要转换为的类型是:java.util.Date");
		}

		try {
			return sdf.parse(strValue);
		} catch (Exception e) {
			throw new IllegalArgumentException("]类型转换异常,值[" + value + "]类型为:" + value.getClass().getCanonicalName() + ",要转换为的类型是:java.util.Date", e);
		}
	}

	private static java.sql.Date convertToJavaSqlDate(Object value) {
		if (value == null) {
			return null;
		}

		return new java.sql.Date(convertToJavaUtilDate(value).getTime());
	}

	private static java.sql.Time convertToJavaSqlTime(Object value) {
		if (value == null) {
			return null;
		}

		return new java.sql.Time(convertToJavaUtilDate(value).getTime());
	}

	private static java.sql.Timestamp convertToJavaSqlTimestamp(Object value) {
		if (value == null) {
			return null;
		}

		return new java.sql.Timestamp(convertToJavaUtilDate(value).getTime());
	}

	private static Byte convertToByte(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		if (Byte.class == clazz) {
			return (Byte) value;
		}
		if (Boolean.TRUE.equals(value)) {
			return 1;
		}
		if (Boolean.FALSE.equals(value)) {
			return 0;
		}

		String strVal = convertToString(value);

		try {
			return new Byte(strVal);
		} catch (Exception e) {
			throw new IllegalArgumentException("]类型转换异常,值[" + value + "]类型为:" + value.getClass().getCanonicalName() + ",要转换为的类型是:java.lang.Byte");
		}
	}

	private static Short convertToShort(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		if (Short.class == clazz) {
			return (Short) value;
		}
		if (Boolean.TRUE.equals(value)) {
			return 1;
		}
		if (Boolean.FALSE.equals(value)) {
			return 0;
		}

		String strVal = convertToString(value);

		try {
			return new Short(strVal);
		} catch (Exception e) {
			throw new IllegalArgumentException("]类型转换异常,值[" + value + "]类型为:" + value.getClass().getCanonicalName() + ",要转换为的类型是:java.lang.Short");
		}
	}

	private static Character convertToCharacter(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		if (Character.class == clazz) {
			return (Character) value;
		}
		if (Boolean.TRUE.equals(value)) {
			return '1';
		}
		if (Boolean.FALSE.equals(value)) {
			return '0';
		}

		String strVal = convertToString(value);

		try {
			if (strVal.length() != 1) {
				throw new Exception("转换后的字符串长度不是1,无法转为Character");
			}
			return strVal.charAt(0);
		} catch (Exception e) {
			throw new IllegalArgumentException("]类型转换异常,值[" + value + "]类型为:" + value.getClass().getCanonicalName() + ",要转换为的类型是:java.lang.Character");
		}
	}

	private static Long convertToLong(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		if (Long.class == clazz) {
			return (Long) value;
		}
		if (Boolean.TRUE.equals(value)) {
			return 1L;
		}
		if (Boolean.FALSE.equals(value)) {
			return 0L;
		}
		if (value instanceof java.util.Date) {
			return ((java.util.Date) value).getTime();
		}

		String strVal = convertToString(value);

		try {
			return new Long(strVal);
		} catch (Exception e) {
			throw new IllegalArgumentException("]类型转换异常,值[" + value + "]类型为:" + value.getClass().getCanonicalName() + ",要转换为的类型是:java.lang.Long");
		}
	}

	private static Integer convertToInteger(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		if (Integer.class == clazz) {
			return (Integer) value;
		}
		if (Boolean.TRUE.equals(value)) {
			return 1;
		}
		if (Boolean.FALSE.equals(value)) {
			return 0;
		}

		String strVal = convertToString(value);

		try {
			return new Integer(strVal);
		} catch (Exception e) {
			throw new IllegalArgumentException("]类型转换异常,值[" + value + "]类型为:" + value.getClass().getCanonicalName() + ",要转换为的类型是:java.lang.Integer");
		}
	}

	private static Float convertToFloat(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		if (Float.class == clazz) {
			return (Float) value;
		}

		String strVal = convertToString(value);

		try {
			return new Float(strVal);
		} catch (Exception e) {
			throw new IllegalArgumentException("]类型转换异常,值[" + value + "]类型为:" + value.getClass().getCanonicalName() + ",要转换为的类型是:java.lang.Float");
		}
	}

	private static Double convertToDouble(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		if (Double.class == clazz) {
			return (Double) value;
		}

		String strVal = convertToString(value);

		try {
			return new Double(strVal);
		} catch (Exception e) {
			throw new IllegalArgumentException("]类型转换异常,值[" + value + "]类型为:" + value.getClass().getCanonicalName() + ",要转换为的类型是:java.lang.Double");
		}
	}

	private static Boolean convertToBoolean(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		if (Boolean.class == clazz) {
			return (Boolean) value;
		}

		String strVal = convertToString(value);

		if ("0".equals(strVal))
			return Boolean.FALSE;
		if ("1".equals(strVal))
			return Boolean.TRUE;
		if ("N".equalsIgnoreCase(strVal))
			return Boolean.FALSE;
		if ("Y".equalsIgnoreCase(strVal))
			return Boolean.TRUE;
		if ("NO".equalsIgnoreCase(strVal))
			return Boolean.FALSE;
		if ("YES".equalsIgnoreCase(strVal))
			return Boolean.TRUE;
		if ("TRUE".equalsIgnoreCase(strVal))
			return Boolean.FALSE;
		if ("FALSE".equalsIgnoreCase(strVal))
			return Boolean.TRUE;

		throw new IllegalArgumentException("]类型转换异常,值[" + value + "]类型为:" + value.getClass().getCanonicalName() + ",要转换为的类型是:java.lang.Boolean");
	}

	private static byte[] convertToBytes(Object value) {
		if (value == null) {
			return null;
		}

		Class<?> clazz = value.getClass();

		if (byte[].class == clazz) {
			return (byte[]) value;
		}
		if (value instanceof InputStream) {
			try {
				return IOUtils.toByteArray((InputStream) value);
			} catch (IOException e) {
				throw new IllegalStateException("copy IO流时出现异常", e);
			}
		}
		if (File.class.isAssignableFrom(clazz)) {
			try {
				return FileUtils.readFileToByteArray((File) value);
			} catch (IOException e) {
				throw new IllegalStateException("read File 到字节数组时出现异常", e);
			}
		}
		if (Blob.class.isAssignableFrom(clazz)) {
			Blob bytes = (Blob) value;
			try {
				return bytes.getBytes(1L, (int) bytes.length());
			} catch (SQLException e) {
				throw new IllegalStateException("read Blob时出现异常", e);
			}
		}

		throw new IllegalArgumentException("]类型转换异常,值[" + value + "]类型为:" + value.getClass().getCanonicalName() + ",要转换为的类型是:byte[]");
	}

	public static void main(String[] args) {
		Object obj = null;
		Class clazz = int.class;
		System.out.println(convert(obj, clazz));
		System.out.println(convert(obj, clazz).getClass().getCanonicalName());
	}
}
