package annotation6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import annotation6.config.AppConfig;
import annotation6.serevice.PersionService;

public class AppMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		PersionService pService = context.getBean(PersionService.class);
		pService.clear();
		pService.insert();
		context.close();
	}
}
