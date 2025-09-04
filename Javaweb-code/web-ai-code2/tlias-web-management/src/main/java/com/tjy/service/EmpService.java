package com.tjy.service;

import com.tjy.pojo.Emp;
import com.tjy.pojo.EmpQueryParam;
import com.tjy.pojo.LoginInfo;
import com.tjy.pojo.PageResult;

import java.util.List;

public interface EmpService {

    /**
     * 分页查询
     */
    PageResult<Emp> page(EmpQueryParam eqp);

    /**
     * 新增员工
     */
    void save(Emp emp);

    /**
     * 根据id批量删除员工
     */
    void delete(List<Integer> ids);

    /**
     * 根据id查询员工数据
     */
    Emp getInfo(Integer id);

    /**
     * 修改员工信息
     */
    void update(Emp emp);

    /**
     * 查询全部员工
     */
    List<Emp> getEmpList();

    /**
     * 登录功能
     */
    LoginInfo login(Emp emp);
}
