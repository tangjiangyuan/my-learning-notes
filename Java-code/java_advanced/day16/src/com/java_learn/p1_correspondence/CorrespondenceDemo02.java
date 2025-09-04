package com.java_learn.p1_correspondence;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/23 9:27
 */
public class CorrespondenceDemo02 {
    /*
        三条线程通信

        问题: sleep 方法 和 wait 方法的区别？
        答 :
            sleep方法时线程睡眠，时间到了自动醒来，sleep方法在休眠的时候，不会释放锁。
            wait方法是线程等待，需要由其它线程进行notify唤醒，wait方法在等待期间，会释放锁。
     */
    public static void main(String[] args) {
        Print2 p = new Print2();
        new Thread(() -> {
            while (true) {
                synchronized (Print2.class) {
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
                synchronized (Print2.class) {
                    try {
                        p.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (Print2.class) {
                    try {
                        p.print3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

class Print2 {
    int flag = 1;
    public void print1() throws InterruptedException {

        while (flag != 1) {
            Print2.class.wait();
        }

        System.out.print("床");
        System.out.print("前");
        System.out.print("明");
        System.out.print("月");
        System.out.print("光");
        System.out.println("");

        flag = 2;
        // notify()随机唤醒，唤醒时停留在 wait()语句，跳出if判断了
        Print2.class.notifyAll();
    }
    public void print2() throws InterruptedException {
        while (flag != 2) Print2.class.wait();
        System.out.print("疑");
        System.out.print("似");
        System.out.print("地");
        System.out.print("上");
        System.out.print("霜");
        System.out.println("");

        flag = 3;
        Print2.class.notifyAll();
    }
    public void print3() throws InterruptedException {
        while (flag != 3) Print2.class.wait();
        System.out.print("举");
        System.out.print("头");
        System.out.print("望");
        System.out.print("明");
        System.out.print("月");
        System.out.println("");

        flag = 1;
        Print2.class.notifyAll();
    }
}
