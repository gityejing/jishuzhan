package com.demo._1api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

/**
 * 建立连接
 * 
 * @author jerome_s@qq.com
 */
public class _1CreateSession implements Watcher {

	private static ZooKeeper zookeeper;

	public static void main(String[] args) throws IOException, InterruptedException {
		// 需要传递一个事件监听器，通过事件监听器来介绍zk的事件通知
		// 这里为了演示方便 直接实现watcher
		zookeeper = new ZooKeeper("10.10.18.45:2181", 5000, new _1CreateSession());

		// 获取zk状态并输出事件接收到的数据
		System.out.println(zookeeper.getState());

		// 因为main还没等到建立好连接就执行完退出了
		// 需要sleep,下面的监听事件才可以执行
		Thread.sleep(Integer.MAX_VALUE);
	}

	@Override
	public void process(WatchedEvent event) {
		System.out.println("收到事件：" + event);
		if (event.getState() == KeeperState.SyncConnected) {
			doSomething();
		}
	}

	private void doSomething() {
		System.out.println("do something");
		
		// 创建一个节点，持久化的节点
		try {
			List<ACL> list = new ArrayList<ACL>();
			ACL aclIp = new ACL(ZooDefs.Perms.ALL,new Id("ip","127.0.0.1"));
			list.add(aclIp);
			zookeeper.create("/suihu", "hhh".getBytes(), list, CreateMode.PERSISTENT);
		} catch (KeeperException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	输出：
	CONNECTING
	收到事件：WatchedEvent state:SyncConnected type:None path:null
	do something
	*/
}
