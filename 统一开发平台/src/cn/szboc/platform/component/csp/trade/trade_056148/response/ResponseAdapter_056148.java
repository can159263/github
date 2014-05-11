package cn.szboc.platform.component.csp.trade.trade_056148.response;

import cn.szboc.platform.component.csp.trade.commons.response.CommonResponse;
import cn.szboc.platform.component.msgbean.annotation.MessageBean;
import cn.szboc.platform.component.msgbean.annotation.To;

/**
 * 对CSP交易056148交易SET方法的抽象(冲正交易，无特殊返回字段)
 * @author
 * 
 */
@MessageBean(Target = To.TO_BEAN, ExpectedWriteSize = 300)
public abstract class ResponseAdapter_056148 extends CommonResponse
{
}