package com.tjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @date 2025/8/12 20:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private Integer degree;
    private Integer classId;
}
