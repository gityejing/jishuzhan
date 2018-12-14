package spring_hibernatetemplate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_hibernatetemplate.service.PersionService;


public class AppMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		PersionService persionService = context.getBean(PersionService.class);
		persionService.clear();
		persionService.insert();
	}
}
