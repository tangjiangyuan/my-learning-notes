package com.java_learn.stream.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class Test4 {
    /*
        案例 - 统计字符次数
        如 : A(1)B(2)C(3)
    */
    public static void main(String[] args) throws IOException {
        method2();
    }

    private static void method1() throws IOException {
        // 使用TreeMap收集字母的对应次数
        TreeMap<Character, Integer> tm = new TreeMap<>();
        // 使用字符流读取文件
        FileReader fr = new FileReader("D:\\a.txt");
        // 通过字符串拼接文件中的字符
        String s = null;
        // 读取文件中的所有字符
        int len;
        char[] chars = new char[10];
        while ((len = fr.read(chars)) != -1) {
            s = new String(chars, 0, len);
        }
        // 关流
        fr.close();
        // 将字符串转换为字符数组
        char[] charArray = s.toCharArray();
        // 遍历字符数组
        for (char c : charArray) {
            // 统计每一个字符以及该字符的个数
            if (!tm.containsKey(c)) {
                tm.put(c, 1);
            } else {
                tm.put(c, tm.get(c) + 1);
            }
        }
        // 将结果输出到控制台
        tm.forEach((k, v) -> System.out.print(k + "(" + v + ")"));
    }

    public static void method2() throws IOException {
        // 使用字符输入流读取文件中的字符
        FileReader fr = new FileReader("D:\\a.txt");
        // 使用map集合存放数据
        HashMap<Character, Integer> hm = new HashMap<>();
        // 读取
        int i;
        while ((i = fr.read()) != -1) {
            // 存入map集合
            char c = (char) i;
            if (!hm.containsKey(c)) {
                hm.put(c, 1);
            } else {
                hm.put(c, hm.get(c) + 1);
            }
        }
        // 关闭输入流
        fr.close();
        // 使用 StringBuilder 来拼接，效率更快
        StringBuilder sb = new StringBuilder();
        hm.forEach((key, value) -> sb.append(key).append("(").append(value).append(")"));
        System.out.println(sb);
    }
}
