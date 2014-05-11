package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B002REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B002RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TSINGLETRANSACTIONRESULT;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("B002_Processor")
public class B002_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgB002((B002REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected B002RESPONSE getDefaultResposne() {
		B002RESPONSE response = of.createB002RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		TSINGLETRANSACTIONRESULT body = of.createTSINGLETRANSACTIONRESULT();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}