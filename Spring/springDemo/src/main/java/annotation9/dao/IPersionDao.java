package annotation9.dao;

import java.util.List;

import annotation9.domain.Persion;

public interface IPersionDao {
	
	public List<Persion> findPersions(String name);
}
