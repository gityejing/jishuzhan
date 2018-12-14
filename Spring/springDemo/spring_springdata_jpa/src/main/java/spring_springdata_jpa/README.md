#spring �� springdata+jpa ������ʹ��#


###1,�漰����jar###

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

###2,��Ҫ��ע�������###
ע�⣺
@EnableJpaRepositories(basePackages = {"annotation9.dao"}, 
	transactionManagerRef = "transactionManager", 
	entityManagerFactoryRef = "entityManagerFactory")
	
// �ȼ��ڼ̳� JpaRepository<Persion,Long> �ӿ�
@RepositoryDefinition(domainClass=Persion.class,idClass=Long.class)
@Query��@Param�����ʹ�ã����в�ѯ������ӳ��
@Query��@Modifying�����ʹ�ã����Դﵽ�޸ĵ�Ч��

###3,�Զ�������ݿ�������������ģ�###
1��ͨ������һ���ӿڣ����磺PersionRepository���̳���JpaRepository���Ϳ���ʹ��springdata��װ�õĸ��ֱ����ķ������������Ĭ���ṩ�ķ����޷�������Ҫ�����Ǿ���Ҫ�����Լ��ķ�����</br>
2�����巽ʽ��</br>
1),����һ���ӿڣ����磺IPersionDao���ڽӿ���д�Լ���Ҫ�ķ�������ԭ���ļ̳���JpaRepository�ȵĽӿ��ټ̳�����ӿ�</br>
2),����һ������ӿڵ�ʵ���࣬��Impl��β��Ȼ��ʵ�ֽӿ��ж���ķ���findPersions����������serveice�㣬�Ϳ���ͨ��ԭ���̳���JpaRepository�Ľӿ�PersionRepository��ֱ�ӵ��õ������Լ�����ķ���findPersions�ˡ�</br>

����İ�����

``` java

// ����ӿ�ʹ��springdata�ṩ�ı����ķ���,���Ҽ̳������Զ��巽���Ľӿ�IPersionDao
public interface PersionRepository extends JpaRepository<Persion,Long>,IPersionDao<Persion>{
	
}
```

```java

public interface IPersionDao<Persion> {
	
	public List<Persion> findPersions(String name);
}


```

``` java

// �����ʵ����
public class PersionRepositoryImpl implements IPersionDao<Persion>{

	@Override
	public List<Persion> findPersions(String name) {
		System.out.println("3333");
		return null;
	}
}

```




