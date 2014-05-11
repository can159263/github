package cn.szboc.platform.component.msgbean;

import cn.szboc.platform.component.msgbean.exception.MsgBeanContextInitException;

public class T extends TestInnerBean {
	public static void main(String[] args) {
		try {
			MessageBeanCotext ctx = new MessageBeanCotext(T.class);
		} catch (MsgBeanContextInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
