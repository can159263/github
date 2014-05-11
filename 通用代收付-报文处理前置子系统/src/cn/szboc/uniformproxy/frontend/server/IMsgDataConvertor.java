package cn.szboc.uniformproxy.frontend.server;

import java.io.File;

/**
 * 报文数据转换器,将报文从一种形式转为另外一种形式
 */
public interface IMsgDataConvertor {

	/**
	 * 转换二进制数据
	 * 
	 * @param data 转换前的数据
	 * @return 转换后的数据
	 * @throws Exception
	 */
	public byte[] convert(byte[] data) throws Exception;

	/**
	 * 转换文件数据
	 * 
	 * @param srcFile 转换前原文件
	 * @param targetFile 转换后源文件
	 * @throws Exception
	 */
	public void convert(File srcFile, File targetFile) throws Exception;

}
