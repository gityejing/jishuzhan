package spring_springdata_jpa.dao;

import java.util.List;

public interface IPersionDao<Persion> {
	
	public List<Persion> findPersions(String name);
}
