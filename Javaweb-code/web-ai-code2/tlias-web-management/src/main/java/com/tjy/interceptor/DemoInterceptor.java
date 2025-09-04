package com.tjy.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 1.0
 * @date 2025/8/14 14:11
 * msg: 拦截器
 */
@Slf4j
@SuppressWarnings("all")
//@Component // 因为HandlerInterceptor是Spring中的接口，所以要添加到spring容器中
public class DemoInterceptor implements HandlerInterceptor {

    // 目标资源方法执行之前执行 - 返回值为true放行，为false拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle ...");
        return true;
    }

    // 目标资源方法执行之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle ...");
    }

    // 试图渲染之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion ...");
    }
}
