package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @date 2025/8/14 19:03
 * msg: 通知顺序
 */
@Slf4j
@Order(7)
//@Aspect
@Component
public class MyAspect04 {
    //前置通知
    @Before("execution(* com.itheima.service.impl.*.*(..))")
    public void before(){
        log.info("MyAspect4 -> before ...");
    }

    //后置通知
    @After("execution(* com.itheima.service.impl..*(..))")
    public void after(){
        log.info("MyAspect4 -> after ...");
    }
}
