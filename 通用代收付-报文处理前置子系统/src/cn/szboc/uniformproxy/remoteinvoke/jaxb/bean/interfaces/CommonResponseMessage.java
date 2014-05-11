package cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces;

import java.io.Serializable;

import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;

public abstract class CommonResponseMessage implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public abstract TRESPONSEHEAD getHEAD();
	
}
