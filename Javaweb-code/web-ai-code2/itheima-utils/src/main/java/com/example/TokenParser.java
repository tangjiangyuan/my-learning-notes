package com.example;

import org.springframework.stereotype.Component;

// 因为在启动类中加入了@Import注解，可以直接注入普通类、配置类
//@Component
public class TokenParser {

    public void parse(){
        System.out.println("TokenParser ... parse ...");
    }

}
