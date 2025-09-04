package com.tjy.controller;

import com.tjy.pojo.PageResult;
import com.tjy.pojo.Result;
import com.tjy.pojo.Student;
import com.tjy.pojo.StudentQueryParam;
import com.tjy.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @date 2025/8/12 20:01
 */
@Slf4j
@SuppressWarnings("all")
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 分页查询学员信息
     */
    @GetMapping
    public Result page(StudentQueryParam sqp) {
        log.info("分页查询:{}", sqp);
        PageResult<Student> pageResult = studentService.page(sqp);
        return Result.success(pageResult);
    }

    /**
     * 添加学员
     */
    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("添加学员:{}", student);
        studentService.save(student);
        return Result.success();
    }

    /**
     * 根据ID查询学员
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据ID查询:{}", id);
        Student student = studentService.getById(id);
        return Result.success(student);
    }

    /**
     * 修改学员
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学员:{}", student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 批量删除学员
     */
    @DeleteMapping("/{ids}")
    public Result dalete(@PathVariable List<Integer> ids) {
        log.info("批量删除:{}", ids);
        studentService.deleteById(ids);
        return Result.success();
    }

    /**
     * 违纪处理
     */
    @PutMapping("/violation/{id}/{score}")
    public Result handleViolation(@PathVariable("id") Integer id, @PathVariable("score") Short score) {
        log.info("违纪处理:{}", id);
        studentService.handleViolation(id, score);
        return Result.success();
    }
}
