#spring ioc �������֪ʶѧϰ
 
1),����һ������������������������

``` java
ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
AnnotationConfigApplicationContext ������������AppConfig.class�Ƕ������������õ������ࡣ
����������Ҫ��һ��ע����б�ʶ��@Configuration ��ʶ�������ļ����൱��һ��xml�����ļ�
```

2),��bean�����������й���ļ��з�ʽ

```txt
 
1�����������ļ���ʹ��@Beanע�⣬���ڷ����ϣ������ķ���ֵ����Ҫ�ŵ������е�bean������������bean��id��name

@Bean ���ڷ����ϣ�ע��һ��bean���ŵ�������
@Scope("prototype")�����Ͷ���������
@Lazy ������
@Conditional �������ķ��뵽�����У�����ʵ��Condition�ӿڣ������жϲ���ϵͳ��windows����linux���������������в��� vm ������

2��ͨ���Զ�ɨ����������еĴ���@Component��@Repository��@Service��@Controller��ע����࣬ɨ��װ����������ȥ
@ComponentScan(value="annotation") �Զ�ɨ��������������������ϣ�
��Ҫɨ������ע���bean��@Component��@Repository��@Service��@Controller

3������������������������bean��ʹ��@Import(Color.class)ע�⣬��ָ���������뵽������ȥ

4��ʵ��ImportSelector�ӿڣ�����ʵ������@Import����@Bean��������ʽ�ŵ������С����������ʵ�����е�selectImports����������������صľ�����Ҫ���ŵ������н��й�������ȫ������

5��ʵ��ImportBeanDefinitionRegistrar�ӿڣ�����ʵ������@Import����@Bean��������ʽ�ŵ������С����������ʵ�����е�registerBeanDefinitions�������ڷ�����ͨ�� BeanDefinitionRegistry registry�����Խ�������Ҫ�ŵ������е�beanע�ᵽ�����С�
��᷽ʽ���磺registry.registerBeanDefinition("yellow", new RootBeanDefinition(Yellow.class));

6��ʵ��FactoryBean<T>�ӿڣ�����ʵ����ͨ��@Import����@Bean��������ʽ�ŵ������С�ʵ������ͨ��getObject()���������ؾ����Ҫ�ŵ������н��й������������������ֱ𷵻���������Ƿ����Ե������Ƕ�����ģʽ��

```

3),��ε�ע�������Ķ���

```txt
������������ע�⣺
@Autowired ��������ע�룬��һ���ӿ��ж��ʵ�����ʱ�򣬸�ע����һ��������ͨ���ھ����ʵ�����ϱ�ע@Primaryע�⣬��ʾ����ע���ʵ���ࡣ
���ߣ���ÿһ�������ʵ���࣬��ע��ͬ��id��name��Ȼ�����id��ʹ��@Qualifie("userService")��ָ��ע���Ǹ�ʵ����Ķ���
@Resource Ĭ�ϸ������ֽ��в���Ȼ��ע�룬��ΰ�����������
���ϵ�ע�⣬�����Է�����1�����ڲ���λ��2�����ڷ�����3�����ڹ�������
```










