package com.javalearn.test;

public class Book {
    /*
        练习 --- 类的定义与对象的创建和使用
        编写一个图书类（Book）
            属性 : 编号（id），书名（name），价格（price）
            行为 : 展示（show）
                    该方法中需要展示出图书的所有属性信息

        编写一个图书测试类（BookTest）
            创建3个图书对象，分别赋值位
                (001,三国,88.88)
                (002,水浒,88.88)
                (003,富婆通讯录,10000)
            调用3个对象，各自的show方法展示属性信息
     */
    String id;
    String name;
    double price;

    public void show() {
        System.out.println("(" + id + "," + name + "," + price + ")");
    }
}
