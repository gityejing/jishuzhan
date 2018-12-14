package spring_springdata_jpa.dao.impl;

import java.util.List;

import spring_springdata_jpa.dao.IPersionDao;
import spring_springdata_jpa.domain.Persion;

public class PersionRepositoryImpl implements IPersionDao<Persion>{

	@Override
	public List<Persion> findPersions(String name) {
		System.out.println("3333");
		return null;
	}


}
