package com.javalearn.p1_collotion.list;

import java.util.LinkedList;

public class LinkedListDemo {
    /*
        LinkedList 底层是基于双链表实现的，查询元素慢，增删首尾元素是非常快的。

        LinkedList 特有方法：

                public void addFirst(E e) : 头部添加
                public void addLast(E e) : 尾部添加
                public E getFirst() : 获取第一个
                public E getLast() :  获取最后一个
                public E removeFirst() : 删除第一个
                public E removeLast() : 删除最后一个
     */
    /*
        LinkedList 集合，底层是双向链表结构，查找元素的时候会从头部，或者尾部逐个查找，
        但是它是属于 List体系中的集合，也可以使用 get方法，根据索引直接获取元素.

        通过 get方法获取传入的索引，get方法中再调用一个node(结点)方法，将传入的索引与结点通过位运算之后的值比较
        如果小于该值，则从头部开始查找，否则，从尾部开始查找
     */
    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        list.add("张三");
        list.add("李四");
        list.add("王五");

        String s = list.get(1);
        System.out.println(s);

    }

    private static void method2() {
        LinkedList<String> list = new LinkedList<>();

        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        list.removeFirst();
        list.removeLast();

        System.out.println(list);
    }

    private static void method1() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("张三");
        list.addFirst("李四");
        list.addFirst("王五");
        list.addLast("赵六");

        System.out.println(list);
    }
}
