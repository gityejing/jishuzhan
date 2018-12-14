package com.springboot.demo.springbootcache.service;

import com.springboot.demo.springbootcache.dao.UserRepository;
import com.springboot.demo.springbootcache.entity.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class UserService {

    @Resource
    public UserRepository userRepository;

    @Cacheable(cacheNames = {"user"})
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Cacheable(cacheNames = {"user"},keyGenerator = "keyGenerator")
    public User findById(Integer id){
        System.out.println("查询数据库");
        return userRepository.findById(id).get();
    }

    @CachePut(cacheNames = {"user"},keyGenerator = "keyGenerator")
    public User update(User user){

        return user;
    }

}
