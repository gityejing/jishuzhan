package com.springehcache.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-base.xml","classpath:spring-ehcache.xml"})
public class Test1 {
	 
	@Resource
	private EhcacheService ehcacheService;

	@Test
	public void test() {
		ehcacheService.findById("1");
	}
}
