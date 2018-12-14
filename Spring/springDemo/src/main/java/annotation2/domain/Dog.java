package annotation2.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Dog {

	public Dog() {
		super();
		System.out.println(" create dog");
	}
	
	// 初始化之后，并且是指依赖注入之后，调用这个方法
	@PostConstruct
	public void init() {
		System.out.println(" init dog ");
	}
	
	// 容器关闭，并且是关闭前，调用这个方法
	@PreDestroy
	public void destory() {
		System.out.println(" destory dog ");
	}
	
}
