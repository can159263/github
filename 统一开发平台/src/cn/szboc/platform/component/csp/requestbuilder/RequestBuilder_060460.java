package cn.szboc.platform.component.csp.requestbuilder;

import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.trade.trade_060460.request.RequestAdapter_060460;
import cn.szboc.platform.component.csp.trade.trade_060460.request.StandardRequestBean_060460;
import cn.szboc.platform.component.csp.trade.trade_060460.response.ResponseAdapter_060460;
import cn.szboc.platform.component.csp.trade.trade_060460.response.StandardResponseBean_060460_OPT_A;
import cn.szboc.platform.component.csp.trade.trade_060460.response.StandardResponseBean_060460_OPT_B;

/**
 * 060460交易请求创建者,R为当调用默认newRequestWithOption时,默认设置的响应class
 */
public class RequestBuilder_060460<R extends ResponseAdapter_060460, SR extends R> extends
		CommonRequestBuilder<RequestAdapter_060460<R, SR>, StandardRequestBean_060460<R, SR>, R, SR> {

	public RequestBuilder_060460(CspTransactionRequestBuilderFactory factory, Class<SR> clazz) {
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
	public StandardRequestBean_060460<R, SR> newRequest(String branchNo, String operator)  {
		// 获取一个默认的请求bean
		StandardRequestBean_060460<R, SR> requestBean = super.newRequest(branchNo, operator);
		if (getStdResponseClazz() == StandardResponseBean_060460_OPT_A.class) {
			requestBean.setUpStdQueryOption("A");
		} else if (getStdResponseClazz() == StandardResponseBean_060460_OPT_B.class) {
			requestBean.setUpStdQueryOption("B");
		}
		return requestBean;
	}

	/**
	 * 创建一个扩展的自定义的请求bean,但内置实现的字段太多时,可以用此方法,在自定义类或者匿名内部类中实现相关注解
	 * 
	 * @param requestAdapter
	 *            该模版要提供必须的字段和属性
	 */
	public RequestAdapter_060460<R, SR> newRequest(String branchNo, String operator, RequestAdapter_060460<R, SR> requestAdapter)
			throws RequestBuildingException {
		requestAdapter = super.newRequest(branchNo, operator, requestAdapter);
		// 对返回的适配器进行本地化配置
		if (getStdResponseClazz() == StandardResponseBean_060460_OPT_A.class) {
			requestAdapter.setUpStdQueryOption("A");
		} else if (getStdResponseClazz() == StandardResponseBean_060460_OPT_B.class) {
			requestAdapter.setUpStdQueryOption("B");
		}
		return requestAdapter;
	}

	/**
	 * 创建一个请求Bean
	 */
	@Override
	protected StandardRequestBean_060460<R, SR> getStandardRequestBean() {
		return new StandardRequestBean_060460<R, SR>();
	}
}