package com.tjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @version 1.0
 * @date 2025/8/12 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

}
