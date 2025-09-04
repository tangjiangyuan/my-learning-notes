package com.tjy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tjy.mapper.ClazzMapper;
import com.tjy.mapper.EmpMapper;
import com.tjy.pojo.Clazz;
import com.tjy.pojo.ClazzQueryParam;
import com.tjy.pojo.PageResult;
import com.tjy.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @version 1.0
 * @date 2025/8/12 11:20
 */
@SuppressWarnings("all")
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private EmpMapper empMapper;

    /**
     * 分页查询班级信息
     */
    /*@Override
    public PageResult<Clazz> page(Integer page, Integer pageSize) {
        // 1. 调用mapper接口，查询总记录数
        Long total = clazzMapper.count();
        // 2. 调用mapper接口，获取数据列表
        Integer start = (page - 1) * pageSize;
        List<Clazz> rows = clazzMapper.list(start, pageSize);
        // 设置课程状态
        for (Clazz clazz : rows) {
            if (LocalDate.now().isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结课");
            } else if (LocalDate.now().isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开班");
            } else {
                clazz.setStatus("在读中");
            }
        }
        // 3. 封装为 PageResult对象
        return new PageResult<>(total, rows);
    }*/

    /**
     * 分页查询--PageHelper
     */
    @Override
    public PageResult<Clazz> page(ClazzQueryParam cqp) {
        // 1. 设置查询条件
        PageHelper.startPage(cqp.getPage(), cqp.getPageSize());
        // 2. 执行查询
        List<Clazz> clazzList = clazzMapper.list(cqp);
        // 设置班级状态
        for (Clazz clazz : clazzList) {
            if (LocalDate.now().isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开课");
            } else if (LocalDate.now().isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结课");
            } else {
                clazz.setStatus("在读中");
            }
        }
        // 3. 解析查询结果，并封装
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    /**
     * 添加班级
     */
    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    /**
     * 根据 ID查询
     */
    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    /**
     * 修改班级
     */
    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);
    }

    /**
     * 删除班级
     */
    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    /**
     * 查询所有班级
     */
    @Override
    public List<Clazz> getAllInfos() {
        List<Clazz> clazzList = clazzMapper.getAllInfos();
        for (Clazz clazz : clazzList) {
            if (LocalDate.now().isAfter(clazz.getEndDate())) {
                clazz.setStatus("已结课");
            } else if (LocalDate.now().isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开课");
            } else {
                clazz.setStatus("在读中");
            }
        }
        return clazzList;
    }
}
