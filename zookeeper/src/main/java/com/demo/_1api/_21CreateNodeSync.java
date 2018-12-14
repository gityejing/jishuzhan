package com.demo._1api;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * 创建节点(同步)
 *
 * @author jerome_s@qq.com
 */
public class _21CreateNodeSync implements Watcher {

	private static ZooKeeper zookeeper;

	public static void main(String[] args) throws IOException, InterruptedException {
		// 建立连接，并注册一个监听器
		zookeeper = new ZooKeeper("10.10.18.45:2181", 5000, new _21CreateNodeSync());
		System.out.println(zookeeper.getState());
		Thread.sleep(Integer.MAX_VALUE);
	}

	private void createNode() {
		try {
			System.out.println("do something"); // Ids.OPEN_ACL_UNSAFE
			// 任何人可以对这个节点进行任何操作
			// 判断节点是否存在
			Stat stat = zookeeper.exists("/node2", true);
			if (stat != null) {
				System.out.println("/node2 节点已经存在");
			} else {
				String path = zookeeper.create("/node2", "123".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				System.out.println("创建节点：" + path);
			}
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("创建节点结束");
	}

	public void showChildrenNodes() {
		try {
			// true 表示监听，false表示不监听，不会触发调用process方法
			List<String> list = zookeeper.getChildren("/", true);
			for (String str : list) {
				System.out.println(str);
			}
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void process(WatchedEvent event) {
		System.out.println("收到事件：" + event);
		if (event.getState() == KeeperState.SyncConnected) {
//			createNode();
			showChildrenNodes();
		} else if (event.getState() == KeeperState.Disconnected) {
			System.out.println("断开连接");
		}
	}

	/*
	 * 输出 CONNECTING 收到事件：WatchedEvent state:SyncConnected type:None path:null
	 * return path:/node2 do something
	 */

}
