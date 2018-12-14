package annotation8_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation8_1.service.PersionService;

public class AppMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		PersionService persionService = context.getBean(PersionService.class);
		persionService.clear();
		persionService.insert();
	}
}
