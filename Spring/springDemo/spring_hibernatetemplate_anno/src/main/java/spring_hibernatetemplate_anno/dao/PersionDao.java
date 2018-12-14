package spring_hibernatetemplate_anno.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import spring_hibernatetemplate_anno.domain.Persion;



@Repository
public class PersionDao {

	@Resource 
	private JdbcTemplate jdbcTemplate;
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void insert(String name) {
		jdbcTemplate.update(" insert into persion(name) values (?) ",name);
	}
	
	public void save(Persion persion) {
		hibernateTemplate.save(persion);
	}

	public void clear() {
		jdbcTemplate.update(" delete from persion ");
	}
}
