package com.javalearn.p5_design.template;

public abstract class CompositionTemplate {
    // 假设是一个作文模板
    public final void write() { // 如果模板不希望子类重写，加入 final关键字
        System.out.println("我的爸爸");

        body(); // 不可控制的部分，定义为一个抽象方法

        System.out.println("啊~这就是我的爸爸~");
    }

    public abstract void body();
}
