package com.mybatisplusdemo;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mybatisplusdemo.dao.BookDAO;
import com.mybatisplusdemo.entity.Book;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 注意：
 * 1，使用数据库的字段名，而不是java类的属性名
 * 2，or orNew and andNew 无括号和有括号的语句会达到不同的效果
 */
public class ConditionTest extends BaseTest {

    @Resource
    BookDAO bookDAO;


    /**
     * 查询价格在某个区间比如10块到50块之间的书
     */
    @Test
    public void test1(){
        // SELECT id AS id,title,price,publishDate FROM books WHERE ( price > 10 and price < 50) LIMIT 0,10
        List<Book> list = new ArrayList<Book>();
        Page<Book> page = new Page<Book>(1,10);
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
         wrapper.where(" price > {0} and price < {1}",10,50);
//        wrapper.where("price between {0} and {1} ",10,50);
        list = bookDAO.selectPage(page,wrapper);
        for (Book book:list) {
            System.out.println(book);
        }
    }

    // SELECT id AS id,title,price,publishDate FROM books WHERE (price between 10 and 50 ) LIMIT 0,10
    @Test
    public void test2(){
        List<Book> list = new ArrayList<Book>();
        Page<Book> page = new Page<Book>(1,10);
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
        wrapper.where(" price between {0} and {1} ",10,50);
        list = bookDAO.selectPage(page,wrapper);
        for (Book book:list) {
            System.out.println(book);
        }
    }

    /**
     * 价格在10到100之间，名字模糊查找一本书读懂众筹
     * SELECT id AS id,title,price,publishDate FROM books WHERE ( price between 10 and 50 ) AND (title LIKE '%一本书读懂众筹%')
     */
    @Test
    public void test3(){
        List<Book> list = new ArrayList<Book>();
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
        wrapper.where(" price between {0} and {1} ",10,50);
        wrapper.andNew().like("title","一本书读懂众筹");

        list = bookDAO.selectList(wrapper);
        for (Book book:list) {
            System.out.println(book);
        }
    }

    // SELECT id AS id,title,price,publishDate FROM books WHERE ( price between 10 and 50 ) AND (title LIKE '%一本书读懂众筹%')
    // SELECT id AS id,title,price,publishDate FROM books WHERE ( price between 10 and 50 ) OR (title LIKE '%一本书读懂众筹%')
    @Test
    public void test4(){
        List<Book> list = new ArrayList<Book>();
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
        wrapper.where(" price between {0} and {1} ",10,50);
        // wrapper.andNew().like("title","一本书读懂众筹");
        wrapper.orNew().like("title","一本书读懂众筹");
        list = bookDAO.selectList(wrapper);
        for (Book book:list) {
            System.out.println(book);
        }
    }

    // SELECT id AS id,title,price,publishDate FROM books WHERE (price BETWEEN 10 AND 100) AND (title LIKE '%一本书读懂众筹%')
    @Test
    public void test5(){
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
        wrapper.between("price",10,100);
        wrapper.andNew().like("title","一本书读懂众筹");
        List<Book> list = bookDAO.selectList(wrapper);
        for (Book b:list) {
            System.out.println(b);
        }
    }

    // SELECT id AS id,title,price,publishDate FROM books WHERE (price > 10) AND (title LIKE '%一本书读懂众筹%')
    @Test
    public void test6(){
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
//        wrapper.lt("price",10);// 小于
        wrapper.gt("price",10);
        wrapper.andNew().like("title","一本书读懂众筹");
        List<Book> list = bookDAO.selectList(wrapper);
        for (Book b:list) {
            System.out.println(b);
        }
    }

    // SELECT id AS id,title,price,publishDate FROM books WHERE (title = '洛克希德马丁')
    @Test
    public void test7(){
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
        wrapper.eq("title","洛克希德马丁");
        List<Book> list = bookDAO.selectList(wrapper);
        for (Book b:list) {
            System.out.println(b);
        }
    }

    // SELECT id AS id,title,price,publishDate FROM books WHERE (title = '洛克希德马丁') OR (title = '一本书读懂众筹3')
    @Test
    public void test8(){
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
        wrapper.eq("title","洛克希德马丁");
        wrapper.orNew().eq("title","一本书读懂众筹3");
        List<Book> list = bookDAO.selectList(wrapper);
        for (Book b:list) {
            System.out.println(b);
        }
    }

    // UPDATE books SET title='苍井空', price=100.78 WHERE (id = 22)
    @Test
    public void test9(){
        Book book = new Book();
        book.setTitle("苍井空");
        book.setPrice(100.78);
        EntityWrapper<Book> wrapper = new EntityWrapper<>();
        wrapper.eq("id",22);
        Integer result = bookDAO.update(book,wrapper);
        System.out.println(result);

    }

    // DELETE FROM books WHERE (title = '洛克希德马丁') OR (title LIKE '%一本书读懂众筹%')
    @Test
    public void test10(){
        EntityWrapper<Book> wrapper = new EntityWrapper<>();
        wrapper.eq("title","洛克希德马丁");
        wrapper.orNew().like("title","一本书读懂众筹");
        Integer result = bookDAO.delete(wrapper);
        System.out.println(result);
    }

    /**
     *  用法和EntityWrapper一样，只是其实例的创建方式是用一个静态方法创建。
     */
    @Test
    public void test11(){
        List<Book> list = bookDAO.selectList(Condition.create().eq("id",1));
        for (Book book:list) {
            System.out.println(book);
        }
    }

}
