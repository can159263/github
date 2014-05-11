package cn.szboc.platform.component.csp.transaction;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.szboc.platform.component.csp.exception.RollbackWarningException;
import cn.szboc.platform.component.csp.requestbuilder.CommonRequest;
import cn.szboc.platform.component.csp.trade.commons.response.ExecuteResponse;

/**
 * 交易的事务管理器
 */
@SuppressWarnings("all")
public class TransactionManager {

	private static Logger _logger = LoggerFactory.getLogger(TransactionManager.class);

	private boolean isInTransaction;

	private List<CommonRequest> history = new ArrayList<CommonRequest>();

	public List<CommonRequest> getHistory() {
		return history;
	}

	public void setHistory(List<CommonRequest> history) {
		this.history = history;
	}

	/**
	 * 开启一个事务,意味着丢弃历史记录
	 */
	public void beginTransaction() {
		if (!history.isEmpty()) {
			throw new IllegalStateException("当前线程CSP事务状态异常,开启事务时,事务列表禁止有任何交易记录");
		}
		history.clear();
		isInTransaction = true;
	}

	public void markTrade(CommonRequest request) {

		if (request == null) {
			throw new IllegalArgumentException("记录交易不能为空");
		}

		// 如果请求是账务类,则进行添加
		if (request.isAccountOperationTrade()) {
			history.add(request);
		}
	}

	public boolean isInTransaction() {
		return isInTransaction;
	}

	/**
	 * 提交当前事务,其实是伪提交,因为中行CICS是没有开启事务的,这里仅仅做了一些清理工作
	 */
	public void commit() {
		// 无论执行成功与否,清除列表数据
		history.clear();
		// 设置不是事务状态了
		isInTransaction = false;
	}

	/**
	 * 回滚当前线程中的CSP事务,意味着就历史记录的每一条账务类交易进行回滚
	 * 
	 * @throws Exception
	 */
	public List<RollbackWarningException> rollback() throws Exception {

		List<RollbackWarningException> warnings = new ArrayList<RollbackWarningException>();
		
		if (!isInTransaction) {
			throw new IllegalStateException("当前线程的CSP交易不在事务管理中,不允许冲正!");
		}

		int size = history.size();

		try {
			// 从最后一个开始处理
			for (int i = 1; i <= size; i++) {
				CommonRequest request = history.get(size - i);
				// 非账务类的CSP交易的直接忽略
				if (!request.isAccountOperationTrade()) {
					continue;
				}
				ExecuteResponse response = request.getResponseBean();
				if (response == null) {
					_logger.error("交易请求未能明确返回结果Bean,无法冲正,具体交易信息如下:" + request);
					throw new IllegalStateException("交易请求未能明确返回结果Bean");
				}
				// 检查交易结果
				switch (response.getResult()) {
				// 明确失败的就继续看下一只交易
					case TRADE_FAILURE:
					case EXCEPTION_BEFORE_SEND:
						continue;
						// 交易成功的和未明确的就发起冲正
					case TRADE_SUCCESS:
					case EXCEPTION_AFTER_SEND:
						try {
							request.rollback();
						} catch(RollbackWarningException e){
							warnings.add(e);
						}
				}
			}
		} finally {
			// 无论执行成功与否,清除列表数据
			history.clear();
			// 设置不是事务状态了
			isInTransaction = false;
		}

		return warnings;
		
	}

}
