package com.java_learn.p4_single_design_pattern;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 9:12
 */
public class SingletonDesignDemo02 {
    /*
        单例设计模式 --- 懒汉式
        -----------------------------------------------
        class Singleton2 {
            private Singleton2() {}

            private static Singleton2 Instance;

            public static Singleton2 getInstance() {
                if (Instance == null) { // 保证不会创建两个对象，导致地址值不同
                    Instance = new Singleton2();
                }
                return Instance;
            }
        }
        -----------------------------------------------
        弊端：在对线程并发操作时，可能创建多个对象。
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton2 instance = Singleton2.getInstance();
                    System.out.println(instance);
                }
            }).start();
        }
    }
}

class Singleton2 {
    private Singleton2() {}

    private static Singleton2 Instance;

    public static Singleton2 getInstance() {
        if (Instance == null) { // 双检测，减少阻塞，提高运行效率
            synchronized (Singleton2.class) {
                if (Instance == null) { // 保证不会创建两个对象，导致地址值不同
                    Instance = new Singleton2();
                }
            }
        }
        return Instance;
    }
}