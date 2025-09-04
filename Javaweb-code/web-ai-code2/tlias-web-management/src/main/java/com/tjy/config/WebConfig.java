package com.tjy.config;

import com.tjy.interceptor.DemoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @version 1.0
 * @date 2025/8/14 14:18
 * msg: 配置类 --- 用来添加拦截器
 */
@SuppressWarnings("all")
//@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 注入DemoInterceptor
     */
//    @Autowired
//    private DemoInterceptor demoInterceptor;

    /**
     * 添加拦截器
     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // registry.addInterceptor(demoInterceptor).addPathPatterns("/**"); // 拦截所有路径
//    }
}
