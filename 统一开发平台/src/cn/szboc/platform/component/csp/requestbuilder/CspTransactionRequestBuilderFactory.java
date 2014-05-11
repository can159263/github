package cn.szboc.platform.component.csp.requestbuilder;

import java.util.List;

import cn.szboc.platform.component.csp.exception.RequestBuildingException;
import cn.szboc.platform.component.csp.exception.RollbackWarningException;
import cn.szboc.platform.component.csp.trade.trade_000400.request.StandardRequestBean_000400;
import cn.szboc.platform.component.csp.trade.trade_000400.response.ResponseAdapter_000400_OPT_1;
import cn.szboc.platform.component.csp.trade.trade_000400.response.ResponseAdapter_000400_OPT_6;
import cn.szboc.platform.component.csp.trade.trade_000400.response.StandardResponseBean_000400_OPT_1;
import cn.szboc.platform.component.csp.trade.trade_000400.response.StandardResponseBean_000400_OPT_6;
import cn.szboc.platform.component.csp.trade.trade_000440.request.StandardRequestBean_000440;
import cn.szboc.platform.component.csp.trade.trade_000440.response.StandardResponseBean_000440;
import cn.szboc.platform.component.csp.trade.trade_001045.request.StandardRequestBean_001045;
import cn.szboc.platform.component.csp.trade.trade_001045.response.StandardResponseBean_001045;
import cn.szboc.platform.component.csp.trade.trade_009751.request.StandardRequestBean_009751;
import cn.szboc.platform.component.csp.trade.trade_009751.response.StandardResponseBean_009751;
import cn.szboc.platform.component.csp.trade.trade_020400.request.StandardRequestBean_020400;
import cn.szboc.platform.component.csp.trade.trade_020400.response.StandardResponseBean_020400;
import cn.szboc.platform.component.csp.trade.trade_056048.request.StandardRequestBean_056048;
import cn.szboc.platform.component.csp.trade.trade_056048.response.StandardResponseBean_056048;
import cn.szboc.platform.component.csp.trade.trade_056148.request.StandardRequestBean_056148;
import cn.szboc.platform.component.csp.trade.trade_056148.response.StandardResponseBean_056148;
import cn.szboc.platform.component.csp.trade.trade_060460.request.StandardRequestBean_060460;
import cn.szboc.platform.component.csp.trade.trade_060460.response.ResponseAdapter_060460_OPT_A;
import cn.szboc.platform.component.csp.trade.trade_060460.response.ResponseAdapter_060460_OPT_B;
import cn.szboc.platform.component.csp.trade.trade_060460.response.StandardResponseBean_060460_OPT_A;
import cn.szboc.platform.component.csp.trade.trade_060460.response.StandardResponseBean_060460_OPT_B;
import cn.szboc.platform.component.csp.trade.trade_097511.request.StandardRequestBean_097511;
import cn.szboc.platform.component.csp.trade.trade_097511.response.StandardResponseBean_097511;
import cn.szboc.platform.component.csp.trade.trade_A00400.request.StandardRequestBean_A00400;
import cn.szboc.platform.component.csp.trade.trade_A00400.response.ResponseAdapter_A00400_OPT_1;
import cn.szboc.platform.component.csp.trade.trade_A00400.response.ResponseAdapter_A00400_OPT_6;
import cn.szboc.platform.component.csp.trade.trade_A00400.response.StandardResponseBean_A00400_OPT_1;
import cn.szboc.platform.component.csp.trade.trade_A00400.response.StandardResponseBean_A00400_OPT_6;
import cn.szboc.platform.component.csp.transaction.TransactionManager;
import cn.szboc.platform.component.ctg.ICtgMessageSend;
import cn.szboc.platform.component.msgbean.MessageBeanCotext;
import cn.szboc.platform.component.msgbean.exception.MsgBeanContextInitException;

/**
 * CSP请求生成器
 */
public class CspTransactionRequestBuilderFactory {

	/**
	 * 保存了交易的历史记录
	 */
	private ThreadLocal<TransactionManager> transactionManager = new ThreadLocal<TransactionManager>(){
		
		protected TransactionManager initialValue() {
			return new TransactionManager();
		};
		
	};
	
	public boolean isInTransaction(){
		return transactionManager.get().isInTransaction();
	}
	
	public void beginTransaction(){
		transactionManager.get().beginTransaction();
	}
	
	public void commit(){
		transactionManager.get().commit();
	}
	
	public List<RollbackWarningException> rollback() throws Exception{
		return transactionManager.get().rollback();
	}
	
	public void markTrade(CommonRequest request) {
		transactionManager.get().markTrade(request);
	}
	
	public CspTransactionRequestBuilderFactory(ICtgMessageSend ctgMessageSender, MessageBeanCotext mbCtx) throws RequestBuildingException {
		if (ctgMessageSender == null) {
			throw new RequestBuildingException("CSP交易请求工厂初始化异常:参数CtgMessageSender不能为空");
		}
		if (mbCtx == null) {
			throw new RequestBuildingException("CSP交易请求工厂初始化异常:参数MessageBeanCotext不能为空");
		}
		this.ctgMessageSender = ctgMessageSender;
		this.mbCtx = mbCtx;
		
		try {
			initMessageBeanContext();
		} catch (MsgBeanContextInitException e) {
			throw new RequestBuildingException("MessageBean上下文转换组件初始化类异常", e);
		}
	}

	private ICtgMessageSend ctgMessageSender;

	private MessageBeanCotext mbCtx;

