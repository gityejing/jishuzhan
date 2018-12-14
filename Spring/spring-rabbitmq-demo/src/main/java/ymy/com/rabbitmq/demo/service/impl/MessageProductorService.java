package ymy.com.rabbitmq.demo.service.impl;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageProductorService {

	@Autowired
	private AmqpAdmin admin;
	
	// 这里实际注入的是RabbitTemplate
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Autowired
	private ConnectionFactory connectionFactory;

	/**
	 * 推送消息
	 * 
	 * 采用的是订阅发布模式中的全键匹配模式
	 * @param routingKey 路由key
	 * @param message
	 */
	public void pushToMessageQueue(String routingKey, String message) {
		amqpTemplate.convertAndSend(routingKey, message);
		System.out.println("成功插入消息 " + message);
	}

	public void popMessage(String destinationQueueName) {
		Message message = amqpTemplate.receive(destinationQueueName);
		System.out.println("成功取出消息 " + new String(message.getBody()));
	}

}
