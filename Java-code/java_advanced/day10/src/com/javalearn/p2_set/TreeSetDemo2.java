package com.javalearn.p2_set;

import com.javalearn.domain.Student;

import java.util.TreeSet;

public class TreeSetDemo2 {
    /*
        TreeSet 集合存储 Student学生对象

        compareTo 方法的返回值：

                0 : 只有张三 23
                1 : 正序排序
                -1 : 倒叙排序

                取出顺序 ： 左 中 右
     */
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>();

        /*
            当我们调用 add方法，向TreeSet添加元素的时候，内部会自动调用 compareTo方法
            根据这个方法的返回值，来决定节点怎么走
         */
        ts.add(new Student("张三", 25));
        ts.add(new Student("李四", 25));
        ts.add(new Student("王五", 25));
        ts.add(new Student("赵六", 25));

        System.out.println(ts);
    }
}
