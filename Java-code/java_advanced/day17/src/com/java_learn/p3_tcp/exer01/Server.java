package com.java_learn.p3_tcp.exer01;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 16:50
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 1. 创建 ServerSocket对象
        ServerSocket server = new ServerSocket(9090);
        System.out.println("服务端开启，等待客户端连接...");
        // 2. 接受客户端响应
        Socket socket = server.accept();
        // 3. 获取流对象
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        // 4. 数据传输
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String msg = new String(bys, 0, len);
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println("接收到" + ip + "发送的消息:" + msg);

        os.write("你也好".getBytes());

        // 5. 释放资源
        socket.close();
        server.close();
    }
}
