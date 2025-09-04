package com.java_learn.p1_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 19:03
 */
public class ThreadDemo04 {
    /*
        开启线程的第三种方法 --- 实现 Callable接口
            1. 编写一个实现 Callable接口
            2. 重写 call方法
            3. 将任务代码写在 call方法中
            4. 创建线程任务资源对象
            5. 创建线程任务对象，封装线程资源
            6. 创建线程对象，传入线程任务
            7. 使用线程对象调用 start开启线程

        细节 --- Callable接口有泛型，call方法有返回值，返回值是什么类型，接口的泛型就是什么类型
     */
    public static void main(String[] args) throws Exception {
        // 4. 创建 线程 任务资源对象
        MyCallable mc = new MyCallable();
        // 5. 创建 线程 任务对象，封装线程资源
        FutureTask<Integer> task1 = new FutureTask<>(mc);
        FutureTask<Integer> task2 = new FutureTask<>(mc);
        // 6. 创建 线程 对象，传入线程任务
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        // 7. 使用线程对象调用 start开启线程
        t1.start();
        t2.start();
        // 使用线程任务对象接收返回值
        Integer result1 = task1.get();
        Integer result2 = task2.get();
        System.out.println("task1结果是:" + result1);
        System.out.println("task2结果是:" + result2);
    }
}

// 1. 编写一个实现 Callable接口
class MyCallable implements Callable<Integer> {
    // 2. 重写 call方法
    @Override
    public Integer call() throws Exception {
        // 3. 将任务代码写在 call方法中
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            // System.out.println("sum:" + sum);
        }
        return sum;
    }
}