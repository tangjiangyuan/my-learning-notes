package com.java_learn.p3_tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 16:31
 */
public class Server {
    public static void main(String[] args) throws Exception{
        // 1. 创建 ServerSocket对象，指定端口
        ServerSocket server = new ServerSocket(8899);
        System.out.println("服务端开启，客户端连接中...");
        // 2. 响应客户端发送的请求
        Socket socket = server.accept();
        // 3. 获取传输数据的流对象
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        // 4. 传输数据
        byte[] bys = new byte[1024];
        int len = is.read(bys); // is.read() 读取字节; is.read(byte[] bys) 读取字节数组的长度
        String msg = new String(bys, 0, len);
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println("读取到" + ip + "发送的消息:" + msg);

        os.write("你也好".getBytes());
        // 5. 释放资源
        socket.close();
        server.close();
    }
}
