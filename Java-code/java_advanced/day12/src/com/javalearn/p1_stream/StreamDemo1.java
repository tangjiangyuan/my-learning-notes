package com.javalearn.p1_stream;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo1 {
    /*
        获取 Stream流对象演示
            - 将数据放入流水线的传送带上

            1. 集合获取 Stream流对象（使用 Collection接口中的默认方法）
                    default Stream<E> stream()

                    * Map集合获取Stream流对象，需要间接获取
                            - map.entrySet().stream()

            2. 数组获取 Stream流对象（使用Arrays数组工具类的静态方法）
                    static <T> Stream<T> stream(T[] array)
            3. 零散的数据获取 Stream流对象（使用 Stream类中的静态方法）
                    static <T> Stream<T> of(T...values)
     */
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6).forEach(s -> System.out.println(s));
        Stream.of("友利奈绪", "雪之下雪乃", "蕾西亚").forEach(s -> System.out.println(s));
    }

    private static void method2() {
        int[] arr1 = {11, 22, 33};
        double[] arr2 = {11.1, 22.2, 33.3};

        IntStream intStream = Arrays.stream(arr1);
        intStream.forEach(s -> System.out.println(s));

        Arrays.stream(arr2).forEach(s -> System.out.println(s));
    }

    private static void method1() {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("张良");
        list.add("王二麻子");
        list.add("谢广坤");
        list.add("张三丰");
        list.add("张翠山");

        list.stream().forEach(s -> System.out.println(s));
        System.out.println("----------------");

        Set<String> set = new HashSet<>();
        set.add("张三丰");
        set.add("张无忌");
        set.add("张翠山");
        set.add("王二麻子");
        set.add("张良");
        set.add("谢广坤");

        set.stream().forEach(s -> System.out.println(s));
        System.out.println("----------------");

        Map<String, Integer> map = new HashMap<>();
        map.put("张三丰", 100);
        map.put("张无忌", 35);
        map.put("张翠山", 55);
        map.put("王二麻子", 22);
        map.put("张良", 30);
        map.put("谢广坤", 55);

        map.entrySet().stream().forEach(s -> System.out.println(s));
    }
}
