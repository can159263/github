package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.A001REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.A001RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("A001_Processor")
public class A001_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgA001((A001REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected A001RESPONSE getDefaultResposne() {
		A001RESPONSE response = of.createA001RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		A001RESPONSE.BODY body = of.createA001RESPONSEBODY();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}