package cn.szboc.platform.component.xmlbean.adaptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.util.Date与xs:dateTime类型的互转
 */
public class DateTimeAdapter {

	public static Date parseDateTime(String s) {
		if(s == null){
			return null;
		}
		try {
			return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(s);
		} catch (ParseException e) {
			throw new IllegalArgumentException("非法参数[" + s + "],要求格式为[yyyy-MM-dd'T'HH:mm:ss]");
		}
	}

	public static String printDateTime(Date dt) {
		if(dt == null){
			return null;
		}
		return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(dt);
	}
}