package annotation2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import annotation2.config.AppConfig;

public class AppMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("容器创建完.。。。");// 单实例的bean构造器的打印在这个之前，多实例的bean在用的时候才构造
//		context.getBean(Car.class);
		context.close();// 容器关闭的时候，具体是关闭前，会调用car额销毁方法，当是多实例状态下的时候,容器关闭，也不会销毁bean
		System.out.println("容器关闭。。。");
	}
}
