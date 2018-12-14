package annotation.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//  «∑ÒlinuxœµÕ≥
		ConfigurableListableBeanFactory bFactory = context.getBeanFactory();
		BeanDefinitionRegistry registry = context.getRegistry();
		ClassLoader classLoader = context.getClassLoader();
		Environment environment = context.getEnvironment();
		String name = environment.getProperty("os.name");
		if(name.contains("Linux")) return true;
		return false;
	}

}
