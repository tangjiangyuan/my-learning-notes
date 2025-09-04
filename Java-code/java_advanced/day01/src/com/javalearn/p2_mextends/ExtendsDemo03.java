package com.javalearn.p2_mextends;

public class ExtendsDemo03 {
    /*
        方法重载(Overload) : 在同一个类中，方法名相同，参数不同（类型不同、个数不同、顺序不同），与返回值无关

        方法重写(Override) : 在子父类中，出现了方法声明一模一样的方法（方法名、参数、返回值）

                目标1 : 能够独立识别出，方法是不是重写的方法
                        - 注解 : @Override

                目标2 : 方法重写的使用场景
                        - 当子类需要父类的方法，但是觉得父类的方法逻辑不好(修改 | 增强)就可以对父类的方法进行重写
     */
    public static void main(String[] args) {
        Son s = new Son();
        s.method();
    }
}
class Father {
    public void method() {
        System.out.println("Father...method...");
    }
}
class Son extends Father{

    @Override
    public void method() {
        System.out.println("Son...method...");
    }
}
