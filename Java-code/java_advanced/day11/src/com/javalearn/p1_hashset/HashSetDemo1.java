package com.javalearn.p1_hashset;

import java.util.HashSet;

public class HashSetDemo1 {
    /*
        HashSet 集合的基本使用

        * 特点 ： 去重
        * 遍历 ： 迭代器，增强for循环，foreach方法
     */
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("b");
        hs.add("a");
        hs.add("c");
        hs.add("d");
        hs.add("b");
        hs.add("b");
        hs.add("b");

        System.out.println(hs);
    }
}
