package com.tjy.service;

import com.tjy.pojo.PageResult;
import com.tjy.pojo.Student;
import com.tjy.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {

    /**
     * 分页查询学员信息
     */
    PageResult<Student> page(StudentQueryParam sqp);

    /**
     * 添加学员
     */
    void save(Student student);

    /**
     * 根据ID查询学员
     */
    Student getById(Integer id);

    /**
     * 修改学员
     */
    void update(Student student);

    /**
     * 删除学员
     */
    void deleteById(List<Integer> ids);

    /**
     * 违纪处理
     */
    void handleViolation(Integer id, Short score);
}
