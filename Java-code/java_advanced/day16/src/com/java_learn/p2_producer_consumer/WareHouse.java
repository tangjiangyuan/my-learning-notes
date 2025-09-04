package com.java_learn.p2_producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/23 11:30
 */
public class WareHouse {
    // 共享仓库，存放共享数据
    public static boolean mark = false; // 包子的存在标志
    public static ReentrantLock lock = new ReentrantLock(); // 创建互斥锁
    public static Condition producer = lock.newCondition(); // 生产者 Condition对象
    public static Condition consumer = lock.newCondition(); // 消费者 Condition对象
}
