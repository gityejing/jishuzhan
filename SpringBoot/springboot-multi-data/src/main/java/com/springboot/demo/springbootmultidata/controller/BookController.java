package com.springboot.demo.springbootmultidata.controller;

import com.springboot.demo.springbootmultidata.test1.BookMapperTest1;
import com.springboot.demo.springbootmultidata.test2.BookMapperTest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookMapperTest1 bookMapperTest1;

    @Autowired
    private BookMapperTest2 bookMapperTest2;

    @RequestMapping("insert001")
    public String insert001(String bookname,Integer bookprice){
        bookMapperTest1.insertBook(bookname,bookprice);
        return "success";
    }

    @RequestMapping("insert002")
    public String insert002(String bookname,Integer bookprice){
        bookMapperTest2.insertBook(bookname,bookprice);
        return "success";
    }
}