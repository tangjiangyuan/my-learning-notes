package com.javalearn.p1_oop;

public class StudentTest {
    /*
        创建Student类的对象进行使用

        1. 创建对象的格式

            类名 对象名 = new 类名();

        2. 使用对象成员变量的格式

            对象名.成员变量名;

        3. 使用对象成员方法的格式

            对象名.成员方法名();

        ----------------------------------
        细节：

            1. 打印对象名，可以看到对象的内存地址

                    com.javalearn.oop.Student@6504e3b2
                    全类名 : 包名 + 类名

            2. 成员变量就算没有赋值，也可以直接使用，使用的是对象的默认值
     */
    public static void main(String[] args) {
        // 1. 创建对象的格式
        Student stu1 = new Student();
        stu1.name = "张三";
        stu1.age = 18;
        // 2. 使用对象成员变量的格式
        System.out.println(stu1.name);
        System.out.println(stu1.age);
        // 3. 使用对象成员方法的格式
        stu1.study();
        stu1.eat();

        System.out.println("----------------");

        Student stu2 = new Student();
        stu2.name = "李四";
        stu2.age = 24;

        System.out.println(stu2.name);
        System.out.println(stu2.age);

        stu2.study();
        stu2.eat();
    }
}
