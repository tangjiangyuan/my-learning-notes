package com.javalearn.p4_constructor;

public class StudentTest {
    /*
        构造方法（构造器）
            在创建对象时，调用的方法。

        格式：
            1. 方法名与类名相同，大小写一致
            2. 没有返回值类型，连void都没有。
            3. 没有具体的返回值（不能由return带回结果数据）
     */
    public static void main(String[] args) {

        Student stu = new Student("张三", 23);
        System.out.println(stu.name + "---" + stu.age);

        Student stu2 = new Student("李四", 24);
        System.out.println(stu2.name + "---" + stu2.age);

        Student stu3 = new Student();
    }
}
