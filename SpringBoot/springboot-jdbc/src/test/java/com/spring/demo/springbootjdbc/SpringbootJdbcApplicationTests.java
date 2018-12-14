package com.spring.demo.springbootjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJdbcApplicationTests {

    @Resource
    DataSource dataSource;

    @Resource
    JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() throws SQLException {
//        System.out.println(dataSource.getClass()); // class com.zaxxer.hikari.HikariDataSource
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);
//        connection.close();
         System.out.println(jdbcTemplate);
    }

}
