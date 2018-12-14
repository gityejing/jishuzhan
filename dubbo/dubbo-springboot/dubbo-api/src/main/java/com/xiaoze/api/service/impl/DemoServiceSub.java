package com.xiaoze.api.service.impl;

import com.xiaoze.api.service.DemoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 本地存根的实现，注意这里有一个构造方法，这个是必须的。
 * 构造方法由dubbo框架调用，会注入服务端的代理对象。
 * 通常情况下，本地存根放在api接口模块中
 */
public class DemoServiceSub implements DemoService {

    private final DemoService demoService;

    public DemoServiceSub(DemoService demoService){
        super();
        this.demoService = demoService;
    }

    @Override
    public String sayHello(String name) {

        System.out.println(" 做一些前期的处理");
        if(!StringUtils.isEmpty(name)){

            // 然后在利用代理对象调用服务提供方的实现
            return demoService.sayHello(name);
        }else{
            return "";
        }

    }
}
