package com.java_learn.p2_thread_method;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 19:58
 */
public class ThreadNameMethodDemo02 {
    /*
        线程设置名字和获取名字
        Thread 类的方法 :
            public String getName() : 获取线程名字
            public void setName() : 设置线程名字
            public static Thread currentThread() : 获取当前线程的对象
     */
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t = new Thread(mr, "A: ");
        t.start();

        for (int i = 1; i <= 200; i++) {
            System.out.println(Thread.currentThread().getName() + "执行了" + i);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "执行了" + i);
        }
    }
}
