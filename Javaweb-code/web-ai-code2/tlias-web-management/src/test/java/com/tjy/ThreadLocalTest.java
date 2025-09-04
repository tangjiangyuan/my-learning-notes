package com.tjy;

/**
 * @version 1.0
 * @date 2025/8/15 11:25
 */
public class ThreadLocalTest {

    private static final ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        local.set("Main Message...");

        new Thread(new Runnable() {
            @Override
            public void run() {
                local.set("Thread Message...");
                System.out.println(Thread.currentThread().getName() + ":" + local.get());
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + ":" + local.get());

        local.remove();
        System.out.println(Thread.currentThread().getName() + ":" + local.get());
    }
}
