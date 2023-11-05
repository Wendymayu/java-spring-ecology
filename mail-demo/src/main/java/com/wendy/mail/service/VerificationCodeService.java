package com.wendy.mail.service;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/29 20:00
 * @Version 1.0
 */
public interface VerificationCodeService {
    /**
     * 发送验证码到邮箱
     *
     * @param email 用户邮箱
     * @return
     */
    String sendCode(String email);
}