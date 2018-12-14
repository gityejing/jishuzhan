package com.aitongyi.rabbitmq.confim;

import java.io.IOException;

import com.aitongyi.rabbitmq.util.ConnUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class CReceive {

	public static void main(String[] args) {
		Channel channel = ConnUtil.createChannelBindQueue("QUEUE_TX_TEST");
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, 
					AMQP.BasicProperties properties, byte[] body) 
					throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("Received '" + message + "'");
			}
		};
		try {
			channel.basicConsume("QUEUE_TX_TEST", true, consumer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
