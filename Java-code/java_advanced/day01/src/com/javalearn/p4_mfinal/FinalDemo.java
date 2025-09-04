package com.javalearn.p4_mfinal;

public class FinalDemo {
    /*
        final 关键字介绍
                final 是最终的意思，可以修饰方法、变量、类

        final 关键字的特点
                1. final 修饰方法，表明该方法是最终方法，不能被重写
                2. final 修饰变量， 表明该变量是常量，不能再次被赋值
                3. final 修饰类，表明该类是最终类，不能被继承

        -------------------------------------------------------

                final 修饰变量 :
                        基本数据类型 : 数据值不可改变
                        引用数据类型 : 地址值不可改变，但是内容可以改变
     */
    public static void main(String[] args) {
        Zi z = new Zi();
    }
}
class Fu {
    final int NUM1 = 1223;

    int num2 = 8082;

    final public void show() {
        System.out.println("Fu...show");
    }
}
class Zi extends Fu {
    public void method() {
        System.out.println(super.NUM1);
    }
}
