spring 注解事务开发

步驟：
1,@Transactional 给类和方法加事务，光加一个这个注解还没有用，要开启基于注解的事务支持
2,@EnableTransactionManagement 开启基于注解的事务管理功能，
3,最关键的一点是配置事务管理器，来控制事务。PlatformTransactionManager接口的实现类，常用的是DataSourceTransactionManager



