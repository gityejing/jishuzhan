package com.springboot.demo.springbootmultidata.test2;
import com.springboot.demo.springbootmultidata.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BookMapperTest2 {

    @Select("select * from book where bookname=#{bookname}")
    public Book findByName(@Param("bookname") String bookname);

    @Insert("insert into book(bookname,bookprice) values (#{bookname},#{bookprice})")
    public int insertBook(@Param("bookname") String bookname, @Param("bookprice") Integer bookprice);
}