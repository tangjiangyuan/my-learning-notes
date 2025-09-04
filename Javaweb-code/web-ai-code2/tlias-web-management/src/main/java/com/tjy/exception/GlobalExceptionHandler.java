package com.tjy.exception;

import com.tjy.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @version 1.0
 * @date 2025/8/11 16:44
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Result exceptionHandler(Exception e) {
        log.error("出错了~",  e);
        return Result.error("对不起，服务异常，请稍后再试~");
    }

    /**
     * 全局异常处理器: 处理异常的机制的优先级: 先从当前异常出发，如果当前异常不能捕获，则继续抛给上级
     */
    @ExceptionHandler
    public Result handleDuplicateKey(DuplicateKeyException e) {
        /* 字段值重复异常 */
        log.error("出错了~",  e);
        // : Duplicate entry '19109091234' for key 'emp.phone'
        String msg = e.getMessage();
        int i = msg.indexOf("Duplicate entry");
        String errMsg = msg.substring(i);
        String[] errArr = errMsg.split(" ");

        return Result.error(errArr[2] + "已存在！");
    }

    @ExceptionHandler
    public Result handleDoNotDelete(DoNotDeleteException e) {
        log.error("出错了~",  e);
        return Result.error(e.getMessage());
    }

    /**
     * StudentNotFoundException
     */
    @ExceptionHandler
    public Result handleStudentNotFound(StudentNotFoundException e) {
        log.error("该学员不存在~",  e);
        return Result.error(e.getMessage());
    }
}
