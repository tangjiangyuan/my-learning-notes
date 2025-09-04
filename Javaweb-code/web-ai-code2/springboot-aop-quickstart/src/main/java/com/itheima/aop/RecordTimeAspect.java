package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @date 2025/8/14 16:36
 */
@Slf4j
//@Aspect // 表示当前类是一个切面类
@Component
public class RecordTimeAspect {

    @Around("execution(* com.itheima.service.impl.*.*(..))") // 范围为 service.impl包下的所有的类和方法
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        // 1. 记录方法执行的开始时间
        long begin = System.currentTimeMillis();

        // 2. 执行原方法
        Object object = pjp.proceed();

        // 3. 记录方法执行的结束时间，并计算耗时
        long end = System.currentTimeMillis();
        log.info("方法:{},耗时:{}ms", pjp.getSignature(), end - begin);

        return object;
    }
}
