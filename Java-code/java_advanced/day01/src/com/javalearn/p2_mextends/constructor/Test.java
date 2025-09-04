package com.javalearn.p2_mextends.constructor;

public class Test {
    /*
        除了Object类，在所有构造方法的第一行代码，都默认隐藏了一句话 super();
        通过这句代码，访问父类的空参构造方法

        细节 -- Java当中所有的类，都直接或间接的继承到了 Object类
     */
    public static void main(String[] args) {
        Zi z1 = new Zi();
        Zi z2 = new Zi(10);
    }
}
class Fu {
    public Fu() {
        System.out.println("父类的空参构造方法");
    }

    public Fu(int num) {
        System.out.println("父类的带参构造方法。。。");
    }
}
class Zi extends Fu {
    public Zi() {
        // super();
        System.out.println("Zi类空参构造方法");
    }
    public Zi(int num) {
        super();
        System.out.println("Zi类带参构造方法。。。");
    }
}
