package com.java_learn.p3_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/23 15:30
 */
public class PoolThreadDemo01 {
    /*
        JDK 提供的线程池
        Executors 中提供静态方法来创建线程池
            static ExecutorService newCachedThreadPool() : 创建一个默认的线程池
            static newFixedThreadPool(int nThreads) : 创建一个指定最多线程数量的线程池
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 100; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "执行了任务...");
                }
            });
        }
        pool.shutdown();
    }

    private static void method1() {
        // 1. 创建线程池对象
        ExecutorService pool = Executors.newCachedThreadPool();
        // 2. 提交任务
        for (int i = 1; i <= 100; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "提交了任务。");
                }
            });
        }
        // 3. 关闭池子
        pool.shutdown();
    }
}
