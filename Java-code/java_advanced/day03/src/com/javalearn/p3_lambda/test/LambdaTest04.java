package com.javalearn.p3_lambda.test;

public class LambdaTest04 {
    public static void main(String[] args) {

        useCalculator(new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });

        System.out.println("-----------");

        // 参数类型可以省略不写
        useCalculator((a, b) -> a - b);
    }

    public static void useCalculator(Calculator calculator) {
        int result = calculator.calc(10, 20);
        System.out.println(result);
    }
}

interface Calculator {
    int calc(int a, int b);
}