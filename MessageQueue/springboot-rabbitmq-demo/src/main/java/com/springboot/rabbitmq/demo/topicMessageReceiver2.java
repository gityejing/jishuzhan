package com.springboot.rabbitmq.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.messages")
public class topicMessageReceiver2 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessageReceiver2  : " +msg);
    }

}