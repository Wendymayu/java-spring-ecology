package com.wendy.common.exception;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/29 15:47
 * @Version 1.0
 */
public enum ErrorCode {
    INTERNAL_ERROR("500", "Internal error."),
    ILLEGAL_ARGUMENT("4001", "Illegal arguments."),
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
