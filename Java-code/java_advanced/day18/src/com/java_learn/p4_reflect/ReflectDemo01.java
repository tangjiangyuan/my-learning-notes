package com.java_learn.p4_reflect;

import com.java_learn.domain.Student;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 15:04
 */
public class ReflectDemo01 {
    /*
        获取字节码的三种方式
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // Class.forName("全类名")
        Class<?> class1 = Class.forName("com.java_learn.domain.Student");
        // 类名.class
        Class<Student> class2 = Student.class;
        // 对象.getClass();
        Class<? extends Student> class3 = new Student().getClass();

        System.out.println(class1);
        System.out.println(class2);
        System.out.println(class3);

        // 证明类的字节码文件只有一份
        System.out.println(class1 == class2);
        System.out.println(class2 == class3);
        System.out.println(class3 == class1);
    }
}
