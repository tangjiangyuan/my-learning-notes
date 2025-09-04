package com.java_learn.p2_thread_method;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 19:58
 */
public class ThreadMethodDemo03 {
    /*
        public final void setDaemon(boolean on) : 设置为守护线程
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "---" + (i + 1));
                }
            }
        }, "线程A: ");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    System.out.println(Thread.currentThread().getName() + "---" + (i + 1));
                }
            }
        }, "线程B: ");

        // 将 t2设置为守护线程，t1结束后，t2也会马上结束(殉情)
        // 守护线程会随着所有非守护线程的结束而结束，所以如果有两条非守护线程，一条结束了守护线程不会也跟着结束
        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}
