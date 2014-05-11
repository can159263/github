package cn.szboc.request;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.commons.io.FileUtils;

import cn.szboc.platform.commons.IOUtils;

public class TestBatchResposne {

	public static void main(String[] args) throws Exception {

		File file = new File("F:/Projects/快付通代收代付系统/设计文档/通信报文规则/统一/xml与xsd/eces_response.xml");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		FileUtils.copyFile(file, baos);

		Socket socket = new Socket("127.0.0.1", 2000);

		int length = baos.size();

		// 报文最前面是8位的报文长度
		String lengthStr = ("00000000" + length);
		lengthStr = lengthStr.substring(lengthStr.length() - 8);

		OutputStream os = socket.getOutputStream();
		os.write(lengthStr.getBytes());
		os.write("ECES002099999999999999999999999999999999".getBytes());
		os.write(baos.toByteArray());
		
		os.flush();
		
		InputStream is = socket.getInputStream();
		
		byte[] lengthBytes = new byte[8];
		IOUtils.readUntilFill(is, lengthBytes);
		
		int respLength = Integer.parseInt(new String(lengthBytes));
		
		byte[] respData = new byte[respLength];
		
		is.skip(40);
		IOUtils.readUntilFill(is, respData);
		
		System.out.println("响应信息");
		System.out.println(new String(respData, "GBK"));
		
		socket.close();
	}

}
