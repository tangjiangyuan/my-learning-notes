package com.javalearn.p2_inner;

public class StaticInnerDemo {
    /*
        静态内部类：static 修饰的成员内部类

        创建对象格式： 外部类名.内部类名 对象名 = new 外部类名.内部类对象();
     */
    public static void main(String[] args) {
        OuterClass.InnerClass.show();
        // OuterClass.InnerClass oi = new OuterClass.InnerClass();
    }
}

class OuterClass {

    int num1 = 10;
    static int num2 = 20;
    static class InnerClass {

        public static void show() {

            System.out.println("show...");

            OuterClass oc = new OuterClass();
            System.out.println(oc.num1);

            System.out.println(num2);// 静态只能访问静态
        }
    }
}