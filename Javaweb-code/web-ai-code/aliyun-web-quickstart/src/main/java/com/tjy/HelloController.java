package com.tjy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/31 11:37
 */
@RestController // 表示当前类是一个请求处理类
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name) {
        System.out.println("name:" + name);
        return "hello:" + name + "~"; // return 的数据会展示在网页中
    }

}
