package cn.szboc.platform.component.csp.requestbuilder;

import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.trade.trade_A00400.request.RequestAdapter_A00400;
import cn.szboc.platform.component.csp.trade.trade_A00400.request.StandardRequestBean_A00400;
import cn.szboc.platform.component.csp.trade.trade_A00400.response.ResponseAdapter_A00400;
import cn.szboc.platform.component.csp.trade.trade_A00400.response.StandardResponseBean_A00400_OPT_1;
import cn.szboc.platform.component.csp.trade.trade_A00400.response.StandardResponseBean_A00400_OPT_6;

/**
 * A00400交易请求创建者,R为当调用默认newRequestWithOption时,默认设置的响应class
 */
public class RequestBuilder_A00400<R extends ResponseAdapter_A00400, SR extends R> extends
		CommonRequestBuilder<RequestAdapter_A00400<R, SR>, StandardRequestBean_A00400<R, SR>, R, SR> {

	public RequestBuilder_A00400(CspTransactionRequestBuilderFactory factory, Class<SR> clazz) {
		super(factory, clazz);
	}

	/**
	 * 创建系统自带的内置请求bean,该bean必须是该交易的全量字段的实现
	 * 
	 * @param branchNo
	 *            交易上送时的必输字段,网点号
	 * @param operator
	 *            交易上送时的必输字段,柜员号
	 * @return
	 * @throws RequestBuildingException
	 */
	public StandardRequestBean_A00400<R, SR> newRequest(String branchNo, String operator) {

		// 获取一个默认的请求bean
		StandardRequestBean_A00400<R, SR> requestBean = super.newRequest(branchNo, operator);

		if (getStdResponseClazz() == StandardResponseBean_A00400_OPT_1.class) {
			requestBean.setUpQueryOption("1");
		} else if (getStdResponseClazz() == StandardResponseBean_A00400_OPT_6.class) {
			requestBean.setUpQueryOption("6");
		}

		return requestBean;
	}

	/**
	 * 创建一个扩展的自定义的请求bean,但内置实现的字段太多时,可以用此方法,在自定义类或者匿名内部类中实现相关注解
	 * 
	 * @param requestAdapter
	 *            该模版要提供必须的字段和属性
	 */
	public RequestAdapter_A00400<R, SR> newRequest(String branchNo, String operator, RequestAdapter_A00400<R, SR> requestAdapter)
			throws RequestBuildingException {

		requestAdapter = super.newRequest(branchNo, operator, requestAdapter);

		// 对返回的适配器进行本地化配置
		if (getStdResponseClazz() == StandardResponseBean_A00400_OPT_1.class) {
			requestAdapter.setUpQueryOption("1");
		} else if (getStdResponseClazz() == StandardResponseBean_A00400_OPT_6.class) {
			requestAdapter.setUpQueryOption("6");
		}

		return requestAdapter;
	}

	/**
	 * 创建一个请求Bean
	 */
	@Override
	protected StandardRequestBean_A00400<R, SR> getStandardRequestBean() {
		return new StandardRequestBean_A00400<R, SR>();
	}
}
