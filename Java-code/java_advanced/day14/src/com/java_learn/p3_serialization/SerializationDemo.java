package com.java_learn.p3_serialization;

import com.java_learn.bean.Student;

import java.io.*;

public class SerializationDemo {
    /*
        序列化流
        构造方法
        序列化 --- ObjectOutputStream(OutputStream out)
        反序列化 --- ObjectInputStream(InputStream in)
        成员方法
            readObject();
            writeObject();
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // writeObject();
         readObject();
    }

    private static void readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\stu.txt"));
        Object o = ois.readObject();
        System.out.println(o);

        ois.close();
    }

    private static void writeObject() throws IOException {
        Student stu = new Student("张三", 23);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\stu.txt"));

        /*
            使用序列流写出的对象必须实现 Serializable接口，才能写出
            否则会报错 --- NotSerializableException
            该接口中没有抽象方法，相当于一个标记
         */
        oos.writeObject(stu);
        oos.close();
    }
}
