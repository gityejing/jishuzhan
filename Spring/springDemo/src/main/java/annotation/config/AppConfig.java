package annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import annotation.domain.BlueFactoryBean;
import annotation.domain.Color;
import annotation.domain.Persion;

@Configuration
@ComponentScan(value="annotation")// �Զ�ɨ��bean�������������Լ�д��bean��������ע��
// �����ڵ������д�Ļ�jar���е�bean
@Import({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})// Ҳ���Ե��������������
public class AppConfig {

	@Bean // �����ڵ������д�Ļ�jar���е�bean
	// Ĭ���ǵ���ģʽ��ֻ�ṹ��һ��
	// ����ĳɶ���ģʽ����ÿ�ζ�����һ�Σ�����Ĺ��췢���ڴ�������ȡ����ʱ��
	@Scope("prototype")
	@Conditional({WinCondition.class})
	Persion persion() {
		return new Persion("123","TOM");
	}
	
	@Bean
	@Lazy
	@Conditional({LinuxCondition.class})
	Persion persion01() {
		return new Persion("122","bill");
	}
	
	/**
	 * spring����hibernate��mybatis�ȿ�ܣ����ṩ�˸���xxxfactoryBean
	 * ��ײ�ʹ�õľ������ԭ����ʵ��FactoryBean<T>�ӿ�,���Ͳ����У���������Ҫ���ص�bean�����͡�
	 * @return
	 */
	@Bean
	BlueFactoryBean blueFactoryBean() {
		return new BlueFactoryBean();
	}
}