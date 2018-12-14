package annotation5;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // 加入到IoC容器
@Aspect // 指定当前类为切面类
public class Aop {

	@Pointcut("execution(public int annotation5.TestService.*(..) )")
	public void pointcut() {
		
	}
	
	@Before("pointcut()")
	public void begin() {
		System.out.println("执行方法前记录日志");
	}

	@After(value="pointcut()")
	public void divAfter() {
		System.out.println("方法执行完后调用");
	}
	
	@AfterReturning(value="pointcut()",returning="result")
	public void divReturn(Object result) {
		System.out.println("方法执行完后调用:"+result);
	}

	@AfterThrowing(value="pointcut()",throwing="exception")
	public void divAfterThrowing(Exception exception) {
		System.out.println("抛出异常后："+exception.getMessage());
	}
}