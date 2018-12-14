package annotation8_1.dao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import annotation8_1.domain.Persion;

@Repository
public class PersionDao {

	@Resource(name="entityManagerFactory")
	private EntityManagerFactory entityManagerFactory;
	
	@Resource 
	private JdbcTemplate jdbcTemplate;
	
	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	public void insert(String name) {
		Persion persion = new Persion();
		persion.setName("haha");
		getEntityManager().merge(persion);
	}

	public void clear() {
		jdbcTemplate.update(" delete from persion ");
	}
}
