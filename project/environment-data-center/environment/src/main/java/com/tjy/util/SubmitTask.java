package com.tjy.util;

import com.tjy.configuration.impl.ConfigurationImpl;
import com.tjy.pojo.Environment;
import com.tjy.service.impl.server.DBStoreImpl;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Collection;

/**
 * @version 1.0
 * @date 2025/8/29 9:13
 */
@Slf4j
@SuppressWarnings("all")
public class SubmitTask implements Runnable {

    private static Socket socket;

    public SubmitTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 接收对象
            try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

                Collection<Environment> coll = (Collection<Environment>) ois.readObject();
                log.info("成功接收到集合对象,内含环境数据个数: {}", coll.size());

                // 存入数据库
                new ConfigurationImpl().getDbStore().saveDB(coll);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
