# spring 基于注解开发学习demo #

## 1,IOC 容器  ## 

1),创建一个容器，并对容器进行配置
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


@Configuration 主配置文件，相当于一个xml配置文件
@ComponentScan(value="annotation") 自动扫描基包，放在主配置类上，
主要扫描如下注解的bean，@Component、@Repository、@Service、@Controller


@Bean 放在方法上，注解一个bean并放到容器中
@Scope("prototype") 单例和多例的配置
@Lazy 懒加载
@Conditional 有条件的放入到容器中，条件实现Condition接口，例如判断操作系统是windows还是linux，可以在配置运行参数 vm 参数。
@Import(Color.class) 导入组件到容器，适用于jar包中的bean或没有源代码的bean并且没有注解。
@Import(MyImportSelector.class) 也可以导入组件到容器中，MyImportSelector是自定义的选择器实现了ImportSelector接口，其有一个方法selectImports，返回值是bean的全类名数组。
@Import(MyImportBeanDefinitionRegistrar.class) 又是一种自定义注入bean的方法，也是实现一个接口ImportBeanDefinitionRegistrar
还可以同时使用不同的方式，如下
@Impor({Color.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})

使用FactoryBean也可以像容器中添加组件，这种方式常用在其他框架于spring进行整合的场景下。
具体的做法是定义自己的factorybean实现FactoryBean接口，然后通过@Bean注解将自定义的FactoryBean放到容器中。

@Autowired 依赖注入
@Resource 依赖注入，推荐使用这个代替上面的@Autowired
@Qualifier 定义bean的id

@PostConstruct bean初始化和依赖注入后调用
@PreDestroy 在容器关闭，并且是在容器关闭前调用

@PropertySource(value = {"jdbc.properties","classpath:common.properties", "classpath:abc.properties"},
encoding="UTF-8",ignoreResourceNotFound=true)
用来读取外部的配置文件

@Value("${destinationLocation}")用来读取配置文件中的键值

@Autowired 根据类型注入， 
@Resource 默认根据名字注入，其次按照类型搜索
@Autowired @Qualifie("userService") 两个结合起来可以根据名字和类型注入
1，放在参数位置
2，放在方法上
3，放在构造器上

@Primary 注解的实例优先于其他实例被注入

@Transactional 可以作用于接口、接口方法、类以及类方法上。推荐用在类和类的方法上。

@Profile 根据当前环境动态的激活和切换一系列组件，比如载入不同的数据源的配置


@ImportResource:导入spring.xml等的配置文件

## 2,AOP 面向切面编程 ##




