package cn.szboc.platform.component.csp.requestbuilder;

import cn.szboc.platform.component.csp.trade.trade_056148.request.RequestAdapter_056148;
import cn.szboc.platform.component.csp.trade.trade_056148.request.StandardRequestBean_056148;
import cn.szboc.platform.component.csp.trade.trade_056148.response.ResponseAdapter_056148;
import cn.szboc.platform.component.csp.trade.trade_056148.response.StandardResponseBean_056148;

/**
 * 000440交易请求创建者,R为当调用默认newRequestWithOption时,默认设置的响应class
 * 
 * @author
 */
public class RequestBuilder_056148 extends
		CommonRequestBuilder<RequestAdapter_056148, StandardRequestBean_056148, ResponseAdapter_056148, StandardResponseBean_056148> {

	private RequestBuilder_056148(CspTransactionRequestBuilderFactory factory, Class<StandardResponseBean_056148> clazz) {
		super(factory, clazz);
	}

	public RequestBuilder_056148(CspTransactionRequestBuilderFactory factory) {
		super(factory, StandardResponseBean_056148.class);
	}

	/**
	 * 创建一个请求Bean
	 */
	@Override
	protected StandardRequestBean_056148 getStandardRequestBean() {
		return new StandardRequestBean_056148();
	}
}