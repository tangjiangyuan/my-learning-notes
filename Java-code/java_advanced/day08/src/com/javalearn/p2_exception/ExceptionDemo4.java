package com.javalearn.p2_exception;

import java.io.FileReader;
import java.text.ParseException;

public class ExceptionDemo4 {
    /*
        子类重写父类方法时，不能抛出父类没有的异常，或者比父类更大的异常
     */
    public static void main(String[] args) {

    }
}

class Fu {

    public void show() throws ParseException {

    }

}

class Zi extends Fu {

    @Override
    public void show() {

    }
}
