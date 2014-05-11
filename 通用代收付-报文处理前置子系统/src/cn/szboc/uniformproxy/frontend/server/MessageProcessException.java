package cn.szboc.uniformproxy.frontend.server;

/**
 * 报文处理抽象异常
 */
public class MessageProcessException extends Exception {

    private static final long serialVersionUID = 1L;

    public MessageProcessException() {

    }

    public MessageProcessException(String message) {
        super(message);
    }

    public MessageProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageProcessException(Throwable cause) {
        super(cause);
    }

}
