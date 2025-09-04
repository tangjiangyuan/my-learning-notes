package com.javalearn.p3_lambda;

public class LambdaDemo03 {
    public static void main(String[] args) {
        useInterA(new A() {
            @Override
            public void show() {
                System.out.println("匿名内部类。。。");
            }
        });

        System.out.println("-------------");

        useInterA(() -> {
            System.out.println("Lambda表达式。。。");
        });
    }

    public static void useInterA(A a) {
        a.show();
    }
}

interface A {
    void show();
}

