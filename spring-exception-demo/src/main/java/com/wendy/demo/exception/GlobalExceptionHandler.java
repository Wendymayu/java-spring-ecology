package com.wendy.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * @Description 全局统一异常处理
 * @Author wendyma
 * @Date 2023/11/11 17:06
 * @Version 1.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(HelloException.class)
    @ResponseBody
    public ResponseEntity<ExceptionResponse> handleBlogException(HelloException e) {
        String errorCode = e.getErrorCode().getCode();
        String errorMsg = !Objects.isNull(e.getMessage()) ? e.getMessage() : e.getErrorCode().getMessgae();
        log.error("HelloException code:{},msg:{}", errorCode, errorMsg);
        ExceptionResponse exceptionResponse = new ExceptionResponse(errorCode, errorMsg);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
