package me.ele.bpm.skyrim.test.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ymy.com.rabbitmq.demo.service.impl.MessageConsumerService;
import ymy.com.rabbitmq.demo.service.impl.MessageProductorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"classpath:bpm-skyrim-mq-2.xml"
	})
public class MessageManagerTest {

	@Resource
	private MessageProductorService messageProductorService;
	@Resource
	private MessageConsumerService messageConsumer;
	
	
	/**
	 * 交换机 ： mq-exchange
	 * 交换机类型：全匹配 direct
	 * 路由key：rabbit_queue_one
	 */
	@Test
	public void testMessageQueue(){
		messageProductorService.pushToMessageQueue("rabbit_queue_one", "hello giraffe");
//		messageProductorService.popMessage("rabbit_queue_one");
	}
	
}
