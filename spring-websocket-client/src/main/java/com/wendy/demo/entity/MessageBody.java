package com.wendy.demo.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2024/4/14 13:34
 * @Version 1.0
 */
@Data
public class MessageBody {
    /**
     * 发送端
     */
    private String from;

    /**
     * 接收端
     */
    private String to;

    /**
     * 消息内容，当前只支持文字
     */
    private String content;

    /**
     * 发送时间
     */
    private long sendTime;

    /**
     * 接收时间
     */
    private long receiveTime;

}
