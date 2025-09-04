package com.javalearn.p3_lambda;

public class LambdaDemo01 {
    /*
        lambda 表达式 : 是从 JDK8 开始出现的一种新语法形式
        作用：简化匿名内部类的写法

        格式：
        () -> {}
        () : 匿名内部类被重写方法的形参列表
        {} : 被重写方法的方法体代码
     */
    public static void main(String[] args) {

        useInterA(new InterA() {
            @Override
            public void show() {
                System.out.println("匿名内部类，重写后的show方法。。。");
            }
        });

        System.out.println("--------------");

        useInterA( () -> {
            System.out.println("lambda表达式，重写后的show方法。。。");
        });
    }

    public static void useInterA(InterA ia) {
        ia.show();
    }
}

// @FunctionalInterface 注解：用来检验该接口是否是函数式接口
@FunctionalInterface
interface InterA {
    void show();
}