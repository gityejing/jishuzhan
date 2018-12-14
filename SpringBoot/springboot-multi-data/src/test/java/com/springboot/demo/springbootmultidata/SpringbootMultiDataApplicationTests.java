package com.springboot.demo.springbootmultidata;

import com.springboot.demo.springbootmultidata.entity.Book;
import com.springboot.demo.springbootmultidata.test1.BookMapperTest1;
import com.springboot.demo.springbootmultidata.test2.BookMapperTest2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMultiDataApplicationTests {

    @Resource
    BookMapperTest1 bookMapperTest1;
    @Resource
    BookMapperTest2 bookMapperTest2;

    @Test
    public void contextLoads() {


    }

    @Test
    public void test1(){
        bookMapperTest1.insertBook("上下五千年",40);
    }

    @Test
    public void test2(){
        bookMapperTest2.insertBook("激荡三十年",50);
    }

}
