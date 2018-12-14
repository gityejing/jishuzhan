package com.aitongyi.rabbitmq.tx;

import java.io.IOException;

import com.aitongyi.rabbitmq.util.ConnUtil;
import com.rabbitmq.client.Channel;

public class TxSend {
	public static void main(String[] args) {
		Channel channel = ConnUtil.createChannelBindQueue("QUEUE_TX_TEST");
		String message = " hello tx 2222333555" ;
		try {
			channel.txSelect();
			channel.basicPublish("","QUEUE_TX_TEST", null, message.getBytes("UTF-8"));
			int i  = 1/0;
			channel.txCommit();
		} catch (Exception e) {
			try {
				channel.txRollback();
				System.out.println("huigun");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
