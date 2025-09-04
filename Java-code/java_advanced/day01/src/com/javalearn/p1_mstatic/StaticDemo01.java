package com.javalearn.p1_mstatic;

public class StaticDemo01 {
    /*
        static 关键字: static 是静态的意思，可以修饰成员变量，也可以修饰成员方法。

        特点 :
            1. 被类的所有对象所共享
            2. 多了一种调用方式，可以通过类名进行调用
            3. 随着类的加载而加载，优先于对象存在
     */
    public static void main(String[] args) {

        Student.school = "兰理工";

        Student stu1 = new Student();
        stu1.name = "张三";
        stu1.age = 23;

        System.out.println(stu1.name + "---" + stu1.age + "---" + Student.school);

        System.out.println("------------------------------");

        Student stu2 = new Student();
        stu2.name = "李四";
        stu2.age = 24;

        System.out.println(stu2.name + "---" + stu2.age + "---" + stu2.school);
    }
}
