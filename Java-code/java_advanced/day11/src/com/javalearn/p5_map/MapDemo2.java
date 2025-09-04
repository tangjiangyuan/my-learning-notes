package com.javalearn.p5_map;

import com.javalearn.domain.Person;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapDemo2 {
    /*
        双列集合底层的数据结构，都是针对键有效，根值没有关系
            TreeMap : 键排序(实现Comparable接口，重写CompareTo方法)
            HashMap : 键唯一(重写 hashCode和equals方法)
            LinkedHashMap : 键唯一，且可以保证存取顺序
     */
    public static void main(String[] args) {
        showTreeMap();
        showHashMap();
        showLinkedHashMap();
    }

    public static void showTreeMap() {
        TreeMap<Person, String> tm = new TreeMap<>((o1, o2) -> o2.getAge() - o1.getAge());
        tm.put(new Person("李四", 24), "北京");
        tm.put(new Person("张三", 23), "上海");
        tm.put(new Person("王五", 25), "成都");
        tm.put(new Person("赵六", 25), "成都");
        System.out.println(tm);
    }

    public static void showHashMap() {
        // 与 HashSet一样，底层都是哈希表，需要重写 equals()和 hashCode()方法，才能保证元素唯一性
        HashMap<Person, String> hm = new HashMap<>();
        hm.put(new Person("李四", 24), "北京");
        hm.put(new Person("张三", 23), "上海");
        hm.put(new Person("王五", 25), "成都");
        hm.put(new Person("王五", 25), "成都");
        System.out.println(hm);
    }

    public static void showLinkedHashMap() {
        LinkedHashMap<Person, String> lhm = new LinkedHashMap<>();
        lhm.put(new Person("李四", 24), "北京");
        lhm.put(new Person("张三", 23), "上海");
        lhm.put(new Person("王五", 25), "成都");
        lhm.put(new Person("王五", 25), "成都");
        System.out.println(lhm);
    }
}
