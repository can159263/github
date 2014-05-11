package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C004REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C004RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("C004_Processor")
public class C004_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgC004((C004REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected C004RESPONSE getDefaultResposne() {
		C004RESPONSE response = of.createC004RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		C004RESPONSE.BODY body = of.createC004RESPONSEBODY();
		C004RESPONSE.BODY.DETAILS details = of.createC004RESPONSEBODYDETAILS();
		
		response.setHEAD(head);
		
		body.setDETAILS(details);
		response.setBODY(body);

		return response;
	}

}