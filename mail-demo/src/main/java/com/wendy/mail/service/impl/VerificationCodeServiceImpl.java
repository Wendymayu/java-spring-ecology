package com.wendy.mail.service.impl;

import com.wendy.mail.service.MailService;
import com.wendy.mail.service.VerificationCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.SecureRandom;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/29 20:02
 * @Version 1.0
 */
@Slf4j
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    private static final int VERIFICATION_CODE_LENGTH = 6;

    @Resource
    private MailService mailService;

    @Override
    public String sendCode(String email) {
        String verificationCode = generateVerificationCode();
        try {
            mailService.sendEmail(email, "登录验证码", verificationCode);
            return "success";
        } catch (Exception e) {
            log.error("Send verification code to email: {} failed", email);
            throw new RuntimeException("Send verification code failed");
        }
    }

    private String generateVerificationCode() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        int num;
        for (int i = 0; i < VERIFICATION_CODE_LENGTH; i++) {
            num = secureRandom.nextInt(10);
            sb.append(num);
        }
        return sb.toString();
    }
}
