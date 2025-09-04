package com.tjy.controller;

import com.tjy.pojo.OperateLog;
import com.tjy.pojo.PageResult;
import com.tjy.pojo.Result;
import com.tjy.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @version 1.0
 * @date 2025/8/15 15:32
 */
@Slf4j
@SuppressWarnings("all")
@RestController
@RequestMapping("/log/page")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 分页查询所有日志信息
     */
    @GetMapping
    public Result getLog(Integer page, Integer pageSize) {
        log.info("分页查询:{}, {}", page, pageSize);
        PageResult<OperateLog> pageResult =  logService.page(page, pageSize);
        return Result.success(pageResult);
    }
}
