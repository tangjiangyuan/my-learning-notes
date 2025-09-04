package com.java_learn.p4_reflect;

import com.java_learn.domain.Student;

import java.lang.reflect.Method;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 15:15
 */
public class ReflectDemo04 {
    /*
        反射类的成员方法
        1. Method[] getMethods()            返回所有公共成员方法对象的数组，包括继承
        2. Method[] getDeclaredMethods()    返回所有成员方法对象的数组，不包括继承
        3. Method getMethod()               返回单个公共成员方法对象
        4. Method getDeclaredMethod()       返回单个成员方法对象
        ------------------------------------------------------------------------------
        Method 类的执行方法
        Object invoke(Object obj, Object...args)    运行方法
     */
    public static void main(String[] args) throws Exception {
        // 1. 创建字节码对象
        Class<?> stuClass = Class.forName("com.java_learn.domain.Student");
        // 2. 通过字节码对象，反射内部的成员方法数组对象(所有 public修饰的)
        Method[] methods = stuClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        // 通过构造方法对象创建类对象
        Student stu = (Student) stuClass.getConstructor().newInstance();

        // 通过字节码对象，反射指定成员方法对象; 第一个参数指定方法名，第二个参数指定那个带参方法
        Method eatMethod = stuClass.getMethod("eat", int.class);

        // 让反射到的成员方法执行起来
        eatMethod.invoke(stu, 3);
    }
}
