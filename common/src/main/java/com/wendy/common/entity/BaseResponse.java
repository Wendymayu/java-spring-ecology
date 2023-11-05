package com.wendy.common.entity;

import lombok.Data;

/**
 * @Description 服务器的响应数据
 * @Author wendyma
 * @Date 2023/9/29 15:51
 * @Version 1.0
 */
@Data
public class BaseResponse<T> {
    private int code;

    private String message;

    private T data;

    public BaseResponse<T> success(T data) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setData(data);
        baseResponse.setCode(200);
        baseResponse.setMessage("success");
        return baseResponse;
    }

    public BaseResponse<T> fail() {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setCode(400);
        baseResponse.setMessage("fail");
        return baseResponse;
    }


}
