package com.javalearn.p2_linkedhashset;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo1 {
    /*
        LinkedHashSet 集合特点 ： 去重，并保证存取顺序
     */
    public static void main(String[] args) {
        LinkedHashSet<String> lsh = new LinkedHashSet<>();

        lsh.add("a");
        lsh.add("b");
        lsh.add("d");
        lsh.add("c");
        lsh.add("c");
        lsh.add("c");

        System.out.println(lsh);
    }
}
