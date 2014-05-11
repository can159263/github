package cn.szboc.uniformproxy.frontend.server.process.processor.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.szboc.platform.commons.DateUtils;
import cn.szboc.uniformproxy.frontend.server.process.processor.bean.MessageBeanInfo;
import cn.szboc.uniformproxy.frontend.server.process.processor.bean.MessageControlBean;
import cn.szboc.uniformproxy.frontend.server.process.processor.dao.MessageDao;

/**
 * 负责报文的存储等工作
 */
@Service("messgeService")
public class MessgeService {

	private MessageDao messageDao;

	public MessageDao getMessageDao() {
		return messageDao;
	}

	@Autowired
	@Qualifier("messageDao")
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	/**
	 * 新增报文
	 * @param bean
	 * @return
	 */
	@Transactional
	public int insertMessageBean(MessageBeanInfo bean) {
		if (bean == null) {
			throw new NullPointerException("报文bean不能为空");
		}
		return this.getMessageDao().insertMessageBean(bean);
	}

	/**
	 * 更新报文
	 * @param bean
	 * @return
	 */
	@Transactional
	public int updateMessageBean(MessageBeanInfo bean) {
		if (bean == null) {
			throw new NullPointerException("报文bean不能为空");
		}
		return this.getMessageDao().updateMessageBean(bean);
	}

	/**
	 * 检查MSG_ID是否已存在
	 * @param systemCode
	 * @param msgId
	 * @return 报文ID已经存在,返回true
	 */
	@Transactional(readOnly = true)
	public boolean checkMessageIdExists(String systemCode, String msgId) {
		if (StringUtils.isEmpty(msgId)) {
			throw new IllegalArgumentException("msgId参数不能为空");
		}
		return this.getMessageDao().checkMessageIdExists(systemCode, msgId) > 0 ? true : false;
	}

	/**
	 * 报文交易时间控制
	 * @param sysCode
	 * @param transCode
	 * @return
	 */
	@Transactional(readOnly = true)
	public Boolean checkMsgControl(String sysCode, String transCode) {

		if (StringUtils.isEmpty(sysCode)) {
			throw new IllegalArgumentException("sysCode参数不能为空");
		}

		if (StringUtils.isEmpty(transCode)) {
			throw new IllegalArgumentException("transCode参数不能为空");
		}

		// 当前系统时间
		String sysTime = DateUtils.getTimeStr();

		MessageControlBean mcb = this.getMessageDao().fingMsgControlBean(sysCode, transCode);

		// 如果系统没有配置该交易,则返回null
		if (mcb == null) {
			return null;
		}

		// 先检查标志判断是否开启
		if (!mcb.isOpen()) {
			return Boolean.FALSE;
		}

		// 如果开启,则判断时间是否在区间内,如果在区间内,则返回TRUE
		if (sysTime.compareTo(mcb.getOpenTimeStart()) >= 0 && sysTime.compareTo(mcb.getOpenTimeEnd()) <= 0) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}

	}
}