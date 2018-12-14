package springDemo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("demoTask2")
public class DemoTask2 {
	
	@Scheduled(cron = "*0/5 * * * * ?")
	public void myTestWork() {
		System.out.println("这是一个定时任务2");
	}
}
