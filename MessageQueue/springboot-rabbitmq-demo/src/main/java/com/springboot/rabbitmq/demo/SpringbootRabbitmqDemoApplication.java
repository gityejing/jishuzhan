package com.springboot.rabbitmq.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit // 开启对rabbitmq的支持
public class SpringbootRabbitmqDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootRabbitmqDemoApplication.class, args);
    }
}
