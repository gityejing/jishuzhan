package annotation5;

import org.springframework.stereotype.Service;

/**
 *  使用切面，在方法调用前记录日志 在方法调用中如果出现异常记录异常 方法调用后记录结果
 * 
 * @author 30000133
 *
 */
@Service
public class TestService {
	public int div(int i, int j) {
		System.out.println("方法被调用");
		return i / j;
	}
}
