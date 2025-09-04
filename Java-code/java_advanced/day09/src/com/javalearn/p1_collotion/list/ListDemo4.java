package com.javalearn.p1_collotion.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo4 {
    /*
        迭代器遍历集合的过程中，使用集合的删除方法，删除倒数第二个元素，就不会出现错误。
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("cdf");
        list.add("ccc");

        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String s = it.next();
            if ("cdf".equals(s)) {
                list.remove("cdf");
            }
        }
        System.out.println(list);
    }
}
