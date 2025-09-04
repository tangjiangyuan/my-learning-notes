package com.javalearn.test;

import java.util.ArrayList;

public class Test3 {
    /*
        练习 : 集合删除元素
        需求 : 创建一个存储String的集合，内部存储（test、张三、李四、test、test）字符串
        删除所有的test字符串，删除后，将集合剩余元素打印在控制台

        总结 : 在遍历集合的过程中，有删除操作
                1. 正序遍历 : 不要忘记 '--'操作
                2. 倒序遍历 : 不需要   '--'操作
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("test");
        list.add("张三");
        list.add("李四");
        list.add("test");
        list.add("test");

        removeTest1(list);
    }

    /**
     * 第二种删除方式 -- 倒叙
     * @param list
     */
    private static void removeTest2(ArrayList<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) { // 倒着遍历也可以避免集合不允许空缺的情况
            String s = list.get(i);
            if ("test".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println(list);
    }

    /**
     * 第一种删除方法 -- 正序
     */
    private static void removeTest1(ArrayList<String> list) {

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if ("test".equals(s)) { // 当变量和常量比较时，通常用常量.equals(变量),这样可以避免空指针异常
                list.remove(s);
                i--; // 删除该索引位置的元素后，集合不允许存在空缺，因此会自动补齐，而这时其实指向的是下一个元素，所以要i--
            }
        }
        System.out.println(list);
    }
}
