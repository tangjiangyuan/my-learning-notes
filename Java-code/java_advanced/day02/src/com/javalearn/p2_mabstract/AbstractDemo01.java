package com.javalearn.p2_mabstract;

public class AbstractDemo01 {
    /*
        抽象类 : 是一种特殊的父类，内部可以编写抽象方法。

        问题 ： 特殊在哪？
        回答 ： 内部允许编写抽象方法

        问题 ： 什么是抽象方法？
        回答 ： 当我们将子类中共性的方法抽取到父类中，发现父类无法给出具体明确（描述不清），
                而子类必须要有这些方法，这时就可以编写抽象方法
     */
    public static void main(String[] args) {

    }
}

abstract class Animal {
    public abstract void eat();
}

class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}

class Dog extends Animal{

    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }
}
