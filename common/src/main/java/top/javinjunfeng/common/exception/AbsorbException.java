package top.javinjunfeng.common.exception;

import lombok.Data;

/**
 * 系统自定义异常，可以范指系统产生的业务异常
 */
@Data
public class AbsorbException extends RuntimeException {

    private String code;

    public AbsorbException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
