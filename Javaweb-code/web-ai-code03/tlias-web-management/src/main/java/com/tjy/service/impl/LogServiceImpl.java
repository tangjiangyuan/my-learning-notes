package com.tjy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tjy.mapper.LogMapper;
import com.tjy.pojo.OperateLog;
import com.tjy.pojo.PageResult;
import com.tjy.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @date 2025/8/15 16:05
 */
@SuppressWarnings("all")
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 分页查询所有日志信息
     */
    @Override
    public PageResult<OperateLog> page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<OperateLog> logList =  logMapper.list();
        Page<OperateLog> p = (Page<OperateLog>) logList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
