package com.java_learn.exercise;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 20:04
 */
public class Server {
    public static void main(String[] args) throws Exception {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                5,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        // 1. 创建 ServerSocket对象
        ServerSocket server = new ServerSocket(9999);
        // 2. 接收客户端响应
        System.out.println("服务器端启动，等待客户端...");
        while (true) {
            Socket socket = server.accept();
            // new Thread(new SubmitTask(socket)).start();
            pool.submit(new SubmitTask(socket));
        }
    }
}
