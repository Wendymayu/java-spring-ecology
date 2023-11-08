package com.wendy.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/8 20:45
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理@Validated参数校验失败异常
     *
     * @param exception 异常类
     * @return 响应
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity exceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            if (errors != null) {
                errors.forEach(p -> {
                    FieldError fieldError = (FieldError) p;
                    errorMsg.append(fieldError.getDefaultMessage());
                });
            }
        }
        return new ResponseEntity<>(errorMsg.toString(), HttpStatus.BAD_REQUEST);
    }
}
