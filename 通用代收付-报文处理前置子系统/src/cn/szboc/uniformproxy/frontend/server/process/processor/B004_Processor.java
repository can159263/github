package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B004REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B004RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TSINGLETRANSACTIONRESULT;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("B004_Processor")
public class B004_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgB004((B004REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected B004RESPONSE getDefaultResposne() {
		B004RESPONSE response = of.createB004RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		B004RESPONSE.BODY body = of.createB004RESPONSEBODY();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}