package com.javalearn.arraylist;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayListDemo01 {
    /*
        ArrayList 集合的使用 :
                细节 : 创建String、StringBuilder、ArrayList类的对象，打印对象名，都没有看到地址值，而是元素内容。

                1. 构造方法
                    public ArrayList() : 创建一个空的集合容器

                2. 集合容器的创建细节 :

                        ArrayList list = new ArrayList();
                        现象 : 可以添加任意类型数据
                        弊端 : 数据不够严谨

                        ArrayList<String> list1 = new ArrayList<>();

                        <> : 泛型
                                目前 : 使用泛型，可以对集合中存储的数据，进行类型限制
                                细节 : 泛型中，不允许编写基本数据类型
                                问题 : 想要在集合中，存储 整数、小数、字符。。。这些数据，应该怎么办？
                                解决 : 使用基本数据类型，所对应的包装类

                                        byte            Byte
                                        short           Short
                                        int             Integer     ***
                                        long            Long
                                        float           Float
                                        double          Double
                                        boolean         Boolean
                                        char            Character   ***
                                        其实只要输入首字母大写即可。
     */
    public static void main(String[] args) {

        test();
    }

    private static void test() {
        // 步骤1：创建一个集合容器，内部存储 11.1 22.2 33.3
        ArrayList<Double> list1 = new ArrayList<>();
        list1.add(11.1);
        list1.add(22.2);
        list1.add(33.3);
        // 步骤2 创建一个集合容器，内部存储 张三、李四、王五
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("张三");
        list2.add("李四");
        list2.add("王五");
        // 步骤3 在控制台展示两个集合中的元素
        System.out.println(list1);
        System.out.println(list2);
    }

    /**
     * 限制list集合的存放数据类型(推荐)
     */
    private static void listPrint2() {
        ArrayList<String> list1 = new ArrayList<>();// jdk 7版本之后，后面尖括号里不用写数据类型
        list1.add("ayaka");
        System.out.println(list1);
    }

    /**
     * list集合存放任意数据类型(不推荐)
     */
    private static void listPrint1() {
        ArrayList list = new ArrayList();

        list.add("张三");
        list.add("李四");
        list.add("王五");

        System.out.println(list);
    }
}
