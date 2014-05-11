package cn.szboc.uniformproxy.frontend.server.process.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import cn.szboc.uniformproxy.remoteinvoke.RemoteInvokeService;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B001REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B001RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TRESPONSEHEAD;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TSINGLETRANSACTIONRESULT;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonRequestMessage;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.interfaces.CommonResponseMessage;

@Component("B001_Processor")
public class B001_Processor extends Processor {

	private RemoteInvokeService service;

	@Autowired
	@Qualifier("remoteInvokeService")
	public void setService(RemoteInvokeService service) {
		this.service = service;
	}

	@Override
	public CommonResponseMessage process(CommonRequestMessage request) throws Exception {
		return service.dealMsgB001((B001REQUEST) request);
	}

	/**
	 * 创建响应对象
	 */
	@Override
	protected B001RESPONSE getDefaultResposne() {
		B001RESPONSE response = of.createB001RESPONSE();

		TRESPONSEHEAD head = of.createTRESPONSEHEAD();
		TSINGLETRANSACTIONRESULT body = of.createTSINGLETRANSACTIONRESULT();

		response.setHEAD(head);
		response.setBODY(body);

		return response;
	}

}