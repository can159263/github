package cn.szboc.uniformproxy.frontend.server.handler.exception;

import cn.szboc.uniformproxy.frontend.server.MessageProcessException;

/**
 * 接收流大小超出阈值
 */
public class ReceiveSizeExceededException extends MessageProcessException {
    
    private static final long serialVersionUID = 1L;

    /**
     * 阈值大小
     */
    private long byteCountThreshold;
    
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
    public long getByteCountThreshold() {
        return byteCountThreshold;
    }
    public void setByteCountThreshold(long byteCountThreshold) {
        this.byteCountThreshold = byteCountThreshold;
    }

    public ReceiveSizeExceededException(long byteCountActual, long byteCountThreshold) {
        super();
        this.byteCountThreshold = byteCountThreshold;
        this.byteCountActual = byteCountActual;
    }

    public ReceiveSizeExceededException(long byteCountActual, long byteCountThreshold, String message) {
        super(message);
        this.byteCountThreshold = byteCountThreshold;
        this.byteCountActual = byteCountActual;
    }

    public ReceiveSizeExceededException(long byteCountActual, long byteCountThreshold, String message, Throwable cause) {
        super(message, cause);
        this.byteCountThreshold = byteCountThreshold;
        this.byteCountActual = byteCountActual;
    }

    public ReceiveSizeExceededException(long byteCountActual, long byteCountThreshold, Throwable cause) {
        super(cause);
        this.byteCountThreshold = byteCountThreshold;
        this.byteCountActual = byteCountActual;
    }

}
