package com.javalearn.p2_method;

public class MethodDemo01 {
    /*

        方法（函数）介绍 ：一段具有独立功能的代码段，不调用就不执行。
        方法的优点：可以将挤在一起的臃肿代码，按照功能进行分类管理，提高代码的可阅读性；提高代码复用性。
        方法定义格式：
                public static void 方法名() {
                    方法体
                }

         方法调用格式：
                方法名();

          注意事项：
                （1）方法与方法之间是平级关系，不允许嵌套定义
                （2）方法不调用就不执行
                （3）方法的定义顺序，和执行顺序无关，要想梳理执行顺序，就看调用顺序。
     */
    public static void main(String[] args) {
        farmer();
        cook();
        consumer();
    }

    public static void farmer() {
        System.out.println("种地");
        System.out.println("除草");
        System.out.println("收割");
    }

    public static void cook() {
        System.out.println("洗菜");
        System.out.println("做菜");
    }

    public static void consumer() {
        System.out.println("点菜");
        System.out.println("用菜");
    }
}
