package cn.szboc.platform.component.ctg;

import cn.szboc.platform.component.ctg.exception.CtgCommonException;

/**
 * CTG模块统一调用接口
 */
public interface ICtgMessageSend {

	
	public byte[] execute(byte[] param) throws CtgCommonException;

}
