package cn.szboc.uniformproxy.frontend.server.process;

/**
 * 报文处理任务执行的状态
 */
public enum MessageDealTaskStatus {

	/**
	 * 初始化
	 */
	INIT,
	
	/**
	 * 将二进制报文数据缓存
	 */
	SAVE_REQUEST_RAW_DATA,
	
	/**
	 * 解码二进制请求数据
	 */
	DECODE_REQUEST,
	
	/**
	 * 报文数据保存
	 */
	SAVE_REQUEST_FILE,
	
	/**
	 * 解析二进制数据为对象
	 */
	PARSE_REQUEST,
	
	/**
	 * 重命名请求报文
	 */
	RENAME_MSG_FILE,
	
	/**
	 * 内部业务处理
	 */
	PROCESSING,
	
	/**
	 * 处理完毕,获取响应bean
	 */
	PROCESS_OVER,
	
	/**
	 * 生成响应报文
	 */
	GENERATE_RESPONSE,
	
	/**
	 * 生成响应报文
	 */
	FORMAT_RESPONSE,
	
	/**
	 * 保存响应报文
	 */
	SAVE_RESPONSE_FILE,
	
	
	/**
	 * 将二进制响应报文数据缓存
	 */
	SAVE_RESPONSE_RAW_DATA,
	
	/**
	 * 响应 
	 */
	RESPONSE
	
	
}
