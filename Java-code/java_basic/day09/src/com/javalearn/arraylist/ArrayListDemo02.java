package com.javalearn.arraylist;

import java.util.ArrayList;

public class ArrayListDemo02 {
    /*
        ArrayList集合常用成员方法

            1. 增
                    public boolean add(E e) : 将指定的元素追加到此列表的末尾。
                    public void add(int index, E element) : 在此列表中的指定位置插入指定的元素。

            2. 删
                    public E remove(int index) : 根据索引做删除，返回被删除的元素。
                    public boolean remove(Object o) : 根据元素做删除。

            3. 改
                    public E set(int index, E element) : 修改指定索引位置，为对应的元素。返回被覆盖掉的元素。

            -----------------------------------------------------------------------------------------
                    以上方法，返回值通常不做接收

            4. 查
                    public E get(int index) : 根据索引，获取元素
                    public int size() : 返回集合中，元素的个数
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("张三1");
        list.add("张三2");
        list.add("张三3");
        list.add("张三4");

        String e1 = list.get(1);
        System.out.println(e1);
        System.out.println(list.size());

    }

    /**
     * 修改元素
     */
    private static void updateMethod() {
        ArrayList<String> list = new ArrayList<>();

        list.add("张三1");
        list.add("张三2");
        list.add("张三3");
        list.add("张三4");

        list.set(1,"张三5");
        System.out.println(list);
    }

    /**
     * 删除元素
     */
    private static void removeMethod() {
        ArrayList<String> list = new ArrayList<>();

        list.add("张三1");
        list.add("张三2");
        list.add("张三3");
        list.add("张三4");
        System.out.println(list);

        list.remove(1);// 根据索引删除
        System.out.println(list);

        list.remove("张三3");// 根据元素删除
        System.out.println(list);
    }

    /**
     * 增加元素
     */
    private static void addMethod() {
        ArrayList<String> list = new ArrayList<>();

        list.add("张三1");
        list.add("张三2");
        list.add("张三3");

        System.out.println(list);

        list.add(0,"张三4");
        System.out.println(list);
    }
}
