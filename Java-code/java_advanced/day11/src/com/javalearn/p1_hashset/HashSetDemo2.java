package com.javalearn.p1_hashset;

import com.javalearn.domain.Student;

import java.util.HashSet;

public class HashSetDemo2 {
    /*
        HashSet 集合存储自定义对象

        HashSet 集合中存储元素，想要保证元素唯一性，
            必须同时重写对象中的 equals()和 hashCode()方法

        HashSet 底层的数据结构是哈希表结构

        哈希表 ：
        JDK8 版本之前 ： 数组 + 链表
        JDK8 版本之后 ： 数据 + 链表 + 红黑树
     */
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<>();

        hs.add(new Student("李四", 23));
        hs.add(new Student("王五", 23));
        hs.add(new Student("王五", 23));
        hs.add(new Student("张三", 23));

        System.out.println(hs);
    }
}
