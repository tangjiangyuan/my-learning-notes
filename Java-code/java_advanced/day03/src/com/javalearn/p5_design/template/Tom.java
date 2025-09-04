package com.javalearn.p5_design.template;

public class Tom extends CompositionTemplate{
    // 子类重写父类中的抽象方法，编写子类需要的模板方法
    @Override
    public void body() {
        System.out.println("那是一个秋天，风儿那么缠绵，" +
                "记忆中爸爸骑车接我放学回家，我的脚卡在了车链中，爸爸蹬不动，他就站起来蹬。。。QAQ");
    }
}
