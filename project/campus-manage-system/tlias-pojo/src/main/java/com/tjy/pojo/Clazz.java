package com.tjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @version 1.0
 * @date 2025/8/12 11:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {
    private Integer id; // id
    private String name; // 班级名称
    private String room; // 班级教室
    private LocalDate beginDate; // 开课时间
    private LocalDate endDate; // 结课时间
    private Integer masterId; // 班主任id
    private Integer subject; // 学科
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间

    private String masterName; // 班主任姓名
    private String status; // 班级状态 - 未开班， 在读， 已结课
}
