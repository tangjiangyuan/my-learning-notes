package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @version 1.0
 * @date 2025/8/14 19:54
 * msg: 切入点表达式二 --- @annotation
 */
@Slf4j
@Aspect
@Component
public class MyAspect06 {

    @Before("execution(* com.itheima.service.*.*(..))")
    public void before(JoinPoint jp) {
        log.info("before...");
        // 1. 获取目标对象
        Object target = jp.getTarget();
        log.info("获取目标对象: {}", target);

        // 2. 获取目标类
        String className = jp.getTarget().getClass().getName();
        log.info("获取目标类: {}", className);

        // 3. 获取目标方法
        String methodName = jp.getSignature().getName();
        log.info("获取目标方法: {}", methodName);

        // 4. 获取目标方法参数
        Object[] args = jp.getArgs();
        log.info("获取目标方法参数: {}", Arrays.toString(args));
    }

    @Around("execution(* com.itheima.service.*.*(..))")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("around...before");

        Object object = pjp.proceed();

        log.info("around...after");
        return object;
    }
}
