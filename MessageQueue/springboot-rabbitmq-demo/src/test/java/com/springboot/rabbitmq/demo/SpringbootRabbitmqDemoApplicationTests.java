package com.springboot.rabbitmq.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqDemoApplicationTests {

    @Resource
    RabbitTemplate rabbitTemplate;

    @Resource
    AmqpAdmin amqpAdmin;

    @Resource
    AmqpTemplate amqpTemplate;

    @Test
    public void contextLoads() {





    }

    @Test
    public void declareExchange(){
        Exchange exchange = new DirectExchange("admin.exchange");
        amqpAdmin.declareExchange(exchange);
    }

    @Test
    public void declareQueue(){
        Queue queue = new Queue("admin.queue",true);
        amqpAdmin.declareQueue(queue);
    }

    @Test
    public void bind(){
        Binding declareBinding = new Binding("admin.queue", Binding.DestinationType.QUEUE,"admin.exchange","admin.hahha",null);
        amqpAdmin.declareBinding(declareBinding);
    }

    @Test
    public void send(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","yejing");
        map.put("age",30);
        rabbitTemplate.convertAndSend("admin.haha",map);
    }

    @Test
    public void receive(){

        Object obj = rabbitTemplate.receiveAndConvert("admin.queue");
        System.out.println(obj.getClass());
        System.out.println(obj);

    }
}
