package com.wendy.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/11/9 22:08
 * @Version 1.0
 */
@Configuration
public class RabbitConfig {

    /**
     * 声明直连交换机
     *
     * @return
     */
    @Bean(RabbitConstants.DIRECT_EXCHANGE)
    public Exchange directExchange() {
        return ExchangeBuilder.directExchange(RabbitConstants.DIRECT_EXCHANGE).durable(true).build();
    }

    /**
     * 声明扇形交换机
     *
     * @return
     */
    @Bean(RabbitConstants.FANOUT_EXCHANGE)
    public Exchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange(RabbitConstants.FANOUT_EXCHANGE).durable(true).build();
    }

    /**
     * 声明主题交换机
     *
     * @return
     */
    @Bean(RabbitConstants.TOPIC_EXCHANGE)
    public Exchange topicExchange() {
        return ExchangeBuilder.topicExchange(RabbitConstants.TOPIC_EXCHANGE).durable(true).build();
    }

    /**
     * 声明队列
     *
     * @return
     */
    @Bean(RabbitConstants.EMAIL_QUEUE)
    public Queue emailQueue() {
        return new Queue(RabbitConstants.EMAIL_QUEUE);
    }

    /**
     * 声明队列
     *
     * @return
     */
    @Bean(RabbitConstants.SMS_QUEUE)
    public Queue smsQueue() {
        return new Queue(RabbitConstants.SMS_QUEUE);
    }

    /**
     * 绑定直连交换机与队列
     *
     * @param queue    待绑定的队列
     * @param exchange 待绑定的交换机
     * @return
     */
    @Bean
    public Binding bindEmailDirectExchange(@Qualifier(RabbitConstants.EMAIL_QUEUE) Queue queue,
                                          @Qualifier(RabbitConstants.DIRECT_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RabbitConstants.EMAIL_DIRECT_BINDING).noargs();
    }

    /**
     * 绑定主题交换机与队列
     *
     * @param queue    待绑定的队列
     * @param exchange 待绑定的交换机
     * @return
     */
    @Bean
    public Binding bindEmailTopicExchange(@Qualifier(RabbitConstants.EMAIL_QUEUE) Queue queue,
                                          @Qualifier(RabbitConstants.TOPIC_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RabbitConstants.EMAIL_TOPIC_BINDING).noargs();
    }

    /**
     * 绑定主题交换机与队列
     *
     * @param queue    待绑定的队列
     * @param exchange 待绑定的交换机
     * @return
     */
    @Bean
    public Binding bindSmsTopicExchange(@Qualifier(RabbitConstants.SMS_QUEUE) Queue queue,
                                        @Qualifier(RabbitConstants.TOPIC_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(RabbitConstants.SMS_TOPIC_BINDING).noargs();
    }
}
