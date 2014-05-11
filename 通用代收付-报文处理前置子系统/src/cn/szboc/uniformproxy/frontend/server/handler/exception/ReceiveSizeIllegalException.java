package cn.szboc.uniformproxy.frontend.server.handler.exception;

import cn.szboc.uniformproxy.frontend.server.MessageProcessException;

/**
 * 接收流大小和预定义长度不符
 */
public class ReceiveSizeIllegalException extends MessageProcessException {
    
    private static final long serialVersionUID = 1L;

    /**
     * 标准大小
     */
    private long byteCountExpect;
    
    /**
     * 实际大小
     */
    private long byteCountActual;
    
    public long getByteCountActual() {
        return byteCountActual;
    }
    public void setByteCountActual(long byteCountActual) {
        this.byteCountActual = byteCountActual;
    }
    public long getByteCountExpect() {
        return byteCountExpect;
    }
    public void setByteCountExpect(long byteCountExpect) {
        this.byteCountExpect = byteCountExpect;
    }

    public ReceiveSizeIllegalException(long byteCountActual, long byteCountExpect) {
        super();
        this.byteCountExpect = byteCountExpect;
        this.byteCountActual = byteCountActual;
    }

    public ReceiveSizeIllegalException(long byteCountActual, long byteCountExpect, String message) {
        super(message);
        this.byteCountExpect = byteCountExpect;
        this.byteCountActual = byteCountActual;
    }

    public ReceiveSizeIllegalException(long byteCountActual, long byteCountExpect, String message, Throwable cause) {
        super(message, cause);
        this.byteCountExpect = byteCountExpect;
        this.byteCountActual = byteCountActual;
    }

    public ReceiveSizeIllegalException(long byteCountActual, long byteCountExpect, Throwable cause) {
        super(cause);
        this.byteCountExpect = byteCountExpect;
        this.byteCountActual = byteCountActual;
    }

}
