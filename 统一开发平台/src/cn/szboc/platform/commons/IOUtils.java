package cn.szboc.platform.commons;

import java.io.IOException;
import java.io.InputStream;

/**
 * 几个IO工具类
 */
public class IOUtils {

	/** 一直写该数组,直到灌满 */
	public static void readUntilFill(InputStream in, byte[] bs) throws IOException {
		if (null == bs) {
			throw new NullPointerException("数组参数不能为null");
		}
		int readNum = 0; // 已经读到的字节数
		while (readNum != bs.length) {
			int readedLength = in.read(bs, readNum, bs.length - readNum);
			if (readedLength == -1) {
				throw new IOException("输入流提前终止, 期望总长度为" + bs.length + ", 实际读取总长度为" + readNum);
			}
			readNum += readedLength;
		}
	}

}
