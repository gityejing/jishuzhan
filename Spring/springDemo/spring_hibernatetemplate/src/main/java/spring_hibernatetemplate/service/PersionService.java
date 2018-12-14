package spring_hibernatetemplate.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring_hibernatetemplate.dao.PersionDao;


@Service
@Transactional
public class PersionService {
	
	@Resource
	private PersionDao persionDao;
	
	@Transactional(readOnly=false)
	public void insert() {
		persionDao.insert("herio1");
		persionDao.insert("herio2");
		System.out.println("≤Â»ÎÕÍ≥…");
	}
	
	
	public void clear() {
		persionDao.clear();
	}
}
