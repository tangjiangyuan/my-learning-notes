package com.tjy.service.impl.main;

import com.tjy.configuration.Configuration;
import com.tjy.configuration.impl.ConfigurationImpl;
import com.tjy.pojo.Environment;

import java.util.Collection;

/**
 * @version 1.0
 * @date 2025/8/27 19:28
 */
public class ClientMain {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Configuration configuration = new ConfigurationImpl();
                // 采集数据
                Collection<Environment> coll = configuration.getGather().gather();
                // 等服务端启动后，再启动客户端
                configuration.getClient().send(coll);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
