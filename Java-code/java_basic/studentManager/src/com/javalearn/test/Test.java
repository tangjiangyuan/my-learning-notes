package com.javalearn.test;

import com.javalearn.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        // 用该集合存放学生信息
        ArrayList<Student> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            // 主界面，搭建菜单
            System.out.println("------学生管理系统------");
            System.out.println("1. 添加学生信息");
            System.out.println("2. 删除学生信息");
            System.out.println("3. 修改学生信息");
            System.out.println("4. 查看学生信息");
            System.out.println("5. 退出");
            System.out.println("请输入您的操作:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudentInfos(list);
                    break;
                case 2:
                    removeStudentInfosById(list);
                    break;
                case 3:
                    updateStudentInfosById(list);
                    break;
                case 4:
                    queryStudentsInfos(list);
                    break;
                case 5:
                    System.out.println("感谢您的使用，再见！");
                    System.exit(0); // 0为状态码，这句代码可以终止JVM虚拟机
                    break;
                default:
                    System.out.println("您的输入有误！请重试！");
            }
        }

    }

    /**
     * 添加学生信息
     * @param list
     */
    private static void addStudentInfos(ArrayList<Student> list) {
        // 1. 调用getIndex方法
        Scanner sc = new Scanner(System.in);

        String id = "";

        while (true) {
            System.out.println("请输入学生id:");
            id = sc.next();
            int index = getIndex(id, list);
            if (index == -1) { // 表示输入的id不存在，可以使用
                break;
            } else {
                // 2.1 否则，给出错误提示
                System.out.println("该id被占用，请重新输入！！！"); // 需要进行死循环
            }
        }

        // 2. 返回-1，表示数据中没有该生信息，可以添加
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        int age = sc.nextInt();
        System.out.println("请输入学生生日:");
        String birthday = sc.next();
        // 将输入的学生信息，封装
        Student stu = new Student(id, name, age, birthday);

        list.add(stu);
        System.out.println("添加成功！");
    }

    /**
     * 修改学生信息
     */
    private static void updateStudentInfosById(ArrayList<Student> list) {
        // 1. 键盘录入需要修改学生的id
        System.out.println("请输入要修改学生的id:");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        // 2. 判断该id是否存在
        int index = getIndex(id, list);
        if (index == -1) {
            // 2.1 返回-1，给出错误提示
            System.out.println("查无此人，修改失败！！！");
        } else {
            // 2.2 否则，进行修改
            System.out.println("请输入新的学生姓名:");
            String name = sc.next();
            System.out.println("请输入新的学生年龄:");
            int age = sc.nextInt();
            System.out.println("请输入新的学生生日:");
            String birthday = sc.next();
            // 将新的学生信息，封装为学生对象
            Student stu = new Student(id, name, age, birthday);
            list.set(index, stu);
            System.out.println("修改成功！");
        }

    }

    /**
     * 删除学生信息
     */
    private static void removeStudentInfosById(ArrayList<Student> list) {
        // 1. 键盘录入要删除学生的id
        System.out.println("请输入要删除学生的id:");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        // 2. 调用getIndex方法，获取索引
        int index = getIndex(id, list);
        // 3. 进行判断
        if (index == -1) {
            // 3.1 返回-1，给出错误提示
            System.out.println("查无此人，删除失败！！！");
        } else {
            // 3.2 否则，成功删除
            list.remove(index);
            System.out.println("删除成功！");
        }
    }

    /**
     * 获取集合中学生id的索引
     *
     * @param id
     * @param list
     * @return
     */
    private static int getIndex(String id, ArrayList<Student> list) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getId().equals(id)) {
                return i;// 找到
            }
        }
        return -1;// 没找到
    }

    /**
     * 查看学生信息
     *
     * @param list
     */
    private static void queryStudentsInfos(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("查无信息，请添加后重试！");
        } else {
            System.out.println("学号\t\t\t姓名\t\t\t年龄\t\t\t生日"); // 推荐使用3个制表符
            for (int i = 0; i < list.size(); i++) {
                Student stu = list.get(i);
                System.out.println(stu.getId() + "\t\t\t" + stu.getName() + "\t\t\t" +
                        stu.getAge() + "\t\t\t" + stu.getBirthday());
            }
        }
    }
}
