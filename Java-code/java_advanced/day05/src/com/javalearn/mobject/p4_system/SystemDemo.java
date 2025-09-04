package com.javalearn.mobject.p4_system;

public class SystemDemo {
    /*
        System 类常见方法 :

            1. public static void exit(int status) : 终止当前运行的 JAVA虚拟机，非零表示异常终止
            2. public static long currentTimeMillis() : 返回当前系统的时间毫秒值形式
                    - 返回 1970年1月1日，0时0分0秒(c语言生日)，到现在所经历过的毫秒值
            3. public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) : 拷贝数据

                                1. Object src : 数据源数组
                                2. int srcPos : 起始索引
                                3. Object dest : 目的地数组
                                4. int destPos : 起始索引
                                5. int length : 拷贝个数
     */
    public static void main(String[] args) {

        //  3. public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) : 拷贝数据
        int[] arr = {11, 22, 33, 44, 55};
        int[] destArr = new int[3];

        System.arraycopy(arr, 2, destArr, 0, 3);

        for (int i = 0; i < destArr.length; i++) {
            System.out.println(destArr[i]);
        }
    }

    private static void method2() {

        // 2. public static long currentTimeMillis() : 返回当前系统的时间毫秒值形式
        long start = System.currentTimeMillis();

        String s = "";
        for (int i = 1; i <= 10000; i++) {
            s += i;
        }

        System.out.println(s);

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
