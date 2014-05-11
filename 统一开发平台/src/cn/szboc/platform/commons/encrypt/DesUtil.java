package cn.szboc.platform.commons.encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.lang3.RandomStringUtils;

import cn.szboc.platform.commons.ByteUtils;

/**
 * DES加密解密组件
 */
public class DesUtil {

	/**
	 * DES工作模式,有很多种,这里只写出最常用的2种
	 */
	public static enum DesMode {

		ECB_NOPADDING("DES/ECB/NoPadding"),

		ECB_PKCS5Padding("DES/ECB/PKCS5Padding");

		private final String mode;

		DesMode(String mode) {
			this.mode = mode;
		}

		public String getMode() {
			return mode;
		}

	}

	/**
	 * 将二进制的字节密钥转为对象
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static Key toKey(byte[] key) throws Exception {

		DESKeySpec dks = new DESKeySpec(key);

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");

		SecretKey sk = keyFactory.generateSecret(dks);

		return sk;
	}

	// 解密
	public static byte[] decrypt(byte[] data, Key k, DesMode mode) throws Exception {
		if (mode == null) {
			throw new NullPointerException("mode 不能为空");
		}
		Cipher cipher = Cipher.getInstance(mode.getMode());
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	// 加密
	public static byte[] encrypt(byte[] data, Key k, DesMode mode) throws Exception {
		if (mode == null) {
			throw new NullPointerException("mode 不能为空");
		}
		Cipher cipher = Cipher.getInstance(mode.getMode());
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	// 加密
	public static void encrypt(File src, File dest, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, k);

		FileInputStream fis = new FileInputStream(src);
		CipherOutputStream cos = new CipherOutputStream(new FileOutputStream(dest), cipher);

		byte[] buffer = new byte[1024];
		int length = -1;

		while ((length = fis.read(buffer)) != -1) {
			cos.write(buffer, 0, length);
		}

		cos.flush();

		cos.close();
		fis.close();
	}

	// 解密
	public static void decrypt(File src, File dest, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, k);

		FileOutputStream fos = new FileOutputStream(dest);
		CipherInputStream cis = new CipherInputStream(new FileInputStream(src), cipher);

		byte[] buffer = new byte[1024];
		int length = -1;

		while ((length = cis.read(buffer)) != -1) {
			fos.write(buffer, 0, length);
		}

		fos.flush();

		fos.close();
		cis.close();
	}

	public static byte[] generateRandomKey() {
		
		KeyGenerator kg = null;
		try {
			kg = KeyGenerator.getInstance("DES");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("JDK不支持此算法[DES]", e);
		}

		kg.init(56);

		SecretKey secretKey = kg.generateKey();

		return secretKey.getEncoded();
	}

}
