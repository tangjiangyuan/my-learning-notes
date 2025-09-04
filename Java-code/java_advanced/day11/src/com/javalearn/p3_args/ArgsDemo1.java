package com.javalearn.p3_args;

public class ArgsDemo1 {
    /*
        args : 参数
        可变参数 : 数据类型...参数名(参数名实际是数组名)
        注意 : 在使用可变参数时，还需要添加其他参数时，可变参数必须放在最后
     */
    public static void main(String[] args) {

        System.out.println(getSum(1, 2));
        System.out.println(getSum(1, 2, 3));
    }

    public static int getSum(int...nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    /*public static int getSum(int a, int b) {
        return a + b;
    }

    public static int getSum(int a, int b, int c) {
        return a + b + c;
    }

    public static int getSum(int a, int b, int c, int d) {
        return a + b + c + d;
    }*/
}
