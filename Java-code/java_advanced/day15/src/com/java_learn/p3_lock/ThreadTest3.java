package com.java_learn.p3_lock;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 22:09
 */
public class ThreadTest3 {
    /*
        同步代码块:
            synchronized(锁对象) {
                多条语句操作共享数据的代码
            }
     */
    public static void main(String[] args) {
        TicketTask3 t1 = new TicketTask3();
        TicketTask3 t2 = new TicketTask3();
        TicketTask3 t3 = new TicketTask3();

        t1.setName("窗口1: ");
        t2.setName("窗口2: ");
        t3.setName("窗口3: ");

        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketTask3 extends Thread {
    private static int tickets = 2000;
    @Override
    public void run() {
        while (true) {
            // 使用类的字节码作为锁对象，应为类的字节码只加载一次(推荐今后使用)
            synchronized (TicketTask3.class) {
                if (tickets == 0) {
                    break;
                }
                System.out.println(getName() + "卖出第" + tickets + "号票。");
                tickets--;
            }
        }
    }
}
