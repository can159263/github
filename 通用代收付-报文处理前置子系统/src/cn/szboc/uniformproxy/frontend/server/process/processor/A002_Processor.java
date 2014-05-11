package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.A002REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.A002RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("A002_Processor")
public class A002_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgA002((A002REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected A002RESPONSE getDefaultResposne() {
		A002RESPONSE response = of.createA002RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		A002RESPONSE.BODY body = of.createA002RESPONSEBODY();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}