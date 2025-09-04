package com.tjy.controller;

import com.tjy.pojo.*;
import com.tjy.service.ClazzService;
import com.tjy.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @date 2025/8/12 11:17
 */
@Slf4j
@SuppressWarnings("all")
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @Autowired
    private EmpService empService;

    /**
     * 分页查询--原始
     */
    /*@GetMapping
    public Result page(Integer page, Integer pageSize) {
        log.info("分页查询:{},{}", page, pageSize);
        PageResult<Clazz> pageResult = clazzService.page(page, pageSize);
        return Result.success(pageResult);
    }*/

    /**
     * 分页查询--pagehelper
     */
    @GetMapping
    public Result page(@Validated ClazzQueryParam cqp) {
        log.info("分页查询:{}", cqp);
        PageResult<Clazz> pageResult = clazzService.page(cqp);
        return Result.success(pageResult);
    }

    /**
     * 添加班级
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("添加班级:{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    /**
     * 根据 ID查询
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据 ID查询:{}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    /**
     * 修改班级
     * 请求的参数为JSON格式，需要加@RequestBody注解
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级:{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /**
     * 根据id删除班级
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除班级:{}", id);
        clazzService.deleteById(id);
        return Result.success();
    }

    /**
     * 查询所有班级
     */
    @GetMapping("/list")
    public Result getAllInfos() {
        log.info("查询所有班级");
        List<Clazz> clazzList =  clazzService.getAllInfos();
        return Result.success(clazzList);
    }
}
