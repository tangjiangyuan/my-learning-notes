package com.javalearn.mobject.p2_equals;

import java.util.Objects;

public class EqualsDemo {
    /*
        Object 类中的 equals()方法 :
            boolean equals(Object obj) 指示一些其他对象是否等于此。

            public boolean equals(Object obj) {
                // this : stu1
                // obj : stu2
                return (this == obj);
            }

            结论 : Object类中的equals方法，默认比较的是对象内存地址
                - 通常会重写 equals方法，让对象之间，比较内容
     */
    public static void main(String[] args) {
        Student stu1 = null;
        Student stu2 = new Student("张三", 23);

        System.out.println(Objects.isNull(stu1)); // true
        System.out.println(Objects.isNull(stu2)); // false

        // 问题: Object.equals方法，和 stu1.equals方法，有什么区别？
        // 细节: Object.equals方法，内部依赖于我们自己所编写的equals
        // 好处: Object.equals方法，内部带有非null判断(不会抛出空指针异常，也就不会影响程序的运行)
        // System.out.println(stu1.equals(stu2));

        /*
            public static boolean equals(Object a, Object b) {

                ------------------------------------------------------------------
                a == b : 如果地址值相同，则返回true，短路 || 后面的判断就不执行了
                       : 如果地址值不相同，则返回false，短路 || 后面的判断继续执行
                ------------------------------------------------------------------
                a != null : 假设 a 是 null 值

                        null != null : false
                        && : 左边为false，右边不执行，记录着null值的a，就不会调用equals方法
                                - 避免空指针异常
                ------------------------------------------------------------------
                a != null : 假设 a 不是 null 值

                        stu1 != null : true
                        && : 左边为true，右边继续执行，a.equals(b)，这里就不会出现空指针异常
                ------------------------------------------------------------------

                return (a == b) || (a != null && a.equals(b));
            }
         */
        System.out.println(Objects.equals(stu1, stu2));

    }
}
