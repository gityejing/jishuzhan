package com.aitongyi.rabbitmq.tx;

import java.io.IOException;

import com.aitongyi.rabbitmq.util.ConnUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class TxRecive {
	public static void main(String[] args) throws IOException {
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
		channel.basicConsume("QUEUE_TX_TEST", true, consumer);
	}
}
