package com.tjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @version 1.0
 * @date 2025/8/7 9:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpExpr {
    private Integer id; // id
    private Integer empId; // 员工id
    private LocalDate begin; // 开始日期
    private LocalDate end; // 结束日期
    private String company; // 公司名称
    private String job; // 职位
}
