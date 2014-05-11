package cn.szboc.uniformproxy.frontend.server;

/**
 * 通道响应码
 */
public enum ChannelResponseCode {

	NORMAL("00", "正常处理"),

	EXP_IO("01", "IO通道异常"),

	LENGTH_VALUE_ILLEGAL("02", "报文长度标识非法"),

	MSG_LENGTH_INVALID("03", "报文长度非法"),

	EXP_MD5("04", "MD5校验异常"),

	EXP_INFLATE("05", "Inflate压缩,解压缩异常"),

	EXP_DES("06", "DES加密解密异常"),

	EXP_EXCESSIVE_FLOW("07", "流程过大,报文被拒绝"),

	EXP_XML_PARSE("08", "XML解析异常"),

	EXP_OTHER("99", "其它原因异常");

	/**
	 * 代码
	 */
	private final String value;

	/**
	 * 本地信息
	 */
	private final String localMessage;

	ChannelResponseCode(String code, String localMessage) {
		this.value = code;
		this.localMessage = localMessage;
	}

	public String value() {
		return value;
	}

	public String getLocalMessage() {
		return localMessage;
	}

	public static ChannelResponseCode fromValue(String value) {
		if (value == null) {
			return null;
		}

		for (ChannelResponseCode respCode : ChannelResponseCode.values()) {
			if (respCode.value.equals(value)) {
				return respCode;
			}
		}

		throw new IllegalArgumentException("非法标识符:" + value);
	}
}
