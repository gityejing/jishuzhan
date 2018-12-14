package com.mybatisplusdemo;

import com.mybatisplusdemo.dao.BookDAO;
import com.mybatisplusdemo.entity.Book;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

public class ARTest extends BaseTest {

    @Resource
    BookDAO bookDAO;

    /**
     * 插入
     */
    @Test
    public void testInsert(){
        Book book = new Book();
        book.setTitle("未来简史");
        book.setPrice(34.8);
        book.setPublishDate(new Date());
        book.insert();
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(2);
        book.setTitle("人类简史");
        book.updateById();
    }

    @Test
    public void testDelete(){
        new Book(8).deleteById();
    }


}
