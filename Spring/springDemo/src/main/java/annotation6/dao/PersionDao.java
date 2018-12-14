package annotation6.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersionDao {

	@Resource 
	private JdbcTemplate jdbcTemplate;
	
	public void insert(String name) {
		jdbcTemplate.update(" insert into persion(name) values (?) ",name);
	}

	public void clear() {
		jdbcTemplate.update(" delete from persion ");
	}
}
