package annotation8.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import annotation8.dao.PersionDao;

@Service
public class PersionService {
	
	@Resource
	private PersionDao persionDao;
	
	public void insert() {
		persionDao.insert("herio1");
		persionDao.insert("herio2");
		System.out.println("≤Â»ÎÕÍ≥…");
	}
	
	public void clear() {
		persionDao.clear();
	}
}
