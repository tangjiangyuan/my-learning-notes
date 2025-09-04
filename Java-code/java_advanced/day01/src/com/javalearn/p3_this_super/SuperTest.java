package com.javalearn.p3_this_super;

public class SuperTest {
    /*
        super 调用父类成员的省略规则 :

            super.父类成员变量 | super.父类成员方法()

            -> 被调用的变量和方法，在子类中不存在，super. 可以直接省略。
     */
    public static void main(String[] args) {
        Zi z = new Zi();
        z.method();
    }
}
class Fu {
    int num = 10;

    public void show() {
        System.out.println("Fu...Show");
    }
}
class Zi extends Fu {
    public void method() {
        System.out.println(num);
        show();
    }
}
