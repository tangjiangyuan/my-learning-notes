package com.java_learn.p2_udp.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author tjy
 * @version 1.0
 * @date 2025/7/24 14:54
 */
public class Send {
    public static void main(String[] args) throws Exception {
        // 1. 创建 DatagramSocket 对象
        DatagramSocket socket = new DatagramSocket(8888);
        // 2. 创建 DatagramPacket 对象
        String msg = "疑似地上霜";
        byte[] bytes = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getByName("127.0.0.1"), 9999);
        // 3. 发送数据
        socket.send(packet);
        // 4. 释放资源
        socket.close();
    }
}
