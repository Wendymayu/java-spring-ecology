package com.wendy.demo.exception;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/29 15:47
 * @Version 1.0
 */
public enum ErrorCode {
    NAME_TOO_LONG("4001", "Name is too long."),
    RESOURCE_NOT_FOUND("4002", "Resource not flound.");

    ErrorCode(String code, String messgae) {
        this.code = code;
        this.messgae = messgae;
    }

    private String code;

    private String messgae;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }
}
