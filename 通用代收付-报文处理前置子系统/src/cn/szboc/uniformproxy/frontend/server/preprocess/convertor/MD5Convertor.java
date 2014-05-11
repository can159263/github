package cn.szboc.uniformproxy.frontend.server.preprocess.convertor;

import java.io.File;
import java.util.Arrays;

import cn.szboc.platform.commons.digest.MD5Util;
import cn.szboc.uniformproxy.frontend.server.IMsgDataConvertor;
import cn.szboc.uniformproxy.frontend.server.preprocess.exception.MD5ParseException;

/**
 * 解压处理器 原始数据指前16字节是MD5值,16字节之后是MD5值对应的数据
 */
public class MD5Convertor implements IMsgDataConvertor {

	@Override
	public byte[] convert(byte[] data) throws MD5ParseException {

		if (data == null) {
			throw new MD5ParseException("原始数据必须非空");
		}
		if (data.length <= 16) {
			throw new MD5ParseException("原始数据长度必须大于16字节");
		}

		try {
			byte[] md5 = Arrays.copyOfRange(data, 0, 16);
			byte[] innerData = Arrays.copyOfRange(data, 16, data.length);
			if (Arrays.equals(md5, MD5Util.caculate(innerData))) {
				return innerData;
			}
		} catch (Exception e) {
			throw new MD5ParseException("MD5计算异常", e);
		}
		// 如果MD5值不等要抛出异常
		throw new MD5ParseException("MD5校验失败");
	}

	@Override
	public void convert(File srcFile, File targetFile) throws MD5ParseException {

		throw new MD5ParseException("暂时不支持文件方式的Infalte处理");

	}

}
