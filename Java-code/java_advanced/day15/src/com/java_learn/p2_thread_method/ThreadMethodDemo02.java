package com.java_learn.p2_thread_method;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 19:57
 */
public class ThreadMethodDemo02 {
    /*
        线程优先级的方法 :
            public setPriority(int newPriority) : 设置线程优先级
            public final int getPriority() : 获取线程优先级
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "执行了:" + (i + 1));
                }
            }
        }, "线程A: ");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "执行了:" + (i + 1));
                }
            }
        }, "线程B: ");

        t1.setPriority(1);
        t2.setPriority(10);

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        t1.start();
        t2.start();
    }
}
