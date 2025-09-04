package com.java_learn.p2_thread_method;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 19:57
 */
public class ThreadMethodDemo01 {
    /*
        休眠线程的方法
            public static void sleep(long time) : 让线程休眠指定时间，单位为毫秒
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println("倒计时:" + (i + 1) + "秒");
            Thread.sleep(1000);
        }
    }
}
