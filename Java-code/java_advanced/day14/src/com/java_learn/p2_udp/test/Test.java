package com.java_learn.p2_udp.test;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // writeObject();
        // 准备反序列化流，读取对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\stu.txt"));
        while (true) {
            try {
                Object o = ois.readObject(); // 反序列流读取到末尾没有标志，只会报错，因此可以 try...catch
                System.out.println(o);
            } catch (EOFException e) { // 捕获到 EOF异常就结束循环
                break;
            }
        }
        ois.close();
    }

    private static void writeObject() throws IOException {
        Student stu1 = new Student("张三", 23);
        Student stu2 = new Student("李四", 24);
        Student stu3 = new Student("王五", 25);

        // 准备序列化流,写出对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\stu.txt"));
        oos.writeObject(stu1);
        oos.writeObject(stu2);
        oos.writeObject(stu3);
        oos.close();
    }
}
