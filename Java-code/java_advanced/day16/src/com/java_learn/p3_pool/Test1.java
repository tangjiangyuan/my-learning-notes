package com.java_learn.p3_pool;

import java.util.concurrent.*;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/23 16:49
 */
public class Test1 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                5,
                60,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 1; i <= 16; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "执行了...");
                }
            });
        }
        pool.shutdown();
    }
}
