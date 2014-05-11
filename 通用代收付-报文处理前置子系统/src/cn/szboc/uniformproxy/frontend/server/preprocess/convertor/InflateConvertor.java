package cn.szboc.uniformproxy.frontend.server.preprocess.convertor;

import java.io.File;

import cn.szboc.platform.commons.compress.DeflateUtil;
import cn.szboc.uniformproxy.frontend.server.IMsgDataConvertor;
import cn.szboc.uniformproxy.frontend.server.preprocess.exception.InflateParseException;

/**
 * 解压
 */
public class InflateConvertor implements IMsgDataConvertor {

	@Override
	public byte[] convert(byte[] data) throws InflateParseException {
		if (data == null) {
			throw new InflateParseException("原始数据不能为空");
		}
		try {
			return DeflateUtil.decompress(data);
		} catch (Exception e) {
			throw new InflateParseException("数据解压异常", e);
		}
	}

	@Override
	public void convert(File srcFile, File targetFile) throws InflateParseException {

		throw new InflateParseException("暂时不支持文件方式的Infalte处理");

	}

}
