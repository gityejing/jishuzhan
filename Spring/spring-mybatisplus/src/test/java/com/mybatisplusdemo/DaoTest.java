package com.mybatisplusdemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.mybatisplusdemo.entity.Book;
import com.mybatisplusdemo.service.BookService;

public class DaoTest extends BaseTest {

	@Resource
	private BookService bookservice;

	@Test
	public void testGetAllBooks() {
		List<Book> books = bookservice.getAllBooks();
		System.out.println(books.size());
		assertNotNull(books);
	}

	@Test
	public void testAdd() {
		Book entity = new Book(8, "Hibernate 第5版", 78.1, new Date());
		try {
			assertEquals(1, bookservice.add(entity));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteInt() {
		assertEquals(1, bookservice.delete(9));
	}

	@Test
	public void testDeleteStringArray() {
		String[] ids = { "7", "11", "12" };
		assertEquals(3, bookservice.delete(ids));
	}

	@Test
	public void testUpdate() {
		Book entity = new Book(7, "Hibernate 第二版", 79.1, new Date());
		try {
			assertEquals(1, bookservice.update(entity));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetBookById() {
		assertNotNull(bookservice.getBookById(1));
	}

	@Test
	public void testAddDouble() {
		// 因为书名相同，添加第二本会失败，用于测试事务
		Book entity1 = new Book(0, "Hibernate 第八版", 78.1, new Date());
		Book entity2 = new Book(0, "Hibernate 第八版", 78.1, new Date());
		assertEquals(2, bookservice.add(entity1, entity2));
	}
}
