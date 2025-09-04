package com.tjy.service;

import com.tjy.pojo.Dept;

import java.util.List;

public interface DeptService {
    /* 查询所有部门信息 */
    List<Dept> findAll();

    /* 根据id删除部门 */
    void deleteById(Integer id);

    /* 根据部门名称添加部门 */
    void addByName(Dept dept);

    /* 根据id查询部门 */
    Dept getInfoById(Integer deptId);

    /* 修改部门信息 */
    void update(Dept dept);
}
