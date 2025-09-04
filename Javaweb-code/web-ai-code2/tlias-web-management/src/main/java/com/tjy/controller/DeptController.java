package com.tjy.controller;

import com.tjy.anno.Log;
import com.tjy.pojo.Dept;
import com.tjy.pojo.Result;
import com.tjy.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @date 2025/8/5 15:18
 */
@SuppressWarnings("ALL")
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    // private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /* 查询所有部门信息 */
    // @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        log.info("查询所有部门信息");
        List<Dept> list =  deptService.findAll();
        return Result.success(list);
    }

    /* 删除部门 - 方式一：HttpServletRequest 获取请求参数 */
    /*@DeleteMapping("/depts")
    public Result delete(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        System.out.println("根据id删除部门:" + id);
        return Result.success();
    }*/

    /* 删除部门 - 方式二：@RequestParam 获取请求参数 */
    // @RequestParam 获取前端传过来的值，绑定给deptId
    // 一旦声明了@RequestParam，该参数在请求时必须传递，如果不传递将会报错，（默认required 为true）
    /*@DeleteMapping("/depts")
    public Result delete(@RequestParam("id") Integer deptId) {
        deptService.deleteById(deptId);
        return Result.success();
    }*/

    /* 删除部门 - 方式三：如果请求参数名与形参变量名相同，直接定义方法形参即可接收。（省略@RequestParam） */
    @Log
    @DeleteMapping
    public Result delete(Integer id) {
        log.info("删除部门根据id:{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    /* 根据部门名称添加部门 */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("添加的部门:{}", dept);
        deptService.addByName(dept);
        return Result.success();
    }

    /* 根据id查询部门 */
    // 路径参数使用 {} 括起来
    @GetMapping("/{id}")
    public Result getInfoById(@PathVariable("id") Integer deptId) {
        log.info("根据id查询部门:{}", deptId);
        Dept dept = deptService.getInfoById(deptId);
        return Result.success(dept);
    }

    /* 修改部门信息 */
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改后的部门信息:{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
