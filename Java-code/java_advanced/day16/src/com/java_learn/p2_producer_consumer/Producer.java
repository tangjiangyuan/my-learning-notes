package com.java_learn.p2_producer_consumer;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/23 11:29
 */
public class Producer implements Runnable {
    // 生产者
    @Override
    public void run() {
        while (true) {
            WareHouse.lock.lock();

            if (WareHouse.mark) {
                // true : 表示有包子，线程进入等待
                try {
                    WareHouse.producer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // false : 表示没有包子，生产后，改变mark状态，唤醒消费者
                System.out.println(Thread.currentThread().getName() + "生产包子");
                WareHouse.mark = true;
                WareHouse.consumer.signal();
            }

            WareHouse.lock.unlock();
        }
    }
}
