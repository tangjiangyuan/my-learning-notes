package com.javalearn.p1_collotion.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo3 {
    /*
        并发修改异常 ： ConcurrentModificationException

        场景 ： 使用[迭代器]遍历集合的构成中，调用了[集合对象]的添加，删除方法，就会出现此异常

        解决方案 ：迭代器的遍历过程中，不允许使用集合对象的添加或删除，那就使用迭代器，自己的添加或删除方法

                    删除方法 ： 普通的迭代器有，List集合也有
                    添加方法 ： 普通的迭代器没有，需要使用 List集合特有的迭代器
     */
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("把青春献给身后那座");
        list.add("辉煌");
        list.add("的都市");
        list.add("为了这个美梦");
        list.add("我们付出了代价");

        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String s = it.next();
            if ("辉煌".equals(s)) {
                it.add("哈哈"); // 普通迭代器iterator没有 add方法
            }
        }

        /*ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String s = it.next();
            if ("辉煌".equals(s)) {
                list.remove("辉煌");
            }
        }*/
        System.out.println(list);
    }
}
