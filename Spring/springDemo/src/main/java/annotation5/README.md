spring注解切面的开发步骤

涉及到如下的注解：
@EnableAspectJAutoProxy：开启自动代理的功能，启用基于注解的切面功能
@Aspect：定义切面类的注解
@Before：前置通知，相当于BeforeAdvice
@AfterReturning：后置通知，相当于AfterReturningAdvice
@Around：环绕通知，相当于MethodInterceptor
@AfterThrowing：抛出通知，相当于ThrowAdvice
@After：最终final通知，不管是否异常，该通知都会执行
@Pointcut：定义切入点的注解

@Component:将bean放到容器中管理

步骤：
1，编写切面类和定义好切入点表达式和切入点方法@Pointcut,@Before,@AfterReturning,@Around,@AfterThrowing,@After
2，将切面类和被切的类都放到容器中管理@Aspect,@Component 
3，最重要的一步，就是一定要在主配置文件上开启注解切面的功能@EnableAspectJAutoProxy