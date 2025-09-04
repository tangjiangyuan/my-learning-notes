package com.java_learn.p3_lock;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 22:091
 */
public class ThreadTest1 {
    /*
        需求 : 某电影院目前正在上映国产大片，共有100张票，而它有3个窗口买票，请输入即一个程序模拟该电影院买票
     */
    public static void main(String[] args) {
        TicketTask tt = new TicketTask();
        Thread t1 = new Thread(tt, "窗口1:");
        Thread t2 = new Thread(tt, "窗口2:");
        Thread t3 = new Thread(tt, "窗口3:");

        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketTask implements Runnable {
    private Object o = new Object();
    private int tickets = 2000;

    @Override
    public void run() {
        while (true) {
            synchronized (o) { // 锁对象可以是任意对象
                if (tickets <= 0) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "卖出了第" + tickets + "号票");
                tickets--;
            }
        }
    }
}
