package annotation2.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import annotation2.domain.Bus;
import annotation2.domain.Car;
import annotation2.domain.Cat;
import annotation2.domain.Dog;

@Configuration
@ComponentScan(value="annotation2")
@Import({Bus.class,Dog.class})
public class AppConfig {

	@Bean(initMethod="init",destroyMethod="destory")
	@Scope("prototype") // 在从容器取出的时候，进行创建和初始化，在容器关闭的时候，具体是关闭前，容器不过调用销毁方法。这是一个特殊之处
	public Car car() {
		return new Car();
	}
	
	@Bean
	@Qualifier("cat") // 指定bean的id名
	public Cat cat() {
		return new Cat();
	}
	
	@Bean
	public CatBeanPostProcessor catBeanPostProcessor() {
		return new CatBeanPostProcessor();
	}
		
	
	
}
