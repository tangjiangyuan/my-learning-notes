package com.javalearn.b;

import com.javalearn.a.Fu;

/*
    和 Fu 类的关系
        - 不同包下的子类
 */
public class Zi extends Fu {
    public void method() {
        super.show();
    }
}
