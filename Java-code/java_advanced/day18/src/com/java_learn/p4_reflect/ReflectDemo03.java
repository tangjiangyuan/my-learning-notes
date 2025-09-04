package com.java_learn.p4_reflect;

import com.java_learn.domain.Student;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 15:15
 */
public class ReflectDemo03 {
    /*
        -----------------------------------------------------------------------------------
        反射类中的成员变量
        1. Field[] getFields()                      返回所有公共成员变量对象的数组
        2. Field[] getDeclaredFields()              返回所有成员变量对象的数组
        3. Field getField(String name)              返回单个公共成员变量对象(只有 public)
        4. Field getDeclaredField(String name)      返回单个成员变量对象
        -----------------------------------------------------------------------------------
        Field 类的设置和获取方法
        1. void set(Object obj, Object value)       赋值
        2. Object get(Object obj)                   获取值
     */
    public static void main(String[] args) throws Exception {
        // 1. 获取类的字节码对象
        Class<Student> stuClass = Student.class;
        // 2. 暴力反射内部的成员变量对象
        Field nameField = stuClass.getDeclaredField("name");
        Field ageField = stuClass.getDeclaredField("age");
        // 3. 设置访问权限
        nameField.setAccessible(true);
        ageField.setAccessible(true);

        // 获取构造方法对象，用来创建类对象
        Constructor<Student> constructor = stuClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Student stu = constructor.newInstance();

        // 4. 赋值
        nameField.set(stu, "张三");
        ageField.set(stu, 23);
        // 5. 获取值
        System.out.println(nameField.get(stu));
        System.out.println(ageField.get(stu));
    }
}
