package com.javalearn.p2_exception;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo2 {
    /*
        编译时异常 ： 编译阶段就出现的错误 (语法错误不算)
                        - 需要在运行之前，给出解决方案
        运行时异常 ： 编译过了，运行期间 [可能会出现的错误]
     */
    public static void main(String[] args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = sdf.parse("2003年8月28日"); // 运行时异常，提醒某段代码极可能出错
        System.out.println(date);
    }
}
