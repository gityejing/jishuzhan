package com.aitongyi.rabbitmq.headers;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeoutException;
 
import com.rabbitmq.client.AMQP.BasicProperties.Builder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
 
 
public class HeadersProducer {
 
	private static final String EXCHANGE_NAME = "exchange_headers";
 
	public static void main(String[] argv) throws Exception{
		new ExchangeHeaders("exchanges type headers test msg~");
	}
	
	static class ExchangeHeaders{
		public ExchangeHeaders(String message) throws IOException, TimeoutException{
			ConnectionFactory factory = new ConnectionFactory();
			// rabbitmq����IP
			factory.setHost("localhost");
			// rabbitmq����Ĭ�϶˿�
			factory.setPort(5672);
			// ���÷��ʵ��û�
			factory.setUsername("guest");
			factory.setPassword("guest");
			Connection connection = factory.newConnection();
			Channel channel = connection.createChannel();
			// ����·�����ֺ�����
			channel.exchangeDeclare(EXCHANGE_NAME, "headers", false, true, null);
			// ������Ϣͷ��ֵ����Ϣ
			Map<String, Object> headers = new Hashtable<String, Object>();
			headers.put("name","jack");
			headers.put("age",30);
			Builder builder = new Builder();
			builder.headers(headers);
			
			channel.basicPublish(EXCHANGE_NAME, "", builder.build(), message.getBytes());
			System.out.println(" Sent msg is '" + message + "'");
 
			channel.close();
			connection.close();
		}
	}
}
