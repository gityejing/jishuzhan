如何切换多环境
1,-Dspring.profile.active=dev，命令行参数

2,使用代码的方式
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();// 空参数的构造函数
context.getEnvironment().setActiveProfiles("dev");// 设置环境
context.register(AppConfig.class);// 注册主配置类
context.refresh();// 刷新容器

3,写在类上，只有当类上的配置和当前环境一致时，类中配置的组件才会生效

4，没有指定环境标识的bean都会被加载
