package spring_springdata_jpa.dao.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import spring_springdata_jpa.domain.Persion;

@Repository
public class PersionDao {

	@Resource 
	private JdbcTemplate jdbcTemplate;
	
	public void insert(String name) {
//		jdbcTemplate.update(" insert into persion(name) values (?) ",name);
		Persion persion = new Persion();
		persion.setName("haha");
	}

	public void clear() {
		jdbcTemplate.update(" delete from persion ");
	}
}
