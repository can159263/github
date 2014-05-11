package cn.szboc.uniformproxy.frontend.system;

import java.util.Arrays;

import cn.szboc.platform.core.PlatformRegister;

/**
 * 系统全局常量表
 * 该类的时候必须建立在类已经初始完毕的情况下
 */
public class SYS {

	public static void init(SystemConfigBean cfg) {

		CODE = cfg.getSystemCode();
		CODE_IN_BYTES = CODE.getBytes();
		LSTN_IP = cfg.getLstnIp();
		LSTN_PORT = cfg.getLstnPort();
		MAX_SIZE_IN_M = cfg.getMaxSizeInM();
		PREFIX_TABLE = cfg.getPrefixOfTable();
		MSG_RECV_PATH = cfg.getMsgRecvPath();
		MSG_SEND_PATH = cfg.getMsgSendPath();
		IS_SAVE_RAW_DATA = cfg.isSaveRawData();
		DES_KEY = cfg.getDesKey();
		
		/*
		 *  TODO 需要增加从数据库中读取，<br>
		 *  同时，如果交换密钥，则也同时需要更新内存中的该值，这样不用每次都需要从数据库中读取DES_KEY<br>
		 *  通过SYS_CODE从表ts_paramerte中读取密钥信息<br>
		 *  
		 */
	}
	
	public static String printStatus(){
		
		StringBuilder sb = new StringBuilder(PlatformRegister.lineSeparator);

		sb.append("系统常量配置如下").append(PlatformRegister.lineSeparator);
		sb.append("系统别                                    : ").append(CODE).append(PlatformRegister.lineSeparator);
		sb.append("系统别字节                            : ").append(Arrays.toString(CODE_IN_BYTES)).append(PlatformRegister.lineSeparator);
		sb.append("监听IP地址                         : ").append(LSTN_IP).append(PlatformRegister.lineSeparator);
		sb.append("监听端口                                : ").append(LSTN_PORT).append(PlatformRegister.lineSeparator);
		sb.append("报文最大长度兆                    : ").append(MAX_SIZE_IN_M).append(PlatformRegister.lineSeparator);
		sb.append("数据库表前缀                        : ").append(PREFIX_TABLE).append(PlatformRegister.lineSeparator);
		sb.append("报文接收缓存路径                : ").append(MSG_RECV_PATH).append(PlatformRegister.lineSeparator);
		sb.append("报文发送缓存路径                : ").append(MSG_SEND_PATH).append(PlatformRegister.lineSeparator);
		sb.append("是否缓存加密解密原始数据: ").append(IS_SAVE_RAW_DATA).append(PlatformRegister.lineSeparator);
		sb.append("DES密钥                              : ").append(Arrays.toString(DES_KEY)).append(PlatformRegister.lineSeparator);
		
		return sb.toString();
	}
	
	
	/**
	 * 系统别
	 */
	public static String CODE;

	/**
	 * 系统别
	 */
	public static byte[] CODE_IN_BYTES;

	/**
	 * 要监听的IP地址
	 */
	public static String LSTN_IP;

	/**
	 * 要监听的端口地址
	 */
	public static int LSTN_PORT;

	/**
	 * 最大读取长度,单位为M
	 */
	public static int MAX_SIZE_IN_M;

	/**
	 * 数据库表前缀名
	 */
	public static String PREFIX_TABLE;

	/**
	 * 接收报文保存路径
	 */
	public static String MSG_RECV_PATH;

	/**
	 * 发送报文保存路径
	 */
	public static String MSG_SEND_PATH;

	/**
	 * 是否保留原始二进制数据
	 */
	public static boolean IS_SAVE_RAW_DATA;
	
	/**
	 * DES密钥
	 */
	public static byte[] DES_KEY;

}
