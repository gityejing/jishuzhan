package spring_springdata_jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring_springdata_jpa.dao.PersionRepository;
import spring_springdata_jpa.dao.PersionRepository2;
import spring_springdata_jpa.dao.impl.PersionDao;
import spring_springdata_jpa.domain.Persion;

@Service
@Transactional
public class PersionService {
	
	@Resource
	private PersionDao persionDao;
	
	@Resource
	private PersionRepository persionRepository;

	@Resource
	private PersionRepository2 persionRepository2;
	
	
	public void insert() {
		persionDao.insert("herio1");
		persionDao.insert("herio2");
		System.out.println("插入完成");
	}
	
	public void save() {
		for (long i = 0; i < 10; i++) {
			Persion persion = new Persion();
			persion.setName("張靚穎");
			persion.setId(i);
			persionRepository.save(persion);
		}
	}
	
	public void findPersions(String name) {
		List<Persion> list = persionRepository2.findByName(name);
		for (Persion persion : list) {
			System.out.println(persion);
		}
		persionRepository.findPersions(name);
	}
	
	public void findPersionsLike(String name) {
		List<Persion> list = persionRepository2.findByNameLike2(name);
		for (Persion persion : list) {
			System.out.println(persion);
		}
	}
	
	public void countPersions() {
		int count = persionRepository2.countPersions();
		System.out.println(count);
	}
	
	public void updateNameById(Long id,String name) {
		persionRepository2.updateNameById(id, name);
		Persion persion = persionRepository.getOne(id);
		System.out.println(persion);
	}
	
	public void findAllByPage(int page, int size) {
		PageRequest pageRequest = PageRequest.of(page-1, size, Direction.DESC, "id");
		Page<Persion> page2 = persionRepository.findAll(pageRequest);
		List<Persion> list = page2.getContent();
		for (Persion persion : list) {
			System.out.println(persion);
		}
		System.out.println("总页数："+page2.getTotalPages());
		System.out.println("总记录数："+page2.getTotalElements());
	}
	
	public void clear() {
		persionDao.clear();
	}
}
