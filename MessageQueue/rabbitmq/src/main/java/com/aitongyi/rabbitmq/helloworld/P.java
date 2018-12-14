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
 * ��Ϣ������
 * 
 * @author hushuang
 *
 */
public class P {

	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {
		// ����
		Connection connection = ConnUtil.getConn();
		// �ܵ�
		Channel channel = connection.createChannel();
		// ��������
		channel.queueDeclare(QUEUE_NAME,false,false,false,null);
		// ����Ϣ
		String message = "Hello World!";
		channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
		System.out.println("P [x] Sent '" + message + "'");
		channel.close();
		connection.close();
	}
	
}
