package annotation.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * �˽ӿڵ����ã����ǽ�selectImports�������ص��࣬�ŵ�spring������ȥ��
 * ���ﷵ�ص���ȫ������һ�����顣
 * @author 30000133
 *
 */
public class MyImportSelector implements ImportSelector{

	/**
	 * ����ֵ����Ҫ���뵽�����е������ȫ����
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		String[] names = new String[] {"annotation.domain.Red"};
		return names;
	}

}
