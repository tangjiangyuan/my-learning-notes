package com.tjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @version 1.0
 * @date 2025/8/7 9:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id; // 员工id
    private String username; // 用户名
    private String password; // 密码
    private String name; // 姓名
    private Integer gender; // 性别
    private String phone; // 手机号
    private Integer job; // 职位 1 班主任；2 讲师； 3 学工主管； 4 教研主管； 5 咨询师
    private Integer salary; // 薪资
    private String image; // 头像
    private LocalDate entryDate; // 入职日期
    private Integer deptId; // 关联的部门id
    private LocalDateTime createTime; // 创建日期
    private LocalDateTime updateTime; // 修改日期

    private String deptName; // 封装记录的部门名称
    private List<EmpExpr> exprList; // 封装工作经历信息
}
