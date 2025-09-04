package com.javalearn.p3_lambda.test;

public class LambdaTest02 {
    public static void main(String[] args) {

        useStringHandler(new StringHandler() {
            @Override
            public void printMessage(String msg) {
                System.out.println("匿名表达式..." + msg + "...");
            }
        });

        System.out.println("-----------");

        useStringHandler(msg -> System.out.println("Lambda..." + msg + "..."));
    }

    public static void useStringHandler(StringHandler stringHandler) {
        stringHandler.printMessage("violet");
    }
}

interface StringHandler {
    void printMessage(String msg);
}