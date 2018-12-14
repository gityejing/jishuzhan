package com.spring.demo.springbootjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Resource
    JdbcTemplate jdbcTemplate;

    @RequestMapping("query")
    @ResponseBody
    public String query(){
        List<Map<String, Object>> map =  jdbcTemplate.queryForList("select * from user");
        return map.toString();
    }
}
