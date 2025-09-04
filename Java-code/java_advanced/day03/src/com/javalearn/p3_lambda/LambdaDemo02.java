package com.javalearn.p3_lambda;

public class LambdaDemo02 {
    /*
        Lambda 表达式，只允许操作函数式编程接口 : 有，且仅有一个抽象方法的接口
     */
    public static void main(String[] args) {

        useInterB(new InterB() {
            @Override
            public void show1() {
                System.out.println("lambda...show1...");
            }

            @Override
            public void show2() {
                System.out.println("lambda...show2...");
            }
        });

        System.out.println("----------");

        // useInterB( () -> {});

    }

    public static void useInterB(InterB ib) {
        ib.show1();
        ib.show2();
    }
}

interface InterB {
    void show1();
    void show2();
}