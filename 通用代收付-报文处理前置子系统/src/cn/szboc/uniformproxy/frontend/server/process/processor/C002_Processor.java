package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C002REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C002RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TACCOUNTRESULTDETAIL;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("C002_Processor")
public class C002_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgC002((C002REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected C002RESPONSE getDefaultResposne() {
		C002RESPONSE response = of.createC002RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		TACCOUNTRESULTDETAIL body = of.createTACCOUNTRESULTDETAIL();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}