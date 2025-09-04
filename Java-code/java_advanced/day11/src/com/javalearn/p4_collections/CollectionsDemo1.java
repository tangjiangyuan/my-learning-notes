package com.javalearn.p4_collections;

import com.javalearn.domain.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsDemo1 {
    /*
        Collections 集合工具类
     */
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        // 批量添加元素
        Collections.addAll(list, "a", "b", "c", "d");
        System.out.println(list);

        // 二分查找(前提：排好序的数据)
        int index = Collections.binarySearch(list, "c");
        System.out.println("'c' 的索引是:" + index);

        // 打乱（洗牌）
        Collections.shuffle(list);
        System.out.println(list);

        // 求最大、最小值
        ArrayList<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 1, 2, 3, 4, 5, 6);

        System.out.println("最大值:" + Collections.max(nums));
        System.out.println("最小值:" + Collections.min(nums));

        System.out.println("------");

        ArrayList<Student> stu = new ArrayList<>();
        Collections.addAll(stu, new Student("张三", 12),
                new Student("李四", 24),
                new Student("王五", 25));
        System.out.println(Collections.max(stu));
        System.out.println(Collections.min(stu));

        // 交换 (通过索引交换元素)
        Collections.swap(stu, 0, 2);
        System.out.println(stu);

        // sort ： 对集合排序
        ArrayList<Integer> box = new ArrayList<>();
        Collections.addAll(box, 1, 3, 5, 2, 4);
        Collections.sort(box, (o1, o2) -> o2 - o1);
        System.out.println(box);
    }
}
