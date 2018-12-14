package com.springboot.demo.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * restful 风格
 */
@RestController
public class HelloController {


    @GetMapping("sayHi")
    public String sayHi(){
        return "hello world";
    }

}
