package com.mybatisplusdemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mybatisplusdemo.entity.Book;


/**
 * ͼ�����ݷ��ʽӿ�
 */
public interface BookDAO extends BaseMapper<Book>{
    /**
     * �������ͼ��
     */
    public List<Book> getAllBooks();
    /**
     * ����ͼ���Ż��ͼ�����
     */
    public Book getBookById(@Param("id") int id);

    /**
     * ���ͼ��
     */
    public int add(Book entity);
    /**
     * ����ͼ����ɾ��ͼ��
     */
    public int delete(int id);
    /**
     * ����ͼ��
     */
    public int update(Book entity);

    public List<Book> findByTitle(@Param("title")  String title);
}