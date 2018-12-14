/**
 * TODO
 * 
 */
package com.aitongyi.rabbitmq.helloworld;

import com.aitongyi.rabbitmq.util.ConnUtil;
import com.rabbitmq.client.*;
import java.io.IOException;

/**
 * ��Ϣ������
 * 
 * @author hushuang
 * 
 */
public class C {

	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {
		Channel channel = ConnUtil.createChannelBindQueue(QUEUE_NAME);
		System.out.println("C [*] Waiting for messages. To exit press CTRL+C");
		
		// ������
		Consumer consumer = new DefaultConsumer(channel) {
			/**
			 * һ������Ϣ���͵����У��ͻ��������������ײ�ԭ�����¼�ģ�͡�
			 * @parame body ���յ�������
			 */
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, 
					AMQP.BasicProperties properties, byte[] body) 
					throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("C [x] Received '" + message + "'");
			}
		};
		// �Զ�Ӧ��
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
}
