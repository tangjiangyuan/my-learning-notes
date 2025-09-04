package com.java_learn.p4_reflect.exer01;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 22:16
 */
public class Test {
    /*
        需求 --- 请向一个泛型为 Integer的集合，添加一个 String字符串
        思路 --- Java中的泛型是假的，只在编译的时候有效
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);

        // 1. 获取 集合的字节码对象
        Class<? extends ArrayList> aClass = list.getClass();
        // 2. 反射类中的add方法
        Method addMethod = aClass.getMethod("add", Object.class);
        // 3. 让 add方法执行
        addMethod.invoke(list, "abc");

        System.out.println(list);
    }
}
