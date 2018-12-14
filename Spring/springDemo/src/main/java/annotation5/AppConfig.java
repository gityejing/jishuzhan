package annotation5;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
//启用自动代理，重要的一步，启用基于注解的切面功能，没有这一个配置，切面类和切入点等都无法起作用。
@EnableAspectJAutoProxy 
@Configuration
@ComponentScan("annotation5")
public class AppConfig {
	
}
