package annotation3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import annotation3.config.AppConfig;
import annotation3.service.FileService;

public class AppMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		FileService service = (FileService) context.getBean("fileService");
		service.readValues();
		service = (FileService)context.getBean("fileService2");
		service.readValues();
		context.close();
	}
}
