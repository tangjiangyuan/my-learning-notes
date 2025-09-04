package com.javaLearn.p1_variable;

public class VariableDemo02 {
    /*
        变量的注意事项：

            1.变量名不允许重复定义

            2.一条语句，可以定义多个变量，中间需要使用逗号分隔

            3.变量在使用之前，必须完成赋值

     */
    public static void main(String[] args) {
        // 1.变量名不允许重复定义
        int salary = 15000;
        // int salary = 12000;
        System.out.println(salary);

        // 2.一条语句，可以定义多个变量，中间需要使用逗号分隔
        int a = 10,b = 20,c = 30;

        // 3.变量在使用之前，必须完成赋值
        /*int age;
        System.out.println(age);*/
    }
}
