package com.springboot.demo.springbootcache.dao;

import com.springboot.demo.springbootcache.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
