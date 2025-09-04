package com.java_learn.p3_lock;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/22 22:09
 */
public class ThreadTest5 {
    /*
        同步方法 : 在方法的返回值类型前面加入 synchronized关键字
        public synchronized void method() {

        }
        同步方法的锁对象 :
            1. 非静态方法 : this
            2. 静态方法 : 类的字节码对象
     */
    public static void main(String[] args) {
        TicketTask5 task = new TicketTask5();
        Thread t1 = new Thread(task, "窗口1:");
        Thread t2 = new Thread(task, "窗口2:");

        t1.start();
        t2.start();
    }
}

class TicketTask5 implements Runnable {
    private static int tickets = 200;
    @Override
    public void run() {
        while (true) {
            String name = Thread.currentThread().getName();
            if ("窗口1:".equals(name)) {
                if (method()) break;
            } else if ("窗口2:".equals(name)) {
                synchronized (TicketTask5.class) { // 非静态
                    if (tickets == 0) {
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出了第:" + tickets + "号票。");
                    tickets--;
                }
            }
        }
    }

    private static synchronized boolean method() {
        if (tickets == 0) {
            return true;
        }
        System.out.println(Thread.currentThread().getName() + "卖出了第:" + tickets + "号票。");
        tickets--;
        return false;
    }
}
