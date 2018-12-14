package com.aitongyi.rabbitmq.confim;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.aitongyi.rabbitmq.util.ConnUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;

/**
 * °lÒ»Åú
 * @author 30000133
 *
 */
public class CSend3 {
	
	public static void main(String[] args) throws InterruptedException {
		Connection connection = ConnUtil.getConn();
		Channel channel = null;
		try {
			channel = connection.createChannel();
			channel.queueDeclare(" QUEUE_TX_TEST ", false, false, false, null);
			channel.confirmSelect();
			channel.addConfirmListener(new ConfirmListener() {
				@Override
				public void handleNack(long deliveryTag, boolean multiple) throws IOException {
					System.out.println(" nack: deliveryTag = "+deliveryTag+" multiple: "+multiple);
				}
				@Override
				public void handleAck(long deliveryTag, boolean multiple) throws IOException {
					System.out.println(" ack: deliveryTag = "+deliveryTag+" multiple: "+multiple);
				}
			});
			String message = " hello tx  ";
			while(true) {
				channel.basicPublish("", "QUEUE_TX_TEST", null, message.getBytes("UTF-8"));
			}
//			channel.close();
//			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
