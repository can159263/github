package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B003REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B003RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TSINGLETRANSACTIONRESULT;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("B003_Processor")
public class B003_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgB003((B003REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected B003RESPONSE getDefaultResposne() {
		B003RESPONSE response = of.createB003RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		B003RESPONSE.BODY body = of.createB003RESPONSEBODY();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}