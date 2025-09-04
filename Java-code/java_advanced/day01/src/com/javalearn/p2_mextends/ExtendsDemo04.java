package com.javalearn.p2_mextends;

public class ExtendsDemo04 {
    /*
        多层继承 c-->b-->a
     */
    public static void main(String[] args) {
        C c = new C();
        c.eat();
    }
}
class A {
    public void eat() {
        System.out.println("吃汉堡");
    }
}
class B extends A {
    @Override
    public void eat() {
        super.eat();
        System.out.println("吃米粉");
    }
}
class C extends B {
    @Override
    public void eat() {
        super.eat();
        System.out.println("吃拉面");
    }
}
