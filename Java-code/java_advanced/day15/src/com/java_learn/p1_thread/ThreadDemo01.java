package com.java_learn.p1_thread;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 19:03
 */
public class ThreadDemo01 {
    /*
        开启线程的第一种方法 继承 Thread类
            1. 编写一个类继承 Thread类
            2. 重写 run方法
            3. 将线程任务代码写到 run方法中
            4. 创建线程对象
            5. 调用 start方法开启线程

         细节 --- 调用start方法开启线程，会自动调用 run方法执行
         注意 --- 只有调用了start方法，才是开启了新线程
     */
    public static void main(String[] args) {
        // 4. 创建线程对象
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        // 5. 调用 start方法开启线程
        mt1.start();
        mt2.start();
    }
}
// 1. 编写一个类继承 Thread类
class MyThread extends Thread {
    // 2. 重写 run方法

    @Override
    public void run() {
        // 3. 将线程任务代码写到 run方法中
        for (int i = 1; i <= 100; i++) {
            System.out.println("线程执行了:" + i);
        }
    }
}
