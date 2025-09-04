package com.java_learn.p3_lock.exer;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 23:05
 */
public class Test2 {
    // 继承 Thread类
    public static void main(String[] args) {
        TicketTaskTest2 ttt1 = new TicketTaskTest2();
        TicketTaskTest2 ttt2 = new TicketTaskTest2();
        TicketTaskTest2 ttt3 = new TicketTaskTest2();

        ttt1.setName("窗口1:");
        ttt2.setName("窗口2:");
        ttt3.setName("窗口3:");

        ttt1.start();
        ttt2.start();
        ttt3.start();
    }
}

class TicketTaskTest2 extends Thread {
    private static int tickets = 2000;
    @Override
    public void run() {
        while (true) {
            synchronized (TicketTaskTest2.class) {
                if (tickets == 0) {
                    break;
                }
                System.out.println(getName() + "卖出了第:" + tickets + "号票。");
                tickets--;
            }
        }
    }
}
