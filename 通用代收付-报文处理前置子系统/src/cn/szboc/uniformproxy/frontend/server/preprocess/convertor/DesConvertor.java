package cn.szboc.uniformproxy.frontend.server.preprocess.convertor;

import java.io.File;
import java.security.Key;

import org.springframework.beans.factory.annotation.Required;

import cn.szboc.platform.commons.encrypt.DesUtil;
import cn.szboc.platform.commons.encrypt.DesUtil.DesMode;
import cn.szboc.uniformproxy.frontend.server.IMsgDataConvertor;
import cn.szboc.uniformproxy.frontend.server.preprocess.exception.DesParseException;
import cn.szboc.uniformproxy.frontend.system.SystemConfigBean;

/**
 * DES加密异常
 */
public class DesConvertor implements IMsgDataConvertor {

	private byte[] key;

	private Key k;

	public byte[] getKey() {
		return key;
	}

	@Required
	public void setConfigBean(SystemConfigBean configBean) {
		if (configBean == null) {
			throw new NullPointerException("configBean 不能为空");
		}
		this.key = configBean.getDesKey();
		if (key == null) {
			throw new NullPointerException("key 不能为空");
		}
		try {
			this.k = DesUtil.toKey(key);
		} catch (Exception e) {
			throw new IllegalArgumentException("非法密钥", e);
		}
	}

	@Override
	public byte[] convert(byte[] data) throws DesParseException {
		if (data == null) {
			throw new DesParseException("原始数据必须非空");
		}
		try {
			return DesUtil.decrypt(data, k, DesMode.ECB_PKCS5Padding);
		} catch (Exception e) {
			throw new DesParseException("数据解密异常", e);
		}
	}

	@Override
	public void convert(File srcFile, File targetFile) throws DesParseException {

		throw new DesParseException("暂时不支持文件方式的Infalte处理");

	}

}
