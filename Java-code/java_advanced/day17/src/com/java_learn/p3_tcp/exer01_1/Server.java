package com.java_learn.p3_tcp.exer01_1;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 18:34
 */
public class Server {
    public static void main(String[] args) throws Exception {

        // 创建线程池
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
        ServerSocket server = new ServerSocket(9090);
        System.out.println("服务器端启动，等待客户端...");

        while (true) { // 在死循环中加入多线程
            // 2. 接收响应
            Socket socket = server.accept();
            // new Thread(new SubmitTask(socket)).start();
            // 取消手动创建线程，将线程交给线程池管理
            pool.submit(new SubmitTask(socket));
        }
    }
}
