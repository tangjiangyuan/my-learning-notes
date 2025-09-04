package com.tjy.config;

import com.tjy.interceptor.TokenInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @version 1.0
 * @date 2025/8/14 14:39
 * @msg 令牌拦截器配置类
 */
@Slf4j
@SuppressWarnings("all")
//@Configuration
public class TokenConfig implements WebMvcConfigurer {

//    @Autowired
//    private TokenInterceptor tokenInterceptor;

    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**") // 拦截所有请求
                .excludePathPatterns("/login"); // 登录接口不拦截
    }*/
}
