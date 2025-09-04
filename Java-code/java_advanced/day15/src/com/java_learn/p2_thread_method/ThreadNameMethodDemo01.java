package com.java_learn.p2_thread_method;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 19:58
 */
public class ThreadNameMethodDemo01 {
    /*
        线程设置名字和获取名字
        Thread 类的方法 :
            public String getName() : 获取线程名字
            public void setName() : 设置线程名字
            public static Thread currentThread() : 获取当前线程的对象
     */
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("A: ");
        MyThread mt2 = new MyThread("B: ");

//        mt1.setName("A: ");
//        mt2.setName("B: ");
        mt1.start();
        mt2.start();
    }
}

class MyThread extends Thread {
    public MyThread() {}
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(super.getName() + "线程任务执行了" + i);
        }
    }
}
