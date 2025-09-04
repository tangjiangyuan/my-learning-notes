package com.javalearn.p1_hashset;

import java.util.HashSet;

public class HashSetDemo4 {
    /*
        当数组存储元素超过12时，会自动扩容位两倍
     */
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("a"); // 1
        hs.add("b"); // 2
        hs.add("c"); // 3
        hs.add("d"); // 4
        hs.add("e"); // 5
        hs.add("f"); // 6
        hs.add("g"); // 7
        hs.add("h"); // 8
        hs.add("i"); // 9
        hs.add("j"); // 10
        hs.add("k"); // 11
        hs.add("l"); // 12
        hs.add("m"); // 13

    }
}
