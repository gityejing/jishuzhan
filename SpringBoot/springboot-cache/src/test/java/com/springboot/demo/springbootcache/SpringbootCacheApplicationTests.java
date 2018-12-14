package com.springboot.demo.springbootcache;

import com.springboot.demo.springbootcache.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

    @Resource
    UserService userService;

    @Test
    public void contextLoads() {
        userService.findAll();
        userService.findAll();
    }

}
