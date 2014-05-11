package com.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.Key;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

import cn.szboc.platform.commons.compress.DeflateUtil;
import cn.szboc.platform.commons.digest.MD5Util;
import cn.szboc.platform.commons.encrypt.DesUtil;
import cn.szboc.platform.commons.encrypt.DesUtil.DesMode;


public class Main {

	public static void main(String[] args) throws Exception {
		File file = new File("F:/Projects/快付通代收代付系统/jar/send_20120601144543_020120601184750262null00000000_saFGyOfqPYvhQQVaeOUV.raw");
	
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FileUtils.copyFile(file, baos);
		
		System.out.println("总长度:" + baos.size());
		
		byte[] MD5 = Arrays.copyOfRange(baos.toByteArray(), 0, 16);
		
		byte[] content = Arrays.copyOfRange(baos.toByteArray(), 16, baos.toByteArray().length);
		
		System.out.println(Arrays.toString(MD5));
		System.out.println(Arrays.toString(MD5Util.caculate(content)));
		
		System.out.println("MD5校验成功");
		
		byte[] desContect = DeflateUtil.decompress(content);
		
		System.out.println("DES数组大小:" + desContect.length/8.0);
		
		byte[] bKey = new byte[]{7, 115, 56, -51, 124, -83, 76, -108};
				
		Key key = DesUtil.toKey(bKey);
		
		byte[] xmlContect = DesUtil.decrypt(desContect, key, DesMode.ECB_PKCS5Padding);
		
		
		System.out.println(new String(xmlContect, "utf-8"));
	}

}
