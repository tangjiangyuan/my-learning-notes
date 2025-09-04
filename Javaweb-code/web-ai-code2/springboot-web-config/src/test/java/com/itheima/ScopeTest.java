package com.itheima;

import com.google.gson.Gson;
import com.itheima.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @version 1.0
 * @date 2025/8/15 17:07
 * msg: 测试Spring Bean作用域 - singleton
 */
@SpringBootTest
public class ScopeTest {

    @Autowired // 获取IOC容器
    private ApplicationContext applicationContext;

    @Test
    public void testScope() {
        for (int i = 0; i < 1000; i++) {
            Object deptController = applicationContext.getBean("deptController");
            System.out.println(deptController);
        }
    }
}
