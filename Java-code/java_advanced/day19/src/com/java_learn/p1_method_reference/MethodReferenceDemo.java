package com.java_learn.p1_method_reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/26 9:28
 */
public class MethodReferenceDemo {
    /*
        方法引用 是 JDK8开始出现的，主要的作用，是对 Lambda表达式进行进一步的简化
        方法引用使用一对冒号 ::
        通过方法的名字来指向一个方法
        可以使语言的构造更紧凑简洁，减少冗余代码
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "A", "B", "C", "D");

        // 方法调用 : .方法名
        // 方法引用 : ::方法名

//        list.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                MethodReferenceDemo.method(s);
//            }
//        });

        list.forEach(MethodReferenceDemo::method);

    }

    public static void method(String s) {
        System.out.println(s.toLowerCase());
    }

    private static void show(ArrayList<String> list) {
        // 1. 匿名内部类
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // 2. Lambda表达式
        list.forEach(s-> System.out.println(s));
        // 3. 方法引用
        list.forEach(System.out::println);
    }
}
