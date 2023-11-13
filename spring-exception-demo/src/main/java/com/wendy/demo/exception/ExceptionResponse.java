package com.wendy.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/11 17:11
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class ExceptionResponse {
    private String errorCode;

    private String errorMsg;
}
