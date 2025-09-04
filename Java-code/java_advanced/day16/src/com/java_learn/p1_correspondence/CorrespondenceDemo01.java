package com.java_learn.p1_correspondence;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/23 9:27
 */
public class CorrespondenceDemo01 {
    /*
        两条线程通信
     */
    public static void main(String[] args) {
        Print1 p = new Print1();
        new Thread(() -> {
            while (true) {
                synchronized (Print1.class) {
                    try {
                        p.print1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (Print1.class) {
                    try {
                        p.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

class Print1 {
    int flag = 1;
    public void print1() throws InterruptedException {

        if (flag != 1) {
            // 线程1等待
            Print1.class.wait();
        }

        System.out.print("床");
        System.out.print("前");
        System.out.print("明");
        System.out.print("月");
        System.out.print("光");
        System.out.println("");

        flag = 2;
        // 唤醒线程2
        Print1.class.notify(); // 没有睡眠的线程也可以 notify()
    }
    public void print2() throws InterruptedException {

        if (flag != 2) {
            // 线程2等待
            Print1.class.wait();
        }

        System.out.print("疑");
        System.out.print("似");
        System.out.print("地");
        System.out.print("上");
        System.out.print("霜");
        System.out.println("");

        flag = 1;
        // 唤醒线程1
        Print1.class.notifyAll(); // 也可以是使用notifyAll()
    }
}
