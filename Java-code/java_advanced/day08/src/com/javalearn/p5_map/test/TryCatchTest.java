package com.javalearn.p5_map.test;

import com.javalearn.p2_exception.StudentAgeException;
import com.javalearn.p5_map.test.domain.Student;

import java.util.Scanner;

public class TryCatchTest {
    /*
        需求 ： 键盘录入学生的姓名和年龄，封装为Student学生对象
     */
    public static void main(String[] args) {

        Student stu = new Student();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生的姓名:");
        String name = sc.nextLine();
        stu.setName(name);

        System.out.println("请输入学生的年龄:");
        int age = 0;
        while (true) {
            try {
                age = Integer.parseInt(sc.nextLine());
                stu.setAge(age);
                break;
            } catch (NumberFormatException e) {
                System.out.println("年龄输入错误，请输入整数类型的年龄:");
            } catch (StudentAgeException e) { // Exception e = new Exception("年龄范围有误，应该在0~120之间！");
                String message = e.getMessage(); // e.getMessage() 方法获取构造方法中的字符串参数
                System.out.println(message);
            }
        }

        System.out.println(stu);
    }
}
