package cn.szboc.platform.component.csp.requestbuilder;

import cn.szboc.platform.component.csp.trade.trade_056048.request.RequestAdapter_056048;
import cn.szboc.platform.component.csp.trade.trade_056048.request.StandardRequestBean_056048;
import cn.szboc.platform.component.csp.trade.trade_056048.response.ResponseAdapter_056048;
import cn.szboc.platform.component.csp.trade.trade_056048.response.StandardResponseBean_056048;

/**
 * 000440交易请求创建者,R为当调用默认newRequestWithOption时,默认设置的响应class
 */
public class RequestBuilder_056048 extends
		CommonRequestBuilder<RequestAdapter_056048, StandardRequestBean_056048, ResponseAdapter_056048, StandardResponseBean_056048> {

	private RequestBuilder_056048(CspTransactionRequestBuilderFactory factory, Class<StandardResponseBean_056048> clazz) {
		super(factory, clazz);
	}

	public RequestBuilder_056048(CspTransactionRequestBuilderFactory factory) {
		super(factory, StandardResponseBean_056048.class);
	}

	/**
	 * 创建一个请求Bean
	 */
	@Override
	protected StandardRequestBean_056048 getStandardRequestBean() {
		return new StandardRequestBean_056048();
	}
}
