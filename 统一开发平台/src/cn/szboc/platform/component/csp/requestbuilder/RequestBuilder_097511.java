package cn.szboc.platform.component.csp.requestbuilder;

import cn.szboc.platform.component.csp.trade.trade_097511.request.RequestAdapter_097511;
import cn.szboc.platform.component.csp.trade.trade_097511.request.StandardRequestBean_097511;
import cn.szboc.platform.component.csp.trade.trade_097511.response.ResponseAdapter_097511;
import cn.szboc.platform.component.csp.trade.trade_097511.response.StandardResponseBean_097511;

/**
 * 097511交易请求创建者,R为当调用默认newRequestWithOption时,默认设置的响应class
 */
public class RequestBuilder_097511 extends
		CommonRequestBuilder<RequestAdapter_097511, StandardRequestBean_097511, ResponseAdapter_097511, StandardResponseBean_097511> {

	/**
	 * 隐藏父类方法,暴露非泛型方法
	 * 
	 * @param factory
	 * @param clazz
	 */
	private RequestBuilder_097511(CspTransactionRequestBuilderFactory factory, Class<StandardResponseBean_097511> clazz) {
		super(factory, clazz);
	}

	public RequestBuilder_097511(CspTransactionRequestBuilderFactory factory) {
		super(factory, StandardResponseBean_097511.class);
	}

	/**
	 * 创建一个请求Bean
	 */
	@Override
	protected StandardRequestBean_097511 getStandardRequestBean() {
		return new StandardRequestBean_097511();
	}
}
