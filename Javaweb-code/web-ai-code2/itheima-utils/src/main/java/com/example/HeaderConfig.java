package com.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderConfig {

    @Bean
    //@ConditionalOnClass(name = "io.jsonwebtoken.Jwts") // 判断环境中是否有对应的字节码文件，如果有就创建bean
    //@ConditionalOnMissingBean // 判断环境中有没有对应的bean，没有就创建bean
    @ConditionalOnProperty(name = "myname", havingValue = "itheima") // 判断myname的属性值是否等于itheima，是就创建bean
    public HeaderParser headerParser(){
        return new HeaderParser();
    }

    @Bean
    public HeaderGenerator headerGenerator(){
        return new HeaderGenerator();
    }
}
