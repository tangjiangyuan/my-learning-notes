package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @date 2025/8/14 17:30
 * msg: 5种通知类型
 */
@Slf4j
//@Aspect
@Component
public class MyAspect01 {

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    public void pc(){}

    // 前置通知 - 目标方法执行之前执行
    @Before("pc()")
    public void before() {
        log.info("before...");
    }

    // 环绕通知 - 目标方法执行之前、之后都会执行
    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("around...before...");
        Object object =  pjp.proceed();
        log.info("around...after");
        return object;
    }

    // 后置通知 - 目标方法执行之后执行; 无论是否出现异常，都会执行
    @After("pc()")
    public void after() {
        log.info("after...");
        log.info("after...exception...");
    }

    // 返回后通知 - 目标方法执行之后执行; 如果出现异常 不会 执行
    @AfterReturning("pc()")
    public void afterReturning() {
        log.info("afterReturning...");
    }

    // 抛出异常后通知 - 目标方法执行之后执行; 只有出现异常才会执行
    @AfterThrowing("pc()")
    public void afterThrowing() {
        log.info("afterThrowing...");
    }
}
