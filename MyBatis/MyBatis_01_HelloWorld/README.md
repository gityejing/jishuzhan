### 遇到的问题

1，插入一条记录，在数据库中出现中文乱码问题，关键代码如下

```java

@Test
public void testInsert() throws IOException {
	SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
	SqlSession openSession = sqlSessionFactory.openSession();
	try {
		/*emp.setLastName(URLEncoder.encode("萍", "utf-8"));
		emp.setGender(URLEncoder.encode("女", "utf-8"));*/
		
		Employee emp = new Employee();
		emp.setLastName("萍");
		emp.setGender("女");
		emp.setEmail("mailfendou@163.com");
		EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
		mapper.insertEmp(emp);
		openSession.commit();// 提交事务，才能存储到数据库中。
	} finally {
		openSession.close();
	}
}

```
这里的 lastName和gender在数据库中是乱码。解决方式是修改了主配置文件中url链接的参数。

```xml

<dataSource type="POOLED">
				<property name="driver" value="com.mysql.jdbc.Driver" />
				<!-- 在链接后面加 上useUnicode=true&amp;characterEncoding=UTF-8,解决保存中文的乱码问题 -->
				<property name="url" 
					value="jdbc:mysql://localhost:3306/mybatis1?useUnicode=true&amp;characterEncoding=UTF-8" />
				<property name="username" value="root"/>
				<property name="password" value="881213" />
			</dataSource>

```





