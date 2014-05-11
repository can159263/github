package cn.szboc.platform.component.msgbean.exception;

import cn.szboc.platform.exception.PlatformCheckedException;

/**
 * message 与 bean 相互转换时抛出的异常
 */
public class MsgBeanConvertException extends PlatformCheckedException{

    private static final long serialVersionUID = 1L;

    public MsgBeanConvertException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MsgBeanConvertException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public MsgBeanConvertException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public MsgBeanConvertException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
