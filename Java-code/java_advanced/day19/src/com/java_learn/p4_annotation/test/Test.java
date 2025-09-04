package com.java_learn.p4_annotation.test;

import java.lang.reflect.Method;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/26 13:53
 */
public class Test {
    public static void main(String[] args) throws Exception{
        Class<AnnotationTest> aClass = AnnotationTest.class;

        AnnotationTest anno = aClass.getConstructor().newInstance();

        // 通过字节码对象，反射类中的所有方法
        Method[] methods = aClass.getMethods();
        // 遍历数组，获取每一个成员方法
        for (Method method : methods) {
            // 看这个方法上面，是否存在 @MyTest注解
            if (method.isAnnotationPresent(MyTest.class)) {
                method.invoke(anno);
            }
        }
    }
}
