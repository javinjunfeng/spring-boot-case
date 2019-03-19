package top.javinjunfeng.rdbms.exception;


import top.javinjunfeng.rdbms.spi.ErrorCode;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author zhangjunfeng
 */
public class RdbmsUtilException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;

    public RdbmsUtilException(ErrorCode errorCode, String errorMessage) {
        super(errorCode.toString() + " - " + errorMessage);
        this.errorCode = errorCode;
    }

    private RdbmsUtilException(ErrorCode errorCode, String errorMessage, Throwable cause) {
        super(errorCode.toString() + " - " + getMessage(errorMessage) + " - " + getMessage(cause), cause);

        this.errorCode = errorCode;
    }

    public static RdbmsUtilException asRdbmsUtilException(ErrorCode errorCode, String message) {
        return new RdbmsUtilException(errorCode, message);
    }

    public static RdbmsUtilException asRdbmsUtilException(ErrorCode errorCode, String message, Throwable cause) {
        if (cause instanceof RdbmsUtilException) {
            return (RdbmsUtilException) cause;
        }
        return new RdbmsUtilException(errorCode, message, cause);
    }

    public static RdbmsUtilException asRdbmsUtilException(ErrorCode errorCode, Throwable cause) {
        if (cause instanceof RdbmsUtilException) {
            return (RdbmsUtilException) cause;
        }
        return new RdbmsUtilException(errorCode, getMessage(cause), cause);
    }

    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    private static String getMessage(Object obj) {
        if (obj == null) {
            return "";
        }

        if (obj instanceof Throwable) {
            StringWriter str = new StringWriter();
            PrintWriter pw = new PrintWriter(str);
            ((Throwable) obj).printStackTrace(pw);
            return str.toString();
        } else {
            return obj.toString();
        }
    }
}
