package cn.szboc.platform.exception;

/**
 * 平台运行时异常
 */
public class PlatformRtException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PlatformRtException() {
        super();
    }

    public PlatformRtException(String message) {
        super(message);
    }

    public PlatformRtException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlatformRtException(Throwable cause) {
        super(cause);
    }

}
