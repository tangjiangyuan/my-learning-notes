package com.javalearn.p5_design.adapter;

public class AdapterDemo02 {
    /*
        当一个类实现了一个接口，但又不想重写所有抽象方法时，可定义一个Adapter适配器的类
            - 再定义一个类继承这个适配器的类，就可以重写自己需要的抽象方法了
     */
    public static void main(String[] args) {

    }
}
interface 和尚 {
    void 打坐();
    void 念经();
    void 撞钟();
    void 习武();
}
abstract class 和尚Adapter implements 和尚{ // 抽象类不能创建对象，如果允许创建对象，即可调用内部没有方法体的方法了，毫无意义。

    @Override
    public void 打坐() {

    }

    @Override
    public void 念经() {

    }

    @Override
    public void 撞钟() {

    }

    @Override
    public void 习武() {

    }
}

class 鲁智深 extends 和尚Adapter {
    @Override
    public void 习武() {
        System.out.println("拳打镇关西");
        System.out.println("倒把垂杨柳");
    }
}

class 唐僧 extends 和尚Adapter {
    @Override
    public void 打坐() {
        super.打坐();
    }

    @Override
    public void 念经() {
        super.念经();
    }

    @Override
    public void 撞钟() {
        super.撞钟();
    }
}
