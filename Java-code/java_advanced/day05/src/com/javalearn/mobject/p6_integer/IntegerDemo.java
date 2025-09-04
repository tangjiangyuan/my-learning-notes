package com.javalearn.mobject.p6_integer;

public class IntegerDemo {
    /*
        包装类 : 将基本数据类型，包装成类，变成引用数据类型
        --------------------------------------------------------
        手动装箱 : 调用方法，手动将基本数据类型，包装成类

                1. public Integer(int value) : 通过构造方法(已过时，不推荐)
                2. public static Integer valueOf(int i) : 通过静态方法

        手动拆箱 : 调用方法，手动将包装类，拆成（转换为）基本数据类型

                1. public int intValue() : 以 int 类型返回该 Integer的值


        --------------------------------------------------------
        JDK5版本开始，出现了自动拆装箱 :

                1. 自动装箱 : 可以将基本数据类型，直接赋值给包装类的变量
                2. 自动拆箱 : 可以将包装类的数据，直接赋值给基本数据类型的变量

        结论 : 基本数据类型，和对应的包装类，可以直接做运算了，不需要操心转换的问题了
    */
    public static void main(String[] args) {

        int num = 10;
        Integer i1 = Integer.valueOf(num);
        int num_i = i1.intValue();

        System.out.println("--------------------");

        int num2 = 10;
        Integer i2 = num2;
        int  num_i2 = i2;

    }
}
