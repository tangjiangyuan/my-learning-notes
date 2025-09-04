package com.javalearn.test;

public class Phone {
    /*
        练习 -- 类的定义与对象的创建和使用
        定义一个手机类（Phone）
            属性:(品牌 brand，颜色 color，价格 price)
            行为:
                打电话（call）
                    - 输出给xxx打电话
                发短信（sendMessage）
                    - 输出群发消息
        编写一个手机测试类（PhoneTest）
            创建两个手机对象，并给属性赋值
                1. 小米，白色，4999
                2. 华为，黑色，6999
            赋值后，校验自己有没有赋值成功，使用打印语句校验，调用两个对象各自的成员方法
     */
    String brand;
    String color;
    int price;

    public void call(String name) {
        System.out.println("给" + name + "打电话");
    }

    public void sendMessage(String name) {
        System.out.println(name + "你好！");
    }
}
