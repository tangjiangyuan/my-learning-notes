package com.java_learn.p3_lock.exer;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 23:01
 */
public class Test1 {
    // 继承 Runnable接口
    public static void main(String[] args) {
        TicketTaskTest1 ttt = new TicketTaskTest1();
        Thread t1 = new Thread(ttt, "窗口1: ");
        Thread t2 = new Thread(ttt, "窗口2: ");
        Thread t3 = new Thread(ttt, "窗口3: ");

        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketTaskTest1 implements Runnable {
    private int tickets = 2000;
    @Override
    public void run() {
        while (true) {
            synchronized (TicketTaskTest1.class) {
                if (tickets == 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "卖出了第:" + tickets + "号票。");
                tickets--;
            }
        }
    }
}
