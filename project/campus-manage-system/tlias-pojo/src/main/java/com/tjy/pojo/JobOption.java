package com.tjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @version 1.0
 * @date 2025/8/11 18:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOption {
    private List jobList; // 职位列表
    private List dataList; // 人数列表
}
