package com.java_learn.p2_udp;

import java.net.*;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 14:22
 */
public class Send {
    /*
        发送端
     */
    public static void main(String[] args) throws Exception {
        // 1. 创建 DatagramSocket 对象
        // DatagramSocket ds = new DatagramSocket(); // 随机端口
        DatagramSocket socket = new DatagramSocket(8888); // 指定端口
        // 2. 创建 DatagramPacket 对象
        String msg = "床前明月光";
        byte[] bytes = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length,
                InetAddress.getByName("127.0.0.1"), 9999);
        // 3. 发送数据
        socket.send(packet);
        // 4. 释放资源
        socket.close();
    }
}
