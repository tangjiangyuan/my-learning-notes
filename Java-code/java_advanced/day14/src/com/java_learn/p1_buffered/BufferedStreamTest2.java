package com.java_learn.p1_buffered;

import java.io.*;
import java.util.ArrayList;

public class BufferedStreamTest2 {
    /*
        案例 --- 读写 Student学生信息
        现有三个学生对象 (张三,23) (李四,24) (王五,25)
        请将这些学生对象的信息保存到本地文件中 D:\stu.txt
        每个学生信息占一行，格式要求
        张三-23
        李四-24
        王五-25
        随后读取这个文件，将学生信息读取到程序，封装为对象，并存入集合
        最后遍历打印集合中的学生信息
     */
    public static void main(String[] args) throws IOException {
        // writeObjectInfos();
        // 准备集合接收对象信息
        ArrayList<Student> list = new ArrayList<>();
        // 准备 字符输入流读取文件
        BufferedReader br = new BufferedReader(new FileReader("D:\\stu.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            Student stu = new Student(line.split("-")[0], Integer.parseInt(line.split("-")[1]));
            list.add(stu);
        }
        br.close();
        for (Student stu : list) {
            System.out.println(stu);
        }
    }

    private static void writeObjectInfos() throws IOException {
        Student stu1 = new Student("张三", 23);
        Student stu2 = new Student("李四", 24);
        Student stu3 = new Student("王五", 25);

        // 准备 字符输出流写出数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\stu.txt"));
        bw.write(stu1.getName() + "-" + stu1.getAge());
        bw.newLine();
        bw.write(stu2.getName() + "-" + stu2.getAge());
        bw.newLine();
        bw.write(stu3.getName() + "-" + stu3.getAge());
        bw.newLine();

        bw.close();
    }
}
