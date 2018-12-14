package com.aitongyi.rabbitmq.confim;

import java.io.IOException;

import com.aitongyi.rabbitmq.util.ConnUtil;
import com.rabbitmq.client.Channel;

/**
 * �lһ�l
 * @author 30000133
 */
public class CSend {
	public static void main(String[] args) {
		Channel channel = ConnUtil.createChannelBindQueue("QUEUE_TX_TEST");
		try {
			channel.confirmSelect();
			String message = " hello tx 2222333555";
			channel.basicPublish("", "QUEUE_TX_TEST", null, message.getBytes("UTF-8"));
			// waitForConfirms() ����˼�ǵȴ���ֱ���ϴΰl�͵���Ϣȫ���l�����ˡ�
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
