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
 * msg: 切入点表达式一 --- execution()
 */
@Slf4j
@Order(7)
//@Aspect
@Component
public class MyAspect05 {
    @Before("@annotation(com.itheima.anno.LogOperation)")
    public void before(){
        log.info("MyAspect4 -> before ...");
    }
}


//前置通知
    /*@Before("execution(* com.itheima.service.impl.*.delete(..)) ||" +
            "execution(* com.itheima.service.impl.DeptServiceImpl.list(..))")*/