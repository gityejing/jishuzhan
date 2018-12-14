package com.springboot.demo.springbootjpa;

import com.springboot.demo.springbootjpa.dao.UserRepository;
import com.springboot.demo.springbootjpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {

    @Resource
    UserRepository userRepository;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("yeping");
        userRepository.save(user);
    }

    @Test
    public void testGet(){
       List<User> users = userRepository.findAll();
       System.out.println(users);
    }
}
