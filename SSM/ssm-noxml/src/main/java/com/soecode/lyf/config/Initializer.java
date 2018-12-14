package com.soecode.lyf.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
	
    @Override
    public Filter[] getServletFilters() {
    	CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		return new Filter[] {characterEncodingFilter};
    }
}
