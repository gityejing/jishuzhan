package spring_springdata_jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import spring_springdata_jpa.domain.Persion;


// 等价于继承 JpaRepository<Persion,Long> 接口
@RepositoryDefinition(domainClass=Persion.class,idClass=Long.class)
public interface PersionRepository2 {

	List<Persion> findByName(String name);
	
	
	List<Persion> findByNameLike(String name);
	
	@Query(" from Persion where name like %:name% ")
	List<Persion> findByNameLike2(@Param("name") String name);
	
	@Query(value=" select count(*) from persion ",nativeQuery=true)
	int countPersions();
	
	@Modifying // 必须加上这个注解，才能达到修改的效果
	@Query(" update Persion p set p.name = :name where id = :id ")
	void updateNameById(@Param("id") Long id,@Param("name") String name);
	
}
