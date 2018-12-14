package com.springboot.demo.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.springboot.demo.mybatis.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


//@Mapper
public interface UserDao {

    int insert(@Param("pojo") User pojo);

    int insertList(@Param("pojos") List< User> pojo);

    List<User> select(@Param("pojo") User pojo);

    int update(@Param("pojo") User pojo);

    @Select(" select * from user ")
    List<User> findAll();

}
