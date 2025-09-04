package com.tjy.controller;

import com.tjy.pojo.Emp;
import com.tjy.pojo.EmpQueryParam;
import com.tjy.pojo.PageResult;
import com.tjy.pojo.Result;
import com.tjy.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @version 1.0
 * @date 2025/8/7 9:22
 */
@Slf4j
@SuppressWarnings("ALL")
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     *  分页查询
     */
    /*
    * @RequestParam : 设置参数默认值
    * @DateTimeFormat : 设置前端传来的日期类型格式 */
    @GetMapping
    public Result page(EmpQueryParam eqp) {
        log.info("分页查询:{}", eqp);
        PageResult<Emp> pageResult =  empService.page(eqp);
        return Result.success(pageResult);
    }

    /**
     * 新增员工
     * @RequestBody 可以接收传来的对象参数
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工:{}", emp);
        empService.save(emp);
        return Result.success();
    }

    /**
     * 根据员工id批量删除 --- 数组
     */
    /*@DeleteMapping
    public Result delete(Integer[] ids) {
        log.info("批量删除员工:{}", Arrays.toString(ids));
        // empService.delete(ids);
        return Result.success();
    }*/

    /**
     * 根据员工id批量删除 --- 集合
     */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("批量删除员工:{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 数据回显 --- 根据id
     * @PathVariable 将路径参数与形参进行绑定
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("数据回显员工id:{}", id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    /**
     * 修改员工信息
     * @RequestBody : JSON格式的数据要封装到对象中，需要该注解
     */
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工信息:{}", emp);
        empService.update(emp);
        return Result.success();
    }

    /**
     * 查询全部员工
     */
    @GetMapping("/list")
    public Result getEmpList() {
        log.info("查询全部员工");
        List<Emp> list = empService.getEmpList();
        return Result.success(list);
    }
}
