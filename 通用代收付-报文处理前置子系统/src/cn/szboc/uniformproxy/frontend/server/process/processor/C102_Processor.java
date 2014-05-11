package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C102REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C102RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TACCOUNTRESULTDETAILV2;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("C102_Processor")
public class C102_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgC102((C102REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected C102RESPONSE getDefaultResposne() {
		C102RESPONSE response = of.createC102RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		TACCOUNTRESULTDETAILV2 body = of.createTACCOUNTRESULTDETAILV2();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}