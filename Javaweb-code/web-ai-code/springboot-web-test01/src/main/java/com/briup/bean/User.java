package com.briup.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/31 16:27
 */
/* 封装用户信息 */
@Data // Lombok 组件提供的注解，自动生成get、set方法
@NoArgsConstructor // 无参构造
@AllArgsConstructor // 有参构造
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;
}
