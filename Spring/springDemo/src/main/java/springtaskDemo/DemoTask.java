package springtaskDemo;

import org.springframework.stereotype.Service;

@Service("demoTask")
public class DemoTask {
	public void myTestWork() {
		System.out.println("这是一个定时任务");
	}
}
