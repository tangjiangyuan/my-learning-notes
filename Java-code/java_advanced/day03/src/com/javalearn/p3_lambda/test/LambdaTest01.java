package com.javalearn.p3_lambda.test;

public class LambdaTest01 {
    /*
        Lambda 表达式的省略写法

            1. 参数类型可以省略不写
            2. 如果只有一个参数，参数类型可以省略，同时 () 也可以省略。
            3. 如果 Lambda表达式的方法体代码只有一行代码，可以省略大括号不写，同时要省略分号！
            4. 如果 Lambda表达式的方法体代码只有一行代码，可以省略大括号不写。
                此时，如果这行代码是return语句，必须省略return不写，同时也必须省略”;“不写
     */
    public static void main(String[] args) {

        useShowHandler(new ShowHandler() {
            @Override
            public void show() {
                System.out.println("匿名表达式...show...");
            }
        });

        System.out.println("---");

        // 如果 Lambda表达式的方法体代码只有一行代码，可以省略大括号不写。
        useShowHandler( () -> System.out.println("Lambda...show"));
    }

    public static void useShowHandler(ShowHandler showHandler) {
        showHandler.show();
    }
}

interface ShowHandler {
    void show();
}