package cn.szboc.uniformproxy.frontend.server.postprocessor.convertor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import cn.szboc.platform.commons.digest.MD5Util;
import cn.szboc.uniformproxy.frontend.server.IMsgDataConvertor;
import cn.szboc.uniformproxy.frontend.server.postprocessor.exception.MD5FormatException;

/**
 * 解压处理器
 */
public class MD5Handler implements IMsgDataConvertor {

	@Override
	public byte[] convert(byte[] data) throws MD5FormatException {
		if (data == null) {
			throw new MD5FormatException("原始数据必须非空");
		}

		byte[] md5Value = null;
		try {
			md5Value = MD5Util.caculate(data);
		} catch (Exception e) {
			throw new MD5FormatException("MD5计算异常", e);
		}

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			baos.write(md5Value);
			baos.write(data);
		} catch (IOException e) {
			throw new MD5FormatException("MD5值拼接异常", e);
		}
		return baos.toByteArray();

	}

	@Override
	public void convert(File srcFile, File targetFile) throws MD5FormatException {

		throw new MD5FormatException("暂时不支持文件MD5操作");

	}

}
