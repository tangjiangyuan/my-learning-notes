package com.java_learn.p3_lock;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 22:09
 */
public class DeadLock {
    /*
        死锁 : 同步嵌套
     */
    public static void main(String[] args) {
        Object objA = new Object();
        Object objB = new Object();

        new Thread(() -> {
            while (true) {
                synchronized (objA) {
                    // 线程一
                    System.out.println(Thread.currentThread().getName() + "---抢到了执行权，上A锁");
                    synchronized (objB) {
                        System.out.println(Thread.currentThread().getName() + "---抢到了执行权，上B锁");
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (objB) {
                    // 线程二
                    System.out.println(Thread.currentThread().getName() + "---抢到了执行权，上B锁");
                    synchronized (objA) {
                        System.out.println(Thread.currentThread().getName() + "---抢到了执行权，上A锁");
                    }
                }
            }
        }).start();
    }
}