	private void initMessageBeanContext() throws MsgBeanContextInitException{
		mbCtx.analyse(StandardRequestBean_000400.class);
		mbCtx.analyse(StandardResponseBean_000400_OPT_1.class);
		mbCtx.analyse(StandardResponseBean_000400_OPT_6.class);
		mbCtx.analyse(StandardRequestBean_000440.class);
		mbCtx.analyse(StandardResponseBean_000440.class);
		mbCtx.analyse(StandardRequestBean_056048.class);
		mbCtx.analyse(StandardResponseBean_056048.class);
		mbCtx.analyse(StandardRequestBean_056148.class);
		mbCtx.analyse(StandardResponseBean_056148.class);
		mbCtx.analyse(StandardRequestBean_060460.class);
		mbCtx.analyse(StandardResponseBean_060460_OPT_A.class);
		mbCtx.analyse(StandardResponseBean_060460_OPT_B.class);
		mbCtx.analyse(StandardRequestBean_097511.class);
		mbCtx.analyse(StandardResponseBean_097511.class);
		mbCtx.analyse(StandardRequestBean_A00400.class);
		mbCtx.analyse(StandardResponseBean_A00400_OPT_1.class);
		mbCtx.analyse(StandardResponseBean_A00400_OPT_6.class);
		mbCtx.analyse(StandardRequestBean_001045.class);
		mbCtx.analyse(StandardResponseBean_001045.class);
		mbCtx.analyse(StandardRequestBean_009751.class);
		mbCtx.analyse(StandardResponseBean_009751.class);
		mbCtx.analyse(StandardRequestBean_020400.class);
		mbCtx.analyse(StandardResponseBean_020400.class);
	}
	
	
	public ICtgMessageSend getCtgMessageSender() {
		return ctgMessageSender;
	}

	public MessageBeanCotext getMbCtx() {
		return mbCtx;
	}

	/**
	 * 创建400交易类型1
	 * 
	 * @return
	 */
	public RequestBuilder_000400<ResponseAdapter_000400_OPT_1, StandardResponseBean_000400_OPT_1> newRequestBuilder_000400_OPT_1() {
		return new RequestBuilder_000400<ResponseAdapter_000400_OPT_1, StandardResponseBean_000400_OPT_1>(this, StandardResponseBean_000400_OPT_1.class);
	}

	/**
	 * 创建400交易类型6
	 * 
	 * @return
	 */
	public RequestBuilder_000400<ResponseAdapter_000400_OPT_6, StandardResponseBean_000400_OPT_6> newRequestBuilder_000400_OPT_6() {
		return new RequestBuilder_000400<ResponseAdapter_000400_OPT_6, StandardResponseBean_000400_OPT_6>(this, StandardResponseBean_000400_OPT_6.class);
	}

	/**
	 * 创建440交易
	 * 
	 * @return
	 */
	public RequestBuilder_000440 newRequestBuilder_000440() {
		return new RequestBuilder_000440(this);
	}

	
	/**
	 * 创建001045交易
	 * 
	 * @return
	 */
	public RequestBuilder_001045 newRequestBuilder_001045() {
		return new RequestBuilder_001045(this);
	}

	/**
	 * 创建056048交易
	 * 
	 * @return
	 */
	public RequestBuilder_056048 newRequestBuilder_056048() {
		return new RequestBuilder_056048(this);
	}
	
	/**
	 * 创建56148冲正交易
	 * 
	 * @return
	 */
	public RequestBuilder_056148 newRequestBuilder_056148() {
		return new RequestBuilder_056148(this);
	}
	
	/**
	 * 创建060460交易类型A
	 * 
	 * @return
	 */
	public RequestBuilder_060460<ResponseAdapter_060460_OPT_A, StandardResponseBean_060460_OPT_A> newRequestBuilder_060460_OPT_A() {
		return new RequestBuilder_060460<ResponseAdapter_060460_OPT_A, StandardResponseBean_060460_OPT_A>(this, StandardResponseBean_060460_OPT_A.class);
	}

	/**
	 * 创建060460交易类型B
	 * 
	 * @return
	 */
	public RequestBuilder_060460<ResponseAdapter_060460_OPT_B, StandardResponseBean_060460_OPT_B> newRequestBuilder_060460_OPT_B() {
		return new RequestBuilder_060460<ResponseAdapter_060460_OPT_B, StandardResponseBean_060460_OPT_B>(this, StandardResponseBean_060460_OPT_B.class);
	}
	
	/**
	 * 创建A00400交易类型1
	 * 
	 * @return
	 */
	public RequestBuilder_A00400<ResponseAdapter_A00400_OPT_1, StandardResponseBean_A00400_OPT_1> newRequestBuilder_A00400_OPT_1() {
		return new RequestBuilder_A00400<ResponseAdapter_A00400_OPT_1, StandardResponseBean_A00400_OPT_1>(this, StandardResponseBean_A00400_OPT_1.class);
	}

	/**
	 * 创建A00400交易类型6
	 * 
	 * @return
	 */
	public RequestBuilder_A00400<ResponseAdapter_A00400_OPT_6, StandardResponseBean_A00400_OPT_6> newRequestBuilder_A00400_OPT_6() {
		return new RequestBuilder_A00400<ResponseAdapter_A00400_OPT_6, StandardResponseBean_A00400_OPT_6>(this, StandardResponseBean_A00400_OPT_6.class);
	}

	/**
	 * 创建097511交易
	 * 
	 * @return
	 */
	public RequestBuilder_097511 newRequestBuilder_097511() {
		return new RequestBuilder_097511(this);
	}
	
	/**
	 * 创建009751交易
	 */
	public RequestBuilder_009751 newRequestBuilder_009751() {
		return new RequestBuilder_009751(this);
	}
	
	/**
	 * 创建20400交易
	 * 
	 * @return
	 */
	public RequestBuilder_020400 newRequestBuilder_020400() {
		return new RequestBuilder_020400(this);
	}
}
