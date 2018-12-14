package com.mybatisplusdemo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mybatisplusdemo.dao.BookDAO;
import com.mybatisplusdemo.entity.Book;

/**
 * ��Ҫ��������BaseMapper�ṩ�Ļ�����crud������
 * �ͼ򵥵�������������ʹ��
 */
public class DaoplusTest extends BaseTest{

	
	@Resource
	BookDAO bookDAO;
	
	@Test
	public void testSave() {
		Book entity = new Book();
		entity.setPrice(3.2);
		entity.setPublishDate(new Date());
		entity.setTitle("һ��������ڳ�");
		bookDAO.insert(entity);
	}
	
	@Test
	public void testSaveAll() {
		for (int i = 11; i < 20; i++) {
			Book entity = new Book();
			entity.setPrice(3.2);
			entity.setPublishDate(new Date());
			entity.setTitle("һ��������ڳ�"+i);
			bookDAO.insert(entity);
		}
	}
	
	
	/**
	 * UPDATE books SET title='С��������',price=0.0,publishDate=null WHERE id=13
	 * δ����ֵ���ֶΣ�����Ϊ��null��Ĭ��ֵ
	 */
	@Test
	public void testUpdate1() {
		Book entity = new Book();
		entity.setId(13);
		entity.setTitle("С��������");
		bookDAO.updateById(entity);
		Book book = bookDAO.selectOne(entity);
		System.out.println(book);
	}
	
	/**
	 * update books set title='���ϣ��',price=0.0,publishDate=null where id=13
	 * ͬ�ϣ�Ҳ�ǽ�δ����ֵ���ֶ����ó���null��Ĭ��ֵ
	 */
	@Test
	public void testUpdate2() {
		Book entity = new Book();
		entity.setId(13);
		entity.setTitle("���ϣ��");
		bookDAO.update(entity);
		Book book = bookDAO.selectOne(entity);
		System.out.println(book);
	}
	
	/**
	 * UPDATE books SET title='���ϣ����',price=0.0,publishDate=null WHERE id=13
	 */
	@Test
	public void testUpdate3() {
		Book entity = new Book();
		entity.setId(13);
		entity.setTitle("���ϣ����");
		bookDAO.updateAllColumnById(entity);
		Book book = bookDAO.selectOne(entity);
		System.out.println(book);
	}
	
	@Test
	public void testSelect() {
		Book book = bookDAO.selectById(2);
//		System.out.println(book);
		List<Book> list = bookDAO.selectList(new EntityWrapper<Book>(book));
//		System.out.println(list);
		Condition condition = Condition.create();
		// �Զ��ļ�where
		condition.addFilter(" id > {0} ", 3);
		// �����������дand
		condition.like("title", "һ��������ڳ�");
//		list = bookDAO.selectList(condition);
//		for (Book book2 : list) {
//			System.out.println(book2);
//		}
		
//		RowBounds ��ҳ��ѯ������������������Ϳ����ˡ�ͨ����page
		Page<Book> page = new Page<Book>();
		page.setCurrent(1);
		page.setSize(4);
		
		list = bookDAO.selectPage(page, condition);
		for (Book book2 : list) {
			System.out.println(book2);
		}
		System.out.println(page.getTotal());// ��ֵ
		System.out.println(page.getRecords().size());// ��ֵ
		
		System.out.println("==========================================================");
		list = bookDAO.selectPage(new Page<Book>(2,4), condition);
		for (Book book2 : list) {
			System.out.println(book2);
		}
//		System.out.println(list);
	}
	
	/**
	 * ��û��ʹ�õ���ҳ�����ʱ������ķ�ҳЧ�������Ǻܺã���ʹ�õ��˷�ҳ���֮�󣬲��������������ҳ
	 */
	@Test
	public void testSelectPage() {
		Condition condition = Condition.create();
		condition.addFilter(" id > {0} ", 3); // �Զ��ļ�where
		condition.like("title", "һ��������ڳ�"); // �����������дand
//		RowBounds ��ҳ��ѯ������������������Ϳ����ˡ�ͨ����page
		Page<Book> page = new Page<Book>();
		page.setCurrent(1);
		page.setSize(4);
		
		List<Book> list = bookDAO.selectPage(page, condition);
		for (Book book2 : list) {
			System.out.println(book2);
		}
		System.out.println(page.getTotal());// ��ֵ
		System.out.println(page.getRecords().size());// ��ֵ
		
		System.out.println("==========================================================");
		list = bookDAO.selectPage(new Page<Book>(2,4), condition);
		for (Book book2 : list) {
			System.out.println(book2);
		}
	}
	
	@Test
	public void testDelete() {
//		Map<String,Object> columnMap = new HashMap<String,Object>();
//		columnMap.put("id", "15");
//		Integer result = bookDAO.deleteByMap(columnMap);
//		System.out.println(result);
		
		
		// DELETE FROM books WHERE id IN ( 27 , 28 , 29 , 30 )
//		List<Integer> ids = new ArrayList<Integer>();
//		ids.add(27);
//		ids.add(28);
//		ids.add(29);
//		ids.add(30);
//		Integer result = bookDAO.deleteBatchIds(ids);
//		System.out.println(result);
		
		// DELETE FROM books
		// WHERE id=26 AND title='һ��������ڳ�15' AND price=3.2 AND publishDate='2018-11-13 15:36:11'
		// OR (id >= 24)
		Book book = bookDAO.selectById(26);
		EntityWrapper<Book> wrapper = new EntityWrapper<Book>(book);
		Integer result = bookDAO.delete(wrapper.orNew("id >= {0}",24));
		System.out.println(result);
	}

	@Test
	public void testSelect1(){
		List<Book> list = bookDAO.getAllBooks();
		for (Book book2 : list) {
			System.out.println(book2);
		}
	}

	@Test
	public void testSelect2(){
		List<Book> list = bookDAO.findByTitle("ʱ���ʷ");
		for (Book book2 : list) {
			System.out.println(book2);
		}
	}

	@Test
	public void testDel(){
		bookDAO.delete(2);
	}

}
