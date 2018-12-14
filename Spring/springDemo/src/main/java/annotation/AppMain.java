package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import annotation.config.AppConfig;
import annotation.domain.Persion;
import annotation.service.HelloService;

public class AppMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloService hs = context.getBean(HelloService.class);
		System.out.println(hs.say());
		
		// 从容器中取出的时候，会进行persion的构造，这个时候单例和多例就开始显现了
		Persion p = context.getBean(Persion.class);
		System.out.println(p);
//		
		p = context.getBean(Persion.class);
		System.out.println(p);
		
		// 通过在运行配置里面的vm参数中设置   -Dos.name=Linux
		// 这样满足了linux系统的条件，那么就会容器中只会有persion01
		String[] names = context.getBeanNamesForType(Persion.class);
		for (String name : names) {
			System.out.println(name);
		}
		
		names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		
		// 默认获取到的是工厂bean创建的对象
		// 如果想要获取工厂bean本身，需要给id加一个前缀如"&blueFactoryBean"
		Object object =  context.getBean("blueFactoryBean");
		System.out.println(object.getClass().getTypeName());
	}
}
