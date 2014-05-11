package cn.szboc.uniformproxy.frontend.server.postprocessor.exception;

import cn.szboc.uniformproxy.frontend.server.MessageProcessException;

/**
 * JAXB转换时出现异常
 */
public class XmlFormatException extends MessageProcessException {

    private static final long serialVersionUID = 1L;

    public XmlFormatException() {
        super();
    }

    public XmlFormatException(String message) {
        super(message);
    }

    public XmlFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public XmlFormatException(Throwable cause) {
        super(cause);
    }

}
