package com.javalearn.p5_map.test;

import java.util.TreeMap;

public class Test1 {
    /*
        练习 --- Map集合练习
        需求 ： 字符串 aababcabcdabcde
                统计字符串每一个字符出现的次数，并按照一下格式输出
                输出结果：
                    a(5)b(4)c(3)d(2)e(1)
     */
    public static void main(String[] args) {
        String info = "aababcabcdabcde";

        // 1.准备一个Map集合，用于统计字符的次数
        TreeMap<Character, Integer> tm = new TreeMap<>();

        // 2.差分字符串
        char[] charArray = info.toCharArray();

        // 3.遍历字符数组，获取每一个字符
        for (char c : charArray) {
            // 4.判断当前字符在集合中是否存在
            if (!tm.containsKey(c)) {
                // 不存在 : 说明是第一次出现
                tm.put(c, 1);
            } else {
                // 存在 : 说明不是第一次出现，获取旧值，并将旧值 + 1 存回去
                tm.put(c, tm.get(c) + 1);
            }
        }

        // 5.遍历集合
        tm.forEach((k, v) -> System.out.print(k + "(" + v + ")"));

        System.out.println();
        System.out.println("--------------------");

        StringBuilder sb = new StringBuilder();
        tm.forEach((key, value) -> sb.append(key).append("(").append(value).append(")"));
        System.out.println(sb);
    }
}
