package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C001REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C001RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("C001_Processor")
public class C001_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgC001((C001REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected C001RESPONSE getDefaultResposne() {
		C001RESPONSE response = of.createC001RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		C001RESPONSE.BODY body = of.createC001RESPONSEBODY();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}