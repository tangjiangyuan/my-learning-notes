package com.java_learn.p2_producer_consumer;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/23 11:29
 */
public class Consumer implements Runnable {
    // 消费者
    @Override
    public void run() {
        while (true) {
            WareHouse.lock.lock();

            if (WareHouse.mark) {
                // true : 表示有包子，吃，改变mark状态，唤醒生产者
                System.out.println(Thread.currentThread().getName() + "吃包子");
                WareHouse.mark = false;
                WareHouse.producer.signal();
            } else {
                // false : 表示没有包子，进入等待
                try {
                    WareHouse.consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            WareHouse.lock.unlock();
        }
    }
}
