#spring 与 springdata+jpa 的整合使用#


###1,涉及到的jar###

```xml
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
```

###2,重要的注解和作用###
注解：
@EnableJpaRepositories(basePackages = {"annotation9.dao"}, 
	transactionManagerRef = "transactionManager", 
	entityManagerFactoryRef = "entityManagerFactory")
	
// 等价于继承 JpaRepository<Persion,Long> 接口
@RepositoryDefinition(domainClass=Persion.class,idClass=Long.class)
@Query和@Param的组合使用，进行查询参数的映射
@Query和@Modifying的组合使用，可以达到修改的效果

###3,自定义的数据库操作方法放在哪？###
1，通过定义一个接口，例如：PersionRepository，继承自JpaRepository，就可以使用springdata封装好的各种便利的方法，但是如果默认提供的方法无法满足需要，我们就需要定义自己的方法。</br>
2，具体方式：</br>
1),定义一个接口，例如：IPersionDao，在接口中写自己想要的方法，让原来的继承自JpaRepository等的接口再继承这个接口</br>
2),定义一个上面接口的实现类，以Impl结尾，然后实现接口中定义的方法findPersions，这样，在serveice层，就可以通过原来继承自JpaRepository的接口PersionRepository来直接调用到我们自己定义的方法findPersions了。</br>

具体的案例：

``` java

// 这个接口使用springdata提供的便利的方法,并且继承我们自定义方法的接口IPersionDao
public interface PersionRepository extends JpaRepository<Persion,Long>,IPersionDao<Persion>{
	
}
```

```java

public interface IPersionDao<Persion> {
	
	public List<Persion> findPersions(String name);
}


```

``` java

// 具体的实现类
public class PersionRepositoryImpl implements IPersionDao<Persion>{

	@Override
	public List<Persion> findPersions(String name) {
		System.out.println("3333");
		return null;
	}
}

```




