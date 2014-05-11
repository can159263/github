package cn.szboc.uniformproxy.frontend.server.postprocessor.convertor;

import java.io.File;

import cn.szboc.platform.commons.compress.DeflateUtil;
import cn.szboc.uniformproxy.frontend.server.IMsgDataConvertor;
import cn.szboc.uniformproxy.frontend.server.postprocessor.exception.DeflateFormatException;

/**
 * 压缩
 */
public class DeflateHandler implements IMsgDataConvertor {

	@Override
	public byte[] convert(byte[] data) throws DeflateFormatException {
		try {
			return DeflateUtil.compress(data);
		} catch (Exception e) {
			throw new DeflateFormatException("报文压缩异常", e);
		}
	}

	@Override
	public void convert(File srcFile, File targetFile) throws DeflateFormatException {
		
		throw new DeflateFormatException("暂时不支持文件压缩");
		
	}
}
