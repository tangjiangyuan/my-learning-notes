package com.java_learn.p3_tcp.exer01;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 16:50
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // 1. 创建 Socket对象
        Socket socket = new Socket("127.0.0.1", 9090);
        // 2. 获取流对象
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        // 3. 数据传输
        os.write("你好".getBytes());

        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String msg = new String(bys, 0, len);
        System.out.println(msg);

        // 4. 释放资源
        socket.close();
    }
}
