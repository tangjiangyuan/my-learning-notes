package com.javalearn.demo;

import com.javalearn.domain.Student;

import java.util.ArrayList;

public class ArrayListDemo {
    /*
        查找集合中id的索引位置
     */
    public static void main(String[] args) {

        Student stu1 = new Student("001","张三",23,"2012-11-22");
        Student stu2 = new Student("002","李四",24,"2012-08-11");
        Student stu3 = new Student("003","王五",25,"2012-12-23");

        ArrayList<Student> list = new ArrayList<>();

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        String id = "001";

        int index = getIndex(id, list);
        System.out.println(index);
    }

    private static int getIndex(String id, ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
