package com.tjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @version 1.0
 * @date 2025/8/12 11:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id; // id
    private String name; // 姓名
    private String no; // 序号
    private Integer gender; // 性别 1: 男； 2: 女
    private String phone; // 手机号
    private String idCard; // 身份证号
    private Integer isCollege; // 是否来自于院校， 1：是， 0：否
    private String address; // 联系地址
    private Integer degree; // 最高学历， 1 初中， 2高中， 3大专， 4本科， 5硕士， 6博士
    private LocalDate graduationDate; // 毕业时间
    private Integer clazzId; // 班级ID
    private Short violationCount; // 违纪次数
    private Short violationScore; // 危机扣分
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间

    private String clazzName; // 班级名称
}
