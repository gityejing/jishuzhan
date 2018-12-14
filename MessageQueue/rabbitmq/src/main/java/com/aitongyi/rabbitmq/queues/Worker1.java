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

		// 第二个参数，true，表示将消息持久化
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		System.out.println("Worker1 [*] Waiting for messages. To exit press CTRL+C");
		
		// 每次从队列中获取数量
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
					// 消息处理完成确认，手动反馈，告诉队列，我处理完了
					channel.basicAck(envelope.getDeliveryTag(), false);
				}
			}
		};
		// 开启手动应答，消息消费完成确认,自动应答改成false，关闭自动应答
		channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
	}

	/**
	 * 工作任务，耗时1秒
	 * @param task
	 */
	private static void doWork(String task) {
		try {
			Thread.sleep(1000); // 暂停1秒钟
		} catch (InterruptedException _ignored) {
			Thread.currentThread().interrupt();
		}
	}
}
