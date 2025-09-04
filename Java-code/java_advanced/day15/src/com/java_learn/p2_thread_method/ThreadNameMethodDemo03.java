package com.java_learn.p2_thread_method;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 19:58
 */
public class ThreadNameMethodDemo03 {
    public static void main(String[] args) throws Exception {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> task1 = new FutureTask<>(mc);
        FutureTask<Integer> task2 = new FutureTask<>(mc);
        Thread t1 = new Thread(task1, "线程A: ");
        Thread t2 = new Thread(task2, "线程B: ");

        t1.start();
        t2.start();
        Integer result1 = task1.get();
        Integer result2 = task2.get();
        System.out.println(t1.getName() + "结果是:" + result1);
        System.out.println(t2.getName() + "结果是:" + result2);
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            System.out.println(Thread.currentThread().getName() + "sum:" + sum);
        }
        return sum;
    }
}
