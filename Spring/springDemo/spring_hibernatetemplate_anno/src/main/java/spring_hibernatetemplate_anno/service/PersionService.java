package spring_hibernatetemplate_anno.service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.annotation.Resource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import spring_hibernatetemplate_anno.dao.CommonDao;
import spring_hibernatetemplate_anno.dao.PersionDao;
import spring_hibernatetemplate_anno.domain.Persion;



@Service
@Transactional
public class PersionService {
	
	@Resource
	private PersionDao persionDao;
	@Resource
	private CommonDao commonDao;
	
	public void insert() {
		persionDao.insert("herio1");
		persionDao.insert("herio2");
		System.out.println("插入完成");
	}
	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void saveTest() {
		for (long i = 1; i <= 100; i++) {
			Persion persion = new Persion();
			persion.setId(i);
			persion.setName("张靓颖"+i);
			persionDao.save(persion);
		}
	}
	
	public void save2() {
		for (long i = 1; i <= 100; i++) {
			Persion persion = new Persion();
			persion.setId(i);
			try {
				persion.setName(org.apache.commons.lang3.StringUtils.toEncodedString("张靓颖".getBytes("UTF-8"), Charset.forName("UTF-8"))+i);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			commonDao.save(persion);
//			int e = 1/ 0;
		}
	}
	
	public void clear() {
		persionDao.clear();
	}
}
