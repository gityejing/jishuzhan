package annotation.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 此接口的作用，就是将selectImports方法返回的类，放到spring容器中去。
 * 这里返回的是全类名的一个数组。
 * @author 30000133
 *
 */
public class MyImportSelector implements ImportSelector{

	/**
	 * 返回值就是要导入到容器中的组件的全类名
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		String[] names = new String[] {"annotation.domain.Red"};
		return names;
	}

}
