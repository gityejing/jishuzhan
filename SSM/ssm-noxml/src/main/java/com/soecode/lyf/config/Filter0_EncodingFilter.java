package com.soecode.lyf.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 放在所有的过滤器前面，中文乱码才可以解决 ，
 * 如何设置filter的顺序，
 * 通过实践发现如果想要控制filer的执行顺序， 
 * 可以通过控制filter的文件名来控制，
 * 比如：Filter0_UserLogin.java，Filter1_ApiLog.java
 * 
 * @author 30000133
 *
 */
@WebFilter(filterName = "Filter0_EncodingFilter", urlPatterns = "/*")
public class Filter0_EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化Filter0_EncodingFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("过滤器销毁Filter0_EncodingFilter");
	}

}
