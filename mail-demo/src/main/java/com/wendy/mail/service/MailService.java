package com.wendy.mail.service;

/**
 * @Description 邮箱服务类
 * @Author wendyma
 * @Date 2023/9/29 20:10
 * @Version 1.0
 */
public interface MailService {
    /**
     * 发送简单邮件
     *
     * @param to      收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendEmail(String to, String subject, String content);
}