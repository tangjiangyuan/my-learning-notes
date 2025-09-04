package com.tjy.pojo;

/**
 * @version 1.0
 * @date 2025/8/7 9:56
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页结果封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    private long total; // 总记录数
    private List<T> rows; // 每行数据
}
