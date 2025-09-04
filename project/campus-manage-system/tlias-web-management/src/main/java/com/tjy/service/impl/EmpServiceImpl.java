package com.tjy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tjy.mapper.EmpExprMapper;
import com.tjy.mapper.EmpMapper;
import com.tjy.pojo.*;
import com.tjy.service.EmpLogService;
import com.tjy.service.EmpService;
import com.tjy.util.JwtUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @version 1.0
 * @date 2025/8/7 9:23
 */
@Slf4j
@Service
@SuppressWarnings("ALL")
public class EmpServiceImpl implements EmpService {

    /*补充:ctrl+i:添加需要重写方法*/

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    /* 原始分页查询 */
    /*@Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        // 1. 调用 mapper接口，查询总记录数
        Long total = empMapper.count();
        // 2. 调用 mapper 接口，获取数据列表
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);
        // 3. 封装为PageResult 对象
        return new PageResult<Emp>(total, rows);
    }*/

    /**
     * pegehelper 分页查询
     * @param page 开始页
     * @param pageSize 每页展示的数量
     * 注意事项：
     *     1. 在使用pagehelper 时，sql语句不能加分号。否则会导致 sql语法错误异常。
     *                 原因：在pagehelper改造sql语句添加分页时，会自动添加limit关键字，而加了分号，会导致limit在分号后面，出现语法错误。
     *     2. PageHelper 仅仅能对紧跟在其后面的第一个查询语句进行分页处理。
     */
    @Override
    public PageResult<Emp> page(EmpQueryParam eqp) {
        // 1. 设置查询条件
        PageHelper.startPage(eqp.getPage(), eqp.getPageSize());
        // 2. 执行查询
        List<Emp> empList = empMapper.list(eqp); // empList 实际类型就是 Page
        // 3. 解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) empList; // p中可以获得 总记录数和 结果封装的集合
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    /**
     * 新增员工
     */
    @Transactional(rollbackFor = {Exception.class}) // 事务管理 - 所有异常都会进行回滚操作
    @Override
    public void save(Emp emp) {
        try {
            // 1. 新增员工基本信息 -- 前端不会转递创建时间和修改时间
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            // 2. 新增员工的工作经历
            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList) && emp.getId() != null){
                //遍历集合, 为empId赋值
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            // 记录操作日志 注入EmpLogService -> 调用 insertLog()
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增员工:" + emp);
            empLogService.insertLog(empLog);
        }
    }

    /**
     * 根据id批量删除员工
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        empMapper.deleteByIds(ids);
        empExprMapper.deleteByEmpIds(ids);
    }

    /**
     * 根据id查询员工数据
     */
    @Override
    public Emp getInfo(Integer id) {
        Emp emp = empMapper.getInfo(id);
        return emp;
    }

    /**
     * 修改员工信息
     */
    // 因为多次操作了数据库，需要加入事务管理
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        // 1. 根据id修改员工的基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        // 2. 根据id修改员工的工作经历信息
        // 2.1 先根据员工的id，删除原有的工作经历信息
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));
        // 2.2 再添加新的工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        // 说明: 先判断经历集合是否为空，不为空再遍历集合，为每一个工作经历的员工id赋值
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }

    /**
     * 查询全部员工
     */
    @Override
    public List<Emp> getEmpList() {
        return empMapper.getEmpList();
    }

    /**
     * 登录
     */
    @Override
    public LoginInfo login(Emp emp) {
        // 1. 调用 mapper接口，根据用户名和密码查询员工
        Emp e = empMapper.selectByUsernameAndPassword(emp);
        // 2. 根据查询的结果进行判断，如果不为空，则返回登录信息
        if (e != null) {
            log.info("登录成功:{}", e);
            // 2.1 生成JWT令牌
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("id", e.getId());
            dataMap.put("username", e.getUsername());

            String token = JwtUtils.generateJwt(dataMap);
            return new LoginInfo(e.getId(), e.getUsername(), e.getName(), token);
        }
        // 3. 返回null
        return null;
    }


}


// JWT令牌演示
/*Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("id", e.getId());
            dataMap.put("username", e.getUsername());
            dataMap.put("name", e.getName());
            String token = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, "tlias")
                    .setClaims(dataMap)
                    .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000 * 10))
                    .compact();*/

