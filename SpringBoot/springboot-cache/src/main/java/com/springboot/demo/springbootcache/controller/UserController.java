package com.springboot.demo.springbootcache.controller;

import com.springboot.demo.springbootcache.entity.User;
import com.springboot.demo.springbootcache.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {

    @Resource
    public UserService userService;

    @GetMapping("findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/findById/{id}")
    public User findById(@PathVariable("id") Integer id){
        System.out.println("访问。。。");
        return userService.findById(id);
    }
}
