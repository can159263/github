package cn.szboc.platform.commons;

/**
 * 关于数组的一些常用工具方法
 */
public class ArrayUtils {

	/**
	 * 判断某个对象是否在数组中
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public static boolean isInArray(Object[] array, Object target) {
		if (array == null) {
			throw new IllegalArgumentException("数据不能为空");
		}

		if (target == null) {
			for (Object object : array) {
				if (object == null) {
					return true;
				}
			}
			return false;
		}

		for (Object object : array) {
			if (target.equals(object)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断某个整型是否在整型数组中
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public static boolean isInArray(int[] array, int target) {
		if (array == null) {
			throw new IllegalArgumentException("数据不能为空");
		}

		for (int item : array) {
			if (target == item) {
				return true;
			}
		}
		return false;
	}

	// 将字节数据dump出来
	public static String dumpBytes(byte[] data) {
		if (data == null) {
			return null;
		}
		if (data.length == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		for (byte b : data) {
			sb.append((int) b);
			sb.append(",");
		}
		// 去除最后一个逗号
		sb.setLength(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}

}
