package cn.szboc.platform.component.msgbean.exception;

/**
 * 上下文初始化时出现异常
 */
public class MsgBeanContextInitException extends MsgBeanConvertException{

    private static final long serialVersionUID = 1L;

    public MsgBeanContextInitException() {
        super();
    }

    public MsgBeanContextInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public MsgBeanContextInitException(String message) {
        super(message);
    }

    public MsgBeanContextInitException(Throwable cause) {
        super(cause);
    }

}
