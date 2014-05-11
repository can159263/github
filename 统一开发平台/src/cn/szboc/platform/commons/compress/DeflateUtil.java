package cn.szboc.platform.commons.compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import java.util.zip.InflaterOutputStream;

import org.apache.commons.io.IOUtils;

/**
 * 使用Deflate算法对某块数据进行压缩和解压
 * 
 */
public abstract class DeflateUtil {

	/**
	 * 对内存字节数组进行压缩,适用于少量的内存数据结构
	 * 
	 * @param data
	 *            待压缩的原始数据
	 * @return byte[] 压缩后的数据
	 */
	public static byte[] compress(byte[] data) throws IOException {

		// 校验
		if (data == null) {
			throw new IllegalArgumentException("参数data不能为空");
		}

		ByteArrayOutputStream baos = null;
		DeflaterOutputStream dos = null;
		try {
			baos = new ByteArrayOutputStream();
			dos = new DeflaterOutputStream(baos);

			IOUtils.copy(new ByteArrayInputStream(data), dos);

			dos.flush();
			dos.close();
		} finally {
			IOUtils.closeQuietly(dos);
		}

		return baos.toByteArray();
	}

	/**
	 * 对某文件进行压缩
	 * 
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public static void compress(File src, File dest) throws IOException {
		FileInputStream fis = null;
		DeflaterOutputStream dos = null;
		try {
			fis = new FileInputStream(src);
			dos = new DeflaterOutputStream(new FileOutputStream(dest));

			IOUtils.copy(fis, dos);

			dos.flush();
			dos.close();

		} finally {
			IOUtils.closeQuietly(fis);
			IOUtils.closeQuietly(dos);
		}
	}

	/**
	 * 解压缩
	 * 
	 * @param data
	 *            待解压缩的数据
	 * @return byte[] 解压缩后的数组
	 * @throws IOException 
	 */
	public static byte[] decompress(byte[] data) throws IOException {

		if (data == null) {
			throw new IllegalArgumentException("参数data不能为空");
		}

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InflaterInputStream iis = new InflaterInputStream(new ByteArrayInputStream(data));

		IOUtils.copy(iis, baos);

		iis.close();

		return baos.toByteArray();
	}

	/**
	 * 对某文件进行解压
	 * 
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public static void decompress(File src, File dest) throws IOException {
		FileOutputStream fos = null;
		InflaterInputStream dis = null;
		try {
			dis = new InflaterInputStream(new FileInputStream(src));
			fos = new FileOutputStream(dest);

			IOUtils.copy(dis, fos);

		} finally {
			IOUtils.closeQuietly(fos);
			IOUtils.closeQuietly(dis);
		}
	}

}
