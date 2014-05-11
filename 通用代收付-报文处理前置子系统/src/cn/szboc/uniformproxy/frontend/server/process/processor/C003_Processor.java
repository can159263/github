package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C003REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C003RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TACCOUNTRESULTDETAIL;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("C003_Processor")
public class C003_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgC003((C003REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected C003RESPONSE getDefaultResposne() {
		C003RESPONSE response = of.createC003RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		C003RESPONSE.BODY body = of.createC003RESPONSEBODY();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}