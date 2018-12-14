package com.springboot.demo.mybatis;

import com.springboot.demo.mybatis.entity.User;
import com.springboot.demo.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

    @Resource
    UserService userService;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("yeping");
        userService.insert(user );
    }

}
