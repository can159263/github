package cn.szboc.uniformproxy.frontend.system;

import cn.szboc.platform.core.PlatformDatabaseObjects;

/**
 * 系统数据库对象表
 */
public class FrontendDatabaseObjects extends PlatformDatabaseObjects {

	/**
	 * 本系统的数据库schema
	 */
	private String systemDbSchema;

	/**
	 * 系统数据库对象构造函数
	 * 
	 * @param commonSchema
	 *            数据库通用schema
	 */
	public FrontendDatabaseObjects(String commonSchema) {
		this(commonSchema, commonSchema);
		systemInit();
	}

	/**
	 * 系统数据库对象构造函数
	 * 
	 * @param systemDbSchema
	 *            系统数据库schema
	 * @param platformDbSchema
	 *            平台数据库schema
	 */
	public FrontendDatabaseObjects(String systemDbSchema, String platformDbSchema) {
		super(platformDbSchema);
		this.systemDbSchema = systemDbSchema;
		systemInit();
	}

	/** 系统别配置表 */
	public String TABLE_TB_PROXY_SYSTEM;

	/** 系统使用代理账号表 */
	public String TABLE_TB_PROXY_ACCOUNT_INFO;

	/** 系统分派路由表 */
	public String TABLE_TB_DISPATCH_ENPOINT_ADDRESSES;

	/** 报文记录表 */
	public String TABLE_TD_MSG_RECORD;

	/** 账务交易申请表 */
	public String TABLE_TD_ACCOUNT_APPLY;



	/** 报文交易时间控制表 */
	public String TABLE_TB_MESSAGE_CONTROL;

	/** 账户验证记录表 */
	public String TABLE_TD_ACCOUNT_VALIDATE_RECORD;
	
	/**
	 * 对平台对象的相关初始化
	 */
	@Override
	protected void systemInit() {

		TABLE_TB_PROXY_SYSTEM = this.systemDbSchema + ".tb_proxy_system";
		TABLE_TB_PROXY_ACCOUNT_INFO = this.systemDbSchema + ".tb_proxy_account_info";
		TABLE_TB_DISPATCH_ENPOINT_ADDRESSES = this.systemDbSchema + ".tb_dispatch_enpoint_addresses";
		TABLE_TD_MSG_RECORD = this.systemDbSchema + ".td_msg_record";
		TABLE_TD_ACCOUNT_APPLY = this.systemDbSchema + ".td_account_apply";
		TABLE_TB_MESSAGE_CONTROL = this.systemDbSchema + ".tb_message_control";
		TABLE_TD_ACCOUNT_VALIDATE_RECORD = this.systemDbSchema + ".td_account_validate_record";
		
	}

}
