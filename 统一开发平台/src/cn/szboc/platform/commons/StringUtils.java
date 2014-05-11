package cn.szboc.platform.commons;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @function：封装字符串常用处理方法<br>
 * @author: wengyy 2008-11-6 <br>
 * @company: 深圳四方精创<br>
 */
public abstract class StringUtils {
	/**
	 * 匹配HTML脚本的Pattern
	 */
	private static final Pattern PATTERN_HTML_SCRIPT = Pattern
			.compile(
					"(<\\s*script[^>]*\\s*>(.|\\n)*?<\\/\\s*script\\s*>)|(<\\s*style\\s*>(.|\\n)*?<\\/\\s*style\\s*>)|(<\\s*title\\s*>(.|\\n)*?<\\/\\s*title\\s*>)|([ |\\s]+)|(<[^>]*>)|(\\&[a-zA-Z]{1,10};)",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

	/**
	 * 匹配HTML脚本中的超链接标志的Pattern
	 */
	private static final Pattern PATTERN_HTML_A_TAG = Pattern.compile("(<\\s*a[^>]*\\s*>)|(<\\/\\s*a\\s*>)", Pattern.CASE_INSENSITIVE
			| Pattern.MULTILINE);

	/**
	 * 匹配全英母的Pattern
	 */
	private static final Pattern PATTERN_FULL_ALPHABET = Pattern.compile("^[a-zA-Z]+$");

	/**
	 * 匹配全阿拉伯数字的Pattern
	 */
	private static final Pattern PATTERN_FULL_NUMBER = Pattern.compile("^[0-9]+$");

	/**
	 * 转成驼峰命名法 如将MY_NAME转换成myName
	 * 
	 * @param name
	 * @return
	 */
	public static String toCamelCase(final String name) {
		if (name == null || name.length() == 0) {
			return name;
		}

		String str = "";
		String[] tmpArr = name.toLowerCase().split("_");

		for (int i = 0; i < tmpArr.length; i++) {
			if (i == 0) {
				str += tmpArr[i];
			} else {
				str += tmpArr[i].substring(0, 1).toUpperCase() + tmpArr[i].substring(1);
			}
		}
		return str;
	}

	/**
	 * 将驼峰命名法的名称转成下划线名称风格 如将myName转换成MY_NAME。
	 * 
	 * @param name
	 * @return 字母全大写的String
	 */
	public static String toUnderlineCase(final String name) {
		if (name == null || name.length() == 0) {
			return name;
		}

		StringBuilder buf = new StringBuilder();
		for (int i = 0, len = name.length(); i < len; i++) {

			// 首字母是大写的除外, 前一个字符是下划线的除外
			if (i != 0 && Character.isUpperCase(name.charAt(i)) && name.charAt(i - 1) != '_') {
				buf.append('_');
			}
			buf.append(name.charAt(i));
		}

		return buf.toString().toUpperCase();

	}

	/**
	 * 返回一个首字母为大写的字符串。
	 * 
	 * @param str
	 * @return
	 */
	public static String uppercaseFirstChar(final String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/***************************************************************************
	 * 替换字符
	 * 
	 * @param obj
	 *            待处理的字符串
	 * @param src
	 *            要替换的字符串
	 * @param target
	 *            用来替换的字符串
	 * @return
	 */
	public static String replaceAll(String obj, String src, String target) {
		// 参数检查
		if (obj == null || src == null || target == null) {
			return obj;
		}
		// 分割
		StringTokenizer sR = new StringTokenizer(obj, src);
		StringBuffer ret = new StringBuffer();
		int iTokens = sR.countTokens();

		int j = 1;
		// 取代
		while (sR.hasMoreTokens()) {

			if (j < iTokens) {
				ret.append(sR.nextToken());
				ret.append(target);
			} else {
				ret.append(sR.nextToken());
			}
			j++;
		}
		// 尾部
		if (obj.endsWith(src)) {
			ret.append(target);
		}
		// 头部
		if (obj.startsWith(src)) {
			ret.insert(0, target);
		}
		return ret.toString();
	}

	public static String encodeStrFromGBKToISO(String s) {
		if (s != null) {
			try {
				s = new String(s.getBytes("GBK"), "8859_1");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return s;
	}

	public static String encodeStrFromISOToGBK(String s) {
		if (s != null) {
			try {
				s = new String(s.trim().getBytes("8859_1"), "gbk");
			} catch (UnsupportedEncodingException ee) {
				ee.printStackTrace();
			}
		}
		return s;
	}

	public static String getStrFromInputStream(InputStream in) {
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
			String tempstr = "";
			String strsum = "";
			while ((tempstr = buffer.readLine()) != null) {
				strsum = strsum + tempstr;

			}
			buffer.close();
			// in.close();
			return strsum;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String formatDecimal(String myNumber) {
		double myDecimal = Double.valueOf(myNumber).doubleValue();
		DecimalFormat form = new DecimalFormat("#,##0.00");
		return form.format(myDecimal);
	}

	public static String formatDecimal(String myNumber, String myFormat) {
		double myDecimal = Double.valueOf(myNumber).doubleValue();
		DecimalFormat form = new DecimalFormat(myFormat);
		return form.format(myDecimal);
	}

	// add by wangchao
	public static String formatDouble(double myNumber, int precision) {
		StringBuffer pBuf = new StringBuffer("##0.");
		for (int i = 0; i < precision; i++) {
			pBuf.append("0");
		}

		DecimalFormat form = new DecimalFormat(pBuf.toString());
		return form.format(myNumber);
	}

	// add by wangchao
	public static String formatDouble(double myNumber, String pattern) {
		StringBuffer pBuf = new StringBuffer(pattern);
		DecimalFormat form = new DecimalFormat(pBuf.toString());
		return form.format(myNumber);
	}

	public static List<String> strToList(String src, String token) {
		List<String> result = new ArrayList<String>();
		if (src != null && !"".equals(src)) {
			StringTokenizer stringtokenizer = new StringTokenizer(src, token);
			while (stringtokenizer.hasMoreTokens()) {
				result.add(stringtokenizer.nextToken().trim());
			}
		}
		return result;
	}

	// 返回数组长度不一定等于token数量，去掉了空值
	public static String[] strToArray(String src, String token) {
		String[] result = {};
		if (src != null && !"".equals(src)) {
			StringTokenizer stringtokenizer = new StringTokenizer(src, token);
			int size = stringtokenizer.countTokens();
			result = new String[size];
			for (int i = 0; stringtokenizer.hasMoreTokens(); i++) {
				result[i] = stringtokenizer.nextToken().trim();
			}
		}
		return result;
	}

	/**
	 * 数值前补0，转为指定长度的字符串
	 * 
	 * @param val
	 * @param targetLen
	 *            新字符串的总长度
	 * @return
	 */
	public static String intToStr(int val, int targetLen) {
		StringBuffer result = new StringBuffer("");

		String src = Integer.toString(val);
		if (val < 0) {
			return src;
		}

		for (int i = 0, len = (targetLen - src.length()); i < len; i++) {
			result.append("0");
		}
		result.append(src);

		// fix bug 长度超限
		if (result.length() > targetLen) {
			throw new RuntimeException("[]长度超限，期望返回的字符串总长度是" + targetLen + "，而当前数值是：" + val);
		}

		return result.toString();
	}

	/**
	 * 检查左右括号（指半角的“(”及“)”）是否匹配
	 * 
	 * @param strWithParenthesies
	 *            包含左右括号的字符串
	 * @return 
	 *         若匹配返回true，不匹配则返回false。如果strWithParenthesies为null或未包括任何括号（指半角的“(”及“
	 *         )”），亦返回true。
	 */
	public static boolean checkParenthesies(String strWithParenthesies) {
		if (strWithParenthesies != null) {
			Stack<Character> stck = new Stack<Character>();
			char c;
			for (int i = 0, len2 = strWithParenthesies.length(); i < len2; i++) {
				c = strWithParenthesies.charAt(i);
				if (c == '(') {
					stck.push(c);
				} else if (c == ')') {
					if (stck.size() > 0) {
						if ('(' == stck.peek()) {
							// 与栈顶的括号相匹配，将栈顶括号出栈
							stck.pop();
						} else {
							// 与栈顶括号不匹配，说明整个str的括号都不匹配
							return false;
						}
					} else {
						// 入栈的第一元素是右括号，说明str的括号不匹配
						return false;
					}
				}
			}
			if (stck.size() > 0) {
				// 如果栈中还有括号，说明str中的括号不匹配
				return false;
			}
		}
		return true;
	}

	/**
	 * 将字符串中的html标记、script代码块、style代码块清除掉。如果传进的参数为null或空字符串，则直接返回原值。
	 * 
	 * @param str
	 * @return
	 */
	public static String cleanHtml(String str) {
		if (str == null || "".equals(str)) {
			return str;
		}

		return PATTERN_HTML_SCRIPT.matcher(str).replaceAll("");
	}

	/**
	 * 将字符串中的html中的A标记代码块清除掉。如果传进的参数为null或空字符串，则直接返回原值。
	 * 
	 * @param str
	 * @return
	 */
	public static String cleanHtmlATag(String str) {
		if (str == null || "".equals(str)) {
			return str;
		}

		return PATTERN_HTML_A_TAG.matcher(str).replaceAll("");
	}

	/**
	 * 检查指定的字符串是否为null或空字符串（即""，或纯空白的字符串，如" "。）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkEmpty(String str) {
		return null == str || "".equals(str.trim()) ? true : false;
	}

	/**
	 * 检查strArray数组中是否包含有值为key的元素
	 * 
	 * @param key
	 * @return
	 */
	public static boolean checkInArray(String key, String[] strArray) {
		if (null == strArray) {
			throw new RuntimeException("数组为null，无法进行查找");
		} else if (null == key) {
			return false;
		}

		for (String val : strArray) {
			if (key.equals(val)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 检查这两个String数组是否包含有共同的元素。注，若其中任意一个数组为null，直接返回false.
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static boolean checkContainsCommon(String[] arr1, String[] arr2) {
		return getCommonOfArrays(arr1, arr2) != null ? true : false;
	}

	/**
	 * 提取这两个String数组共同的元素。注，若其中任意一个数组为null，直接返回null.
	 * 
	 * @param arr1
	 * @param arr2
	 * @return 当这两个数组不存在共同元素时，返回null.
	 */
	public static List<String> getCommonOfArrays(String[] arr1, String[] arr2) {
		if (null == arr1 || null == arr2) {
			return null;
		}
		List<String> commons = new ArrayList<String>();
		for (String s : arr1) {
			// 20090331w注(当前JDK版本1.5)：Arrays.binarySearch(Object arr, Object
			// key)是不可靠的，所以还是暂时使用传统的遍历方式。
			for (String s2 : arr2) {
				if (s != null && s.equals(s2)) {
					commons.add(s);
				}
			}
		}
		if (commons.isEmpty()) {
			commons = null;
		}
		return commons;
	}

	/**
	 * 匹配str是否全由英文字母组成，包括大小写。对于str为null或为空的情况，返回false.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkFullAlphabets(String str) {
		if (str == null || "".equals(str)) {
			return false;
		}
		return PATTERN_FULL_ALPHABET.matcher(str).matches();
	}

	/**
	 * 匹配str是否全由阿拉伯数字组成，包括大小写。对于str为null或为空的情况，返回false.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean checkFullNumbers(String str) {
		if (str == null || "".equals(str)) {
			return false;
		}
		return PATTERN_FULL_NUMBER.matcher(str).matches();
	}

	/**
	 * 使用当前时间（毫秒） + 随机10个数字字母的方式生成随机字符串
	 * 
	 * @return
	 */
	public static String randomString() {
		return System.currentTimeMillis() + "" + RandomStringUtils.randomAlphanumeric(10);
	}

	/**
	 * using String c to fill a String Object in the left to the fixed length,<br>
	 * 
	 * @param string
	 *            src
	 * @param length
	 *            fixed length
	 * @param c
	 *            the padding String
	 * @return
	 */
	public static String leftFillStr(String string, int length, String c) {
		String str = toNotNullStr(string);

		StringBuffer buf = new StringBuffer();
		int len = length - str.length();
		buf.append(getFixedLengthStr(len, c));
		buf.append(str);

		return buf.toString();
	}

	/**
	 * using String c to fill a String Object in the left to the fixed length,<br>
	 * 
	 * @param string
	 *            src
	 * @param length
	 *            fixed length
	 * @param c
	 *            the padding String
	 * @return
	 */
	public static String rightFillStr(String string, int length, String c) {
		String str = toNotNullStr(string);

		StringBuffer buf = new StringBuffer();
		int len = length - str.length();
		buf.append(str);
		buf.append(getFixedLengthStr(len, c));

		return buf.toString();
	}

	/**
	 * @param length
	 * @param c
	 * @return
	 */
	public static String getFixedLengthStr(int length, String c) {
		StringBuffer buf = new StringBuffer();

		int len = c.length();
		int i = 0;

		while (i < length) {
			buf.append(c);
			i += len;
		}

		return buf.toString();
	}

	/**
	 * return a not null String object.<br>
	 * if the param String object is null, then return ""; else return the param
	 * itself;
	 * 
	 * @param string
	 * @return
	 */
	public static String toNotNullStr(String string) {
		if (string == null) {
			return "";
		}
		return string;
	}

	private static String hexString = "0123456789ABCDEF ";

	/**
	 * 将字符串编码成16进制数字,适用于所有字符（包括中文）
	 */
	public static String encode(String str) {
		// 根据默认编码获取字节数组
		byte[] bytes = str.getBytes();
		StringBuilder sb = new StringBuilder(bytes.length * 2);
		// 将字节数组中每个字节拆解成2位16进制整数
		for (int i = 0; i < bytes.length; i++) {
			sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
			sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
		}
		return sb.toString();
	}

	/**
	 * 将16进制数字解码成字符串,适用于所有字符（包括中文）
	 */
	public static String decode(String bytes) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length() / 2);
		// 将每2位16进制整数组装成一个字节
		for (int i = 0; i < bytes.length(); i += 2)
			baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString.indexOf(bytes.charAt(i + 1))));
		return new String(baos.toByteArray());
	}

	/**
	 * 切割一个提示性语句,若多余length个字符,则只保留前面length个字符
	 * @param msg
	 * @param length
	 * @return
	 */
	public static String cut(String msg, int length) {
		if (msg == null) {
			return null;
		}
		if (length < 0) {
			throw new IllegalArgumentException("长度不能为负数");
		}
		if (msg.length() <= length) {
			return msg;
		} else {
			return msg.substring(0, length);
		}
	}
}
