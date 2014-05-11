package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C104REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C104RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("C104_Processor")
public class C104_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgC104((C104REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected C104RESPONSE getDefaultResposne() {
		C104RESPONSE response = of.createC104RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		C104RESPONSE.BODY body = of.createC104RESPONSEBODY();
		C104RESPONSE.BODY.DETAILS details = of.createC104RESPONSEBODYDETAILS();
		
		response.setHEAD(head);
		
		body.setDETAILS(details);
		response.setBODY(body);

		return response;
	}

}