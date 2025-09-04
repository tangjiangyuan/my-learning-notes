package com.java_learn.p2_enum;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 23:50
 */
public class EnumTest {
    /*
        枚举介绍 : Java中的一种特殊类型，常用于信息的标志和分类
            1. 常量
            2. 枚举 : 入参严谨，提示性更强，代码优雅
     */
    public static void main(String[] args) {
        method(Season.SPRING);

        System.out.println(Season.SPRING.ordinal());
        System.out.println(Season.SUMMER.ordinal());
        System.out.println(Season.AUTUMN.ordinal());
        System.out.println(Season.WINTER.ordinal());
    }

    public static void method(Season season) {
        switch (season) {
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
            default :
                System.out.println("错误");
                break;
        }
    }
}

enum Season {
    // 枚举项 : 枚举类的对象
    SPRING("春天"), SUMMER("夏天"), AUTUMN("秋天"), WINTER("冬天");

    String name;

    private Season(String name) {
        this.name = name;
    }
}
