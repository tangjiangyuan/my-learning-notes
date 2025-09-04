package com.java_learn.p1_correspondence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/23 9:27
 */
public class CorrespondenceDemo03 {
    /*
        三条线程 --- 优化
     */
    public static void main(String[] args) {
        Print3 p = new Print3();
        new Thread(() -> {
            while (true) {
                try {
                    p.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    p.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    p.print3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class Print3 {
    ReentrantLock lock = new ReentrantLock();

    // 第一次调用 await，Condition对象就会和线程绑定
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    int flag = 1;

    public void print1() throws InterruptedException {
        lock.lock();

        if (flag != 1) c1.await();

        System.out.print("床");
        System.out.print("前");
        System.out.print("明");
        System.out.print("月");
        System.out.print("光");
        System.out.println("");

        flag = 2;
        c2.signal();
        lock.unlock();
    }
    public void print2() throws InterruptedException {
        lock.lock();
        // 线程2等待，c2绑定线程2. 那个线程第一次调用await，就会绑定那个线程
        if (flag != 2) c2.await();
        System.out.print("疑");
        System.out.print("似");
        System.out.print("地");
        System.out.print("上");
        System.out.print("霜");
        System.out.println("");

        flag = 3;
        c3.signal();
        lock.unlock();
    }
    public void print3() throws InterruptedException {
        lock.lock();
        if (flag != 3) c3.await();
        System.out.print("举");
        System.out.print("头");
        System.out.print("望");
        System.out.print("明");
        System.out.print("月");
        System.out.println("");

        flag = 1;
        c1.signal();
        lock.unlock();
    }
}
