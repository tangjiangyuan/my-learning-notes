package com.javalearn.test;


public class PhoneTest {
    public static void main(String[] args) {

        Phone p1 = new Phone();
        p1.brand = "小米";
        p1.color = "白色";
        p1.price = 4999;

        System.out.println(p1.brand + "---" + p1.color + "---" + p1.price);

        System.out.println("-------------------------");

        Phone p2 = new Phone();
        p2.brand = "华为";
        p2.color = "黑色";
        p2.price = 6999;

        System.out.println(p2.brand + "---" + p2.color + "---" + p2.price);

        p1.call("张三");
        p1.sendMessage("张三,");

        p2.call("李四");
        p2.sendMessage("李四,");
    }
}
