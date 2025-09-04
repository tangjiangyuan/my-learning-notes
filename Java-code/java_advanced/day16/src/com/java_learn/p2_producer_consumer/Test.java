package com.java_learn.p2_producer_consumer;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/23 11:30
 */
public class Test {
    public static void main(String[] args) {
        new Thread(new Producer(), "生产者:").start();
        new Thread(new Consumer(), "消费者:").start();
    }
}
