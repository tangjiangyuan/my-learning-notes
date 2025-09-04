package com.briup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 默认扫描当前包及其子包
public class SpringbootWebTest01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebTest01Application.class, args);
    }

}
