package com.java_learn.p3_pool;

import java.util.concurrent.*;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/23 15:30
 */
public class PoolThreadDemo02 {
    /*
        自定义线程池
        参数5 : 任务队列
            1) 有界队列 :  new ArrayBlockingQueue<>(num);
            2) 无界队列 :  new LinkedBlockingDeque<>(); 无界(概念无界，实际有界Integer.MAX_VALUE)
     */
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2, // 核心线程(正式员工)
                5, // 总线程数(正式员工 + 临时员工)
                60,
                TimeUnit.MILLISECONDS, // 时间单位 毫秒
                new ArrayBlockingQueue<>(10), // 指定任务队列为10
                Executors.defaultThreadFactory(), // 系统默认线程工厂
                new ThreadPoolExecutor.AbortPolicy() // 拒绝策略 : 提交新任务时拒绝
        );
        // 只有超过（核心线程数 + 任务队列数）才会创建普通线程(招聘临时工)
        // 只有超过（总线程数 + 任务队列数）时，才会出发拒绝策略
        for (int i = 1; i <= 16; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "提交了任务...");
                }
            });
        }
        pool.shutdown();
    }
}
