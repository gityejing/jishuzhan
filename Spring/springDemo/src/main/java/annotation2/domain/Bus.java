package annotation2.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Bus implements InitializingBean,DisposableBean{
	
	public Bus() {
		super();
		System.out.println(" create bus ... ");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(" destory bus ");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(" afterPropertiesSet bus ");
	}

}
