package cn.szboc.platform.component.csp.requestbuilder;

import cn.szboc.platform.component.csp.trade.trade_000440.request.RequestAdapter_000440;
import cn.szboc.platform.component.csp.trade.trade_000440.request.StandardRequestBean_000440;
import cn.szboc.platform.component.csp.trade.trade_000440.response.ResponseAdapter_000440;
import cn.szboc.platform.component.csp.trade.trade_000440.response.StandardResponseBean_000440;

/**
 * 000440交易请求创建者,R为当调用默认newRequestWithOption时,默认设置的响应class
 */
public class RequestBuilder_000440 extends
		CommonRequestBuilder<RequestAdapter_000440, StandardRequestBean_000440, ResponseAdapter_000440, StandardResponseBean_000440> {

	/**
	 * 隐藏父类方法,暴露非泛型方法
	 * @param factory
	 * @param clazz
	 */
	private RequestBuilder_000440(CspTransactionRequestBuilderFactory factory, Class<StandardResponseBean_000440> clazz) {
		super(factory, clazz);
	}

	public RequestBuilder_000440(CspTransactionRequestBuilderFactory factory) {
		super(factory, StandardResponseBean_000440.class);
	}

	/**
	 * 创建一个请求Bean
	 */
	@Override
	protected StandardRequestBean_000440 getStandardRequestBean() {
		return new StandardRequestBean_000440();
	}
}
