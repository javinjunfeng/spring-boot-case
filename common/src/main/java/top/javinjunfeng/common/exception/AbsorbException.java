package com.sztech.absorb.core.exception;

import lombok.Data;

/**
 * 系统自定义异常，可以范指系统产生的业务异常
 *
 * Created by zhongjunkai on 18/10/23.
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
