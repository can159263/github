package cn.szboc.platform.component.xmlbean.adaptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.util.Date与xs:time类型的互转
 */
public class TimeAdapter {

	public static Date parseTime(String s) {
		if(s == null){
			return null;
		}
		try {
			return new SimpleDateFormat("HH:mm:ss").parse(s);
		} catch (ParseException e) {
			throw new IllegalArgumentException("非法参数[" + s + "],要求格式为[HH:mm:ss]");
		}
	}

	public static String printTime(Date dt) {
		if(dt == null){
			return null;
		}
		return new SimpleDateFormat("HH:mm:ss").format(dt);
	}
}