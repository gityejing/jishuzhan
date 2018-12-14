package spring_hibernatetemplate_anno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring_hibernatetemplate_anno.config.AppConfig;
import spring_hibernatetemplate_anno.service.PersionService;

public class AppMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PersionService persionService = ctx.getBean(PersionService.class);
		persionService.clear();
//		persionService.saveTest();
		persionService.save2();
	}
}
