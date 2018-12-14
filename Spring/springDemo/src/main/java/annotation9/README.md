spring 与 jpa 的整合使用
spring 与 springdata 的整合使用


涉及到的jar
<!-- https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa -->
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-jpa</artifactId>
    <version>2.1.1.RELEASE</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager -->
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-entitymanager</artifactId>
    <version>${hibernate.version}</version>
</dependency>


注解：
@EnableJpaRepositories(basePackages = {"annotation9.dao"}, 
	transactionManagerRef = "transactionManager", 
	entityManagerFactoryRef = "entityManagerFactory")
	
// 等价于继承 JpaRepository<Persion,Long> 接口
@RepositoryDefinition(domainClass=Persion.class,idClass=Long.class)
@Query和@Param的组合使用，进行查询参数的映射
@Query和@Modifying的组合使用，可以达到修改的效果
