package cn.szboc.commons;

import java.util.Arrays;

import org.junit.Test;

import cn.szboc.platform.commons.encrypt.DesUtil;

public class DesTest {

	private static byte[] keyBytes = new byte[] { 52, 55, 98, 25, 37, 124, 98, 121 };
	
	@Test
	public void test() {
		
		try {
			byte[] x = "".getBytes("GBK");
			//byte[] y = DesUtil.encrypt(x, keyBytes);
			//byte[] xx = DesUtil.decrypt(y, keyBytes);
			//System.out.println(Arrays.equals(x, xx));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
