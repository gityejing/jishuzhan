package com.springboot.demo.springbootjpa.dao;

import com.springboot.demo.springbootjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
