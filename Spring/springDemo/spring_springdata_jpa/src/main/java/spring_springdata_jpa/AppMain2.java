package spring_springdata_jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring_springdata_jpa.config.AppConfig;
import spring_springdata_jpa.service.PersionService;

public class AppMain2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(AppConfig.class);
		PersionService persionService = context.getBean(PersionService.class);
		persionService.clear();
		persionService.save();
//		persionService.findPersionsLike("èàÏn");
//		persionService.countPersions();
//		persionService.updateNameById(2L, "“∫æß");
//		persionService.findPersionsLike("èàÏn");
//		persionService.findAllByPage(1, 3);
		persionService.findPersions("èàÏn");
		context.close();
	}
}
