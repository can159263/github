package cn.szboc.uniformproxy.frontend.server.process.processor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import cn.szboc.uniformproxy.frontend.server.process.processor.bean.MessageBeanInfo;
import cn.szboc.uniformproxy.frontend.server.process.processor.bean.MessageControlBean;
import cn.szboc.uniformproxy.frontend.system.FrontendDaoSupport;
import cn.szboc.uniformproxy.frontend.system.FrontendDatabaseObjects;

/**
 * 负责报文的存储、校验等工作
 * @author
 */
@Repository("messageDao")
public class MessageDao extends FrontendDaoSupport
{
	/** 新增参数Bean */
    private String sql_insertMessageBean;
    
    /** 更新参数Bean */
    private String sql_updateMessageBean;
    
    /** 检查MSG_ID是否已存在 */
    private String sql_checkMessageId;
    
    /** 检查报文交易时间控制 */
    private String sql_checkMsgControl;
    
	@Override
	protected void initSQL(FrontendDatabaseObjects dbObjects) {
		
		FrontendDatabaseObjects DB = getPlatformDatabaseObjects();
    	
    	sql_insertMessageBean = "INSERT INTO " + DB.TABLE_TD_MSG_RECORD
    						  + "		(sys_code, msg_id, msg_type, recv_datetime_in_msg, recv_datetime, recv_path)"
    						  + "VALUES (:sysCode, :msgId, :msgType, :recvDatetimeInMsg, :recvDatetime, :recvPath)";
    	
    	sql_updateMessageBean = "UPDATE " + DB.TABLE_TD_MSG_RECORD
				  			  + "	SET	send_datetime = :sendDatetime,"
				  			  + "		send_path = :sendPath,		  "
				  			  + "		send_datetime_in_msg = :sendDatetimeInMsg,			  "
				  			  + "		ret_code = :retCode			  "
				  			  + " WHERE sys_code = :sysCode			  "
				  			  + "   AND msg_id = :msgId				  ";
    	
    	sql_checkMessageId = " SELECT COUNT(1) FROM " + DB.TABLE_TD_MSG_RECORD
    					   + " WHERE sys_code = :sys_code AND msg_id = :msgId";
    	
    	sql_checkMsgControl = new StringBuilder()
        					  .append(" SELECT SYS_CODE,          TRANS_CODE,       IS_OPEN,        ")
        					  .append("        OPEN_TIME_START,   OPEN_TIME_END						")
        					  .append(" FROM ").append(DB.TABLE_TB_MESSAGE_CONTROL)
        					  .append("	WHERE sys_code = :sys_code AND trans_code = :trans_code ")
        					  .toString();
	}
    
    /**
     * 新增报文
     * @param bean
     * @return
     */
    public int insertMessageBean(MessageBeanInfo bean)
    {
		SqlParameterSource sps = new MapSqlParameterSource()
								.addValue("sysCode", bean.getSysCode())
								.addValue("msgId", bean.getMsgId())
								.addValue("msgType", bean.getMsgType())
								.addValue("recvDatetime", new Timestamp(bean.getRecvDatetime().getTime()))
								.addValue("recvDatetimeInMsg", bean.getMsgRecvDatetime())
								.addValue("recvPath", bean.getRecvPath());
		
		return this.getNamedParameterJdbcTemplate().update(this.sql_insertMessageBean, sps);
	}
    
    /**
     * 更新报文
     * @param bean
     * @return
     */
    public int updateMessageBean(MessageBeanInfo bean)
    {
		SqlParameterSource sps = new MapSqlParameterSource()
    							.addValue("sendDatetime", new Timestamp(bean.getSendDatetime().getTime()))
    							.addValue("sendPath", bean.getSendPath())
    							.addValue("retCode", bean.getRetCode())
    							.addValue("sysCode", bean.getSysCode())
    							.addValue("sendDatetimeInMsg", bean.getMsgSendDatetime())
    							.addValue("msgId", bean.getMsgId());
		
		return this.getNamedParameterJdbcTemplate().update(this.sql_updateMessageBean, sps);
	}
    
    /** 根据系统别和报文ID, 查找符合条件的报文个数 */
    public int checkMessageIdExists(String systemCode, String msgId)
    {
		SqlParameterSource sps = new MapSqlParameterSource()
			.addValue("sys_code", systemCode)
			.addValue("msgId", msgId);
			
		return this.getNamedParameterJdbcTemplate().queryForInt(this.sql_checkMessageId, sps);
	}
    
	/**
	 * 检查报文交易时间控制
	 */
	public MessageControlBean fingMsgControlBean(String sysCode, String transCode) {
		SqlParameterSource sps = new MapSqlParameterSource().addValue("sys_code", sysCode).addValue("trans_code", transCode);

		return this.getNamedParameterJdbcTemplate().query(this.sql_checkMsgControl, sps, new ResultSetExtractor<MessageControlBean>() {

			@Override
			public MessageControlBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()){
					MessageControlBean mcb = new MessageControlBean();
					mcb.setSysCode(rs.getString("SYS_CODE"));
					mcb.setTransCode(rs.getString("TRANS_CODE"));
					mcb.setOpen(rs.getBoolean("IS_OPEN"));
					mcb.setOpenTimeStart(rs.getString("OPEN_TIME_START"));
					mcb.setOpenTimeEnd(rs.getString("OPEN_TIME_END"));
					return mcb;
				}
				return null;
			}
		});
	}

}