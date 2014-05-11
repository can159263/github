package cn.szboc.platform.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.szboc.platform.exception.PlatformRtException;

public class DateUtils {
	
	/**
	 * 获取系统日期时间(10位)
	 * 格式为:yyyy-MM-dd
	 * @return 字符串日期时间
	 */
	public static String getDateStr() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	/**
	 * 将传入的日期转为yyyy-MM-dd的格式
	 * @return
	 */
	public static String getDateStr(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	/**
	 * 获取系统日期时间(8位)
	 * 格式为:yyyyMMdd
	 * @return 字符串日期时间
	 */
	public static String getDateStrNO() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	/**
	 * 获取系统日期时间(8位)
	 * 格式为:yyyyMMdd
	 * @return 字符串日期时间
	 */
	public static String getDateStrNO(Date date) {
		return new SimpleDateFormat("yyyyMMdd").format(date);
	}
	
	/**
	 * 根据年月日返回"YYYY-MM-DD"格式
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static String getDateStr(int year, int month, int day) {

		Calendar cl = Calendar.getInstance();
		cl.set(year, 0, 1);
		cl.add(Calendar.MONTH, (month - 1));
		cl.add(Calendar.DATE, (day - 1));
		year = cl.get(Calendar.YEAR);
		month = cl.get(Calendar.MONTH) + 1;
		day = cl.get(Calendar.DATE);
		String date = String.valueOf(year * 10000 + month * 100 + day);
		return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
	}


	/**
	 * 获取系统日期时间（字符串格式）
	 * 
	 * @return 字符串日期时间
	 */
	public static String getDateTimeStr() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 获取系统日期时间（字符串格式）
	 * 
	 * @return 字符串日期时间
	 */
	public static String getDateTimeStr(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/**
	 * 不带下划线
	 * 
	 * @return 字符串日期时间
	 */
	public static String getDateTimeStrNo() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	
	/**
	 * 不带下划线
	 * 
	 * @return 字符串日期时间
	 */
	public static String getDateTimeStrNo(Date date) {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
	}
	
	/**
	 * 获取系统当前时间
	 * 格式为:HH:mm:ss
	 * @return the system time
	 */
	public static String getTimeStr() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	/**
	 * 获取距离当前时间[时/分/秒]偏移的时间格式
	 * 
	 * @param hour
	 *            时,负数代表时间往前
	 * @param minute
	 *            分,负数代表时间往前
	 * @param second
	 *            秒,负数代表时间往前
	 * @return
	 */
	public static String getTimeStr(int hour, int minute, int second) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.HOUR_OF_DAY, hour);
		c.add(Calendar.MINUTE, minute);
		c.add(Calendar.SECOND, second);
		Date d = c.getTime();
		return new SimpleDateFormat("HH:mm:ss").format(d);
	}

	/**
	 * 获取系统当前时间
	 * 格式为HHmmss
	 * @return the system time
	 */
	public static String getTimeStrNo() {
		return new SimpleDateFormat("HHmmss").format(new Date());
	}
	
	/**
	 * 获取系统当前时间
	 * 格式为HHmmss
	 * @return the system time
	 */
	public static String getTimeStrNo(Date date) {
		return new SimpleDateFormat("HHmmss").format(date);
	}

	/**
	 * 按照标准的格式yyyy-MM-dd HH:mm:ss进行解析日期
	 * @param value
	 * @return
	 */
	public static Date parseDate(String value){
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value);
		} catch (ParseException e) {
			throw new PlatformRtException("转换Date对象时异常,值为:" + value, e);
		}
	}
	
	public static void main(String[] args) {
		try {
			
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS").parse("2012-04-17 00:00:01.0");
			System.out.println(
					date.getTime()
			);
			Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS").parse("2012-04-17 00:00:01.001002");
			System.out.println(
					date2.getTime()
					);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
