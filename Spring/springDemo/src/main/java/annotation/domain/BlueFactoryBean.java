package annotation.domain;

import org.springframework.beans.factory.FactoryBean;

public class BlueFactoryBean implements FactoryBean<Blue> {

	/**
	 * 返回一个对象，这个对象会添加到容器中
	 */
	@Override
	public Blue getObject() throws Exception {
		return new Blue();
	}

	/**
	 * 返回对象的类型
	 */
	@Override
	public Class<?> getObjectType() {
		return Blue.class;
	}

	/**
	 * 单例模式还是多例模式
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
