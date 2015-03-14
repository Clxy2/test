package cn.clxy.tools.core.exception;

/**
 * System exception.
 * @author clxy
 */
public class SystemException extends RuntimeException {

    /**
     * Default serial Version.
     */
    private static final long serialVersionUID = 1L;

    public SystemException(Throwable cause) {
        super(cause);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException() {
    }
}
