package cn.szboc.request;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.Socket;
import java.security.Key;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import cn.szboc.platform.commons.ByteUtils;
import cn.szboc.platform.commons.compress.DeflateUtil;
import cn.szboc.platform.commons.digest.MD5Util;
import cn.szboc.platform.commons.encrypt.DesUtil;
import cn.szboc.platform.commons.encrypt.DesUtil.DesMode;

public class TestDecode {

	private byte[] key = { 7, 115, 56, -51, 124, -83, 76, -108 };

	@Test
	public void test() throws Exception {

		Key k = DesUtil.toKey(key);
		
		File file = new File("F:/Projects/快付通代收代付系统/设计文档/通信报文规则/统一/xml与xsd/recv1165528449319564021.raw");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FileUtils.copyFile(file, baos);

		byte[] response = baos.toByteArray();

		byte[] respData = Arrays.copyOfRange(response, 10, response.length);

		byte[] md5value = MD5Util.caculate(Arrays.copyOfRange(respData, 16, respData.length));
		if (!Arrays.equals(md5value, Arrays.copyOfRange(respData, 0, 16))) {
			System.out.println("MD5异常");
		} else {
			System.out.println("MD5正常");
			byte[] decompress = DeflateUtil.decompress(Arrays.copyOfRange(respData, 16, respData.length));
			byte[] respDes = DesUtil.decrypt(decompress, k, DesMode.ECB_PKCS5Padding);
			System.out.println("响应报文:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(new String(respDes));
			System.out.println("响应报文:<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}

	}
}