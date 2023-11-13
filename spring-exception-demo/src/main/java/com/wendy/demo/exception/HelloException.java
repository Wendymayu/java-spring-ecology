package com.wendy.demo.exception;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/29 15:46
 * @Version 1.0
 */
public class HelloException extends RuntimeException {
    private ErrorCode errorCode;

    private String message;

    public HelloException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public HelloException(ErrorCode errorCode, String message) {
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
