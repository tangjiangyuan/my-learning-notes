package com.java_learn.p4_reflect;

import java.lang.reflect.Constructor;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/25 15:15
 */
public class ReflectDemo02 {
    /*
        反射类中的构造方法
        1. Constructor<?>[] getConstructors()               返回所有公共构造方法对象的数组(只能拿到public)
        2. Constructor<?>[] getDeclaredConstructors()       返回所有构造方法对象的数组(private)
        3. Constructor<T> getConstructor(Class<?>...parameterType)              返回单个公共构造方法对象
        4. Constructor<T> getDeclaredConstructor(Class<?>...parameterType)      返回单个构造方法对象
        创建对象的方法
        1. T newInstance(Object...initargs)     根据指定的构造方法创建对象
        2. setAccessible(boolean flag)          设置为true，表示取消访问检查
     */
    public static void main(String[] args) throws Exception {
        // 1. 获取类的字节码对象
        Class<?> stuClass = Class.forName("com.java_learn.domain.Student");
        // 2. 反射构造方法对象
        // 根据参数确定要获取的构造方法是哪个
        Constructor<?> constructor = stuClass.getDeclaredConstructor(String.class, int.class);
        // 暴力反射之后都会调用该方法，打开权限
        constructor.setAccessible(true); // 打开构造方法的权限
        System.out.println(constructor);
        // 3. 通过构造方法对象，实例化
        Object o = constructor.newInstance("张三", 23);
        System.out.println(o);
    }

    private static void constructorMethod1(Class<?> stuClass) {
        Constructor<?>[] constructors = stuClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
