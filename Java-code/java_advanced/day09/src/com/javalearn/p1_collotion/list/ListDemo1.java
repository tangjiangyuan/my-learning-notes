package com.javalearn.p1_collotion.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
    /*
        List 接口的特点 ： 存取有序，有索引，可以存储重复的元素

        和索引有关的API ：

            public void add(int index, E element) : 在指定的索引位置，添加元素
            public E remove(int index) : 根据索引删除集合中的元素
            public E set(int index, E element) : 根据索引修改集合的元素
            public E get(int index) : 返回指定索引处的元素
     */
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(111);
        list.add(222);
        list.add(333);

        list.remove(Integer.valueOf(222)); // 如果不装箱，删除的是222索引处的元素，造成索引越界异常
        System.out.println(list);
    }

    private static void method1() {
        List<String> list = new ArrayList<>();

        list.add("张三");
        list.add("李四");
        list.add("王五");

        System.out.println(list);

        list.add(0, "赵六");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);

        list.set(1, "Tom");
        System.out.println(list);
    }
}
