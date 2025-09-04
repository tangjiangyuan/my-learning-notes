package com.javalearn.mobject.p5_bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {
    /*
        BigDecimal : 用于解决小数运算中,出现的不精确问题

        BigDecimal 创建对象 :

                public BigDecimal(double val) : 不推荐，无法保证小数运算的精确
                public BigDecimal(String val)
                public static BigDecimal valueOf(double val)

        BigDecimal 常用成员方法 :

                public BigDecimal add(BigDecimal b) : 加法
                public BigDecimal subtract(BigDecimal b) : 减法
                public BigDecimal multiply(BigDecimal b) : 乘法
                public BigDecimal divide(BigDecimal b) : 除法
                public BigDecimal divide(另一个BigDecimal对象，精确几位，舍入模式) : 除法

        注意 : 如果使用BigDecimal运算，出现了除不尽的情况，就会出现异常
     */
    public static void main(String[] args) {

        double num1 = 0.1;
        double num2 = 0.2;
        // System.out.println(num1 + num2); // 0.30000000000000004

        BigDecimal bd1 = BigDecimal.valueOf(10.0);
        BigDecimal bd2 = BigDecimal.valueOf(3.0);
        System.out.println(bd1.divide(bd2, 2, RoundingMode.HALF_UP)); // 四舍五入
        System.out.println(bd1.divide(bd2, 2, RoundingMode.UP)); // + 1
        System.out.println(bd1.divide(bd2, 2, RoundingMode.DOWN)); // 截取，即小数点后两位的数据都不要了

        System.out.println("--------------------------------------------------------");

        BigDecimal result = bd1.divide(bd2, 2, RoundingMode.HALF_UP);

        double v = result.doubleValue();

        Math.abs(v);

    }

    private static void method() {
        BigDecimal bd1 = BigDecimal.valueOf(0.1);
        BigDecimal bd2 = BigDecimal.valueOf(0.2);

        System.out.println(bd1.add(bd2));
        System.out.println(bd1.subtract(bd2));
        System.out.println(bd1.multiply(bd2));
        System.out.println(bd1.divide(bd2));
    }

    private static void createObj3() {
        BigDecimal bd1 = BigDecimal.valueOf(0.1);
        BigDecimal bd2 = BigDecimal.valueOf(0.2);
        System.out.println(bd1.add(bd2));
    }

    private static void createObj2() {
        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");
        System.out.println(bd1.add(bd2));
    }

    private static void createObj1() {
        BigDecimal bd1 = new BigDecimal(0.1);
        BigDecimal bd2 = new BigDecimal(0.2);
        // System.out.println(bd1.add(bd2)); // 0.3000000000000000166533453693773481063544750213623046875
    }
}
