package com.tjy.service;

import com.tjy.pojo.Clazz;
import com.tjy.pojo.ClazzQueryParam;
import com.tjy.pojo.PageResult;

import java.util.List;


public interface ClazzService {

    /**
     * 分页查询班级信息
     */
    /*PageResult<Clazz> page(Integer page, Integer pageSize);*/

    /**
     * 分页查询--PageHelper
     */
    PageResult<Clazz> page(ClazzQueryParam cqp);


    /**
     * 添加班级
     */
    void save(Clazz clazz);

    /**
     * 根据 ID查询
     */
    Clazz getById(Integer id);

    /**
     * 修改班级
     */
    void update(Clazz clazz);

    /**
     * 删除班级
     */
    void deleteById(Integer id);

    /**
     * 查询所有班级
     */
    List<Clazz> getAllInfos();
}
