package com.javalearn.p1_generics;

import java.util.ArrayList;
import java.util.ListIterator;

public class GenericsDemo1 {
    /*
        泛型的介绍：JDK5引入的，可以在编译阶段约束操作的数据类型，并进行检查

        注意 ： 泛型默认的类型是Object

        泛型的好处 ：

                1. 统一数据类型
                2. 将运行期错误提升了编译期

        泛型的学习路径 ：

                1. 泛型类
                2. 泛型方法
                3. 泛型接口
                4. 泛型通配符
                5. 泛型的限定
     */
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("张三");
        list.add("李四");
        list.add("王五");

        ListIterator<String> iterator = list.listIterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
    }
}
