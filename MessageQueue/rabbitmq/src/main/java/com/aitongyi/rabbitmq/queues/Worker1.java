/**
 * TODO
 * 
 */
package com.aitongyi.rabbitmq.queues;

import com.rabbitmq.client.*;

import java.io.IOException;

public class Worker1 {
	
	private static final String TASK_QUEUE_NAME = "task_queue";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		final Connection connection = factory.newConnection();
		final Channel channel = connection.createChannel();

		// �ڶ���������true����ʾ����Ϣ�־û�
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		System.out.println("Worker1 [*] Waiting for messages. To exit press CTRL+C");
		
		// ÿ�δӶ����л�ȡ����
		channel.basicQos(1);

		final Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println("Worker1 [x] Received '" + message + "'");
				try {
					doWork(message);
				} finally {
					System.out.println("Worker1 [x] Done");
					// ��Ϣ�������ȷ�ϣ��ֶ����������߶��У��Ҵ�������
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};
		// �����ֶ�Ӧ����Ϣ�������ȷ��,�Զ�Ӧ��ĳ�false���ر��Զ�Ӧ��
		channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
	}

	/**
	 * �������񣬺�ʱ1��
	 * @param task
	 */
	private static void doWork(String task) {
		try {
			Thread.sleep(1000); // ��ͣ1����
		} catch (InterruptedException _ignored) {
			Thread.currentThread().interrupt();
		}
	}
}
