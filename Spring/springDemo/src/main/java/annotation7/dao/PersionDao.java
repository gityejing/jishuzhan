package annotation7.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import annotation7.domain.Persion;

@Repository
public class PersionDao {

	@Resource 
	private JdbcTemplate jdbcTemplate;
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void insert(String name) {
//		jdbcTemplate.update(" insert into persion(name) values (?) ",name);
		Persion persion = new Persion();
		persion.setName("haha");
		hibernateTemplate.save(persion);
	}

	public void clear() {
		jdbcTemplate.update(" delete from persion ");
	}
}
