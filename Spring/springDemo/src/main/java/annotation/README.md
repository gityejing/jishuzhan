#spring ioc 容器相关知识学习
 
1),创建一个容器，并对容器进行配置

``` java
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
AnnotationConfigApplicationContext 就是容器对象，AppConfig.class是对容器进行配置的配置类。
配置类上需要有一个注解进行标识：@Configuration 标识主配置文件，相当于一个xml配置文件
```

2),把bean交给容器进行管理的集中方式

```txt
 
1，在主配置文件中使用@Bean注解，放在方法上，方法的返回值就是要放到容器中的bean，方法名就是bean的id或name

@Bean 放在方法上，注解一个bean并放到容器中
@Scope("prototype")单例和多例的配置
@Lazy 懒加载
@Conditional 有条件的放入到容器中，条件实现Condition接口，例如判断操作系统是windows还是linux，可以在配置运行参数 vm 参数。

2，通过自动扫描包，将包中的带有@Component、@Repository、@Service、@Controller等注解的类，扫描装备到容器中去
@ComponentScan(value="annotation") 自动扫描基包，放在主配置类上，
主要扫描如下注解的bean，@Component、@Repository、@Service、@Controller

3，在主配置类或者容器管理的bean上使用@Import(Color.class)注解，将指定的类引入到容器中去

4，实现ImportSelector接口，并将实现类以@Import或者@Bean等其它方式放到容器中。容器会调用实现类中的selectImports方法，这个方法返回的就是需要被放到容器中进行管理的类的全类名。

5，实现ImportBeanDefinitionRegistrar接口，并将实现类以@Import或者@Bean等其它方式放到容器中。容器会调用实现类中的registerBeanDefinitions方法，在方法中通过 BeanDefinitionRegistry registry，可以将我们需要放到容器中的bean注册到容器中。
祖册方式例如：registry.registerBeanDefinition("yellow", new RootBeanDefinition(Yellow.class));

6，实现FactoryBean<T>接口，并将实现类通过@Import或者@Bean等其它方式放到容器中。实现类中通过getObject()方法，返回具体的要放到容器中进行管理的类对象。其他方法分别返回类的类别和是否是以单例还是多例的模式。

```

3),如何的注入依赖的对象

```txt
采用以下三个注解：
@Autowired 根据类型注入，当一个接口有多个实现类的时候，该注入哪一个，可以通过在具体的实现类上标注@Primary注解，表示优先注入此实现类。
或者，对每一个具体的实现类，标注不同的id或name，然后根据id，使用@Qualifie("userService")，指定注入那个实现类的对象。
@Resource 默认根据名字进行查找然后注入，其次按照类型搜索
以上的注解，都可以放置在1，放在参数位置2，放在方法上3，放在构造器上
```










