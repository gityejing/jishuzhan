package com.aitongyi.rabbitmq.confim;

import java.io.IOException;

import com.aitongyi.rabbitmq.util.ConnUtil;
import com.rabbitmq.client.Channel;

/**
 * 發一條
 * @author 30000133
 */
public class CSend {
	public static void main(String[] args) {
		Channel channel = ConnUtil.createChannelBindQueue("QUEUE_TX_TEST");
		try {
			channel.confirmSelect();
			String message = " hello tx 2222333555";
			channel.basicPublish("", "QUEUE_TX_TEST", null, message.getBytes("UTF-8"));
			// waitForConfirms() 的意思是等待，直到上次發送的消息全部發送完了。
			if(!channel.waitForConfirms()) {
				System.out.println(" message send fail");
			}else {
				System.out.println("message send ok");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
