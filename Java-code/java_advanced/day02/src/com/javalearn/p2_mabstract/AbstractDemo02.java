package com.javalearn.p2_mabstract;

public class AbstractDemo02 {
    /*
        抽象类的注意事项 :

                1. 抽象类不能实例化（即不能创建对象）
                        - 如果允许创建对象，就可以调用内部没有方法体的抽象方法了（无意义）
                2. 抽象类存在构造方法
                        - 交给子类，通过 super访问
                3. 抽象类可以存在普通方法
                        - 可以让子类继承到，继续使用
                4. 抽象类的子类
                        1）要么重写抽象类中的所有抽象方法
                        2）要么是抽象类
     */
    public static void main(String[] args) {
        // 1. 抽象类不能实例化（即不能创建对象）
        // Fu fu = new Fu();
    }
}
abstract class Fu {

    public Fu() {

    }

    public void show() {

    }
}
class Zi extends Fu {

    public Zi() {
        super(); // 访问父类构造方法
    }

    @Override
    public void show() {
        super.show();
    }
}

