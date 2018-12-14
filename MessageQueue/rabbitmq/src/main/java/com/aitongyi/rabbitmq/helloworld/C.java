/**
 * TODO
 * 
 */
package com.aitongyi.rabbitmq.helloworld;

import com.aitongyi.rabbitmq.util.ConnUtil;
import com.rabbitmq.client.*;
import java.io.IOException;

/**
 * 消息消费者
 * 
 * @author hushuang
 * 
 */
public class C {

	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {
		Channel channel = ConnUtil.createChannelBindQueue(QUEUE_NAME);
		System.out.println("C [*] Waiting for messages. To exit press CTRL+C");
		
		// 消费者
		Consumer consumer = new DefaultConsumer(channel) {
			/**
			 * 一旦有消息发送到队列，就会调用这个方法，底层原理是事件模型。
			 * @parame body 接收到的数据
			 */
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, 
					AMQP.BasicProperties properties, byte[] body) 
					throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("C [x] Received '" + message + "'");
			}
		};
		// 自动应答
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
}
