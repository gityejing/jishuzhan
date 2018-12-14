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
 * ע�⣺
 * 1��ʹ�����ݿ���ֶ�����������java���������
 * 2��or orNew and andNew �����ź������ŵ�����ﵽ��ͬ��Ч��
 */
public class ConditionTest extends BaseTest {

    @Resource
    BookDAO bookDAO;


    /**
     * ��ѯ�۸���ĳ���������10�鵽50��֮�����
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
     * �۸���10��100֮�䣬����ģ������һ��������ڳ�
     * SELECT id AS id,title,price,publishDate FROM books WHERE ( price between 10 and 50 ) AND (title LIKE '%һ��������ڳ�%')
     */
    @Test
    public void test3(){
        List<Book> list = new ArrayList<Book>();
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
        wrapper.where(" price between {0} and {1} ",10,50);
        wrapper.andNew().like("title","һ��������ڳ�");

        list = bookDAO.selectList(wrapper);
        for (Book book:list) {
            System.out.println(book);
        }
    }

    // SELECT id AS id,title,price,publishDate FROM books WHERE ( price between 10 and 50 ) AND (title LIKE '%һ��������ڳ�%')
    // SELECT id AS id,title,price,publishDate FROM books WHERE ( price between 10 and 50 ) OR (title LIKE '%һ��������ڳ�%')
    @Test
    public void test4(){
        List<Book> list = new ArrayList<Book>();
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
        wrapper.where(" price between {0} and {1} ",10,50);
        // wrapper.andNew().like("title","һ��������ڳ�");
        wrapper.orNew().like("title","һ��������ڳ�");
        list = bookDAO.selectList(wrapper);
        for (Book book:list) {
            System.out.println(book);
        }
    }

    // SELECT id AS id,title,price,publishDate FROM books WHERE (price BETWEEN 10 AND 100) AND (title LIKE '%һ��������ڳ�%')
    @Test
    public void test5(){
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
        wrapper.between("price",10,100);
        wrapper.andNew().like("title","һ��������ڳ�");
        List<Book> list = bookDAO.selectList(wrapper);
        for (Book b:list) {
            System.out.println(b);
        }
    }

    // SELECT id AS id,title,price,publishDate FROM books WHERE (price > 10) AND (title LIKE '%һ��������ڳ�%')
    @Test
    public void test6(){
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
//        wrapper.lt("price",10);// С��
        wrapper.gt("price",10);
        wrapper.andNew().like("title","һ��������ڳ�");
        List<Book> list = bookDAO.selectList(wrapper);
        for (Book b:list) {
            System.out.println(b);
        }
    }

    // SELECT id AS id,title,price,publishDate FROM books WHERE (title = '���ϣ����')
    @Test
    public void test7(){
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
        wrapper.eq("title","���ϣ����");
        List<Book> list = bookDAO.selectList(wrapper);
        for (Book b:list) {
            System.out.println(b);
        }
    }

    // SELECT id AS id,title,price,publishDate FROM books WHERE (title = '���ϣ����') OR (title = 'һ��������ڳ�3')
    @Test
    public void test8(){
        EntityWrapper<Book> wrapper = new EntityWrapper<Book>();
        wrapper.eq("title","���ϣ����");
        wrapper.orNew().eq("title","һ��������ڳ�3");
        List<Book> list = bookDAO.selectList(wrapper);
        for (Book b:list) {
            System.out.println(b);
        }
    }

    // UPDATE books SET title='�Ծ���', price=100.78 WHERE (id = 22)
    @Test
    public void test9(){
        Book book = new Book();
        book.setTitle("�Ծ���");
        book.setPrice(100.78);
        EntityWrapper<Book> wrapper = new EntityWrapper<>();
        wrapper.eq("id",22);
        Integer result = bookDAO.update(book,wrapper);
        System.out.println(result);

    }

    // DELETE FROM books WHERE (title = '���ϣ����') OR (title LIKE '%һ��������ڳ�%')
    @Test
    public void test10(){
        EntityWrapper<Book> wrapper = new EntityWrapper<>();
        wrapper.eq("title","���ϣ����");
        wrapper.orNew().like("title","һ��������ڳ�");
        Integer result = bookDAO.delete(wrapper);
        System.out.println(result);
    }

    /**
     *  �÷���EntityWrapperһ����ֻ����ʵ���Ĵ�����ʽ����һ����̬����������
     */
    @Test
    public void test11(){
        List<Book> list = bookDAO.selectList(Condition.create().eq("id",1));
        for (Book book:list) {
            System.out.println(book);
        }
    }

}
