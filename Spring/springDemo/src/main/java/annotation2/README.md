# spring容器中bean的生命周期管理 #

默认情况先，容器中bean的生命周期（创建--初始化--销毁），由容器来进行管理，我们可以通过如下的方式和容器进行交互，参与bean的整个生命周期管理工作。

```txt

1,指定初始化和销毁方法,例如：@Bean(initMethod="init",destroyMethod="destory"),在类中定义init()和destory()方法。

2，InitializingBean和DisposableBean接口
如果Bean类已实现org.springframework.beans.factory.InitializingBean接口，则执行他的afterProPertiesSet()方法
在容器关闭时，如果Bean类有实现org.springframework.beans.factory.DisposableBean接口，则执行他的destroy()方法，这里仅对单实例的bean起作用

3,JSR-250定义的两个注解@PostConstruct和@PreDestroy
在方法上加上注解@PostConstruct，这个方法就会在Bean初始化之后被Spring容器执行（注：Bean初始化包括，实例化Bean，并装配Bean的属性（依赖注入）使用@Autowired和@Resource注解（推荐用@Resource））。
在方法上加上注解@PreDestroy，这个方法就会在Bean初始化之后被Spring容器执行。由于我们当前还没有需要用到它的场景，这里不去演示。其用法同@PostConstruct。

4，BeanPostProcessor接口
如果我们想在Spring容器中完成bean实例化、配置以及其他初始化方法前后要添加一些自己逻辑处理。我们需要定义一个或多个BeanPostProcessor接口实现类，然后注册到Spring IoC容器中

```







@Primary 注解的实例优先于其他实例被注入

@Transactional 可以作用于接口、接口方法、类以及类方法上。推荐用在类和类的方法上。

@Profile 根据当前环境动态的激活和切换一系列组件，比如载入不同的数据源的配置


@ImportResource:导入spring.xml等的配置文件




