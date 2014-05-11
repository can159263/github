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

public class TestRequestS004 {

	private byte[] key = { -48, 56, 118, 121, 8, 112, -82, -125 };
	
	@Test
	public void test() throws Exception {
		
		File file = new File("F:/Projects/快付通代收代付系统/设计文档/通信报文规则/统一/xml与xsd/B001_request.xml");
		
		
		Resource resource = new FileSystemResource(file);
		
		InputStream is = resource.getInputStream();
		
		byte[] data = new byte[is.available()];
		
		if (is.read(data) != file.length()) {
			Assert.fail("没有读完");
		} else {
			System.out.println("请求报文:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println(new String(data, "UTF-8"));
			System.out.println("请求报文:<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		}

		//System.out.println(">>>>>>>>>>" + Arrays.toString(data));

		Key k = DesUtil.toKey(key);

		// 加密
		data = DesUtil.encrypt(data, k, DesMode.ECB_PKCS5Padding);

		FileUtils.writeByteArrayToFile(new File("F:/Projects/快付通代收代付系统/设计文档/通信报文规则/统一/xml与xsd/A001_request.des"), data);
		
		// 压缩
		data = DeflateUtil.compress(data);
		
		FileUtils.writeByteArrayToFile(new File("F:/Projects/快付通代收代付系统/设计文档/通信报文规则/统一/xml与xsd/A001_request.compress"), data);

		// 计算MD5
		byte[] md5 = MD5Util.caculate(data);

		// 拼接MD5
		data = ByteUtils.byteJoin(md5, data);

		FileUtils.writeByteArrayToFile(new File("F:/Projects/快付通代收代付系统/设计文档/通信报文规则/统一/xml与xsd/A001_request.md5"), data);
		
		System.out.println("MD5+报文数组长度:" + data.length);
		//将某个整型数据转换成4个字节的数组
		byte[] headData = ByteUtils.transformInteger(data.length);
		//按照顺序拼接多个数组，并返回
		byte[] finalData = ByteUtils.byteJoin("S004".getBytes(), headData, data);

		System.out.println("发送报文数据:");
		System.out.println("发送报文数据总长度:" + finalData.length);
		System.out.println(Arrays.toString(finalData));
		
//		Socket s = new Socket("22.145.27.92", 15000);
		Socket s = new Socket("22.145.28.48", 15000);
		s.getOutputStream().write(finalData);
		s.getOutputStream().flush();
		
		//s.shutdownOutput();
		
		System.out.println("发送完毕,开始接收响应");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		
		IOUtils.copy(s.getInputStream(), baos);
		
		byte[] response = baos.toByteArray();
		
		System.out.println("接收到响应字节数为:" + response.length);
		System.out.println("接收到系统别为:" + new String(response, 0, 4));
		String respString = new String(response, 4, 2);
		System.out.println("接收到响应码为:" + respString);

		int length = ByteUtils.parseInteger(Arrays.copyOfRange(response, 6, 10));
		System.out.println("后续加密流的长度为:" + length);
		byte[] respData = Arrays.copyOfRange(response, 10, response.length);
		
		if(respString.equals("00")){
			byte[] md5value = MD5Util.caculate(Arrays.copyOfRange(respData, 16, respData.length));
			if(!Arrays.equals(md5value, Arrays.copyOfRange(respData, 0, 16))){
				System.out.println("MD5异常");
			}else{
				System.out.println("MD5正常");
				byte[] decompress = DeflateUtil.decompress(Arrays.copyOfRange(respData, 16, respData.length));
				byte[] respDes = DesUtil.decrypt(decompress, k, DesMode.ECB_PKCS5Padding);
				System.out.println("响应报文:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
				System.out.println();
				System.out.println(new String(respDes, "UTF-8"));
				System.out.println("响应`报文:<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			}
		}else{
			System.out.println("响应信息:" + new String(respData, "UTF-8"));
		}
	}
}