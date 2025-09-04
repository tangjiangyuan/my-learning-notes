package com.javalearn.p2_set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo1 {
    /*
        TreeSet 集合的特点 ： 排序、去重
     */
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();

        ts.add("a");
        ts.add("b");
        ts.add("c");
        ts.add("d");
        ts.add("d");
        ts.add("d");
        ts.add("d");

        System.out.println(ts);
    }
}
