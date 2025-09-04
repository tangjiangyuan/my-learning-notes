package com.java_learn.p1_thread;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 19:03
 */
public class ThreadDemo03 {
    /*
        开启线程的第二种方式 : 实现 Runnable接口 --- 扩展性更强
            1. 编写一个类实现 Runnable接口
            2. 重写 run方法
            3. 将线程任务代码写在 run方法中
            4. 创建线程任务资源
            5. 创建线程对象，将资源传入
            6. 使用线程对象调用 start方法，开启线程
     */
    public static void main(String[] args) {
        // 4. 创建线程任务资源
        MyRunnable mr = new MyRunnable();
        // 5. 创建线程对象，将资源传入
        Thread t = new Thread(mr);
        // 6. 使用线程对象调用 start方法，开启线程
        t.start();

        for (int i = 1; i <= 200; i++) {
            System.out.println("main线程执行了" + i);
        }
    }
}

// 1. 编写一个类实现 Runnable接口
class MyRunnable implements Runnable {
    // 2. 重写 run方法
    @Override
    public void run() {
        // 3. 将线程任务代码写在 run方法中
        for (int i = 1; i <= 200; i++) {
            System.out.println("线程任务执行了" + i);
        }
    }
}