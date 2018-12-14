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
 * 主要用来测试BaseMapper提供的基本的crud操作，
 * 和简单的条件构造器的使用
 */
public class DaoplusTest extends BaseTest{

	
	@Resource
	BookDAO bookDAO;
	
	@Test
	public void testSave() {
		Book entity = new Book();
		entity.setPrice(3.2);
		entity.setPublishDate(new Date());
		entity.setTitle("一本书读懂众筹");
		bookDAO.insert(entity);
	}
	
	@Test
	public void testSaveAll() {
		for (int i = 11; i < 20; i++) {
			Book entity = new Book();
			entity.setPrice(3.2);
			entity.setPublishDate(new Date());
			entity.setTitle("一本书读懂众筹"+i);
			bookDAO.insert(entity);
		}
	}
	
	
	/**
	 * UPDATE books SET title='小泽玛利亚',price=0.0,publishDate=null WHERE id=13
	 * 未设置值得字段，更新为了null和默认值
	 */
	@Test
	public void testUpdate1() {
		Book entity = new Book();
		entity.setId(13);
		entity.setTitle("小泽玛利亚");
		bookDAO.updateById(entity);
		Book book = bookDAO.selectOne(entity);
		System.out.println(book);
	}
	
	/**
	 * update books set title='洛克希德',price=0.0,publishDate=null where id=13
	 * 同上，也是将未设置值得字段设置成了null和默认值
	 */
	@Test
	public void testUpdate2() {
		Book entity = new Book();
		entity.setId(13);
		entity.setTitle("洛克希德");
		bookDAO.update(entity);
		Book book = bookDAO.selectOne(entity);
		System.out.println(book);
	}
	
	/**
	 * UPDATE books SET title='洛克希德马丁',price=0.0,publishDate=null WHERE id=13
	 */
	@Test
	public void testUpdate3() {
		Book entity = new Book();
		entity.setId(13);
		entity.setTitle("洛克希德马丁");
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
		// 自动的加where
		condition.addFilter(" id > {0} ", 3);
		// 多个条件不用写and
		condition.like("title", "一本书读懂众筹");
//		list = bookDAO.selectList(condition);
//		for (Book book2 : list) {
//			System.out.println(book2);
//		}
		
//		RowBounds 分页查询条件，用其具体的子类就可以了。通常用page
		Page<Book> page = new Page<Book>();
		page.setCurrent(1);
		page.setSize(4);
		
		list = bookDAO.selectPage(page, condition);
		for (Book book2 : list) {
			System.out.println(book2);
		}
		System.out.println(page.getTotal());// 有值
		System.out.println(page.getRecords().size());// 无值
		
		System.out.println("==========================================================");
		list = bookDAO.selectPage(new Page<Book>(2,4), condition);
		for (Book book2 : list) {
			System.out.println(book2);
		}
//		System.out.println(list);
	}
	
	/**
	 * 在没有使用到分页插件的时候，这里的分页效果并不是很好，在使用到了分页插件之后，才是真正的物理分页
	 */
	@Test
	public void testSelectPage() {
		Condition condition = Condition.create();
		condition.addFilter(" id > {0} ", 3); // 自动的加where
		condition.like("title", "一本书读懂众筹"); // 多个条件不用写and
//		RowBounds 分页查询条件，用其具体的子类就可以了。通常用page
		Page<Book> page = new Page<Book>();
		page.setCurrent(1);
		page.setSize(4);
		
		List<Book> list = bookDAO.selectPage(page, condition);
		for (Book book2 : list) {
			System.out.println(book2);
		}
		System.out.println(page.getTotal());// 有值
		System.out.println(page.getRecords().size());// 无值
		
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
		// WHERE id=26 AND title='一本书读懂众筹15' AND price=3.2 AND publishDate='2018-11-13 15:36:11'
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
		List<Book> list = bookDAO.findByTitle("时间简史");
		for (Book book2 : list) {
			System.out.println(book2);
		}
	}

	@Test
	public void testDel(){
		bookDAO.delete(2);
	}

}
