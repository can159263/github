package cn.szboc.platform.component.csp.trade.trade_060460.response;

import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 对CSP交易060460交易SET方法的抽象
 * 
 * @author
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 1283)
public abstract class ResponseAdapter_060460 extends CommonResponse {

}