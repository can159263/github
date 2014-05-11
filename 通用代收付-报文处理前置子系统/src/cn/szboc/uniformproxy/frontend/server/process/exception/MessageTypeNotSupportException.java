package cn.szboc.uniformproxy.frontend.server.process.exception;

import cn.szboc.uniformproxy.frontend.server.preprocess.exception.XmlParseException;

/**
 * XML解析时出现的一系列异常
 */
public class MessageTypeNotSupportException extends XmlParseException {

    private static final long serialVersionUID = 1L;

    public MessageTypeNotSupportException() {
        super();
    }

    public MessageTypeNotSupportException(String message) {
        super(message);
    }

    public MessageTypeNotSupportException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageTypeNotSupportException(Throwable cause) {
        super(cause);
    }

}
