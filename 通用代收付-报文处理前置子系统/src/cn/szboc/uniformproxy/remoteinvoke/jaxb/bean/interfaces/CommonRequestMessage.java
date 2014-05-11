package cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces;

import java.io.Serializable;

import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TREQUESTHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TTRANSMSGTYPE;

/**
 * 通用请求信息
 */
public abstract class CommonRequestMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract TREQUESTHEAD getHEAD();

	public abstract TTRANSMSGTYPE getTransType();

	/**
	 * 获取请求的参数信息
	 * @return
	 */
	public String getArgumentInfo() {
		return null;
	}

}
