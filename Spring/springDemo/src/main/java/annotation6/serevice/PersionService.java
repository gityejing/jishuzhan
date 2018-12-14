package annotation6.serevice;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import annotation6.dao.PersionDao;

@Service
public class PersionService {
	
	@Resource
	private PersionDao persionDao;
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert() {
		persionDao.insert("herio1");
//		int i = 1/0;
		persionDao.insert("herio2");
		System.out.println("≤Â»ÎÕÍ≥…");
	}
	
	public void clear() {
		persionDao.clear();
	}
}
