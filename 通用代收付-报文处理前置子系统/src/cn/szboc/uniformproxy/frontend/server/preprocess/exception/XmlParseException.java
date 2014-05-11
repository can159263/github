package cn.szboc.uniformproxy.frontend.server.preprocess.exception;

import cn.szboc.uniformproxy.frontend.server.MessageProcessException;

/**
 * JAXB转换时出现异常
 */
public class XmlParseException extends MessageProcessException {

    private static final long serialVersionUID = 1L;

    public XmlParseException() {
        super();
    }

    public XmlParseException(String message) {
        super(message);
    }

    public XmlParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public XmlParseException(Throwable cause) {
        super(cause);
    }

}
