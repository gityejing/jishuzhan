/**
 * TODO
 * 
 */
package com.aitongyi.rabbitmq.publish;

/**
 * @author hushuang
 *
 */

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLog {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        
        // 分发消息
		for(int i = 0 ; i < 10; i++){
			String message = " Hello World! " + i;
			channel.basicPublish(EXCHANGE_NAME,"",null,message.getBytes());
		    System.out.println(" [x] Sent '" + message + "'");
		}
		
		// 关闭资源
        channel.close();
        connection.close();
    }
}
