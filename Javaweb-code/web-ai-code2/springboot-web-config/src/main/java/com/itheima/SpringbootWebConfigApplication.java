package com.itheima;

import com.example.EnableHeaderConfig;
import com.example.HeaderConfig;
import com.example.MyImportSelector;
import com.example.TokenParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Import;

// 自动配置方案一: @Component + @ComponentScan
//@ComponentScan(basePackages = {"com.example", "com.itheima"})
@SpringBootApplication

// 自动配置方案二: @Import
// @Import(TokenParser.class) // 普通类
// @Import(HeaderConfig.class) // 配置类

// 自动配置方案三: ImportSelector接口的实现类
// @Import(MyImportSelector.class) // ImportSelector接口的实现类

// 自动配置方案四: 使用第三方提供的注解
@EnableHeaderConfig
public class SpringbootWebConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebConfigApplication.class, args);
    }

}
