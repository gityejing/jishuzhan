/**
 * TODO
 * 
 */
package com.aitongyi.rabbitmq.helloworld;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.aitongyi.rabbitmq.util.ConnUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 消息生产者
 * 
 * @author hushuang
 *
 */
public class P {

	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {
		// 链接
		Connection connection = ConnUtil.getConn();
		// 管道
		Channel channel = connection.createChannel();
		// 声明队列
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		// 发消息
		String message = "Hello World!";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
		System.out.println("P [x] Sent '" + message + "'");
		channel.close();
		connection.close();
	}
	
}
