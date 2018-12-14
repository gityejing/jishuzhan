package com.springboot.demo.springbootcache;


import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 *
 * 整合好redis后，自动配置，提供了StringRedisTemplate和RedisTemplate两个类，方便开发
 *
 */
public class RedisTest extends SpringbootCacheApplicationTests {


    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    RedisTemplate redisTemplate;

    @Test
    public void test1(){
        ValueOperations vo = stringRedisTemplate.opsForValue();
        vo.set("kkk","jjj");

    }
}
