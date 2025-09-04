package com.tjy.service.impl;

import com.tjy.mapper.DeptMapper;
import com.tjy.pojo.Dept;
import com.tjy.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @version 1.0
 * @date 2025/8/5 15:18
 */
@SuppressWarnings("ALL")
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /* 查询所有部门信息 */
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    /* 根据id删除部门 */
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    /* 根据部门名称添加部门 */
    @Override
    public void addByName(Dept dept) {
        // 1. 补全基础属性 - create_time, update_time
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        // 2. 调用mapper接口，传入参数
        deptMapper.addByName(dept);
    }

    /* 根据id查询部门 */
    @Override
    public Dept getInfoById(Integer deptId) {
        Dept dept = deptMapper.getInfoById(deptId);
        return dept;
    }

    /* 修改部门信息 */
    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
