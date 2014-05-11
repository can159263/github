package cn.szboc.platform.component.csp.requestbuilder;

import cn.szboc.platform.component.csp.trade.trade_009751.request.RequestAdapter_009751;
import cn.szboc.platform.component.csp.trade.trade_009751.request.StandardRequestBean_009751;
import cn.szboc.platform.component.csp.trade.trade_009751.response.ResponseAdapter_009751;
import cn.szboc.platform.component.csp.trade.trade_009751.response.StandardResponseBean_009751;

/**
 * 009751交易请求创建者
 */
public class RequestBuilder_009751 extends
		CommonRequestBuilder<RequestAdapter_009751, StandardRequestBean_009751, ResponseAdapter_009751, StandardResponseBean_009751> {

	/**
	 * 隐藏父类方法,暴露非泛型方法
	 * 
	 * @param factory
	 * @param clazz
	 */
	private RequestBuilder_009751(CspTransactionRequestBuilderFactory factory, Class<StandardResponseBean_009751> clazz) {
		super(factory, clazz);
	}

	public RequestBuilder_009751(CspTransactionRequestBuilderFactory factory) {
		super(factory, StandardResponseBean_009751.class);
	}

	/**
	 * 创建一个请求Bean
	 */
	@Override
	protected StandardRequestBean_009751 getStandardRequestBean() {
		return new StandardRequestBean_009751();
	}
}
