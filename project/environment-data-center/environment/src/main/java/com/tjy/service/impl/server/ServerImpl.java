package com.tjy.service.impl.server;

import com.tjy.service.inter.server.Server;
import com.tjy.util.SubmitTask;
import com.tjy.util.WoosModuleInit;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @date 2025/8/27 18:37
 */
@Slf4j
@SuppressWarnings("all")
public class ServerImpl implements Server, WoosModuleInit {

    private static int port;

    // 使用线程池管理线程
    ThreadPoolExecutor pool = new ThreadPoolExecutor(
            40,
            80,
            2,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(150),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
    );

    @Override
    public void init(Properties prop) throws Exception {
        port = Integer.parseInt(prop.getProperty("port"));
    }

    @Override
    public void receive() throws IOException {
        ServerSocket server = new ServerSocket(port);
        log.info("网络模块服务端启动成功,port: {},等待客户端连接...", server.getLocalPort());

        while (true) {
            Socket socket = server.accept();
            log.info("客户端连接成功,socket: {}", socket);
            pool.submit(new SubmitTask(socket));
        }
    }
}
