package com.wendy.common.exception;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/29 15:46
 * @Version 1.0
 */
public class CommonException extends RuntimeException {
    private ErrorCode errorCode;

    private String message;

    public CommonException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public CommonException(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
