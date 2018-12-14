package com.springboot.demo.mybatis.controller;

import com.springboot.demo.mybatis.entity.User;
import com.springboot.demo.mybatis.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("list")
    public String listAllUsers(){
        List<User> list = userService.listAllUsers();
        return list.toString();
    }

}
