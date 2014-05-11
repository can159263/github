package cn.szboc.platform.component.ctg.withSpring;

import java.util.Arrays;

import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jca.cci.core.support.CommAreaRecord;

import cn.szboc.platform.component.ctg.ICtgMessageSend;
import cn.szboc.platform.component.ctg.exception.ConnectEstablishedException;
import cn.szboc.platform.component.ctg.exception.ConnectNotEstablishException;
import cn.szboc.platform.component.ctg.exception.CtgCommonException;

import com.ibm.connector2.cics.ECIInteractionSpec;

/**
 * CTG消息发送器
 */
public class CtgMessageSender implements ICtgMessageSend{

	private static Logger _logger = LoggerFactory.getLogger(CtgMessageSender.class);

	private ConnectionFactory connectionFactory;

	private String functionName;

	private int executeTimeout;

	private int commareaLength;

	@Required
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Required
	public void setExecuteTimeout(int executeTimeout) {
		this.executeTimeout = executeTimeout;
	}

	@Required
	public void setConnectionFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	@Required
	public void setCommareaLength(int commareaLength) {
		this.commareaLength = commareaLength;
	}

	/**
	 * 发送二进制字节和返回处理过的二进制数据 CTG返回的数组后面多余部分用null来填充,本函数在fa
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public byte[] execute(byte[] param) throws CtgCommonException {

		// 组建交互参数
		ECIInteractionSpec ixnSpec = null;

		try {
			ixnSpec = new ECIInteractionSpec();

			ixnSpec.setFunctionName(this.functionName);
			ixnSpec.setCommareaLength(this.commareaLength);
			ixnSpec.setInteractionVerb(ECIInteractionSpec.SYNC_SEND_RECEIVE);
			ixnSpec.setExecuteTimeout(this.executeTimeout);

		} catch (Throwable t) {
			throw new ConnectNotEstablishException("初始化ECI交互参数时发生异常", t);
		}

		CommAreaRecord sendRecord = new CommAreaRecord(param);
		CommAreaRecord recvRecord = new CommAreaRecord();

		Connection conn = null;
		Interaction ixn = null;

		// 获取连接
		try {
			conn = connectionFactory.getConnection();
			ixn = conn.createInteraction();
		} catch (Throwable t) {
			closeInteraction(ixn);
			closeConnection(conn);
			throw new ConnectNotEstablishException("与CTG服务器连接异常", t);
		}

		// 发送交易
		try {
			
			ixn.execute(ixnSpec, sendRecord, recvRecord);

			byte[] rtn = recvRecord.toByteArray();

			int idx = 0;

			// 去除多余0字节
			for (; idx < rtn.length; idx++) {
				if (rtn[idx] == 0) {
					break;
				}
			}
			return Arrays.copyOf(rtn, idx);
		} catch (Throwable t) {
			throw new ConnectEstablishedException("ECI接口与CTG进行交互时异常", t);
		} finally {
			closeInteraction(ixn);
			closeConnection(conn);
		}
	};

	private void closeInteraction(Interaction ixn) {
		if (ixn != null) {
			try {
				ixn.close();
			} catch (Throwable t) {
				_logger.error("Interaction(JCA)关闭异常", t);
			}
		}
	}

	private void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Throwable t) {
				_logger.error("Connection(JCA)关闭异常", t);
			}
		}
	}
	
}
