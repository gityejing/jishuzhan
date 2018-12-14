#spring和hibernate整合开发#

##1,使用的版本##
```xml
<properties>
	<spring.version>5.1.1.RELEASE</spring.version>
	<hibernate.version>5.3.7.Final</hibernate.version>
</properties>
```

##2,需要整合什么##
1)，用spring容器来管理hibernate的sessionfactory</br>
2)，hibernate使用spring的申明似事务管理</br>

##3,hibernateTemplate简化开发##

spring提供的hibernateTemplate简化开发，进行数据库的增删该查操作



##4,在开发过程中遇到事务的问题##
1),no transaction is in progress
刚开始使用的事务管理器是：DataSourceTransactionManager
后来改成了：HibernateTransactionManager
就没再报错了
</br>

