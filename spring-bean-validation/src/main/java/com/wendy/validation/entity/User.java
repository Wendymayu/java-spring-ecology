package com.wendy.validation.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/7 23:40
 * @Version 1.0
 */
@Data
public class User {
    @Length(min = 1, max = 10, message = "用户名长度在1-10之间")
    private String userName;

    @NotNull
    @Size(min = 1, max = 10, message = "昵称长度在3-8之间")
    private String nickName;

    @Size(max = 100, message = "最大长度为100")
    private String address;

    @DecimalMin(value = "18", message = "年龄最小为18")
    @DecimalMax(value = "60", message = "年龄不能超过60")
    private Integer age;

    @Email(message = "必须为邮箱格式")
    private String email;

    @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号码为11位数字")
    private String phone;
}
