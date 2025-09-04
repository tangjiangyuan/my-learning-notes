package com.javalearn.p2_mextends;

public class ExtendsDemo02 {
    /*
        - 子父类中出现了方法声明一模一样的方法（方法名、参数、返回值）
                - 在创建子类对象，调用方法的使用，会优先使用子类的方法逻辑
                - 这虽然是就近原则的现象，但其实是子类的方法，对父类的方法，进行了重写操作
     */
    public static void main(String[] args) {
        Zi z = new Zi();
        z.print();
    }
}
class Fu {
    int num = 10;

    public void print() {
        System.out.println("Fu...");
    }
}
class Zi extends Fu{
    int num = 20;

    public void method() {
        int num = 30;
        System.out.println(num);             // 30 就近
        System.out.println(this.num);        // 20 打印本类中的成员变量
        System.out.println(super.num);       // 10 打印父类中的成员变量
    }

    public void print() {
        System.out.println("Zi...");
    }
}
