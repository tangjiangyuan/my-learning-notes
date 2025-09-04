package com.tjy.service.impl.main;

import com.tjy.pojo.Environment;
import com.tjy.service.impl.client.ClientImpl;
import com.tjy.service.impl.client.GatherImpl;
import com.tjy.service.impl.server.ServerImpl;
import com.tjy.service.inter.client.Client;
import com.tjy.service.inter.client.Gather;
import com.tjy.service.inter.server.Server;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Collection;

/**
 * @version 1.0
 * @date 2025/8/27 16:28
 */
@Slf4j
@SuppressWarnings("all")
public class GatherTest {
    public static void main(String[] args) {
        log.info("开始采集数据...");

        Gather gather = new GatherImpl();
        Collection<Environment> list = null;
        try {
            list = gather.gather();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        list.forEach(System.out::println);

        log.info("数据采集完成...");

        Collection<Environment> finalList = list;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Server server = new ServerImpl();
                Client client = new ClientImpl();
                try {
                    server.receive();
                    client.send(finalList);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
