package com.javalearn.p1_collotion.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

public class ListDemo2 {
    /*
        List 集合的遍历方式 ：

                1. 迭代器遍历
                2. 增强 for循环
                3. foreach 方法
                4. 普通 for循环
                5. ListIterator (List 集合特有的迭代器)
     */
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");

        ListIterator<String> it = list.listIterator();

        // 正序遍历
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("---------------------");

        // 倒叙遍历
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }

    }

    /**
     * 普通 for循环
     * @param list
     */
    private static void method4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }

    /**
     * foreach 方法
     * @param list
     */
    private static void method3(List<String> list) {
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    /**
     * 增强 for循环
     * @param list
     */
    private static void method2(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 迭代器遍历
     * @param list
     */
    private static void method1(List<String> list) {
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
