package com.wendy.common.exception;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/29 15:47
 * @Version 1.0
 */
public enum ErrorCode {
    INTERNAL_ERROR("500", "Internal error."),
    ILLEGAL_ARGUMENT("4001", "Illegal arguments.");

    ErrorCode(String code, String messgae) {
        this.code = code;
        this.messgae = messgae;
    }

    private String code;

    private String messgae;
}
