package com.tjy.aop;

import com.alibaba.fastjson.JSON;
import com.tjy.mapper.OperateLogMapper;
import com.tjy.pojo.OperateLog;
import com.tjy.util.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@SuppressWarnings("all")
@Aspect
@Component
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    /**
     * 拦截 controller 包下所有打了 @Log 的方法
     */
    @Around("@annotation(com.tjy.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        // 目标类、方法
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        // 方法参数
        String methodParams = JSON.toJSONString(Arrays.asList(joinPoint.getArgs()));

        // 开始时间
        LocalDateTime operateTime = LocalDateTime.now();

        long start = System.currentTimeMillis();

        // 执行原方法
        Object result = joinPoint.proceed();

        // 耗时
        long costTime = System.currentTimeMillis() - start;

        // 返回值
        String returnValue = JSON.toJSONString(result);

        // 封装实体
        OperateLog opLog = new OperateLog();
        opLog.setOperateEmpId(getCurrentUserId());
        opLog.setOperateTime(operateTime);
        opLog.setClassName(className);
        opLog.setMethodName(methodName);
        opLog.setMethodParams(methodParams.length() > 2000 ? methodParams.substring(0, 2000) : methodParams);
        opLog.setReturnValue(returnValue.length() > 2000 ? returnValue.substring(0, 2000) : returnValue);
        opLog.setCostTime(costTime);

        // 入库
        log.info("记录操作日志: {}", opLog);
        operateLogMapper.insert(opLog);

        return result;
    }

    /**
     * 获取当前登录用户的id
     */
    public Integer getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }
}