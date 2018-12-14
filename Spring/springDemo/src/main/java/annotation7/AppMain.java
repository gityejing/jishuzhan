package annotation7;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotation7.service.PersionService;

public class AppMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		PersionService persionService = context.getBean(PersionService.class);
		persionService.clear();
		persionService.insert();
	}
}
