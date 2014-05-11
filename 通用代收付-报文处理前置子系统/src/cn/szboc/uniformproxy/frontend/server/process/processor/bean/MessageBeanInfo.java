package cn.szboc.uniformproxy.frontend.server.process.processor.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.szboc.platform.core.PlatformRegister;

public class MessageBeanInfo
{
	/** 系统别 */
	private String sysCode;
	
	/** 报文ID */
	private String msgId;
	
	/** 报文类型 */
	private String msgType;
	
	/** 接收时间 */
	private Date msgRecvDatetime;
	
	/** 接收时间 */
	private Date recvDatetime;
	
	/** 发送时间 */
	private Date sendDatetime;
	
	/** 接收时间 */
	private Date msgSendDatetime;
	
	/** 接收报文全路径 */
	private String recvPath;
	
	/** 发送报文全路径 */
	private String sendPath;
	
	/** 报文处理返回码 */
	private String retCode;
	
	public String getSysCode()
	{
		return sysCode;
	}
	public void setSysCode(String sysCode)
	{
		this.sysCode = sysCode;
	}
	public String getMsgId()
	{
		return msgId;
	}
	public void setMsgId(String msgId)
	{
		this.msgId = msgId;
	}
	public String getMsgType()
	{
		return msgType;
	}
	public void setMsgType(String msgType)
	{
		this.msgType = msgType;
	}
	public Date getRecvDatetime()
	{
		return recvDatetime;
	}
	public void setRecvDatetime(Date recvDatetime)
	{
		this.recvDatetime = recvDatetime;
	}
	public Date getSendDatetime()
	{
		return sendDatetime;
	}
	public void setSendDatetime(Date sendDatetime)
	{
		this.sendDatetime = sendDatetime;
	}
	public String getRecvPath()
	{
		return recvPath;
	}
	public void setRecvPath(String recvPath)
	{
		this.recvPath = recvPath;
	}
	public String getSendPath()
	{
		return sendPath;
	}
	public void setSendPath(String sendPath)
	{
		this.sendPath = sendPath;
	}
	public String getRetCode()
	{
		return retCode;
	}
	public void setRetCode(String retCode)
	{
		this.retCode = retCode;
	}
	
	public Date getMsgRecvDatetime() {
		return msgRecvDatetime;
	}
	public Date getMsgSendDatetime() {
		return msgSendDatetime;
	}
	public void setMsgRecvDatetime(Date msgRecvDatetime) {
		this.msgRecvDatetime = msgRecvDatetime;
	}
	public void setMsgSendDatetime(Date msgSendDatetime) {
		this.msgSendDatetime = msgSendDatetime;
	}
	/**
	 * 覆盖toString方法,使用易读的方式打印该参数
	 */
    @Override
    public String toString()
    {
        String lineSeparator = PlatformRegister.lineSeparator;
        
        return new StringBuilder().append("系统别[").append(this.sysCode).append("]").append(lineSeparator)
                    			  .append("报文ID[").append(this.msgId).append("]").append(lineSeparator)
                    			  .append("报文类型[").append(this.msgType).append("]").append(lineSeparator)
                    			  .append("接收时间[").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.recvDatetime)).append("]").append(lineSeparator)
                    			  .append("发送时间[").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.sendDatetime)).append("]").append(lineSeparator)
                    			  .append("接收报文全路径[").append(this.recvPath).append("]").append(lineSeparator)
                    			  .append("发送报文全路径[").append(this.sendPath).append("]").append(lineSeparator)
                    			  .append("报文处理返回码[").append(this.retCode).append("]").append(lineSeparator)
                    			  .toString();
    }
}