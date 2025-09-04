package com.javalearn.p1_collotion;

import com.javalearn.domain.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CollectionDemo2 {
    /*
        集合的通用遍历方式
                public Iterator<E> iterator() : 返回此集合中的元素的迭代器。
                public E next() : 从集合中获取一个元素。
                public boolean hasNext() : 如果迭代具有更多元素，则返回 true 。

                注意：如果调用多次next方法，当集合中没有元素时，就会报出 NoSuchElementException异常
     */
    public static void main(String[] args) {
        method3();
    }

    /**
     * 使用 foreach 方法遍历集合
     */
    private static void method3() {
        Collection<Student> c = new ArrayList<>();

        c.add(new Student("张三", 23));
        c.add(new Student("李四", 24));
        c.add(new Student("王五", 25));

        c.forEach(System.out::println);
    }

    /**
     * 增强 for循环
     */
    private static void method2() {
        Collection<Student> c = new ArrayList<>();

        c.add(new Student("张三", 23));
        c.add(new Student("李四", 24));
        c.add(new Student("王五", 25));

        // 增强for循环
        for (Student stu : c) {
            System.out.println(stu);
        }
    }

    /**
     * 迭代器
     */
    private static void method1() {
        Collection<Student> c = new ArrayList<>();

        c.add(new Student("张三", 23));
        c.add(new Student("李四", 24));
        c.add(new Student("王五", 25));

        // 1. 获取迭代器
        Iterator<Student> it = c.iterator();

        // 2. 循环判断，集合中是否还有元素
        while (it.hasNext()) {
            // 3. 调用 next方法，将元素取出
            System.out.println(it.next());
        }

        // 非正常情况
        /*while (true) {
            try {
                Student stu = it.next();
                System.out.println(stu);
            } catch (NoSuchElementException e) {
                break;
            }
        }*/
    }
}
