package com.javalearn.p1_collotion;

import com.javalearn.domain.Student;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    /*
        Collection 的常用方法：

                public boolean add(E e) : 把给定的对象添加到当前集合中
                public void clear() : 清空集合中所有的元素
                public boolean remove(E e) : 把给定的对象在当前集合中删除
                public boolean contains(Object obj) : 判断当前集合中是否包含给定的对象
                public boolean isEmpty() : 判断当前集合是否为空
                public int size() : 返回集合中元素的个数(集合的长度)
     */
    public static void main(String[] args) {

        // 多态
        Collection<Student> c = new ArrayList<>();

        c.add(new Student("张三", 23));
        c.add(new Student("李四", 24));
        c.add(new Student("王五", 25));

        System.out.println(c);

        // remove() 方法，在删除数据时，比较的是地址值，想要删除数据，需要重写对象的equals方法
        c.remove(new Student("李四", 24));
        System.out.println(c);

        // contains() 方法，同样依赖重写的equals方法
        System.out.println(c.contains(new Student("李四", 24)));
    }

    private static void method() {
        Collection<String> c = new ArrayList<>();

        c.add("张三");
        c.add("李四");
        c.add("王五");

        System.out.println(c);

        boolean b = c.remove("李四");
        System.out.println(b);
        System.out.println(c);

        c.clear();
        System.out.println(c);
    }
}
