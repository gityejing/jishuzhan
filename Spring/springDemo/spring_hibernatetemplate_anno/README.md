#spring��hibernate���Ͽ���#

##1,ʹ�õİ汾##
```xml
<properties>
	<spring.version>5.1.1.RELEASE</spring.version>
	<hibernate.version>5.3.7.Final</hibernate.version>
</properties>
```

##2,��Ҫ����ʲô##
1)����spring����������hibernate��sessionfactory</br>
2)��hibernateʹ��spring���������������</br>

##3,hibernateTemplate�򻯿���##

spring�ṩ��hibernateTemplate�򻯿������������ݿ����ɾ�ò����



##4,�ڿ����������������������##
1),no transaction is in progress
�տ�ʼʹ�õ�����������ǣ�DataSourceTransactionManager
�����ĳ��ˣ�HibernateTransactionManager
��û�ٱ�����
</br>

