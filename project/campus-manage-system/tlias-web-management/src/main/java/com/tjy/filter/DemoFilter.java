package com.tjy.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @version 1.0
 * @date 2025/8/14 9:46
 */
@Slf4j
//@WebFilter(urlPatterns = "/*") // 拦截所有请求
public class DemoFilter implements Filter {

    // 初始化过滤器，web服务器启动的时候执行，只执行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 初始化过滤器...");
    }

    // 过滤器核心方法，拦截到请求之后执行，每次请求都会执行
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截到了请求... 放行前...");
        // 放行，让请求继续往下执行，如果不写，请求会被拦截

        filterChain.doFilter(servletRequest, servletResponse);

        log.info("拦截到了请求... 放行后...");
    }

    // 销毁过滤器，web服务器关闭的时候执行，只执行一次
    @Override
    public void destroy() {
        log.info("destroy 销毁过滤器...");
    }
}
