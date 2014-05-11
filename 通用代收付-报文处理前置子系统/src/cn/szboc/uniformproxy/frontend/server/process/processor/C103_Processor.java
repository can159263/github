package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C103REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C103RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("C103_Processor")
public class C103_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgC103((C103REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected C103RESPONSE getDefaultResposne() {
		C103RESPONSE response = of.createC103RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		C103RESPONSE.BODY body = of.createC103RESPONSEBODY();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}