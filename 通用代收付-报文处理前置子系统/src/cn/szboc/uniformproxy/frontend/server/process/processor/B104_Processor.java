package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B104REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B104RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("B104_Processor")
public class B104_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgB104((B104REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected B104RESPONSE getDefaultResposne() {
		B104RESPONSE response = of.createB104RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		B104RESPONSE.BODY body = of.createB104RESPONSEBODY();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}