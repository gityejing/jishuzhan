package com.aitongyi.rabbitmq.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnUtil {

	public static Connection getConn() {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		factory.setPort(5672);
		factory.setUsername("yejing");
		factory.setPassword("881213");
		factory.setVirtualHost("/yejing_virtual_host");
		Connection connection = null;
		try {
			connection = factory.newConnection();
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static Channel createChannelBindQueue(String queueName) {
		return createChannelBindQueue(queueName,false);
	}

	public static Channel createChannelBindQueue(String queueName,boolean durable) {
		Connection connection = getConn();
		Channel channel = null;
		try {
			channel = connection.createChannel();
			channel.queueDeclare(queueName, durable, false, false, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return channel;
	}
	
}
