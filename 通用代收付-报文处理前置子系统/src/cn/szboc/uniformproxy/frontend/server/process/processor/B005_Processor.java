package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B005REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B005RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TSINGLETRANSACTIONRESULT;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("B005_Processor")
public class B005_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgB005((B005REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected B005RESPONSE getDefaultResposne() {
		B005RESPONSE response = of.createB005RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		B005RESPONSE.BODY body = of.createB005RESPONSEBODY();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}