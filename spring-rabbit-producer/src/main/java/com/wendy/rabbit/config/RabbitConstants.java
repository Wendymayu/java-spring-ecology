package com.wendy.rabbit.config;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/9 22:44
 * @Version 1.0
 */
public class RabbitConstants {
    /**
     * 通过邮件消费的队列
     */
    public static final String EMAIL_QUEUE = "email_queue";

    /**
     * 通过短信消费的队列
     */
    public static final String SMS_QUEUE = "sms_queue";

    /**
     * 默认交换机名字
     */
    public static final String DEFAULT_EXCHANGE = "";

    /**
     * 直连交换机名字
     */
    public static final String DIRECT_EXCHANGE = "direct_exchange";

    /**
     * 扇形交换机名字
     */
    public static final String FANOUT_EXCHANGE = "fanout_exchange";

    /**
     * 主题交换机名字
     */
    public static final String TOPIC_EXCHANGE = "topic_exchange";

    /**
     * 用于默认交换机的路由键
     */
    public static final String EMAIL_DEFAULT_ROUTINGKEY = "email_queue";

    /**
     * 直连交换机的路由键
     */
    public static final String EMAIL_DIRECT_ROUTINGKEY = "email";

    /**
     * 直连交换机的绑定名
     */
    public static final String EMAIL_DIRECT_BINDING = "email";

    /**
     * 主题交换机的绑定名
     */
    public static final String EMAIL_TOPIC_BINDING = "email.#.inform.#";

    /**
     * 主题交换机的绑定名
     */
    public static final String SMS_TOPIC_BINDING = "sms.#.inform.#";

}
