package cn.szboc.platform.component.csp.requestbuilder;

import cn.szboc.platform.component.csp.trade.trade_001045.request.RequestAdapter_001045;
import cn.szboc.platform.component.csp.trade.trade_001045.request.StandardRequestBean_001045;
import cn.szboc.platform.component.csp.trade.trade_001045.response.ResponseAdapter_001045;
import cn.szboc.platform.component.csp.trade.trade_001045.response.StandardResponseBean_001045;

/**
 * 001045交易请求创建者,R为当调用默认newRequestWithOption时,默认设置的响应class
 */
public class RequestBuilder_001045 extends
		CommonRequestBuilder<RequestAdapter_001045, StandardRequestBean_001045, ResponseAdapter_001045, StandardResponseBean_001045> {

	private RequestBuilder_001045(CspTransactionRequestBuilderFactory factory, Class<StandardResponseBean_001045> clazz) {
		super(factory, clazz);
	}

	public RequestBuilder_001045(CspTransactionRequestBuilderFactory factory) {
		super(factory, StandardResponseBean_001045.class);
	}

	/**
	 * 创建一个请求Bean
	 */
	@Override
	protected StandardRequestBean_001045 getStandardRequestBean() {
		return new StandardRequestBean_001045();
	}
}
