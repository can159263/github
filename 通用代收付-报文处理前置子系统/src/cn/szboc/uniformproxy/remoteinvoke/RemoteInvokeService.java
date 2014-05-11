package cn.szboc.uniformproxy.remoteinvoke;

import cn.szboc.uniformproxy.remoteinvoke.batch.bean.recv.BatchDeductResponseRecvBean;
import cn.szboc.uniformproxy.remoteinvoke.batch.bean.send.BatchDeductResponseSendBean;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.A001REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.A001RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.A002REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.A002RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B001REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B001RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B002REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B002RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B003REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B003RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B004REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B004RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B005REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B005RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B101REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B101RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B102REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B102RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B104REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B104RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B105REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.B105RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C001REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C001RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C002REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C002RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C003REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C003RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C004REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C004RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C102REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C102RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C103REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C103RESPONSE;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C104REQUEST;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.C104RESPONSE;

/**
 * 远程系统调用
 */
public interface RemoteInvokeService {

	public A001RESPONSE dealMsgA001(A001REQUEST request);
	
	public A002RESPONSE dealMsgA002(A002REQUEST request);

	public B001RESPONSE dealMsgB001(B001REQUEST request);

	public B002RESPONSE dealMsgB002(B002REQUEST request);

	public B003RESPONSE dealMsgB003(B003REQUEST request);

	public B004RESPONSE dealMsgB004(B004REQUEST request);

	public B005RESPONSE dealMsgB005(B005REQUEST request);
	
	public B101RESPONSE dealMsgB101(B101REQUEST request);
	
	public B102RESPONSE dealMsgB102(B102REQUEST request);
	
	public B104RESPONSE dealMsgB104(B104REQUEST request);
	
	public B105RESPONSE dealMsgB105(B105REQUEST request);

	public C001RESPONSE dealMsgC001(C001REQUEST request);

	public C002RESPONSE dealMsgC002(C002REQUEST request);

	public C003RESPONSE dealMsgC003(C003REQUEST request);

	public C004RESPONSE dealMsgC004(C004REQUEST request);
	
	public C102RESPONSE dealMsgC102(C102REQUEST request);
	
	public C103RESPONSE dealMsgC103(C103REQUEST request);
	
	public C104RESPONSE dealMsgC104(C104REQUEST request);

	public BatchDeductResponseSendBean dealEcesBatchAccountResponse(BatchDeductResponseRecvBean request);

}
