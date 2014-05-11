package cn.szboc.commons;

import java.util.Arrays;

import cn.szboc.platform.commons.encrypt.DesUtil;

public class GenerateDesKey {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(DesUtil.generateRandomKey()));
	}
}
