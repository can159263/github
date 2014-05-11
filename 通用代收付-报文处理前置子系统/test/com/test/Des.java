package com.test;

import cn.szboc.platform.commons.encrypt.DesUtil;

public class Des {

	public static void main(String[] args) {
		byte[] b = DesUtil.generateRandomKey();
		System.out.println(b);
	}

}
