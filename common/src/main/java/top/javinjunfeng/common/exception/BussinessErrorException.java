package top.javinjunfeng.common.exception;

/**
 * 业务逻辑错误异常
 */
public class BussinessErrorException extends RuntimeException{

    private String code;

    public BussinessErrorException(String message, BErrorType errorType) {
        super(message);
        this.code = errorType.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static enum BErrorType{

        REFERENCED("001"),
        REPEAT("002"),
        CANT_FIND_PARENT("003"),
        CANT_BE_NULL("004");

        private String code;

        BErrorType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

}
