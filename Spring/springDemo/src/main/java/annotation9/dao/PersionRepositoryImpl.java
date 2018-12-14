package annotation9.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Repository;

import annotation9.domain.Persion;

@Repository
public class PersionRepositoryImpl implements IPersionDao{

	@Resource
	EntityManagerFactory entityManagerFactory;
	
	
	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	
	@Override
	public List<Persion> findPersions(String name) {
		
		
		return null;
	}

}
