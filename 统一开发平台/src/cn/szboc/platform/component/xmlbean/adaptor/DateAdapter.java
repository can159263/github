package cn.szboc.platform.component.xmlbean.adaptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.util.Date与xs:date类型的互转
 */
public class DateAdapter {

	public static Date parseDate(String s) {
		if(s == null){
			return null;
		}
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(s);
		} catch (ParseException e) {
			throw new IllegalArgumentException("非法参数[" + s + "],要求格式为[yyyy-MM-dd]");
		}
	}

	public static String printDate(Date dt) {
		if(dt == null){
			return null;
		}
		return new SimpleDateFormat("yyyy-MM-dd").format(dt);
	}
}