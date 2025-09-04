package com.javalearn.mobject.p3_math;

public class MathDemo {
    /*
        Math 类: 包含执行基本数字运算的方法
        --------------------------------------------------------------------
        public static int abs(int a) : 获取参数绝对值
        public static double ceil(double a) : 向上取整
        public static double floor(double a) : 向下取整
        public static int round(float a) : 四舍五入
        public static int max(int a, int b) : 获取两个int值中的最大值
        public static double pow(double a, double b) : 返回a的b次幂的值
        public static double random() : 返回值为double的随机值，范围[0.0, 1.0) 无限接近 1
        --------------------------------------------------------------------
     */
    public static void main(String[] args) {

        System.out.println(Math.abs(-123));
        System.out.println(Math.abs(-12.3));

        System.out.println("------------------");

        System.out.println(Math.ceil(12.0));
        System.out.println(Math.ceil(12.2));
        System.out.println(Math.ceil(12.4));
        System.out.println(Math.ceil(12.8));

        System.out.println("------------------");

        System.out.println(Math.floor(12.0));
        System.out.println(Math.floor(12.5));
        System.out.println(Math.floor(12.8));

        System.out.println("------------------");

        System.out.println(Math.round(12.4));
        System.out.println(Math.round(12.6));

        System.out.println("------------------");

        System.out.println(Math.max(10, 20));
        System.out.println(Math.min(10, 20));

        System.out.println("------------------");

        System.out.println(Math.pow(2, 3));

        System.out.println("------------------");

        System.out.println(Math.random());
    }
}
