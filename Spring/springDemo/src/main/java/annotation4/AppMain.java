package annotation4;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import annotation4.config.AppConfig;

public class AppMain {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.register(AppConfig.class);
		context.refresh();
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[] names = context.getBeanNamesForType(DataSource.class);
		for (String name : names) {
			System.out.println(name);
		}
		context.close();
	}
}
