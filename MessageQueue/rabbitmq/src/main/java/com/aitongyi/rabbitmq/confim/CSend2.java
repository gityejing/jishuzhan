package com.aitongyi.rabbitmq.confim;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.aitongyi.rabbitmq.util.ConnUtil;
import com.rabbitmq.client.Channel;

/**
 * �lһ��
 * @author 30000133
 *
 */
public class CSend2 {
	public static void main(String[] args) {
		Channel channel = ConnUtil.createChannelBindQueue("QUEUE_TX_TEST");
		try {
			channel.confirmSelect();
			String message = " hello tx 2222333555";
			for (int i = 0; i < 10; i++) {
				message+=i;
				channel.basicPublish("", "QUEUE_TX_TEST", null, message.getBytes("UTF-8"));
				// waitForConfirms() ����˼�ǵȴ���ֱ���ϴΰl�͵���Ϣȫ���l�����ˡ�
			}
			channel.waitForConfirmsOrDie();
			channel.close();
		} catch (IOException | InterruptedException | TimeoutException e) {
			e.printStackTrace();
		}
		
		
	}
}
