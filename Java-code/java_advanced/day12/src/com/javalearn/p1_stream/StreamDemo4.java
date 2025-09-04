package com.javalearn.p1_stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {
    /*
        Stream流的收集操作

            public R collect(Collector c) : 开始收集 Stream流，指定收集器

        Collectors :
            public static <T> Collector toList() : 把元素收集到 List集合中
            public static <T> Collector toSet() : 把元素收集到 Set集合中
            public static Collector toMap(Function keyMapper, Function valueMapper) : 把元素收集到 Map集合中
     */
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(s -> s % 2 == 0).collect(Collectors.toList());
        System.out.println(list);

        System.out.println("---------------");

        Set<Integer> set = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).filter(s -> s % 2 != 0).collect(Collectors.toSet());
        System.out.println(set);
    }
}
