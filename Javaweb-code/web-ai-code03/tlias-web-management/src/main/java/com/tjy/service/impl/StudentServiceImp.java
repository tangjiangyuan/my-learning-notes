package com.tjy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tjy.exception.StudentNotFoundException;
import com.tjy.mapper.StudentMapper;
import com.tjy.pojo.PageResult;
import com.tjy.pojo.Student;
import com.tjy.pojo.StudentQueryParam;
import com.tjy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @version 1.0
 * @date 2025/8/12 20:02
 */
@SuppressWarnings("all")
@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询学员信息
     */
    @Override
    public PageResult<Student> page(StudentQueryParam sqp) {
        // 1. 设置查询条件
        PageHelper.startPage(sqp.getPage(), sqp.getPageSize());
        // 2. 执行查询
        List<Student> studentList = studentMapper.page(sqp);
        Page<Student> p = (Page<Student>) studentList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    /**
     * 添加学员
     */
    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }

    /**
     * 根据ID查询学员
     */
    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    /**
     * 修改学员信息
     */
    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    /**
     * 删除学员
     */
    @Override
    public void deleteById(List<Integer> ids) {
        studentMapper.deleteById(ids);
    }

    /**
     * 违纪处理
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void handleViolation(Integer id, Short score) {
        // 1. 通过id获取学员信息
        Student student = studentMapper.getById(id);
        if (student == null) {
            throw new StudentNotFoundException("ID为:" + id + "的学员不存在");
        }

        // 2. 计算新的违纪分数和次数
        short newScore = (short) (student.getViolationScore() + score);
        short newCount = (short) (student.getViolationCount() + 1);

        // 3. 通过id直接修改学员的违纪分数和次数
        studentMapper.handleViolation(id, newCount, newScore);
    }
}
