package com.javalearn.p5_map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {
    /*
        Map 集合常用 API
        -----------------------------
        public V put(K key, V value) :                  添加元素(修改 : 如果键已经存在，就会使用新值，替换旧值);
                                                                --- V : 返回的是被覆盖的旧值，如果没有覆盖，返回的是null;无意义
        public V remove(Object key) :                   根据键删除键值对元素 (键是唯一的)
                                                                --- V : 返回的是删除的键所对应的值
        public void clear() :                           移除所有的键值对元素
        public boolean containsKey(Object key) :        判断集合是否包含指定的键
        public boolean containsValue(Object value) :    判断集合是否包含指定的值
        public boolean isEmpty() :                      判断集合是否为空
        public int size() :                             集合的长度，也就是集合中键值对的个数
     */
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("张三", "北京");
        map.put("李四", "上海");
        map.put("王五", "成都");
        System.out.println(map);
        System.out.println(map.size());
        System.out.println("------------------");

        System.out.println(map.containsKey("张三"));
        System.out.println(map.containsValue("北京"));
        System.out.println("------------------");

        map.remove("张三");
        System.out.println(map);
        System.out.println("------------------");

        map.clear();
        System.out.println(map);
        System.out.println("------------------");

        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println("------------------");
    }
}
