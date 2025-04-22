package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init初始化方法执行力");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截到了请求");
        System.out.println("放行前的逻辑");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("放行后的逻辑");
    }

    @Override
    public void destroy() {
        System.out.println("destroy销毁方法执行力");
    }
}
