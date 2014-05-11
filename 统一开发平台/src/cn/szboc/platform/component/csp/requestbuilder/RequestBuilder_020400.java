package cn.szboc.platform.component.csp.requestbuilder;

import cn.szboc.platform.component.csp.trade.trade_020400.request.RequestAdapter_020400;
import cn.szboc.platform.component.csp.trade.trade_020400.request.StandardRequestBean_020400;
import cn.szboc.platform.component.csp.trade.trade_020400.response.ResponseAdapter_020400;
import cn.szboc.platform.component.csp.trade.trade_020400.response.StandardResponseBean_020400;

/**
 * 020400交易请求创建者,R为当调用默认newRequestWithOption时,默认设置的响应class
 */
public class RequestBuilder_020400 extends
		CommonRequestBuilder<RequestAdapter_020400, StandardRequestBean_020400, ResponseAdapter_020400, StandardResponseBean_020400> {

	/**
	 * 隐藏父类方法,暴露非泛型方法
	 * @param factory
	 * @param clazz
	 */
	private RequestBuilder_020400(CspTransactionRequestBuilderFactory factory, Class<StandardResponseBean_020400> clazz) {
		super(factory, clazz);
	}

	public RequestBuilder_020400(CspTransactionRequestBuilderFactory factory) {
		super(factory, StandardResponseBean_020400.class);
	}

	/**
	 * 创建一个请求Bean
	 */
	@Override
	protected StandardRequestBean_020400 getStandardRequestBean() {
		return new StandardRequestBean_020400();
	}
}
