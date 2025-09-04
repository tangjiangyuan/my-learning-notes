package com.tjy.service;

import com.tjy.pojo.OperateLog;
import com.tjy.pojo.PageResult;

import java.util.List;

public interface LogService {
    /**
     * 分页查询所有日志信息
     */
    PageResult<OperateLog> page(Integer page, Integer pageSize);
}
