package com.atguigu.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CtlMethodHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, 
    		HttpServletResponse response, 
    		Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler;

            System.out.println("类："+hm.getBeanType());
            System.out.println("方法："+hm.getMethod().getName());
            System.out.println("方法上的注解："+hm.getMethodAnnotation(RequestMapping.class).value());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, 
    		HttpServletResponse response, 
    		Object handler, 
    		ModelAndView modelAndView) throws Exception {
        if(modelAndView != null) {
        	System.out.println("逻辑视图："+modelAndView.getViewName());
        }
    	/*System.out.println("逻辑视图："+modelAndView.getViewName());
        System.out.println("模型数据"+modelAndView.getModel().entrySet());*/
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
