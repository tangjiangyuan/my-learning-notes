package com.javalearn.p5_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapDemo3 {
    /*
        Map集合的遍历
     */
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("张三", "北京");
        hm.put("李四", "上海");
        hm.put("王五", "成都");
    }

    private static void method3(HashMap<String, String> hm) {
        hm.forEach((key, value) -> System.out.println(key + "---" + value));
    }

    private static void method2(HashMap<String, String> hm) {
        // 2.获取到所有的键值对对象
        Set<Map.Entry<String, String>> entrySet = hm.entrySet();
        // 遍历set集合，得到每一个键值对对象
        for (Map.Entry<String, String> stringEntry : entrySet) {
            System.out.println(stringEntry.getKey() + "---" + stringEntry.getValue());
        }
    }

    private static void method1(HashMap<String, String> hm) {
        /* 通过键找值*/
        // 1.获取到所有的键
        Set<String> keySet = hm.keySet();
        // 2.遍历set集合，得到每一个键
        for (String key : keySet) {
            String value = hm.get(key);
            System.out.println(key + "---" + value);
        }
    }
}
