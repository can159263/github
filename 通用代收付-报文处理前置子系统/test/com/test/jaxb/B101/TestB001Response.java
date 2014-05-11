package com.test.jaxb.B101;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.Socket;
import java.security.Key;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import cn.szboc.platform.commons.ByteUtils;
import cn.szboc.platform.commons.DateUtils;
import cn.szboc.platform.commons.compress.DeflateUtil;
import cn.szboc.platform.commons.digest.MD5Util;
import cn.szboc.platform.commons.encrypt.DesUtil;
import cn.szboc.platform.commons.encrypt.DesUtil.DesMode;
import cn.szboc.platform.component.xmlbean.nospring.XmlBeanMapping;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B101REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.ObjectFactory;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TREQUESTHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TTRANSDETAILV2;

@ContextConfiguration(locations = "classpath*:MessageRecvApplicatonContext.xml")
public class TestB001Response extends AbstractJUnit4SpringContextTests {

	@Autowired
	@Qualifier("KEY_XML_BEAN_MAPPING")
	private XmlBeanMapping xmlBeanMapping;

	@Test
	public void testOut() {

		for (int i = 0; i < 300; i++) {
			create();
		}

	}

	private void create() {
		String msgId = DateUtils.getDateTimeStrNo() + RandomStringUtils.randomAlphanumeric(16);

		File file = new File("d:/kft/" + msgId + ".xml");
		FileOutputStream fos = null;
		try {
			file.createNewFile();
			fos = new FileOutputStream(file);
		} catch (Exception e1) {
			e1.printStackTrace();
			Assert.fail("1");
		}

		ObjectFactory of = new ObjectFactory();

		B101REQUEST request = of.createB101REQUEST();

		TREQUESTHEAD head = of.createTREQUESTHEAD();

		head.setSYSCODE("S007");
		head.setMSGID(msgId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			head.setSENDTIMESTAMP(sdf.parse("2012-12-10 12:00:00"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		TTRANSDETAILV2 detail = of.createTTRANSDETAILV2();
		detail.setTRANSNO(DateUtils.getDateTimeStrNo() + RandomStringUtils.randomNumeric(6));
		detail.setTRANSDATE(new Date());
		detail.setACCOUNTNO("744557189184");
		detail.setACCOUNTNAME("刘金");
		detail.setMONEY(new BigDecimal("0.01"));
		detail.setUSEITEM("700");
		detail.setCOMPANYNAME("YYY");
		detail.setCOMPANYLINKMAN("YYY");
		detail.setCOMPANYTEL("YYY");

		request.setHEAD(head);
		request.setBODY(detail);

		try {
			xmlBeanMapping.beanToStream(request, fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private byte[] key = { 93, 115, 121, -108, 31, -101, 44, 69 };

	@Test
	public void testSend() throws Exception {

		ExecutorService es = Executors.newFixedThreadPool(5);

		File dir = new File("d:/kft");
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			
			final int idx = i;
			final File file = files[idx];
			
			es.submit(new Runnable() {

				@Override
				public void run() {
					try {
						System.out.println("$$$$$$$$$$$$  " + idx);
						Resource resource = new FileSystemResource(file);

						InputStream is = resource.getInputStream();

						byte[] data = new byte[is.available()];

						if (is.read(data) != file.length()) {
							Assert.fail("没有读完");
						} else {
							System.out.println("请求报文:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
							System.out.println("共有字节数:" + data.length);
							System.out.println(new String(data, "UTF-8"));
							System.out.println("请求报文:<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
						}

						Key k = DesUtil.toKey(key);

						// 加密
						data = DesUtil.encrypt(data, k, DesMode.ECB_PKCS5Padding);

						// 压缩
						data = DeflateUtil.compress(data);

						// 计算MD5
						byte[] md5 = MD5Util.caculate(data);

						// 拼接MD5
						data = ByteUtils.byteJoin(md5, data);

						System.out.println("MD5+报文数组长度:" + data.length);
						//将某个整型数据转换成4个字节的数组
						byte[] headData = ByteUtils.transformInteger(data.length);
						//按照顺序拼接多个数组，并返回
						byte[] finalData = ByteUtils.byteJoin("S007".getBytes(), headData, data);

						System.out.println("发送报文数据:");
						System.out.println("发送报文数据总长度:" + finalData.length);
						System.out.println(Arrays.toString(finalData));

						Socket s = new Socket("22.145.28.48", 15000);
						s.getOutputStream().write(finalData);
						s.getOutputStream().flush();

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

						if (respString.equals("00")) {
							byte[] md5value = MD5Util.caculate(Arrays.copyOfRange(respData, 16, respData.length));
							if (!Arrays.equals(md5value, Arrays.copyOfRange(respData, 0, 16))) {
								System.out.println("MD5异常");
							} else {
								System.out.println("MD5正常");
								byte[] decompress = DeflateUtil.decompress(Arrays.copyOfRange(respData, 16, respData.length));
								byte[] respDes = DesUtil.decrypt(decompress, k, DesMode.ECB_PKCS5Padding);
								System.out.println("响应报文:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
								System.out.println();
								System.out.println(new String(respDes, "UTF-8"));
								System.out.println("响应`报文:<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
							}
						} else {
							System.out.println("响应信息:" + new String(respData, "UTF-8"));
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			});

		}
		Thread.sleep(5 * 60* 1000);
	}
}
