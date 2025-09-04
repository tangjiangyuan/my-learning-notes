package com.javalearn.p2_exception;

public class ThrowableMethodDemo {
    /*
        Throwable 常用方法 ：

                public String getMessage();         获取异常的错误原因
                public void printStackTrace();      展示完整的异常错误信息
     */
    public static void main(String[] args) {

        System.out.println("开始");

        try {
            System.out.println(10 / 0);
        } catch (Exception e) {
            String message = e.getMessage();
            System.out.println(message);
        }

        System.out.println("结束");
    }
}
