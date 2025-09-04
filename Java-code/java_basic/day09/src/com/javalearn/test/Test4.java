package com.javalearn.test;

import com.javalearn.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Test4 {
    /*
        需求 : 定义一个方法，方法接收一个集合对象（泛型为Student）
            方法内部将年龄低于18的学生对象找出
            并存入新集合对象，方法返回新集合
     */
    public static void main(String[] args) {
        // 1. 定义第一个集合，用来存放所有学生信息
        ArrayList<Student> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("请问你要输入几名学生的信息?");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println("---请输入第" + (i + 1) + "名学生的信息---");
            // 2. 调用该方法，用来添加学生信息
            addStudentsInfos(list);
        }

        // 3. 调用checkAgeList() 方法，用来筛选符合条件的学生信息，并返回第二个集合
        ArrayList<Student> ageList = checkAgeList(list);

        for (int i = 0; i < ageList.size(); i++) {// 遍历第二个集合，获取信息
            Student student = ageList.get(i);
            System.out.println(student.getName() + "---" + student.getAge());
        }
    }

    /**
     * 筛选年龄低于18的学生信息
     *
     * @param list
     */
    private static ArrayList<Student> checkAgeList(ArrayList<Student> list) {

        ArrayList<Student> ageList = new ArrayList<>();// 定义第二个集合，用来存放符合条件的学生信息

        for (int i = 0; i < list.size(); i++) {// 遍历第一个集合，获取所有学生信息
            Student student = list.get(i);

            if (student.getAge() < 18) {// 进行判断

                ageList.add(student);// 符合，存入第二个集合
            }
        }
        return ageList;
    }

    /**
     * 添加学生信息
     *
     * @param list
     */
    public static void addStudentsInfos(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名:");
        String name = sc.next();
        System.out.println("请输入年龄:");
        int age = sc.nextInt();

        Student student = new Student(name, age);
        list.add(student);
    }
}
