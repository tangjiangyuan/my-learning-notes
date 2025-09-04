package com.tjy.service.impl.main;

import com.tjy.configuration.impl.ConfigurationImpl;

/**
 * @version 1.0
 * @date 2025/8/27 19:28
 */
public class ServerMain {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                // 接收数据
                new ConfigurationImpl().getServer().receive();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
