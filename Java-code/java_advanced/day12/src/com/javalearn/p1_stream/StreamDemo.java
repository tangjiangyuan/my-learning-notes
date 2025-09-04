package com.javalearn.p1_stream;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo {
    /*
        需求 --- 按照下面的要求完成集合的创建和遍历
                1. 创建一个集合，存储多个字符串元素
                2. 把集合中所有以“张”开头的元素存储到一个新的集合
                3. 把“张”开头的集合中的长度为3的元素存储到一个新的集合
                4. 遍历上一步得到的集合中的元素输出
     */
    public static void main(String[] args) {
        // 1. 创建一个集合，存储多个字符串元素
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("张良");
        list.add("王二麻子");
        list.add("谢广坤");
        list.add("张三丰");
        list.add("张翠山");

        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3)
                .forEach(s -> System.out.println(s));
    }

    private static void method1(List<String> list) {
        // 2. 把集合中所有以“张”开头的元素存储到一个新的集合
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : list) {
            /*char c = s.charAt(0);*/
            if (s.startsWith("张")) {
                list1.add(s);
            }
        }

        // 3. 把“张”开头的集合中的长度为3的元素存储到一个新的集合
        ArrayList<String> list2 = new ArrayList<>();
        for (String s : list1) {
            if (s.length() == 3) {
                list2.add(s);
            }
        }

        // 4. 遍历上一步得到的集合中的元素输出
        for (String s : list2) {
            System.out.println(s);
        }
    }
}
