package cn.szboc.platform.commons;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.HexDump;

/**
 * 字节的相关操作工具类
 */
public class ByteUtils {

	/**
	 * 判断某个字节数组是否为空
	 * 
	 * @param array
	 * @return
	 */
	public static boolean isEmpty(byte[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 按照顺序拼接多个数组，并返回
	 * 
	 * @param bytes
	 *            要拼接的多个数组
	 * @return 返回拼接好的新数组,不会覆盖原有任何一个数组
	 */
	public static byte[] byteJoin(byte[]... bytes) {
		if (null == bytes) {
			return null;
		}
		int rtnLength = 0;/* 要返回总数组的长度 */
		for (int i = 0; i < bytes.length; i++) {
			if (null == bytes[i]) {
				bytes[i] = new byte[0];
			}
			rtnLength += bytes[i].length;
		}
		/* 要返回的字节数组 */
		byte[] rtn = new byte[rtnLength];
		int copyedLength = 0;
		for (int i = 0; i < bytes.length; i++) {
			byte[] b = bytes[i];
			System.arraycopy(b, 0, rtn, copyedLength, b.length);
			copyedLength += b.length;
		}
		return rtn;
	}

	/**
	 * 单字节与数组拼接
	 * 
	 * @param byteValue
	 * @param bytes
	 * @return 返回拼接好的新数组,不会覆盖原有任何数据
	 */
	public static byte[] byteJoin(byte byteValue, byte[] bytes) {
		return ByteUtils.byteJoin(new byte[] { byteValue }, bytes);
	}

	/**
	 * 左侧填充
	 * 
	 * @param data
	 *            原数据
	 * @param length
	 *            填充后应该形成的数组程度
	 * @param material
	 *            填充byte,传入int超过1个字节大小将自动截取
	 * @return 返回填充后的数组
	 */
	public static byte[] leftPad(byte[] data, int length, int material) {
		if (data == null) {
			throw new NullPointerException("传入字节数组不能为null");
		}
		if (length < data.length) {
			throw new IllegalArgumentException("总长度length" + length + "小于原数据长度" + data.length);
		}
		byte[] tmp = new byte[length - data.length];
		byte materialByte = (byte) material;
		Arrays.fill(tmp, materialByte);
		return byteJoin(tmp, data);
	}

	/**
	 * 右侧填充
	 * 
	 * @param data
	 *            原数据
	 * @param length
	 *            填充后应该形成的数组程度
	 * @param material
	 *            填充byte
	 * @return 返回填充后的数组
	 */
	public static byte[] rightPad(byte[] data, int length, int material) {
		if (data == null) {
			throw new NullPointerException("传入字节数组不能为null");
		}
		if (length < data.length) {
			throw new IllegalArgumentException("总长度length" + length + "小于原数据长度" + data.length);
		}

		byte materialByte = (byte) material;

		byte[] tmp = new byte[length - data.length];
		Arrays.fill(tmp, materialByte);

		return byteJoin(data, tmp);
	}

	/**
	 * 对字节数组进行左清除
	 * 
	 * @param data
	 * @param material
	 * @return
	 */
	public static byte[] leftTrim(byte[] data, int material) {
		if (data == null) {
			throw new NullPointerException("传入字节数组不能为null");
		}

		byte materialByte = (byte) material;

		int idx = 0;
		while (idx < data.length) {
			if (data[idx] != materialByte) {
				break;
			}
			idx++;
		}
		return Arrays.copyOfRange(data, idx, data.length);
	}

	/**
	 * 对字节数组进行右清除
	 * 
	 * @param data
	 * @param material
	 * @return
	 */
	public static byte[] rightTrim(byte[] data, int material) {
		if (data == null) {
			throw new NullPointerException("传入字节数组不能为null");
		}

		byte materialByte = (byte) material;

		int idx = data.length - 1;
		while (idx >= 0) {
			if (data[idx] != materialByte) {
				break;
			}
			idx--;
		}
		return Arrays.copyOfRange(data, 0, idx + 1);
	}

	/**
	 * 将某个整型数据转换成4个字节的数组
	 * 
	 * @param i
	 * @return
	 */
	public static byte[] transformInteger(int v) {

		byte[] tmp = new byte[4];

		tmp[0] = (byte) ((v >>> 24) & 0xFF);
		tmp[1] = (byte) ((v >>> 16) & 0xFF);
		tmp[2] = (byte) ((v >>> 8) & 0xFF);
		tmp[3] = (byte) ((v >>> 0) & 0xFF);

		return tmp;

	}

	/**
	 * 将4个字节数组转为int
	 * 
	 * @param i
	 * @return
	 */
	public static int parseInteger(byte[] data) {

		if (data == null || data.length != 4) {
			throw new IllegalArgumentException("非法参数数组,必须是4字节");
		}

		try {
			return new DataInputStream(new ByteArrayInputStream(data)).readInt();
		} catch (IOException e) {
			throw new IllegalArgumentException("非法参数", e);
		}

	}

	/** 内部十六进制数字 */
	private static final String hexStr = "0123456789ABCDEF";

	/** 
	 *  
	 * @param bytes 
	 * @return 将二进制转换为十六进制字符输出 
	 */
	public static String binaryToHexString(byte[] bytes) {

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			//字节高4位  
			result.append(hexStr.charAt((bytes[i] & 0xF0) >> 4));
			//字节低4位  
			result.append(hexStr.charAt(bytes[i] & 0x0F));
		}
		return result.toString();
	}

	/** 
	 *  
	 * @param hexString 
	 * @return 将十六进制转换为字节数组 
	 */
	public static byte[] hexStringToBinary(String hexString) {
		
		if(hexString == null){
			throw new NullPointerException("hexString 不允许为空");
		}
		
		if(hexString.length() == 0){
			throw new IllegalArgumentException("hexString 长度不能为0");
		}
		
		//hexString的长度对2取整，作为bytes的长度  
		int len = hexString.length() / 2;
		byte[] bytes = new byte[len];
		byte high = 0;//字节高四位  
		byte low = 0;//字节低四位  

		for (int i = 0; i < len; i++) {
			//右移四位得到高位  
			high = (byte) ((hexStr.indexOf(hexString.charAt(2 * i))) << 4);
			low = (byte) hexStr.indexOf(hexString.charAt(2 * i + 1));
			bytes[i] = (byte) (high | low);//高地位做或运算  
		}
		
		return bytes;
	}

}
