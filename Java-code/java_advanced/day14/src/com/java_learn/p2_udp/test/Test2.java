package com.java_learn.p2_udp.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // writeObject();
        readObject();
    }

    private static void readObject() throws IOException, ClassNotFoundException {
        // writeObject();
        // 准备反序列化流，读取对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\stu.txt"));
        ArrayList<Student> list = (ArrayList<Student>) ois.readObject(); // 向下转型，可以通过循环遍历list
        for (Student stu : list) {
            System.out.println(stu);
        }
        ois.close();
    }

    private static void writeObject() throws IOException {
        Student stu1 = new Student("张三", 23);
        Student stu2 = new Student("李四", 24);
        Student stu3 = new Student("王五", 25);

        ArrayList<Student> list = new ArrayList<>();
        Collections.addAll(list, stu1, stu2, stu3);

        // 准备序列化流,写出对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\stu.txt"));
        oos.writeObject(list);
        oos.close();
    }
}
