package com.javalearn.mobject.p1_tostring;

import com.javalearn.mobject.p2_equals.Student;

public class ToStringDemo {
    /*
        public String toString()  返回对象的字符串表示形式。

            public String toString() {
                return getClass().getName() + "@" + Integer.toHexString(hashCode());
            }

            getClass().getName() : 类名称，全类名(包名 + 类名)
            Integer.toHexString() : 转十六进制
            hashCode() : 返回的是对象的内存地址 + 哈希算法，算出来的整数(哈希值)

          -----------------------------------------------------------------

          细节 : 使用打印语句，打印对象名的时候，println方法，源码层面，会自动调用toString方法。

          public static String valueOf(Object obj) {
                return (obj == null) ? "null" : obj.toString();
          }
     */
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);
        System.out.println(a.toString());

        Student stu = new Student("张三", 23);
        System.out.println(stu);

    }
}

class A {

}
