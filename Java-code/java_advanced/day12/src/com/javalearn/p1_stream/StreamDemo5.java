package com.javalearn.p1_stream;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDemo5 {
    /*
        创建一个 ArrayList集合，并添加以下字符串
            "张三,23"
            "李四,24"
            "王五,25"
            保留年龄大于等于24岁的人，并将结果收集到 Map集合中，姓名为键，年龄为值
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三,23");
        list.add("李四,24");
        list.add("王五,25");

        Map<String, Integer> map = list.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));

        map.forEach((k, v) -> System.out.println(k + "---" + v));

        // list.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24).forEach(s -> System.out.println(s));
    }
}
