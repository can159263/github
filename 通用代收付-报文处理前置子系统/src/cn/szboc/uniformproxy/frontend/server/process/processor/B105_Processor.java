package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B105REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B105RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("B105_Processor")
public class B105_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgB105((B105REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected B105RESPONSE getDefaultResposne() {
		B105RESPONSE response = of.createB105RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		B105RESPONSE.BODY body = of.createB105RESPONSEBODY();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}