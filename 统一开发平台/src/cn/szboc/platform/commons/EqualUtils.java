package cn.szboc.platform.commons;

import java.math.BigDecimal;
import java.util.Date;

public class EqualUtils {

	/**	判断字符串是否相同	*/
	public static boolean equal(String string1, String string2) {
		if (string1 == null) {
			return string2 == null;
		}
		return string1.equals(string2);
	}

	/**	判断日期是否相同	*/
	public static boolean equal(Date date1, Date date2) {
		if (date1 == null) {
			return date2 == null;
		}
		return date1.equals(date2);
	}

	/**	判断数字是否相同	*/
	public static boolean equal(BigDecimal number1, BigDecimal number2) {
		if (number1 == null) {
			return number2 == null;
		}
		return number1.equals(number2);
	}

}
